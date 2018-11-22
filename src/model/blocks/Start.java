package model.blocks;

import java.awt.*;

public class Start extends SpecializedBlock{

    public Start() {
        super();
        backgroundColor = new Color(204, 223, 255);
        textColor = Color.RED;
        text = "S";
        textDisplay = "Start";
    }

    @Override
    public String toString() {
        return text;
    }
}

