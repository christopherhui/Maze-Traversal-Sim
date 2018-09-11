package ui;

import events.HandleKeys;

import java.util.*;

public class MazeTraversalSim {
    private static void welcomeSign() {
        System.out.println("Welcome to your create a maze.");
    }

    private static void generateOptions() {
        System.out.println("Options: Press 1 to create a maze. Press 2 to open a preexisting maze. " +
                "Press 3 to import a maze.");
    }
    private static void handleKeys() {
        // todo Helper function used for later
        System.out.println("--- Handles Keys ---");
    }

    public static void main(String[] args) {

        welcomeSign();
        generateOptions();
        handleKeys();

    }
}
