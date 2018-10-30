package ui;

import model.MazeMap;

public class CurrentMaze {
    private MazeMap currMaze;
    private int currMazeNum;

    public int get_curr_maze_num() {
        return currMazeNum;
    }

    public void set_curr_maze_num(int i) {
        currMazeNum = i;
    }

    public MazeMap get_curr_maze() {
        return currMaze;
    }

    public void set_curr_maze(MazeMap m) { currMaze = m; }
}
