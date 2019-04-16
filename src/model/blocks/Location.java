package model.blocks;

import java.awt.*;

public class Location extends SpecializedBlock {

    public Location() {
        super();
        backgroundColor = new Color(143,249,116);
        text = "F";
    }

    @Override
    public String toString() {
        return text;
    }
}
