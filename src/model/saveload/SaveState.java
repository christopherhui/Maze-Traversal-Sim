package model.saveload;

import model.ListOfMaze;
import model.MazeMap;

import java.io.IOException;
import java.io.PrintWriter;

public class SaveState {

    // REQUIRES: ListOfMaze is non-empty
    // EFFECTS: saves maze implementation into a output-file
    public void save(ListOfMaze lom, String saveFile) throws IOException {
        PrintWriter writer = new PrintWriter(saveFile,"UTF-8");
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