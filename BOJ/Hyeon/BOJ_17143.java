package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17143 {
    static int R, C, M;
    static Shark[][] fishing;
    static int res;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fishing = new Shark[R][C];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int speed = Integer.parseInt(st.nextToken());
            int di = Integer.parseInt(st.nextToken()) - 1;
            int scale = Integer.parseInt(st.nextToken());

            fishing[y][x] = new Shark(y, x, speed, di, scale);
        }

        for (int i = 0; i < C; i++) {
            catchShark(i);
            // 나머지들 방향대로 움직이고
            moveShark();
        }
        System.out.println(res);
    }

    static void catchShark(int col) {
        for (int row = 0; row < R; row++) {
            if (fishing[row][col] != null) {
                res += fishing[row][col].scale;
                fishing[row][col] = null;
                break;
            }
        }
    }

    static void moveShark() {
        Shark[][] newFishing = new Shark[R][C];
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (fishing[row][col] != null) {
                    Shark shark = fishing[row][col];
                    fightShark(shark);
                    // 상어가 있으면 비교해서 삽입
                    if (newFishing[shark.y][shark.x] == null || newFishing[shark.y][shark.x].scale < shark.scale) {
                        newFishing[shark.y][shark.x] = shark;
                    }
                }
            }
        }
        fishing = newFishing;
    }

    static void fightShark(Shark shark) {
        int s = shark.speed;
        if (shark.di < 2) {
            s %= (R - 1) * 2;
        } else {
            s %= (C - 1) * 2;
        }

        for (int k = 0; k < s; k++) {
            int ny = shark.y + dy[shark.di];
            int nx = shark.x + dx[shark.di];

            if (ny < 0 || ny >= R || nx < 0 || nx >= C) {
                shark.di = (shark.di % 2 == 0) ? shark.di + 1 : shark.di - 1;

                ny = shark.y + dy[shark.di];
                nx = shark.x + dx[shark.di];
            }
            shark.y = ny;
            shark.x = nx;
        }
    }

    static class Shark {
        int y;
        int x;
        int speed;
        int di;
        int scale;

        public Shark(int y, int x, int speed, int di, int scale) {
            this.y = y;
            this.x = x;
            this.speed = speed;
            this.di = di;
            this.scale = scale;
        }
    }
}

// G1 낚시왕 시뮬레이션

// 메소드를 여러개를 펼치고 다양한 속성을 클래스로 받아서 관리하는 형태