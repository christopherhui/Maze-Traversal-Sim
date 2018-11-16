import model.ListOfMaze;
import ui.menu.NewButtonAction;
import ui.menu.OpenButtonAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeTraversalSimMain extends JFrame implements ActionListener {
    private final int WIDTH = 600;
    private final int HEIGHT = 500;

    private JPanel controlPanel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem openMenuItem;
    private ListOfMaze listOfMaze;
    private DefaultListModel<String> defaultListModel;

    public static void main(String[] args) {
        new MazeTraversalSimMain();
    }

    public MazeTraversalSimMain() {
        super("Maze Traversal Simulator");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        controlPanel = new JPanel();
        menuBar = new JMenuBar();

        listOfMaze = new ListOfMaze();
        defaultListModel = new DefaultListModel<>();

        // File Menu Buttons
        fileMenu = new JMenu("File");
        newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new NewButtonAction(listOfMaze, defaultListModel));
        fileMenu.add(newMenuItem);

        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(this);
        fileMenu.add(saveMenuItem);

        openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(new OpenButtonAction(listOfMaze, defaultListModel));
        fileMenu.add(openMenuItem);
        menuBar.add(fileMenu);

        //sideBar creation
        JList<String> mazesAvaliable = new JList<>(defaultListModel);
        mazesAvaliable.setBounds(1,1,1,1);
        add(mazesAvaliable);

        setJMenuBar(menuBar);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ok");
    }
}
