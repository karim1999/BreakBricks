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
    private double maxSpeed= 10;
    private double currentXSpeed;
    private double currentYSpeed;

    public GamePane() {
        initializeGame();
    }
    private void initializeGame(){
        this.getChildren().clear();
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
//                ball.setCenterX(250);
//                ball.setCenterY(473);
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
        gameLoop();
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
        double x= maxSpeed;
        double y= -maxSpeed;
        if(ball.getLayoutBounds().intersects(stick.getLayoutBounds())){
            double difference= stick.getX() + stick.getWidth()/2 - ball.getCenterX();
            if(difference > 0){
                double ratio= difference/(stick.getWidth());
                currentXSpeed= -x*ratio;
                currentYSpeed= y*(1-ratio);

            }else if(difference < 0){
                double ratio= -difference/(stick.getWidth());
                currentXSpeed= x*ratio;
                currentYSpeed= y*(1-ratio);
            }else{
                currentXSpeed= 0;
                currentYSpeed= y;
            }
        }
    }
    private void checkBallLimitsCollision(Ball ball){
        if(currentXSpeed >0){
            if(Config.screenWidth <= ball.getCenterX() + ball.getRadius()){
                currentXSpeed*=-1;
            }
        }else{
            if(0 >= ball.getCenterX() - ball.getRadius()){
                currentXSpeed*=-1;
            }
        }
        if(currentYSpeed >0){
            if(Config.screenHeight <= ball.getCenterY() + ball.getRadius()){
                start= false;
            }
        }else{
            if(0 >= ball.getCenterY() - ball.getRadius()){
                currentYSpeed*=-1;
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
                        currentYSpeed*=-1;
                    }else if(ball.getCenterY() >= brick.getY() && ball.getCenterY() <= brick.getY() + brick.getHeight()){
                        currentXSpeed*=-1;
                    }else{
                        currentXSpeed*=-1;
                        currentYSpeed*=-1;
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

            ball.setCenterX(ball.getCenterX() + currentXSpeed);
            ball.setCenterY(ball.getCenterY() + currentYSpeed);
        }
    }
}
