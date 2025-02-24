package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17135 {
    static int N, M, D;
    static ArrayList<Point> enemy;
    static boolean[] archers;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        enemy = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    enemy.add(new Point(i, j));
                }
            }
        }
        archers = new boolean[M]; // 궁수 조합 배열

        comb(0, 0);
        System.out.println(res);
        // 최종결과
    }

    static void comb(int idx, int depth) {
        if (depth == 3) {
            attack();
            return;
        }
        if (idx >= M) {
            return;
        }
        archers[idx] = true;
        comb(idx + 1, depth + 1);
        archers[idx] = false;
        comb(idx + 1, depth);
    }

    static void attack() {
        ArrayList<Point> copy = new ArrayList<>(enemy);
        int sum = 0;

        while (!copy.isEmpty()) {
            Point[] three = new Point[3];
            int idx = 0;

            for (int i = 0; i < M; i++) {
                if (archers[i]) {
                    int min = Integer.MAX_VALUE;
                    Point target = null;
                    for (Point e : copy) {
                        int dis = distance(e.y, e.x, N, i);
                        if (dis <= D) {
                            if (dis < min || (dis == min && e.x < target.x)) {
                                min = dis;
                                target = e;
                            }
                        }
                    }
                    if (target != null) {
                        three[idx++] = target;
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if (three[i] != null && copy.contains(three[i])) {
                    copy.remove(three[i]);
                    sum++;
                }
            }
            ArrayList<Point> moved = new ArrayList<>();
            for (Point a : copy) {
                if (a.y + 1 < N) {
                    moved.add(new Point(a.y + 1, a.x));
                }
            }
            copy = moved;
        }
        res = Math.max(res, sum);
    }

    static int distance(int y1, int x1, int y2, int x2) {
        return Math.abs(y1 - y2) + Math.abs(x2 - x1);
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

// G3 캐슬 디펜스 조합, 브루트포스, 시뮬레이션
// 개어렵게 풀었다.
// 일단 첫 번째로 격자판에 적이 있고, 궁수는 격자판 아래에 있다
// 그런데 격자판을 다 볼 필요없이 그냥 격자판에서 1이 적혀있는 적의 좌표만 가져온다.
// 이를 가져와서 궁수의 위치에 따라 거리를 구하면 되는데
// 적이 성밖으로 나갈 때까지 반복해야 하기 때문에 Arraylist 단위로 반복하고
// 복사본을 사용해서 값을 구한다.

// y,x의 좌표를 그냥 int 배열로 해도되는데
// 클래스를 두어서 했다.