package ui.saveload;

import exceptions.CannotConvertException;
import exceptions.IllegalCharacterException;
import model.RectangularMazes;
import model.MazeMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadState {

    public void load(RectangularMazes lom) {
        try {
            List<String> lines = Files.readAllLines(Paths.get("savefile.txt"));
            for (String line : lines) {
                try {
                    MazeMap maze = new MazeMap(line);
                    lom.add_maze(maze);
                    System.out.println("Maze successfully added.");
                }
                catch (IllegalCharacterException e) {
                    System.out.println("An unexpected character was found, maze unsuccessfully added.");
                }
                catch (CannotConvertException e) {
                    System.out.println("The maze could not be converted, maze unsuccessfully added.");
                }
            }
        }
        catch (IOException e) {
            System.out.println("No file was found!");
        }
    }
}
