package model;

import blocks.*;

import java.util.List;

public class MazeMap {
    private int mazeHLength;
    private int mazeWLength;
    private SpecializedBlock[][] maze;

    // TODO: change to different data structure
    // REQUIRES: Size of w and size of h is larger than 1
    // EFFECTS: Creates an empty w*h size adjacency matrix
    public MazeMap(int w, int h) {
        this.mazeWLength = w;
        this.mazeHLength = h;
        this.maze = new SpecializedBlock[h][w];

        for (int i = 0; i < mazeHLength; i++) {
            for (int j = 0; j < mazeWLength; j++) {
                maze[i][j] = new EmptySpace();
            }
        }
    }

    // REQUIRES: Must be a maze from save state, must be larger than 1, and is a valid block type
    // EFFECTS: Recreates a w*h size adjacency matrix with respective blocks
    public MazeMap(String m) {
        String[] mazeRows = m.split("-");
        this.mazeWLength = mazeRows[0].length();
        this.mazeHLength = mazeRows.length;
        this.maze = new SpecializedBlock[mazeHLength][mazeWLength];

        for (int i = 0; i < mazeHLength; i++) {
            for (int j = 0; j < mazeWLength; j++) {
                maze[i][j] = block_converter(Character.toString(mazeRows[i].charAt(j)));
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
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < mazeHLength-1; i++) {
            for (int j = 0; j < mazeWLength-1; j++) {
                s.append(maze[i][j].to_display() + " ");
            }
            s.append(maze[i][mazeWLength-1].to_display());
            s.append("\n");
        }
        for (int j = 0; j < mazeWLength-1; j++) {
            s.append(maze[mazeHLength-1][j].to_display() + " ");
        }
        s.append(maze[mazeHLength-1][mazeWLength-1].to_display());
        return s.toString();
    }

    // EFFECTS: Changes a String to a Block object representing a block in a maze
    private SpecializedBlock block_converter(String s) {
        switch(s) {
            case "O":
                return new EmptySpace();
            case "E":
                return (End)new End();
            case "F":
                return new Location();
            case "S":
                return new Start();
            case "V":
                return new Traversed();
            case "W":
                return new Wall();
        }
        return new EmptySpace();
    }
}
