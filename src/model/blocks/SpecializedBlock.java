package model.blocks;

import model.MazeMap;

import java.util.ArrayList;
import java.util.List;

public abstract class SpecializedBlock implements Block, Display {
    protected String backgroundColor;
    protected int status;
    protected String textColor;
    protected String text;

    public SpecializedBlock() {
        backgroundColor = "White";
        status = 0;
        textColor = null;
        text = null;
    }

    public String get_background_color() {
        return backgroundColor;
    }

    public int get_status() {
        return status;
    }

    public String get_text_color() {
        return textColor;
    }

    public abstract String toString();
}
