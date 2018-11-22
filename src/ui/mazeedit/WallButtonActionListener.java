package ui.mazeedit;

import ui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WallButtonActionListener implements ActionListener {
    MainFrame mainFrame;

    public WallButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.changeButtonStatus("Wall");
    }
}
