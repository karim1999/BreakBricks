package BreakBreaks.Game;

import BreakBreaks.Config;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Iterator;

public class GamePane extends Pane {
    private Ball ball;
    private Stick stick;
    private ArrayList<Brick> bricks= new ArrayList<>();
    private boolean start;

    public GamePane() {

        //Background Picture


        initializeGame();
        gameLoop();
    }

    private void initializeGame(){
        this.getChildren().clear();
        bricks.clear();
        stick= new Stick(Config.screenWidth/2 - Config.stickWidth/2, Config.screenHeight - Config.stickHeight);
        ball= new Ball(Config.screenWidth/2, Config.screenHeight - Config.stickHeight - Config.ballRadius);

        for(int i= 0; i < 10; i++){
            for (int j = 0; j < 20; j++){
                Brick brick= new Brick(i*50, j*15);
                bricks.add(brick);
                this.getChildren().add(brick);
            }
        }
        setOnKeyPressed(e->{
            if(e.getCode() == KeyCode.LEFT)
                stick.setMovingLeft(true);
            if(e.getCode() == KeyCode.RIGHT)
                stick.setMovingRight(true);
            if(e.getCode() == KeyCode.SPACE){
                start= true;
            }
        });
        setOnKeyReleased(e->{
            if(e.getCode() == KeyCode.LEFT)
                stick.setMovingLeft(false);
            if(e.getCode() == KeyCode.RIGHT)
                stick.setMovingRight(false);
        });
        this.getChildren().addAll(ball, stick);
    }
    public void gameLoop(){
        new AnimationTimer(){
            @Override
            public void handle(long now) {
                updateGame();
            }
        }.start();
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
    private void checkBallLimitsCollision(Ball ball){
        if(ball.currentXSpeed >0){
            if(Config.screenWidth <= ball.getCenterX() + ball.getRadius()){
                ball.currentXSpeed*=-1;
            }
        }else{
            if(0 >= ball.getCenterX() - ball.getRadius()){
                ball.currentXSpeed*=-1;
            }
        }
        if(ball.currentYSpeed >0){
            if(Config.screenHeight <= ball.getCenterY() + ball.getRadius()){
                start= false;
                initializeGame();
            }
        }else{
            if(0 >= ball.getCenterY() - ball.getRadius()){
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
    private void updateGame() {

        //Move Stick with controllers
        stick.move(start, ball);
        if(start){
            checkBallStickCollision(ball, stick);
            checkBallLimitsCollision(ball);
            checkBallBricksCollision(ball, bricks);

            ball.move();
        }
    }
}
