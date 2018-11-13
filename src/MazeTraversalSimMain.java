import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeTraversalSimMain extends JFrame implements ActionListener {
    private JPanel controlPanel;
    private JLabel headerLabel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem newMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem openMenuItem;

    public static void main(String[] args) {
        new MazeTraversalSimMain();
    }

    public MazeTraversalSimMain() {
        super("Maze Traversal Simulator");
        setPreferredSize(new Dimension(600,500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        controlPanel = new JPanel();
        menuBar = new JMenuBar();

        // File Menu Buttons
        fileMenu = new JMenu("File");
        newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);

        saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(this);
        fileMenu.add(saveMenuItem);

        openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener(this);
        fileMenu.add(openMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
