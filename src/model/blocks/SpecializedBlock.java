package model.blocks;

import model.MazeMap;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class SpecializedBlock implements Block, Display {
    protected Color backgroundColor;
    protected int status;
    protected Color textColor;
    protected String text;
    protected String textDisplay;

    public SpecializedBlock() {
        backgroundColor = Color.WHITE;
        status = 0;
        textColor = null;
        text = null;
        textDisplay = null;
    }

    public Color get_background_color() {
        return backgroundColor;
    }

    public String get_text() {return text;}

    public String get_text_display() {return textDisplay;}

    public int get_status() {
        return status;
    }

    public Color get_text_color() {
        return textColor;
    }

    public abstract String toString();
}
