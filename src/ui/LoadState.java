package ui;

import exceptions.CannotConvertException;
import exceptions.IllegalCharacterException;
import model.ListofMazes;
import model.MazeMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadState {

    public void load(ListofMazes lom) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("savefile.txt"));
            for (String line : lines) {
                try {
                    MazeMap maze = new MazeMap(line);
                    lom.add_maze(maze);
                }
                catch (IllegalCharacterException e) {
                    System.out.println("An unexpected character was found, maze unsuccessfully added.");
                }
            }
        }
        catch (IOException e) {
            System.out.println("No file was found!");
        }
    }
}
