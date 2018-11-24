package ui.mazeedit;

import model.MazeMap;
import ui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TraverseButtonActionListener implements ActionListener {
    private MainFrame mainFrame;
    private MazeMap mazeMap;

    public TraverseButtonActionListener(MainFrame mainFrame, MazeMap mazeMap) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] dimensionsStart = mazeMap.getStart().split(",");
    }
}
