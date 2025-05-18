package team.select.player;

import java.util.*;

public class Player {
    int jerseyNumber;
    String name;
    String country;

    public Player(int jerseyNumber, String name, String country) {
        this.jerseyNumber = jerseyNumber;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return name + " (" + country + ", #" + jerseyNumber + ")";
    }

    public static void printPlayerList(String title, List<Player> players) {
        System.out.println(title);
        for (Player p : players) {
            System.out.println("  " + p);
        }
        System.out.println();
    }
}
