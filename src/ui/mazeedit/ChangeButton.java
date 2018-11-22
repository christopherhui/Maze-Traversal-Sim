package ui.mazeedit;

import exceptions.CannotConvertException;
import model.MazeMap;
import ui.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeButton implements ActionListener {
    MainFrame mainFrame;
    MazeMap mazeMap;
    int width;
    int height;
    JButton jButtonSelected;
    JButton[][] jButtons;


    public ChangeButton(MainFrame mainFrame, MazeMap mazeMap, Integer width, Integer height, JButton selectButton, JButton[][] jButtons) {
        this.mainFrame = mainFrame;
        this.mazeMap = mazeMap;
        this.width = width;
        this.height = height;
        this.jButtonSelected = selectButton;
        this.jButtons = jButtons;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (mainFrame.getButtonStatus()) {
            case ("Empty"):
                try {
                    mazeMap.changeBlock(width, height, "O");
                    changeBlock();
                } catch (CannotConvertException e1) {
                    JOptionPane.showMessageDialog(null, "You cannot replace this block.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                finally {
                    break;
                }
            case ("Wall"):
                try {
                    mazeMap.changeBlock(width, height, "W");
                    changeBlock();
                } catch (CannotConvertException e1) {
                    JOptionPane.showMessageDialog(null, "You cannot replace this block.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                finally {
                    break;
                }
            case ("Start"):
                try {
                    String[] dimensionsStart = mazeMap.getStart().split(",");
                    jButtons[Integer.parseInt(dimensionsStart[0])][Integer.parseInt(dimensionsStart[1])].setBackground(Color.WHITE);
                    jButtons[Integer.parseInt(dimensionsStart[0])][Integer.parseInt(dimensionsStart[1])].setText("");
                    mazeMap.changeBlock(width, height, "S");
                    changeBlock();
                } catch (CannotConvertException e1) {
                    JOptionPane.showMessageDialog(null, "You cannot replace this block.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                finally {
                    break;
                }
            case ("End"):
                try {
                    String[] dimensionsEnd = mazeMap.getEnd().split(",");
                    jButtons[Integer.parseInt(dimensionsEnd[0])][Integer.parseInt(dimensionsEnd[1])].setBackground(Color.WHITE);
                    jButtons[Integer.parseInt(dimensionsEnd[0])][Integer.parseInt(dimensionsEnd[1])].setText("");
                    mazeMap.changeBlock(width, height, "E");
                    changeBlock();
                } catch (CannotConvertException e1) {
                    JOptionPane.showMessageDialog(null, "You cannot replace this block.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                finally {
                    break;
                }
        }
    }

    public void changeBlock() {
        System.out.println(mazeMap);
        jButtonSelected.setBackground(mazeMap.get_maze()[width][height].get_background_color());
        jButtonSelected.setText(mazeMap.get_maze()[width][height].get_text_display());
    }
}
