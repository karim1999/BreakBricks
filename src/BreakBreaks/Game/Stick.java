package BreakBreaks.Game;

import BreakBreaks.Config;
import javafx.scene.shape.Rectangle;

public class Stick extends Rectangle {

    public Stick(double x, double y) {
        setFill(Config.stickColor);
        setWidth(Config.stickWidth);
        setHeight(Config.stickHeight);
        setArcHeight(Config.stickArcHeight);
        setArcWidth(Config.stickArcWidth);
        setX(x);
        setY(y);
    }

}
