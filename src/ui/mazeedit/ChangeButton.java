package ui.mazeedit;

import exceptions.CannotConvertException;
import exceptions.IllegalCharacterException;
import exceptions.StartEndException;
import model.MazeMap;
import ui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeButton implements ActionListener {
    MainFrame mainFrame;
    MazeMap mazeMap;
    int width;
    int height;
    JButton jButton;

    public ChangeButton(MainFrame mainFrame, MazeMap mazeMap, Integer width, Integer height, JButton jButton) {
        this.mainFrame = mainFrame;
        this.mazeMap = mazeMap;
        this.width = width;
        this.height = height;
        this.jButton = jButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (mainFrame.getButtonStatus()) {
            case ("Empty"):
                try {
                    mazeMap.changeBlock(width, height, "O");
                    System.out.println(mazeMap);
                    jButton.setBackground(mazeMap.get_maze()[width][height].get_background_color());
                    jButton.setText(mazeMap.get_maze()[width][height].get_text_display());
                } catch (CannotConvertException e1) {
                    JOptionPane.showMessageDialog(null, "You cannot replace this block.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                finally {
                    break;
                }
            case ("Wall"):
                try {
                    mazeMap.changeBlock(width, height, "W");
                    System.out.println(mazeMap);
                    jButton.setBackground(mazeMap.get_maze()[width][height].get_background_color());
                    jButton.setText(mazeMap.get_maze()[width][height].get_text_display());
                } catch (CannotConvertException e1) {
                    JOptionPane.showMessageDialog(null, "You cannot replace this block.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                finally {
                    break;
                }
        }
    }
}
