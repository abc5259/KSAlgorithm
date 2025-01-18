package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3043 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Tank[] tanks = new Tank[N];
        int num = 1;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tanks[i] = new Tank(num++, r-1, c-1);
        }
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        Arrays.sort(tanks, (a,b) -> a.x - b.x);
        for(int i=0; i<N; i++) {
            Tank tank = tanks[i];
            int targetX = i;

            while (tank.x > targetX) {
                tank.x--;
                cnt++;
                sb.append(tank.num).append(" ").append('U').append('\n');
            }
        }

        for(int i=N-1; i>=0; i--) {
            Tank tank = tanks[i];
            int targetX = i;

            while (tank.x < targetX) {
                tank.x++;
                cnt++;
                sb.append(tank.num).append(" ").append('D').append('\n');
            }
        }

        Arrays.sort(tanks, (a,b) -> a.y - b.y);
        for(int i=0; i<N; i++) {
            Tank tank = tanks[i];
            int targetY = i;

            while (tank.y > targetY) {
                tank.y--;
                cnt++;
                sb.append(tank.num).append(" ").append('L').append('\n');
            }
        }

        for(int i=N-1; i>=0; i--) {
            Tank tank = tanks[i];
            int targetY = i;

            while (tank.y < targetY) {
                tank.y++;
                cnt++;
                sb.append(tank.num).append(" ").append('R').append('\n');
            }
        }

        System.out.println(cnt);
        System.out.print(sb);
    }
    static class Tank {
        int num, x, y;

        public Tank(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
}
