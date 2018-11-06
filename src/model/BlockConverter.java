package model;

import exceptions.IllegalCharacterException;
import model.blocks.*;

public class BlockConverter {
    MazeMap mazeMap;

    public BlockConverter(MazeMap mazeMap) {
        this.mazeMap = mazeMap;
    }

    // EFFECTS: prints a w,h matrix representing the maze
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < mazeMap.get_h()-1; i++) {
            for (int j = 0; j < mazeMap.get_w()-1; j++) {
                s.append(mazeMap.get_maze()[i][j].toString() + " ");
            }
            s.append(mazeMap.get_maze()[i][mazeMap.get_w()-1].toString());
            s.append("\n");
        }
        for (int j = 0; j < mazeMap.get_w()-1; j++) {
            s.append(mazeMap.get_maze()[mazeMap.get_h()-1][j].toString() + " ");
        }
        s.append(mazeMap.get_maze()[mazeMap.get_h()-1][mazeMap.get_w()-1].toString());
        return s.toString();
    }

    // REQUIRES: must be a valid block type
    // EFFECTS: Changes a String to a Block object representing a block in a maze
    public SpecializedBlock block_converter(String s) throws IllegalCharacterException {
        switch(s) {
            case "O":
                return new EmptySpace();
            case "E":
                return new End();
            case "F":
                return new Location();
            case "S":
                return new Start();
            case "V":
                return new Traversed();
            case "W":
                return new Wall();
        }
        throw new IllegalCharacterException();
    }
}
