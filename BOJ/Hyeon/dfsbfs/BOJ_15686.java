package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
    static int[][] map;
    static int N, M, min = Integer.MAX_VALUE;
    static ArrayList<Point> chicken;
    static ArrayList<Point> home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        chicken = new ArrayList<>();
        home = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    home.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        select = new boolean[chicken.size()];
        comb(0, 0);

        System.out.println(min);
    }

    static boolean[] select;

    static void comb(int start, int depth) {
        if (depth == M) {
            cal();
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            select[i] = true;
            comb(i + 1, depth + 1);
            select[i] = false;
        }
    }

    static void cal() {
        int total = 0;

        for (Point point : home) {
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < chicken.size(); j++) {
                if (select[j]) {
                    int distance = Math.abs(point.y - chicken.get(j).y) + Math.abs(point.x - chicken.get(j).x);
                    tmp = Math.min(tmp, distance);
                }
            }
            total += tmp;
        }
        min = Math.min(min, total);
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

// G5 치킨 배달 백트래킹
