package BreakBreaks.Game;

import BreakBreaks.Config;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
//    double defaultY;
    public Ball(double x, double y) {
        setRadius(Config.ballRadius);
        setFill(Config.ballColor);
        setCenterX(x);
        setCenterY(y);
    }
    public void move(){
    }
}
