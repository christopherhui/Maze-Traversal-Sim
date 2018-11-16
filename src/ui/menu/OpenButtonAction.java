package ui.menu;

import exceptions.CannotConvertException;
import exceptions.IllegalCharacterException;
import model.ListOfMaze;
import ui.saveload.LoadState;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenButtonAction implements ActionListener {
    ListOfMaze listOfMaze;

    public OpenButtonAction(ListOfMaze listOfMaze) {
        this.listOfMaze = listOfMaze;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select a saved text file");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files only", "txt");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            LoadState loadState = new LoadState();
            String fileName = jfc.getSelectedFile().getPath().substring(jfc.getSelectedFile().getPath().lastIndexOf("\\")+1);
            System.out.println(fileName);
            try {
                loadState.load(listOfMaze, fileName);
            }
            catch (CannotConvertException e1) {
            }
        }
    }
}
