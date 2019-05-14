package BreakBreaks.Game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick extends Rectangle {
    public Brick(double x, double y) {
        setX(x);
        setY(y);
        setWidth(50);
        setHeight(15);
        setArcHeight(5);
        setArcWidth(5);
        setFill(Color.BROWN);
    }
}
