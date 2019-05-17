package BreakBreaks.Game;

import BreakBreaks.Config;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.Iterator;

public class Player extends Group {
    private Stick stick;
    private ArrayList<Ball> balls= new ArrayList<>();
    private ArrayList<Brick> bricks= new ArrayList<>();

    private Frame frame;
    private KeyCode leftKey;
    private KeyCode rightKey;
    private KeyCode startKey;

    private boolean isPlaying;
    private boolean hasStarted;
    private boolean hasWon;
    private boolean hasLost;

    Player(Frame frame, KeyCode leftKey, KeyCode rightKey, KeyCode start){
        this.frame= frame;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.startKey= start;

        stick= new Stick( frame.getMinX() + frame.getWidth()/2 - Config.stickWidth/2, frame.getMaxY() - Config.stickHeight);
        Ball ball= new Ball(frame.getMinX() + frame.getWidth()/2, frame.getMinY() + frame.getMaxY() - Config.stickHeight - Config.ballRadius);
        balls.add(ball);

        for(int i= 0; i < 10; i++){
            for (int j = 0; j < 20; j++){
                Brick brick= new Brick(frame.getMinX() + i*50, frame.getMinY() + j*15);
                bricks.add(brick);
                this.getChildren().add(brick);
            }
        }

        this.getChildren().addAll(ball, stick);

    }

    private void checkBallStickCollision(Ball ball, Stick stick){
        double x= Config.maxSpeed;
        double y= -Config.maxSpeed;
        if(ball.getLayoutBounds().intersects(stick.getLayoutBounds())){
            double difference= stick.getX() + stick.getWidth()/2 - ball.getCenterX();
            if(difference > 0){
                double ratio= difference/(stick.getWidth());
                ball.currentXSpeed= -x*ratio;
                ball.currentYSpeed= y*(1-ratio);

            }else if(difference < 0){
                double ratio= -difference/(stick.getWidth());
                ball.currentXSpeed= x*ratio;
                ball.currentYSpeed= y*(1-ratio);
            }else{
                ball.currentXSpeed= 0;
                ball.currentYSpeed= y;
            }
        }
    }
    private void checkBallFrameCollision(Ball ball, Frame frame){
        if(ball.currentXSpeed >0){
            if(frame.getMaxX() <= ball.getCenterX() + ball.getRadius()){
                ball.currentXSpeed*=-1;
            }
        }else{
            if(frame.getMinX() >= ball.getCenterX() - ball.getRadius()){
                ball.currentXSpeed*=-1;
            }
        }
        if(ball.currentYSpeed >0){
            if(frame.getMaxY() <= ball.getCenterY() + ball.getRadius()){
//                start= false;
//                initializeGame();
            }
        }else{
            if(frame.getMinY() >= ball.getCenterY() - ball.getRadius()){
                ball.currentYSpeed*=-1;
            }
        }
    }
    private void checkBallBricksCollision(Ball ball, ArrayList<Brick> bricks){
        Iterator itr = bricks.iterator();
        boolean isIntersected= false;
        while (itr.hasNext())
        {
            Brick brick = (Brick)itr.next();
            if(ball.getLayoutBounds().intersects(brick.getLayoutBounds())){
                if(!isIntersected){
                    isIntersected= true;
                    itr.remove();
                    getChildren().remove(brick);
                    if(ball.getCenterX() >= brick.getX() && ball.getCenterX() <= brick.getX() + brick.getWidth()){
                        ball.currentYSpeed*=-1;
                    }else if(ball.getCenterY() >= brick.getY() && ball.getCenterY() <= brick.getY() + brick.getHeight()){
                        ball.currentXSpeed*=-1;
                    }else{
                        if(ball.currentYSpeed > 0){
                            ball.currentXSpeed*=-1;
                        }else{
                            ball.currentYSpeed*=-1;
                        }
                    }
                }else{
                    break;
                }
            }
        }
    }

    public void play(){
        if(KeyManager.getkeystate(startKey)){
            isPlaying= true;
        }
        //StickMoving
        if(bricks.size() == 0){
            isPlaying = false;
            hasWon= true;
        }
        if(balls.size() == 0){
            isPlaying = false;
            hasLost= true;
        }

        for (int i=0; i < balls.size(); i++){
            if (balls.get(i).getCenterY() >= frame.getMaxY()){
                System.out.println("End Game");
                getChildren().remove(balls.get(i));
                balls.remove(i);
            }
        }

        moveStick();

        if(isPlaying){
            for (Ball ball : balls){
                checkBallStickCollision(ball, stick);
                checkBallFrameCollision(ball, frame);
                checkBallBricksCollision(ball, bricks);
                ball.move();
            }
        }
    }

    private void moveStick(){
        boolean isMovingLeft= KeyManager.getkeystate(leftKey);
        boolean isMovingRight= KeyManager.getkeystate(rightKey);
        double speed= Config.stickSpeed;
        for (Ball ball: balls){
            if(isMovingLeft && stick.getX() > frame.getMinX()){
                if(!isPlaying)
                    ball.setCenterX(ball.getCenterX() - speed);
                stick.setX(stick.getX() - speed);
            }
            if(isMovingRight && stick.getX() < frame.getMaxX() - Config.stickWidth){
                if(!isPlaying)
                    ball.setCenterX(ball.getCenterX() + speed);
                stick.setX(stick.getX() + speed);
            }
        }
    }
}
