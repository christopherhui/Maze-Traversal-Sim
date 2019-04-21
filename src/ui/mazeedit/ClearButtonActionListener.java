package ui.mazeedit;

import model.MazeMap;
import ui.MainFrame;
import ui.MazeInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButtonActionListener implements ActionListener {
    private MainFrame mainFrame;
    private MazeMap mazeMap;

    public ClearButtonActionListener(MainFrame mainFrame, MazeMap curr_maze) {
        this.mainFrame = mainFrame;
        this.mazeMap = curr_maze;
    }

    public void setMazeMap(MazeMap mazeMap) {
        this.mazeMap = mazeMap;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mazeMap.clearBlocks();
        mainFrame.changeButtonStatus("Clear");
    }
}
