package ui.mazeedit;

import ui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonActionListener implements ActionListener {
    MainFrame mainFrame;

    public StartButtonActionListener(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.changeButtonStatus("Start");
    }
}
