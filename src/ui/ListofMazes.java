package ui;
import java.util.Vector;

public class ListofMazes {
    private int numMazes;
    private Vector<MazeMap> mazeMaps;

    public int get_mazes() {
        return numMazes;
    }

    public void add_maze(MazeMap mazeMap) {
        mazeMaps.add(mazeMap);
        numMazes += 1;
    }

    public void print_maze(int x) {
        System.out.println(mazeMaps.get(x).get_maze());
    }

    public void print_all_mazes() {
        for (MazeMap m : mazeMaps) {
            System.out.println(m.get_maze());
        }
    }
}
