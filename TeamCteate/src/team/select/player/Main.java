package team.select.player;

import java.util.*;

import static team.select.player.Player.printPlayerList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Player> deshiPlayers = new ArrayList<>(Arrays.asList(
                new Player(75, "Shakib Al Hasan", "Bangladesh"),
                new Player(15, "Mushfiqur Rahim", "Bangladesh"),
                new Player(28, "Tamim Iqbal", "Bangladesh"),
                new Player(30, "Mahmudullah", "Bangladesh"),
                new Player(16, "Liton Das", "Bangladesh"),
                new Player(90, "Mustafizur Rahman", "Bangladesh"),
                new Player(3,  "Taskin Ahmed", "Bangladesh"),
                new Player(32, "Mehidy Hasan", "Bangladesh"),
                new Player(10, "Nasum Ahmed", "Bangladesh"),
                new Player(66, "Afif Hossain", "Bangladesh"),
                new Player(5,  "Mosaddek Hossain", "Bangladesh"),
                new Player(9,  "Nurul Hasan", "Bangladesh"),
                new Player(11, "Ebadot Hossain", "Bangladesh"),
                new Player(47, "Shoriful Islam", "Bangladesh"),
                new Player(21, "Najmul Hossain", "Bangladesh")
        ));

        List<Player> foreignPlayers = new ArrayList<>(Arrays.asList(
                new Player(31, "David Warner", "Australia"),
                new Player(63, "Jos Buttler", "England"),
                new Player(55, "Ben Stokes", "England"),
                new Player(22, "Kane Williamson", "New Zealand"),
                new Player(49, "Steve Smith", "Australia"),
                new Player(56, "Babar Azam", "Pakistan"),
                new Player(18, "Virat Kohli", "India"),
                new Player(18, "Faf du Plessis", "South Africa"),
                new Player(12, "Andre Russell", "West Indies"),
                new Player(19, "Rashid Khan", "Afghanistan")
        ));

        List<String> teamNames = Arrays.asList(
                "Dhaka Dominators",
                "Chattogram Challengers",
                "Khulna Titans",
                "Sylhet Strikers",
                "Rajshahi Royals"
        );

        List<Team> teams = new ArrayList<>();
        for (String name : teamNames) {
            teams.add(new Team(name));
        }

        printPlayerList("Deshi Players BEFORE Shuffle:", deshiPlayers);
        printPlayerList("Foreign Players BEFORE Shuffle:", foreignPlayers);

        System.out.println("<<===========  After Shuffle  ===========>>\n\n");

        Collections.shuffle(deshiPlayers);
        Collections.shuffle(foreignPlayers);

        printPlayerList("Deshi Players:", deshiPlayers);
        printPlayerList("Foreign Players:", foreignPlayers);

        System.out.println("=== Assign Players to Teams ===");

        while (!deshiPlayers.isEmpty() || !foreignPlayers.isEmpty()) {
            System.out.print("\nEnter player name to assign : ");
            String inputName = sc.nextLine().trim();

            if (inputName.equalsIgnoreCase("exit"))
                break;

            Player found = null;

            Iterator<Player> it = deshiPlayers.iterator();
            while (it.hasNext()) {
                Player p = it.next();
                if (p.name.equalsIgnoreCase(inputName)) {
                    found = p;
                    it.remove();
                    break;
                }
            }

            if (found == null) {
                it = foreignPlayers.iterator();
                while (it.hasNext()) {
                    Player p = it.next();
                    if (p.name.equalsIgnoreCase(inputName)) {
                        found = p;
                        it.remove();
                        break;
                    }
                }
            }

            if (found == null) {
                System.out.println(" Player not found or already assigned.");
                continue;
            }

            System.out.print("Assign to which team (1-5)? ");
            int teamNum;
            try {
                teamNum = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid number. Try again.");
                continue;
            }

            if (teamNum < 1 || teamNum > teams.size()) {
                System.out.println(" Invalid team number.");
                continue;
            }

            Team chosen = teams.get(teamNum - 1);
            chosen.addPlayer(found);
            System.out.println("Right " + found.name + " assigned to " + chosen.name);
        }

        System.out.println("\n=== Final Team Rosters ===");
        for (Team t : teams) {
            t.printTeam();
        }

    }
}
