import model.ListOfMaze;
import model.MazeMap;
import ui.CurrentMaze;
import ui.mazeselect.MazeSelect;
import ui.menu.NewButtonAction;
import ui.menu.OpenButtonAction;
import ui.menu.SaveAsButtonAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeTraversalSimMain extends JFrame {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu mazeMenu;
    private ListOfMaze listOfMaze;
    private DefaultListModel<String> defaultListModel;
    private CurrentMaze selectedMaze;

    public static void main(String[] args) {
        new MazeTraversalSimMain();
    }

    public MazeTraversalSimMain() {
        super("Maze Traversal Simulator");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        menuBar = new JMenuBar();
        listOfMaze = new ListOfMaze();
        defaultListModel = new DefaultListModel<>();
        selectedMaze = new CurrentMaze();

        setJMenuBar(menuBar);

        // File Menu Buttons
        fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new NewButtonAction(listOfMaze, defaultListModel));
        fileMenu.add(newMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save As");
        saveMenuItem.addActionListener(new SaveAsButtonAction(listOfMaze));
        fileMenu.add(saveMenuItem);

        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(new OpenButtonAction(listOfMaze, defaultListModel));
        fileMenu.add(openMenuItem);
        menuBar.add(fileMenu);

        // Maze Menu Buttons
        mazeMenu = new JMenu("Maze");
        mazeMenu.setEnabled((selectedMaze.get_curr_maze() != null));
        menuBar.add(mazeMenu);

        //sideBar creation
        JList<String> mazesAvaliable = new JList<>(defaultListModel);
        mazesAvaliable.addMouseListener(new MazeSelect(listOfMaze, selectedMaze));
        add(mazesAvaliable, BorderLayout.EAST);

        //JButton creation
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(3,3));
        buttonPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPane.add(new JButton());
        buttonPane.add(new JButton());
        buttonPane.add(new JButton());
        buttonPane.add(new JButton());
        buttonPane.add(new JButton());
        buttonPane.add(new JButton());buttonPane.add(new JButton());buttonPane.add(new JButton());buttonPane.add(new JButton());

        add(buttonPane);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
