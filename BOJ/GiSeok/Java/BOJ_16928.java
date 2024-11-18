/**
 * 16928 - 뱀과 사다리 게임(G5/BFS) [O]
 * 시도 10
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] map = new int[101];
        int[] visited = new int[101];
        for (int i = 1; i <= 100; i++) map[i] = i;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start] = end;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start] = end;
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        visited[1] = 0;

        while (!q.isEmpty()) {
            int x = q.pop();
            int y = map[x];

            if (x != y) {
                if (visited[y] != 0 && visited[y] <= visited[x]) continue;
                q.add(y);
                visited[y] = visited[x];
            } else {
                for (int i = 1; i <= 6; i++) {
                    int ny = x + i;

                    if (ny < 0 || ny > 100) continue;
                    if (visited[ny] != 0 && visited[ny] <= visited[x] + 1) continue;
                    q.add(ny);
                    visited[ny] = visited[x] + 1;
                }
            }
        }

        System.out.println(visited[100]);
    }
}
