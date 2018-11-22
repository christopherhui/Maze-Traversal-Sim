package model.blocks;

import java.awt.*;

public class Start extends SpecializedBlock{

    public Start() {
        super();
        backgroundColor = Color.PINK;
        textColor = Color.RED;
        text = "S";
        textDisplay = "Start";
    }

    @Override
    public String toString() {
        return text;
    }
}

