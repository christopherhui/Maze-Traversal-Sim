package ui;

public class MazeMap {
    private int mazeXLength;
    private int mazeYLength;
    private String[][] maze;

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

    // todo: Create a method to create a maze
    public int get_x() {
        return mazeXLength;
    }

    public int get_y() {
        return mazeYLength;
    }

    public String[][] get_maze() {
        return maze;
    }
}
