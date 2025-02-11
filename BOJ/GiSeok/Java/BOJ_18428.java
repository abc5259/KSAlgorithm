/**
 * [G5 브루트포스] 감시 피하기 - O, 00:23:35
 * 시도 1
 * 시간 복잡도
 * 장애물 하나 놓을때마다 n^2 이므로 3번 놓으니까 n^6
 * 그리고, n^6 과정에서 계속 선생님 부딪히는지 봐야하니까 (5 * 4 * n^2) * n^6
 * = 20 * n^8 = 33,592,320
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_18428 {

    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static char[][] school;
    private static int n;
    private static boolean ret = false;
    private static ArrayList<Point> teachers;

    private static class Point {
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        school = new char[n][n];
        teachers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                school[i][j] = st.nextToken().charAt(0);
                if (school[i][j] == 'T') teachers.add(new Point(i, j));
            }
        }

        dfs(3);
        System.out.println(ret ? "YES" : "NO");
    }

    private static void dfs(int cnt) {
        if (cnt == 0) {
            boolean flag = true;

            for (int idx = 0; idx < teachers.size(); idx++) {
                Point point = teachers.get(idx);

                for (int i = 0; i < 4; i++) {
                    int y = point.y;
                    int x = point.x;
                    while (y + dy[i] >= 0 && y + dy[i] < n
                            && x + dx[i] >= 0 && x + dx[i] < n) {
                        if (school[y + dy[i]][x + dx[i]] == 'O') break;
                        else if (school[y + dy[i]][x + dx[i]] == 'S') { flag = false; break; }
                        y += dy[i];
                        x += dx[i];
                    }
                }
            }

            if (flag) ret = true;
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (school[i][j] == 'X') {
                    school[i][j] = 'O';
                    dfs(cnt-1);
                    school[i][j] = 'X';
                }
            }
        }
    }
}
