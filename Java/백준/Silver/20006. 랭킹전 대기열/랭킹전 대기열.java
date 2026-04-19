import java.io.*;
import java.util.*;

public class Main {
    static int p, m;

    public static class Player implements Comparable<Player> {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }

        @Override
        public int compareTo(Player o1) {
            return name.compareTo(o1.name);
        }

    }

    public static class Room {
        int level;
        int size;
        ArrayList<Player> players = new ArrayList<>();

        Room(int level, Player player) {
            this.level = level;
            this.players.add(player);
            size = 1;
        }

        void add(Player player) {
            players.add(player);
            size++;
        }

        int getSize() {
            return players.size();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<Room> rooms = new ArrayList<Room>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            Player player = new Player(Integer.parseInt(st.nextToken()), st.nextToken());
            boolean isJoined = false;

            for (Room room : rooms) {
                if (room.size != m && player.level >= room.level - 10 && player.level <= room.level + 10) {
                    room.add(player);
                    isJoined = true;
                    break;
                }
            }

            if (!isJoined) {
                rooms.add(new Room(player.level, player));
            }
        }

        for (Room room : rooms) {
            if (room.size == m)
                sb.append("Started!\n");
            else
                sb.append("Waiting!\n");

            Collections.sort(room.players);

            for (int i = 0; i < room.players.size(); i++) {
                sb.append(room.players.get(i).level).append(" ").append(room.players.get(i).name).append("\n");
            }
        }

        System.out.println(sb);
    }
}