package ui.menu;

import model.ListOfMaze;
import ui.saveload.SaveState;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveAsButtonAction implements ActionListener {
    ListOfMaze listOfMaze;

    public SaveAsButtonAction(ListOfMaze listOfMaze) {
        this.listOfMaze = listOfMaze;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select a text file to save to");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files only", "txt");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            SaveState saveState = new SaveState();
            String fileName = jfc.getSelectedFile().getPath().substring(jfc.getSelectedFile().getPath().lastIndexOf("\\")+1);
            System.out.println(fileName);
            try {
                saveState.save(listOfMaze, fileName);
                JOptionPane.showMessageDialog(null, "File successfuly saved.", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
            catch (IOException e1) {
            }
        }
    }
}
