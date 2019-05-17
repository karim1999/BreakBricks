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
    public boolean hasWon;
    public boolean hasLost;

    public int score;

    Player(Frame frame, KeyCode leftKey, KeyCode rightKey, KeyCode start){
        this.frame= frame;
        this.leftKey = leftKey;
        this.rightKey = rightKey;
        this.startKey= start;

        stick= new Stick( frame.getMinX() + frame.getWidth()/2 - Config.stickWidth/2, frame.getMaxY() - Config.stickHeight);
        Ball ball= new Ball(frame.getMinX() + frame.getWidth()/2, frame.getMinY() + frame.getMaxY() - Config.stickHeight - Config.ballRadius);
        balls.add(ball);

        for(int i= 0; i < Config.brickNumCols; i++){
            for (int j = 0; j < Config.brickNumRows; j++){
                Brick brick= new Brick(frame.getMinX() + i*Config.brickWidth, frame.getMinY() + j*Config.brickHeight);
                bricks.add(brick);
                this.getChildren().add(brick);
            }
        }

        for (int i= 0; i < bricks.size()/10; i++){
            double random1= Math.random()*bricks.size();
            double random2= Math.random()*bricks.size();
            bricks.get((int)random1).setType(Brick.Type.UNIQUE1);
            bricks.get((int)random2).setType(Brick.Type.UNIQUE2);
        }

        this.getChildren().addAll(ball, stick);

    }
    public void checkBallBricksCollision(Ball ball, ArrayList<Brick> bricks){
        Iterator<Brick> itr = bricks.iterator();
        boolean isIntersected= false;
        while (itr.hasNext())
        {
            Brick brick = itr.next();
            if(ball.getLayoutBounds().intersects(brick.getLayoutBounds())){
                itr.remove();
                increaseScore();
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
                if(brick.type == Brick.Type.UNIQUE1){
                    addMultipleBalls(ball);
                }else if(brick.type == Brick.Type.UNIQUE2){
                    destroyCollAndRow(brick);
                }
                break;
            }
        }
    }

    private void destroyCollAndRow(Brick brick) {
        Iterator<Brick> itr = bricks.iterator();
        while (itr.hasNext())
        {
            Brick currentBrick= itr.next();
            if(currentBrick.getX() == brick.getX() || currentBrick.getY() == brick.getY()){
                getChildren().remove(currentBrick);
                itr.remove();
                increaseScore();
            }
        }

    }
    private void increaseScore(){
        score+= 1;
    }

    void addMultipleBalls(Ball ball){
        for (int i= 0; i < Config.numAdditionBalls; i++){
            Ball newBall= new Ball(ball.getCenterX(), ball.getCenterY());
            //To avoid moving only in x
            newBall.currentYSpeed= ((Config.maxSpeed-1) * Math.random()) +1;
            newBall.currentXSpeed= Config.maxSpeed- newBall.currentYSpeed;
            balls.add(newBall);
            getChildren().add(newBall);
        }
    }
    public int play(){
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
            if(isPlaying){
                Ball ball= balls.get(i);
                ball.checkBallStickCollision(stick);
                ball.checkBallFrameCollision(frame);
                checkBallBricksCollision(ball, bricks);
                ball.move();
            }
            if (balls.get(i).getCenterY() >= frame.getMaxY()){
                getChildren().remove(balls.get(i));
                balls.remove(i);
            }
        }

        moveStick();

        System.out.println(score);
        return score;
    }

    private void moveStick(){
        boolean isMovingLeft= KeyManager.getkeystate(leftKey);
        boolean isMovingRight= KeyManager.getkeystate(rightKey);
        double speed= Config.stickSpeed;
        if(balls.size() >= 1){
            Ball ball= balls.get(0);
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
