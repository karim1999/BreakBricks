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

}
