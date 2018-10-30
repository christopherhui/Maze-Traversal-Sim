package model.blocks;

import model.MazeMap;

import java.util.ArrayList;
import java.util.List;

public abstract class SpecializedBlock implements Block, Display {
    protected String backgroundColor;
    protected int status;
    protected String textColor;
    protected List<MazeMap> mazesBelongTo;

    public SpecializedBlock() {
        backgroundColor = "White";
        status = 0;
        textColor = null;
        mazesBelongTo = new ArrayList<>();
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

    abstract public String to_display();
}
