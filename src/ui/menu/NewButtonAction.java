package ui.menu;

import exceptions.IllegalCharacterException;
import exceptions.SizeException;
import model.ListOfMaze;
import model.MazeMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewButtonAction extends JFrame implements ActionListener {
    private ListOfMaze listOfMaze;
    private DefaultListModel defaultListModel;

    public NewButtonAction(ListOfMaze listOfMaze, DefaultListModel defaultListModel) {
        this.listOfMaze = listOfMaze;
        this.defaultListModel = defaultListModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String width = JOptionPane.showInputDialog("What size is your new maze width?");
        String height = JOptionPane.showInputDialog("What size is your new maze height?");
        try {
            checkConditions(width,height);
            listOfMaze.add_maze(new MazeMap(Integer.parseInt(width), Integer.parseInt(height)));
            JOptionPane.showMessageDialog(null, "Maze successfully created.", "Message", JOptionPane.INFORMATION_MESSAGE);
            defaultListModel.addElement("Maze " + defaultListModel.size() + ": " + width + " by " + height + " dimensions.");
        } catch (SizeException e1) {
            JOptionPane.showMessageDialog(null, "Size of maze must be between 3-30.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException e2) {
            JOptionPane.showMessageDialog(null, "The input was not a valid number.", "Error", JOptionPane.WARNING_MESSAGE);
        } catch (IllegalCharacterException e3 ) {
        }
    }

    public void checkConditions(String width, String height) throws SizeException, NumberFormatException {
        int widthNum = Integer.parseInt(width);
        int heightNum = Integer.parseInt(height);
        // Cannot be larger than 30 or smaller than 3
        if (widthNum > 30 || widthNum <= 2 || heightNum > 30 || heightNum <= 2) {
            throw new SizeException();
        }
    }
}
