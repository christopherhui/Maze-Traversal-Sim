import model.ListOfMaze;
import model.MazeMap;
import ui.CurrentMaze;
import ui.MainFrame;
import ui.mazeselect.MazeSelect;
import ui.menu.NewButtonAction;
import ui.menu.OpenButtonAction;
import ui.menu.SaveAsButtonAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeTraversalSimMain extends JFrame {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.main();
    }
}
