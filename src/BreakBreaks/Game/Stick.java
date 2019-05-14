package BreakBreaks.Game;

import BreakBreaks.Config;
import javafx.scene.shape.Rectangle;

public class Stick extends Rectangle {
    private boolean isMovingLeft;
    private boolean isMovingRight;
    private double speed= 10;

    public Stick(double x, double y) {
        setFill(Config.getStickColor());
        setWidth(Config.getStickWidth());
        setHeight(Config.getStickHeight());
        setArcHeight(Config.getStickArcHeight());
        setArcWidth(Config.getStickArcWidth());
        setX(x);
        setY(y);
    }

    public void setMovingLeft(Boolean movingLeft) {
        isMovingLeft = movingLeft;
    }

    public void setMovingRight(Boolean movingRight) {
        isMovingRight = movingRight;
    }

    public void move(boolean start, Ball ball){
        if(isMovingLeft && getX() > 0){
            if(!start)
                ball.setCenterX(ball.getCenterX() - speed);
            setX(getX() - speed);
        }
        if(isMovingRight && getX() < Config.getScreenWidth() - Config.stickWidth){
            if(!start)
                ball.setCenterX(ball.getCenterX() + speed);
            setX(getX() + speed);
        }
    }
}
