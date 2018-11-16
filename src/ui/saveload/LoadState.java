package ui.saveload;

import exceptions.CannotConvertException;
import exceptions.IllegalCharacterException;
import model.ListOfMaze;
import model.MazeMap;
import ui.menu.OpenButtonAction;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LoadState {

    // TODO: repetition help?
    public void load(ListOfMaze lom, String string) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(string));
            for (String line : lines) {
                MazeMap maze = new MazeMap(line);
                lom.add_maze(maze);
            }
        }
        catch (CannotConvertException e1) {
            System.out.println();
        }
        catch (IOException e) {
            System.out.println("No file was found!");
        }
    }

    public void load(ListOfMaze lom, String string, DefaultListModel defaultListModel) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(string));
            for (String line : lines) {
                MazeMap maze = new MazeMap(line);
                lom.add_maze(maze);
                defaultListModel.addElement("Loaded maze: " + maze.get_w() + " by " + maze.get_h() + " dimensions.");
            }
        }
        catch (CannotConvertException e1) {
            System.out.println();
        }
        catch (IOException e) {
            System.out.println("No file was found!");
        }
    }
}
