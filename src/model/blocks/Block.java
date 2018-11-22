package model.blocks;

import java.awt.*;

public interface Block {
    // EFFECTS: gets the background color of the block
    Color get_background_color();

    // EFFECTS: gets the type of block in the maze
    int get_status();

    // EFFECTS: returns the string version of object
    String toString();
}
