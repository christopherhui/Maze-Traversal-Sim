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

    public static void main(String[] args) {
        new MazeTraversalSimMain();
    }

    public MazeTraversalSimMain() {
        super("Maze Traversal Simulator");
        setPreferredSize(new Dimension(400,300));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);

        controlPanel = new JPanel();
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        newMenuItem = new JMenuItem("New",new ImageIcon(this.getClass().getResource("model/Images/New.png")));
        newMenuItem.addActionListener(this);
        fileMenu.add(newMenuItem);

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
