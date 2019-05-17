package BreakBreaks.Game;

import javafx.scene.input.KeyCode;

public class KeyManager
{
    //represent states of my game keys
    //UP,DOWN,LEFT,RIGHT
    private static boolean [] keystates= new boolean[6];

    private static int keycodeToIndx(KeyCode k)
    {
        switch(k)
        {
            case LEFT:
                return 0;
            case RIGHT:
                return 1;
            case A:
                return 2;
            case D:
                return 3;
            case SPACE:
                return 4;
            case ENTER:
                return 5;
            default:
                return -1;
        }
    }


    public static void setkeystate(KeyCode k , boolean state)
    {
        int i = keycodeToIndx(k);
        if(i != -1)
            keystates[i] = state;
    }

    public static boolean getkeystate(KeyCode k)
    {
        int i = keycodeToIndx(k);
        if(i != -1)
            return keystates[i];

        return false;
    }


}