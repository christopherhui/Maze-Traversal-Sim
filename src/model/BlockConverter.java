package model;

import exceptions.IllegalCharacterException;
import model.blocks.*;

import java.util.Map;

public class BlockConverter {
    MazeMap mazeMap;
    AllBlocks allBlocks;

    public BlockConverter(MazeMap mazeMap) {
        this.mazeMap = mazeMap;
        this.allBlocks = new AllBlocks();
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
        BlockFactory blockFactory = new BlockFactory();
        return blockFactory.makeBlock(s);
    }
}
