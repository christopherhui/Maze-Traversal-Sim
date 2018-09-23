package ui;

public class MazeMap {
    private int mazeHLength;
    private int mazeWLength;
    private String[][] maze;

    // REQUIRES: Size of w and size of h is larger than 1
    // EFFECTS: Creates an empty w*h size adjacency matrix
    public MazeMap(int w, int h) {
        this.mazeWLength = w;
        this.mazeHLength = h;
        this.maze = new String[h][w];

        for (int i = 0; i < mazeHLength; i++) {
            for (int j = 0; j < mazeWLength; j++) {
                maze[i][j] = "O";
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
    public String[][] get_maze() {
        return maze;
    }

    // EFFECTS: prints a w,h matrix representing the maze
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < mazeHLength-1; i++) {
            for (int j = 0; j < mazeWLength-1; j++) {
                s.append(maze[i][j] + " ");
            }
            s.append(maze[i][mazeWLength-1]);
            s.append("\n");
        }
        for (int j = 0; j < mazeWLength-1; j++) {
            s.append(maze[mazeHLength-1][j] + " ");
        }
        s.append(maze[mazeHLength-1][mazeWLength-1]);
        return s.toString();
    }
}
