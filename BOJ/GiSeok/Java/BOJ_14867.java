/**
 * 14867 - 물통 [부분성공(실패)|01:29:16]
 * 골드2, BFS, 시도5
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_14867 {

    static HashSet<String> set = new HashSet<>();
    static int bottleA, bottleB;
    static int pA, pB;

    static class Pair {
        int y, x, cnt;

        public Pair(int y, int x, int cnt) { this.y = y; this.x = x; this.cnt = cnt; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        bottleA = Integer.parseInt(st.nextToken());
        bottleB = Integer.parseInt(st.nextToken());

        pA = Integer.parseInt(st.nextToken());
        pB = Integer.parseInt(st.nextToken());

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, 0, 0));
        set.add(0 + "." + 0);

        while (!q.isEmpty()) {

            Pair p = q.poll();

            if (p.y == pA && p.x == pB) { System.out.println(p.cnt); return; }

            if (!set.contains(bottleA + "." + p.x)) {
                q.add(new Pair(bottleA, p.x, p.cnt + 1));
                set.add(bottleA + "." + p.x);
            }

            if (!set.contains(p.y + "." + bottleB)) {
                q.add(new Pair(p.y, bottleB, p.cnt + 1));
                set.add(p.y + "." + bottleB);
            }

            if (p.y != 0) {
                if (bottleB - p.x >= p.y && !set.contains(0 + "." + (p.x+p.y))) {
                    q.add(new Pair(0, p.x + p.y, p.cnt + 1));
                    set.add(0 + "." + (p.x+p.y));
                }
                else if (bottleB - p.x < p.y && !set.contains((p.y - (bottleB - p.x)) + "." + bottleB)) {
                    q.add(new Pair(p.y - (bottleB - p.x), bottleB, p.cnt + 1));
                    set.add((p.y - (bottleB - p.x)) + "." + bottleB);
                }
            }
            if (p.x != 0) {
                if (bottleA - p.y >= p.x && !set.contains((p.x + p.y) + "." + 0)) {
                    q.add(new Pair(p.x + p.y, 0, p.cnt + 1));
                    set.add((p.x + p.y) + "." + 0);
                }
                else if (bottleA - p.y < p.x && !set.contains(bottleA + "." + (p.x - (bottleA - p.y)))) {
                    q.add(new Pair(bottleA, p.x - (bottleA - p.y), p.cnt + 1));
                    set.add(bottleA + "." + (p.x - (bottleA - p.y)));
                }
            }

            if (!set.contains(0 + "." + p.x)) {
                q.add(new Pair(0, p.x, p.cnt + 1));
                set.add(0 + "." + p.x);
            }

            if (!set.contains(p.y + "." + 0)) {
                q.add(new Pair(p.y, 0, p.cnt + 1));
                set.add(p.y + "." + 0);
            }
        }

        System.out.println(-1);
    }
}










