package BOJ.GiSeok.Java;

import java.io.*;
import java.util.*;

public class BOJ_19236 {

    /**
     * 물고기가 각 칸에 있음.
     * 물고기는 8가지 방향을 가짐.
     * 작은 물고기부터 순서대로 이동.
     * 이동하려고 할때 이동할 수 있는 칸이 없으면 계속 45도 반시계로 방향 회전
     *   이동할 수 있는 칸: 빈 칸, 다른 물고기가 있는 칸
     *       다른 물고기가 있는 칸은 서로의 위치를 바꿈
     *   이동할 수 없는 칸: 상어 있는 칸, 공간의 경계를 넘는 칸
     * 상어는 한번에 여러 칸 무빙 가능
     */

    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};

    static int ans = 0;

    static class Fish {
        int y, x;
        int num;
        int dir;

        public Fish(int y, int x, int num, int dir) {
            this.y = y;
            this.x = x;
            this.num = num;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Fish> fishes = new ArrayList<>();

        Fish shark = null;
        for (int y = 0; y < 4; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int x = 0; x < 4; x++) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;

                if (y == 0 && x == 0) {
                    shark = new Fish(0, 0, a, b);
                } else {
                    Fish f = new Fish(y, x, a, b);
                    fishes.add(f);
                }
            }
        }

        dfs(shark, fishes);
        System.out.println(ans);
    }

    static void dfs(Fish shark, List<Fish> fishes) {
        fishes.sort(Comparator.comparingInt(o -> o.num));

        // 물고기 이동 1번
        for (int i = 0; i < fishes.size(); i++) {
            Fish f = fishes.get(i);

            while (true) {
                int ny = f.y + dy[f.dir];
                int nx = f.x + dx[f.dir];

                if ((ny < 0 || ny >= 4 || nx < 0 || nx >= 4) ||
                    (shark.y == ny && shark.x == nx)) {
                    f.dir = (f.dir + 1) % 8;
                    continue;
                }

                Fish exist = fishes.stream()
                    .filter(fish -> fish.y == ny && fish.x == nx)
                    .findFirst()
                    .orElse(null);

                if (exist != null) {
                    exist.y = f.y;
                    exist.x = f.x;
                }
                f.y = ny;
                f.x = nx;
                break;
            }
        }

        // 상어 이동
        // 상어는 물고기 번호의 합 최대를 구해야함.
        // 가능한 경로는 원래 위치 + (dy, dx [dir] * 1, 2, 3)
        boolean isfinish = true;
        for (int i = 1; i <= 3; i++) {
            int ny = shark.y + (dy[shark.dir] * i);
            int nx = shark.x + (dx[shark.dir] * i);

            if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4) continue;

            Fish exist = fishes.stream()
                .filter(fish -> fish.y == ny && fish.x == nx)
                .findFirst()
                .orElse(null);

            if (exist != null) {
                fishes.remove(exist);

                List<Fish> deepCopy = new ArrayList<>();
                for (Fish fish : fishes) deepCopy.add(new Fish(fish.y, fish.x, fish.num, fish.dir));

                fishes.add(exist);
                dfs(new Fish(exist.y, exist.x, exist.num + shark.num, exist.dir), new ArrayList<>(deepCopy));

                isfinish = false;
            }
        }

        if (isfinish) {
            ans = Math.max(ans, shark.num);
        }
    }
}
