package ui.mazeselect;

import model.ListOfMaze;
import model.MazeMap;
import ui.CurrentMaze;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MazeSelect implements MouseListener {
    private ListOfMaze listOfMaze;
    private CurrentMaze currentMaze;

    public MazeSelect(ListOfMaze listOfMaze, CurrentMaze currentMaze) {
        this.listOfMaze = listOfMaze;
        this.currentMaze = currentMaze;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.getPoint());
        Object obj = e.getSource();
        if (obj instanceof JList) {
            JList list = (JList) obj;
            String name = (String)list.getModel().getElementAt(list.locationToIndex(e.getPoint()));
            String[] parsedName = name.split(" ");
            MazeMap selectedMaze = listOfMaze.get_maze(Character.getNumericValue(parsedName[1].charAt(0)));
            currentMaze.set_curr_maze(selectedMaze);
            System.out.println(listOfMaze.get_maze(Character.getNumericValue(parsedName[1].charAt(0))));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
