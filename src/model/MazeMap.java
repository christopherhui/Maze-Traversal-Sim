package model;

import exceptions.StartEndException;
import model.blocks.*;
import exceptions.IllegalCharacterException;
import exceptions.LargerLengthException;
import exceptions.ShorterLengthException;

import java.util.*;

public class MazeMap extends SpecializedBlock {
    private int mazeHLength;
    private int mazeWLength;
    private SpecializedBlock[][] maze;
    private BlockConverter bc;
    private BlockFactory bf;
    private String start;
    private String end;

    // REQUIRES: Size of w and size of h is larger than 1, initializes start at (0,0) and end at bottom corner.
    // EFFECTS: Creates an empty w*h size adjacency matrix
    public MazeMap(int w, int h) throws IllegalCharacterException {
        this.mazeWLength = w;
        this.mazeHLength = h;
        this.maze = new SpecializedBlock[h][w];
        this.bc = new BlockConverter(this);
        this.bf = new BlockFactory();
        this.start = "0,0";
        this.end = Integer.toString(mazeHLength-1) + "," + Integer.toString(mazeWLength-1); // Height, Width

        for (int i = 0; i < mazeHLength; i++) {
            for (int j = 0; j < mazeWLength; j++) {
                maze[i][j] = bf.createEmptyBlock();
            }
        }
        maze[0][0] = bf.makeBlock("S");
        maze[mazeHLength-1][mazeWLength-1] = bf.makeBlock("E");
    }

    // REQUIRES: Must be a maze from save state, must be larger than 1, and is a valid block type
    // EFFECTS: Recreates a w*h size adjacency matrix with respective model.blocks
    public MazeMap(String m) throws IllegalCharacterException, ShorterLengthException, LargerLengthException, StartEndException {
        String[] mazeRows = m.split("-");
        this.mazeWLength = mazeRows[0].length();
        this.mazeHLength = mazeRows.length;
        this.maze = new SpecializedBlock[mazeHLength][mazeWLength];
        this.bc = new BlockConverter(this);
        this.start = null;
        this.end = null;

        for (int i = 0; i < mazeHLength; i++) {
            if (mazeRows[i].length() > mazeWLength) {
                System.out.println("\nMaze is longer than expected.");
                throw new LargerLengthException();
            }
            else if(mazeRows[i].length() < mazeWLength) {
                System.out.println("\nMaze is shorter than expected.");
                throw new ShorterLengthException();
            }
            else {
                for (int j = 0; j < mazeWLength; j++) {
                    if (Character.toString(mazeRows[i].charAt(j)).equals("S") && start == null) {
                        start = Integer.toString(i) + "," + Integer.toString(j);
                    }
                    else if (Character.toString(mazeRows[i].charAt(j)).equals("E") && end == null) {
                        end = Integer.toString(i) + "," + Integer.toString(j);
                    }
                    else if (Character.toString(mazeRows[i].charAt(j)).equals("S") && start != null
                            || Character.toString(mazeRows[i].charAt(j)).equals("E") && end != null) {
                        throw new StartEndException();
                    }
                    maze[i][j] = bc.block_converter(Character.toString(mazeRows[i].charAt(j)));
                }
            }
        }
        if (start == null || end == null) {
            throw new StartEndException();
        }
    }

    // EFFECTS: Returns the w-length of maze
    public int get_w() {
        return mazeWLength;
    }

    // EFFECTS: Returns the h-length of maze
    public int get_h() {
        return mazeHLength;
    }

    // EFFECTS: Returns the area of maze
    public int get_area() {
        return mazeWLength * mazeHLength;
    }

    // EFFECTS: Returns the maze
    public SpecializedBlock[][] get_maze() {
        return maze;
    }

    // EFFECTS: prints a w,h matrix representing the maze
    @Override
    public String toString() {
        return bc.toString();
    }

    // REQUIRES: w and h must be within the bounds of MazeMap and must be a valid block type
    // MODIFIES: this
    // EFFECTS: changes the maze with a type of block at w,h
    public void changeBlock(int w, int h, String s) throws IllegalCharacterException, StartEndException {
        String[] dimensionsStart = start.split(",");
        String[] dimensionsEnd = end.split(",");
        if (s.equals("S")) {
            maze[Integer.parseInt(dimensionsStart[0])][Integer.parseInt(dimensionsStart[1])] = bc.block_converter("O");
            maze[w][h] = bc.block_converter("S");
            start = Integer.toString(w) + "," + Integer.toString(h);
        }
        else if (s.equals("E")) {
            maze[Integer.parseInt(dimensionsEnd[0])][Integer.parseInt(dimensionsEnd[1])] = bc.block_converter("O");
            maze[w][h] = bc.block_converter("E");
            end = Integer.toString(w) + "," + Integer.toString(h);
        }
        else if(w == Integer.parseInt(dimensionsStart[0]) && h == Integer.parseInt(dimensionsStart[1])) {
            throw new StartEndException();
        }
        else if(w == Integer.parseInt(dimensionsEnd[0]) && h == Integer.parseInt(dimensionsEnd[1])) {
            throw new StartEndException();
        }
        else {
            maze[w][h] = bc.block_converter(s);
        }
    }

    public void traverseBFS() throws IllegalCharacterException {
        boolean[][] visited = new boolean[mazeHLength][mazeWLength];
        Map<CoordPair<Integer, Integer>, CoordPair<Integer, Integer>> parent = new HashMap<>();
        Queue<CoordPair<Integer, Integer>> queue = new LinkedList<>();
        List<CoordPair<Integer, Integer>> directions = new ArrayList<>();
        boolean found = false;

        directions.add(new CoordPair<>(-1,0));
        directions.add(new CoordPair<>(0, -1));
        directions.add(new CoordPair<>(0, 1));
        directions.add(new CoordPair<>(1, 0));

        for (int i = 0; i < mazeHLength; i++) {
            for (int j = 0; j < mazeWLength; j++) {
                visited[i][j] = false;
            }
        }
        queue.add(new CoordPair<>(Integer.parseInt(start.split(",")[0]), Integer.parseInt(start.split(",")[1])));
        visited[Integer.parseInt(start.split(",")[0])][Integer.parseInt(start.split(",")[1])] = true;

        CoordPair<Integer, Integer> curVal = null;
        while (!queue.isEmpty()) {
            curVal = queue.remove();

            if (curVal.first == Integer.parseInt(end.split(",")[0])
                    && curVal.second == Integer.parseInt(end.split(",")[1])) {
                found = true;
                break;
            }


            // Checks if it is the start or the end block, if it is, it doesn't do anything
            if (curVal.first == Integer.parseInt(start.split(",")[0]) &&
                    curVal.second == Integer.parseInt(start.split(",")[1]) ||
                    curVal.first == Integer.parseInt(end.split(",")[0]) &&
                    curVal.second == Integer.parseInt(end.split(",")[1])) {
            }
            else maze[curVal.second][curVal.first] = bc.block_converter("V");

            // Todo: Add a way to change the block's color, needs an association between ChangeButton and MazeMap
            // Todo: Check if the block is at the end, if it is, then you have finished searching

            for (int i = 0; i < 4; i++) {
                if (curVal.first + directions.get(i).first >= 0 && curVal.first + directions.get(i).first < mazeWLength
                    && curVal.second + directions.get(i).second >= 0 && curVal.second + directions.get(i).second < mazeHLength
                    && !visited[curVal.second+directions.get(i).second][curVal.first+directions.get(i).first]
                    && maze[curVal.second+directions.get(i).second][curVal.first+directions.get(i).first].toString() != "W") {
                        int x = curVal.first+directions.get(i).first;
                        int y = curVal.second+directions.get(i).second;
                        visited[y][x] = true;
                        parent.put(new CoordPair<>(x, y), new CoordPair<>(curVal.first, curVal.second));
                        queue.add(new CoordPair<>(x, y));
                }
            }
        }

        if (found) {
            curVal = parent.get(new CoordPair<>(curVal.first, curVal.second));
            while (curVal.first != Integer.parseInt(start.split(",")[0])
                    || curVal.second != Integer.parseInt(start.split(",")[1])) {
                // Todo: Does a backtrack to find the path from start to end
                maze[curVal.second][curVal.first] = bc.block_converter("F");
                curVal = parent.get(new CoordPair<>(curVal.first, curVal.second));
            }
        }
        System.out.println(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MazeMap mazeMap = (MazeMap) o;
        return mazeHLength == mazeMap.mazeHLength &&
                mazeWLength == mazeMap.mazeWLength &&
                Arrays.equals(maze, mazeMap.maze);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mazeHLength, mazeWLength);
        result = 31 * result + Arrays.hashCode(maze);
        return result;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    private class CoordPair<S, T> {
        S first;
        T second;

        public CoordPair(S x, T y) {
            this.first = x;
            this.second = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CoordPair<?, ?> coordPair = (CoordPair<?, ?>) o;
            return Objects.equals(first, coordPair.first) &&
                    Objects.equals(second, coordPair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
