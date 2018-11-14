package ui;

import model.ListOfMaze;
import ui.statuses.*;

import java.util.Scanner;

public class MazeEvents {
    private Scanner keys;
    private Messages messages;
    private CurrentMaze cm;

    private StatusZero sz;
    private StatusOne s1;
    private StatusTwo s2;
    private StatusThree s3;
    private StatusFour s4;

    public MazeEvents() {
        this.keys = new Scanner(System.in);
        this.messages = new Messages();
        this.cm = new CurrentMaze();

        this.sz = new StatusZero();
        this.s1 = new StatusOne();
        this.s2 = new StatusTwo();
        this.s3 = new StatusThree();
        this.s4 = new StatusFour();
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom, st
    // EFFECTS: Runs the main model for the creation, edit, and deletion of mazes
    public void handle_key() {

        ListOfMaze lom = new ListOfMaze();
        CurrentStatus st = new CurrentStatus();

        messages.main_menu();
        while (keys.hasNext()) {
            String key = keys.nextLine();
            getStatusState(lom, st, key);
        }
    }

    // Zero: Main menu of program
    // One: Runs the creation of maze using dimensions
    // Two: Accesses a certain maze created previously
    // Three: Does things to selected maze
    private void getStatusState(ListOfMaze lom, CurrentStatus st, String key) {
        if (st.get_status() == 0) {
            run_status_zero(keys, key, lom, st);
        }
        else if(st.get_status() == 1) {
            run_status_one(key, lom, st);
        }
        else if(st.get_status() == 2) {
            run_status_two(cm, key, lom, st);
        }
        else if(st.get_status() == 3) {
            run_status_three(cm, key, lom, st);
        }
        else if(st.get_status() == 4) {
            run_status_four(cm, key, st);
        }
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom (in the future), st
    // EFFECTS: Runs the creation, access of a maze and termination of program
    public void run_status_zero(Scanner keys, String key, ListOfMaze lom, CurrentStatus st) {
        sz.run_status_zero(keys, key, lom, st);
    }

    // REQUIRES: Is a String input
    // MODIFIES: this, lom, st
    // EFFECTS: Creates a maze with w,h dimensions, and must have values greater than 1
    public void run_status_one(String key, ListOfMaze lom, CurrentStatus st) {
        s1.run_status_one(key,lom,st);
    }

    public void run_status_two(CurrentMaze cm, String key, ListOfMaze lom, CurrentStatus st) {
        s2.run_status_two(cm, key, lom, st);
    }

    public void run_status_three(CurrentMaze cm, String key, ListOfMaze lom, CurrentStatus st) {
        s3.run_status_three(cm, key, lom, st);
    }

    public void run_status_four(CurrentMaze cm, String key, CurrentStatus st) {
        s4.run_status_four(cm, key, st);
    }
}
