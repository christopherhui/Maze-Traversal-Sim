package ui;

import model.ListOfMaze;
import ui.mazeedit.*;
import ui.menu.NewButtonAction;
import ui.menu.OpenButtonAction;
import ui.menu.SaveAsButtonAction;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu mazeMenu;
    private ListOfMaze listOfMaze;
    private DefaultListModel<String> defaultListModel;
    private CurrentMaze selectedMaze;
    private JPanel buttonPane;
    private JPanel barButtons;
    private String selectedButton;
    private JLabel textButtonSelect;
    private TraverseButtonActionListener traverseActionListener;
    private ClearButtonActionListener clearButtonActionListener;
    private MazeInterface mazeInterface;

    public MainFrame() {
        super("Maze Traversal Simulator");
    }

    public void main() {
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        menuBar = new JMenuBar();
        listOfMaze = new ListOfMaze();
        defaultListModel = new DefaultListModel<>();
        selectedMaze = new CurrentMaze();
        buttonPane = new JPanel();
        barButtons = new JPanel();
        selectedButton = "";

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

        //sideBar creation
        JList<String> mazesAvaliable = new JList<>(defaultListModel);
        mazeInterface = new MazeInterface(listOfMaze, selectedMaze, this);
        mazesAvaliable.addMouseListener(mazeInterface);
        add(mazesAvaliable, BorderLayout.EAST);

        //JButton creation
        add(buttonPane, BorderLayout.CENTER);

        //barButtons creation
        barButtons.setLayout(new FlowLayout());
        barButtons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        textButtonSelect = new JLabel("Button selected: None");
        setupButtons();
        barButtons.add(textButtonSelect);
        add(barButtons, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel getButtonPane() {
        return buttonPane;
    }

    public void setSelectedMaze(CurrentMaze selectedMaze) {
        this.selectedMaze = selectedMaze;
        traverseActionListener.setMazeMap(selectedMaze.get_curr_maze());
        clearButtonActionListener.setMazeMap(selectedMaze.get_curr_maze());
    }

    public void setupButtons() {

        JButton emptyButton = new JButton("Empty");
        emptyButton.setBackground(Color.WHITE);
        emptyButton.addActionListener(new EmptyButtonActionListener(this));
        barButtons.add(emptyButton);

        JButton wallButton = new JButton("Wall");
        wallButton.setBackground(Color.GRAY);
        wallButton.addActionListener(new WallButtonActionListener(this));
        barButtons.add(wallButton);

        JButton startButton = new JButton("Start");
        startButton.setBackground(new Color(204, 223, 255));
        startButton.addActionListener(new StartButtonActionListener(this));
        barButtons.add(startButton);

        JButton endButton = new JButton("End");
        endButton.setBackground(new Color(211, 111, 242));
        endButton.addActionListener(new EndButtonActionListener(this));
        barButtons.add(endButton);

        JButton traverseButton = new JButton("Traverse");
        traverseButton.setBackground(Color.YELLOW);
        traverseActionListener = new TraverseButtonActionListener(this, selectedMaze.get_curr_maze());
        traverseButton.addActionListener(traverseActionListener);
        barButtons.add(traverseButton);

        JButton clearbutton = new JButton("Clear");
        clearbutton.setBackground(Color.RED);
        clearButtonActionListener = new ClearButtonActionListener(this, selectedMaze.get_curr_maze());
        clearbutton.addActionListener(clearButtonActionListener);
        barButtons.add(clearbutton);
    }

    public void changeButtonStatus(String status) {
        selectedButton = status;
        textButtonSelect.setText("Button selected: " + status);
    }

    public String getButtonStatus() {
        return selectedButton;
    }
}
