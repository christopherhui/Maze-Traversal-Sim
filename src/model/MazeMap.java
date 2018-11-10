package model;

import model.blocks.*;
import exceptions.IllegalCharacterException;
import exceptions.LargerLengthException;
import exceptions.ShorterLengthException;

import java.util.Arrays;
import java.util.Objects;

public class MazeMap extends SpecializedBlock {
    private int mazeHLength;
    private int mazeWLength;
    private SpecializedBlock[][] maze;
    private BlockConverter bc;
    private BlockFactory bf;

    // REQUIRES: Size of w and size of h is larger than 1
    // EFFECTS: Creates an empty w*h size adjacency matrix
    public MazeMap(int w, int h) {
        this.mazeWLength = w;
        this.mazeHLength = h;
        this.maze = new SpecializedBlock[h][w];
        this.bc = new BlockConverter(this);
        this.bf = new BlockFactory();

        for (int i = 0; i < mazeHLength; i++) {
            for (int j = 0; j < mazeWLength; j++) {
                maze[i][j] = bf.createEmptyBlock();
            }
        }
    }

    // REQUIRES: Must be a maze from save state, must be larger than 1, and is a valid block type
    // EFFECTS: Recreates a w*h size adjacency matrix with respective model.blocks
    public MazeMap(String m) throws IllegalCharacterException, ShorterLengthException, LargerLengthException {
        String[] mazeRows = m.split("-");
        this.mazeWLength = mazeRows[0].length();
        this.mazeHLength = mazeRows.length;
        this.maze = new SpecializedBlock[mazeHLength][mazeWLength];
        this.bc = new BlockConverter(this);

        for (int i = 0; i < mazeHLength; i++) {
            if (mazeRows[i].length() > mazeWLength) {
                System.out.println("\nMaze is longer than expected.");
                throw new LargerLengthException();
            }
            else if(mazeRows[i].length() < mazeWLength) {
                System.out.println("\nMaze is shorter than expected.");
                throw new ShorterLengthException();
            }
            else {
                for (int j = 0; j < mazeWLength; j++) {
                    maze[i][j] = bc.block_converter(Character.toString(mazeRows[i].charAt(j)));
                }
            }
        }
    }

    // EFFECTS: Returns the w-length of maze
    public int get_w() {
        return mazeWLength;
    }

    // EFFECTS: Returns the h-length of maze
    public int get_h() {
        return mazeHLength;
    }

    // EFFECTS: Returns the area of maze
    public int get_area() {
        return mazeWLength * mazeHLength;
    }

    // EFFECTS: Returns the maze
    public SpecializedBlock[][] get_maze() {
        return maze;
    }

    // EFFECTS: prints a w,h matrix representing the maze
    @Override
    public String toString() {
        return bc.toString();
    }

    // REQUIRES: w and h must be within the bounds of MazeMap and must be a valid block type
    // MODIFIES: this
    // EFFECTS: changes the maze with a type of block at w,h
    public void changeBlock(int w, int h, String s) throws IllegalCharacterException {
        maze[w][h] = bc.block_converter(s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazeMap mazeMap = (MazeMap) o;
        return mazeHLength == mazeMap.mazeHLength &&
                mazeWLength == mazeMap.mazeWLength &&
                Arrays.equals(maze, mazeMap.maze);
    }

    @Override
    public int hashCode() {

        int result = Objects.hash(mazeHLength, mazeWLength);
        result = 31 * result + Arrays.hashCode(maze);
        return result;
    }
}
