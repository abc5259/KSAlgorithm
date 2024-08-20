/**
 * 15662 - 톱니바퀴 (2) [성공|00:49:54]
 * 골드5, 구현, 시도1
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15662 {
    // 시간제한 2초, 메모리제한 512MB
    // 8개의 톱니를 가진 톱니바퀴 T개가 일렬로 놓여져 있음.
    // 톱니는 각각 N, S극 중 하나를 나타낸다.
    // 한 톱니바퀴를 회전시켰을 때, 마주한 톱니가 다른 극이라면 같이 회전
    // 같은 극이라면 회전 x
    // N = 0, S = 1

    static boolean[][] gears;
    static boolean[] visited;
    static int t, k;

    static void rotate(int idx, boolean dir) {
        if (dir) { // 오른
            boolean g = gears[idx][7];

            for (int i = 7; i > 0; i--) gears[idx][i] = gears[idx][i-1];
            gears[idx][0] = g;
        } else { // 왼
            boolean g = gears[idx][0];

            for (int i = 0; i < 7; i++) gears[idx][i] = gears[idx][i+1];
            gears[idx][7] = g;
        }
    }

    static void gearChoice(int n, boolean dir) {

        if (n < 0 && n >= t) return;
        visited[n] = true;

        if (n-1 >= 0 && gears[n-1][2] == !gears[n][6]) { // 왼쪽 회전해야함.
            if (!visited[n-1]) gearChoice(n-1, !dir);
        }

        if (n+1 < t && gears[n+1][6] == !gears[n][2]) { // 오른쪽 회전해야함.
            if (!visited[n+1]) gearChoice(n+1, !dir);
        }

        // 본인 회전
        rotate(n, dir);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        gears = new boolean[t][8];
        for (int i = 0; i < t; i++) {
            String m = br.readLine();
            for (int j = 0; j < m.length(); j++)
                gears[i][j] = m.charAt(j) != '0';
        }

        k = Integer.parseInt(br.readLine());
        for (int K = 0; K < k; K++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int _gear = Integer.parseInt(st.nextToken()) - 1;
            boolean dir = st.nextToken().equals("1");

            visited = new boolean[t];
            gearChoice(_gear, dir);
        }

        int ret = 0;
        for (int i = 0; i < t; i++)
            if (gears[i][0]) ret++;

        System.out.println(ret);
    }
}
