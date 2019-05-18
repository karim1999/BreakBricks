package BreakBreaks.Game;

import BreakBreaks.Config;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
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
        setY(y+ Config.scoreIndentation);
        setWidth(50);
        setHeight(15);
        setArcHeight(5);
        setArcWidth(5);
        setType(type);
//        setFill(Color.valueOf("#FF8A65"));

//        if (Brick.type == Type.NORMAL) {setFill(new ImagePattern(normalBrick));}

//        setType(Type.UNIQUE1);
//        if (Brick.type == Type.UNIQUE1) {setFill(new ImagePattern(addingBallsBrick));}
//        brick.setX(x);
//        brick.setX(y);
//        getChildren().add(brick);
    }

    public void setType(Type type) {
        this.type = type;
        if (type == Type.NORMAL)
        {
            setFill(new ImagePattern(Config.normalBrick));
        }
        if (type == Type.UNIQUE1)
        {
            setFill(new ImagePattern(Config.addingBallsBrick));
        }
        if (type == Type.UNIQUE2)
        {
            setFill(new ImagePattern(Config.removingBricks));
        }
    }
}

