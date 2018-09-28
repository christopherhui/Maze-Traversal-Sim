package ui;

import model.ListofMazes;
import model.MazeMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadState {

    public void load(ListofMazes lom) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("savefile.txt"));
        for (String line : lines) {
            MazeMap maze = new MazeMap(line);
            lom.add_maze(maze);
        }
    }
}
