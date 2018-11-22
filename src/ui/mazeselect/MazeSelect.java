package ui.mazeselect;

import model.ListOfMaze;
import model.MazeMap;
import ui.CurrentMaze;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MazeSelect implements MouseListener {
    private ListOfMaze listOfMaze;
    private CurrentMaze currentMaze;
    private MainFrame mainFrame;
    private JButton[][] jButtons;

    public MazeSelect(ListOfMaze listOfMaze, CurrentMaze currentMaze, MainFrame mainFrame) {
        this.listOfMaze = listOfMaze;
        this.currentMaze = currentMaze;
        this.mainFrame = mainFrame;
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
            removeMaze();
            createMaze(selectedMaze);
            mainFrame.setSelectedMaze(currentMaze);
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

    public void createMaze(MazeMap mazeMap) {
        jButtons = new JButton[mazeMap.get_h()][mazeMap.get_w()];
        mainFrame.getButtonPane().setLayout(new GridLayout(mazeMap.get_h(),mazeMap.get_w()));
        mainFrame.getButtonPane().setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 0; i < mazeMap.get_h(); i++) {
            for (int j = 0; j < mazeMap.get_w(); j++) {
                jButtons[i][j] = new JButton();
                jButtons[i][j].setBackground(mazeMap.get_maze()[i][j].get_background_color());
                jButtons[i][j].setText(mazeMap.get_maze()[i][j].get_text_display());
                mainFrame.getButtonPane().add(jButtons[i][j]);
            }
        }
    }

    public void removeMaze() {
        mainFrame.getButtonPane().removeAll();
        jButtons = null;
        mainFrame.getButtonPane().revalidate();
        mainFrame.repaint();
    }
}
