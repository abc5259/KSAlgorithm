package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20006 {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            Player player = new Player(score, name);

            boolean isEnter = false;
            for (Room room : rooms) {
                if(room.canEnter(score)) {
                    room.enter(player);
                    isEnter = true;
                    break;
                }
            }

            if(!isEnter) {
                Room room = new Room(player);
                rooms.add(room);
            }
        }

        StringBuffer sb = new StringBuffer();
        for (Room room : rooms) {
            if(room.player.size() == M) {
                sb.append("Started!\n");
            }else {
                sb.append("Waiting!\n");
            }

            while (!room.player.isEmpty()) {
                Player p = room.player.poll();
                sb.append(p.score + " " + p.name).append("\n");
            }
        }

        System.out.print(sb);
    }

    static class Room {
        PriorityQueue<Player> player = new PriorityQueue<>((a,b) -> a.name.compareTo(b.name));
        int score;

        public Room(Player p) {
            player.offer(p);
            this.score = p.score;
        }

        public boolean canEnter(int score) {
            if(player.size() >= M) return false;
            return this.score - 10 <= score && score <= this.score + 10;
        }

        public void enter(Player p) {
            player.offer(p);
        }
    }

    static class Player {
        int score;
        String name;

        public Player(int score, String name) {
            this.score = score;
            this.name = name;
        }
    }
}
