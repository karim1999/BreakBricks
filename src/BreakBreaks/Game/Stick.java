package BreakBreaks.Game;

import BreakBreaks.Config;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Stick extends Rectangle {

    public Stick(double x, double y, ImagePattern colorFill) {
        setFill(colorFill);
        setWidth(Config.stickWidth);
        setHeight(Config.stickHeight);
        setArcHeight(Config.stickArcHeight);
        setArcWidth(Config.stickArcWidth);
        setX(x);
        setY(y);
    }

}
