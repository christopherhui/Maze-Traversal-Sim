package ui.saveload;

import model.RectangularMazes;
import model.MazeMap;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class SaveState {

    // REQUIRES: RectangularMazes is non-empty
    // EFFECTS: saves maze implementation into a output-file
    public void save(RectangularMazes lom) throws IOException {
        PrintWriter writer = new PrintWriter("savefile.txt","UTF-8");
        for (MazeMap mazeMap : lom.get_mazes()) {
            writer.println(save_maze(mazeMap));
        }
        writer.close();
    }

    private String save_maze(MazeMap maze) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < maze.get_h()-1; i++) {
            for (int j = 0; j < maze.get_w()-1; j++) {
                s.append(maze.get_maze()[i][j].toString());
            }
            s.append(maze.get_maze()[i][maze.get_w()-1].toString());
            s.append("-");
        }
        for (int j = 0; j < maze.get_w()-1; j++) {
            s.append(maze.get_maze()[maze.get_h()-1][j].toString());
        }
        s.append(maze.get_maze()[maze.get_h()-1][maze.get_w()-1].toString());
        return s.toString();
    }
}