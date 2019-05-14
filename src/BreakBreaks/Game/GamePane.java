package BreakBreaks.Game;

import BreakBreaks.Config;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Iterator;

public class GamePane extends Pane {
    Ball ball;
    Stick stick;
    ArrayList<Brick> bricks= new ArrayList<>();
    boolean start;
    double maxSpeed= 10;
    double currentXSpeed;
    double currentYSpeed;

    public GamePane() {
        stick= new Stick(200, 480);
        ball= new Ball(200, 473);

        for(int i= 0; i < 10; i++){
            for (int j = 0; j < 20; j++){
                Brick brick= new Brick(i*50, j*15);
                bricks.add(brick);
                this.getChildren().add(brick);
            }
        }
        this.getChildren().addAll(ball, stick);

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

    private void updateGame() {
        stick.move(start, ball);
        if(start){
//            ball.move();
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

            if(currentXSpeed >0){
                if(Config.getScreenWidth() <= ball.getCenterX() + ball.getRadius()){
                    currentXSpeed*=-1;
                }
            }else{
                if(0 >= ball.getCenterX() - ball.getRadius()){
                    currentXSpeed*=-1;
                }
            }
            if(currentYSpeed >0){
                if(Config.getScreenHeight() <= ball.getCenterY() + ball.getRadius()){
                    start= false;
                }
            }else{
                if(0 >= ball.getCenterY() - ball.getRadius()){
                    currentYSpeed*=-1;
                }
            }
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
                        if(ball.getCenterX() > brick.getX() && ball.getCenterX() < brick.getX() + brick.getWidth()){
                            currentYSpeed*=-1;
                        }else{
                            currentXSpeed*=-1;
                        }
                    }else{
                        break;
                    }
                }
            }
            ball.setCenterX(ball.getCenterX() + currentXSpeed);
            ball.setCenterY(ball.getCenterY() + currentYSpeed);
        }
    }
}
