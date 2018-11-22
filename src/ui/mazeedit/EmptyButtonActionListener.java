package ui.mazeedit;

import model.blocks.EmptySpace;
import ui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmptyButtonActionListener implements ActionListener {
    MainFrame mainFrame;

    public EmptyButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.changeButtonStatus("Empty");
    }
}
