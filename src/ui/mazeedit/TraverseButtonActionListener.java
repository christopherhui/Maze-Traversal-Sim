package ui.mazeedit;

import exceptions.IllegalCharacterException;
import model.MazeMap;
import ui.MainFrame;
import ui.MazeInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TraverseButtonActionListener implements ActionListener {
    MainFrame mainFrame;
    MazeMap mazeMap;

    public TraverseButtonActionListener(MainFrame mainFrame, MazeMap mazeMap) {
        this.mainFrame = mainFrame;
        this.mazeMap = mazeMap;
    }

    public void setMazeMap(MazeMap mazeMap) {
        this.mazeMap = mazeMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.changeButtonStatus("Traverse");
        try {
            mazeMap.traverseBFS();
        } catch (IllegalCharacterException e1) {
            e1.printStackTrace();
        } catch (NullPointerException e2) {
            JOptionPane.showMessageDialog(null, "No maze was selected.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
