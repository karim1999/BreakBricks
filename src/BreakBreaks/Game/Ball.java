package BreakBreaks.Game;

import BreakBreaks.Config;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
    public double currentXSpeed;
    public double currentYSpeed;

    public Ball(double x, double y) {
        super(x, y, Config.ballRadius, Config.ballColor);
    }
    public void move(){
        setCenterX(getCenterX() + currentXSpeed);
        setCenterY(getCenterY() + currentYSpeed);
    }

    public void checkBallStickCollision(Stick stick){
        double x= Config.maxSpeed;
        double y= -Config.maxSpeed;
        if(getLayoutBounds().intersects(stick.getLayoutBounds())){
            double difference= stick.getX() + stick.getWidth()/2 - getCenterX();
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
    public void checkBallFrameCollision(Frame frame){
        if(currentXSpeed >0){
            if(frame.getMaxX() <= getCenterX() + getRadius()){
                currentXSpeed*=-1;
            }
        }else{
            if(frame.getMinX() >= getCenterX() - getRadius()){
                currentXSpeed*=-1;
            }
        }
        if(currentYSpeed >0){
            if(frame.getMaxY() <= getCenterY() + getRadius()){
//                start= false;
//                initializeGame();
            }
        }else{
            if(frame.getMinY() >= getCenterY() - getRadius()){
                currentYSpeed*=-1;
            }
        }
    }

}
