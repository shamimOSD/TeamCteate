package team.select.player;

import java.util.*;
public class Team {
    String name;
    List<Player> players;

    public Team(String name) {
        this.name = name;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void printTeam() {
        System.out.println(name + ":");
        for (Player p : players) {
            System.out.println("  " + p);
        }
        System.out.println();
    }
}
