package model;

import exceptions.IllegalCharacterException;
import model.blocks.*;

import java.util.Map;

public class BlockConverter {
    MazeMap mazeMap;
    AllBlocks allBlocks;

    Map<String, Class> t;

    public BlockConverter(MazeMap mazeMap) {
        this.mazeMap = mazeMap;
        this.allBlocks = new AllBlocks();
        set_up();
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
        for (SpecializedBlock block : allBlocks.getSpecializedBlocks()) {
            if (block.toString().equals(s)) {
                try {
                    Class c = block.getClass();
                    return (SpecializedBlock) c.newInstance();
                } catch (Exception e) {

                }
            }
        }
        throw new IllegalCharacterException();
    }

    public void set_up() {
        EmptySpace block1 = new EmptySpace();
        End block2 = new End();
        Location block3 = new Location();
        Start block4 = new Start();
        Traversed block5 = new Traversed();
        Wall block6 = new Wall();

        allBlocks.addBlock(block1);
        allBlocks.addBlock(block2);
        allBlocks.addBlock(block3);
        allBlocks.addBlock(block4);
        allBlocks.addBlock(block5);
        allBlocks.addBlock(block6);
    }
}
