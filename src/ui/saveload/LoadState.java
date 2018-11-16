package ui.saveload;

import exceptions.CannotConvertException;
import exceptions.IllegalCharacterException;
import model.ListOfMaze;
import model.MazeMap;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadState {

    public void load(ListOfMaze lom, String string) throws IllegalCharacterException, CannotConvertException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(string));
            for (String line : lines) {
                MazeMap maze = new MazeMap(line);
                lom.add_maze(maze);
                System.out.println("Maze successfully added.");
            }
        }
        catch (IOException e) {
            System.out.println("No file was found!");
        }
    }
}
