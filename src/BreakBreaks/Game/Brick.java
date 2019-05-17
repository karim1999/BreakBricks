package BreakBreaks.Game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick extends Rectangle {
    enum Type {
        NORMAL,
        UNIQUE1,
        UNIQUE2
    };
    Type type= Type.NORMAL;

    public Brick(double x, double y) {
        setX(x);
        setY(y);
        setWidth(50);
        setHeight(15);
        setArcHeight(5);
        setArcWidth(5);
        setFill(Color.BROWN);
    }

    public void setType(Type type) {
        this.type = type;
    }
}

