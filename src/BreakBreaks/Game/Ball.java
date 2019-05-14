package BreakBreaks.Game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
//    double defaultY;
    public Ball(double x, double y) {
        setRadius(7);
        setFill(Color.BLACK);
        setCenterX(x);
        setCenterY(y);
    }
    public void move(){
    }
}
