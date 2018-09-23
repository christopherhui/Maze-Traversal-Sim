package ui;

public class MazeMap {
    private int mazeXLength;
    private int mazeYLength;
    private String[][] maze;

    // REQUIRES: Size of x and size of y is larger than 1
    // EFFECTS: Creates an empty x*y size adjacency matrix
    public MazeMap(int x, int y) {
        this.mazeXLength = x;
        this.mazeYLength = y;
        this.maze = new String[x][y];

        for (int i = 0; i < mazeXLength; i++) {
            for (int j = 0; j < mazeYLength; j++) {
                maze[i][j] = "O";
            }
        }
    }

    // EFFECTS: Returns the x-length of maze
    public int get_x() {
        return mazeXLength;
    }

    // EFFECTS: Returns the y-length of maze
    public int get_y() {
        return mazeYLength;
    }

    // EFFECTS: Returns the area of maze
    public int get_area() {
        return mazeXLength * mazeYLength;
    }

    // EFFECTS: Returns the maze
    public String[][] get_maze() {
        return maze;
    }

    // EFFECTS: prints a x,y matrix representing the maze
    public String toString() {
        String s = "";
        for (int i = 0; i < mazeXLength-1; i++) {
            for (int j = 0; j < mazeYLength-1; j++) {
                s += maze[i][j] + " ";
            }
            s += maze[i][mazeYLength-1];
            s += "\n";
        }
        for (int j = 0; j < mazeYLength-1; j++) {
            s += maze[mazeXLength-1][j] + " ";
        }
        s += maze[mazeXLength-1][mazeYLength-1];
        return s;
    }
}
