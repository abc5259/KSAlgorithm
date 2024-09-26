/**
 * 16235 - 나무 재태크 [실패|01:32:35]
 * 골드3, 구현, 시도8
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_16235 {

    static int n, m, k;
    static int[][] map;
    static int[][] dies;
    static int[][] A;

    static LinkedList<tree> trees = new LinkedList<>();

    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};

    static class tree {
        int x, y, old;

        tree(int y, int x, int old) {
            this.y = y;
            this.x = x;
            this.old = old;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        dies = new int[n][n];
        A = new int[n][n];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = 5;
                A[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int old = Integer.parseInt(st.nextToken());

            trees.add(new tree(y-1, x-1, old));
        }

        trees.sort(new Comparator<tree>() {
            @Override
            public int compare(tree o1, tree o2) {
                return o1.old - o2.old;
            }
        });

        for (int year = 0; year < k; year++) {

            // 봄 가을
            LinkedList<tree> tmp = new LinkedList<>();
            Iterator iterator = trees.iterator();
            while (iterator.hasNext()) {
                tree t = (tree) iterator.next();

                // 양분을 먹고 나이 증가 -> 번식
                if (map[t.y][t.x] >= t.old) {
                    map[t.y][t.x] -= t.old;
                    t.old++;

                    if (t.old % 5 == 0) {
                        for (int d = 0; d < 8; d++) {
                            int ny = t.y + dy[d];
                            int nx = t.x + dx[d];
                            if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                            tmp.add(new tree(ny, nx, 1));
                        }
                    }
                } else {
                    dies[t.y][t.x] += t.old/2;
                    iterator.remove();
                }
            }

            trees.addAll(0, tmp);

            // 여름, 겨울
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    map[y][x] += dies[y][x] + A[y][x];
                    dies[y][x] = 0;
                }
            }
        }

        System.out.println(trees.size());
    }
}
