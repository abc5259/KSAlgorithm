package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17143 {
    static int R,C,M;
    static Shark[][] map;
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R][C];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            Shark shark = new Shark(r - 1, c - 1, s, d - 1, z);
            map[r-1][c-1] = shark;
        }

        int sum = 0;
        for(int y=0; y<C; y++) {
            // 상어 낚시
            for(int x=0; x<R; x++) {
                if(map[x][y] != null) {
                    sum += map[x][y].z;
                    map[x][y] = null;
                    break;
                }
            }
            // 상어 이동
            Queue<Shark> sharkQ = new LinkedList<>();
            for(int i=0; i<R; i++) {
                for(int j=0; j<C; j++) {
                    if(map[i][j] == null) continue;
                    Shark shark = map[i][j];
                    int speed = shark.s;
                    if(shark.d == 0 || shark.d == 1) {
                        speed %= (R-1) * 2;
                    }else {
                        speed %= (C-1) * 2;
                    }

                    for(int s=0; s<speed; s++) {
                        shark.r = shark.r + dir[shark.d][0];
                        shark.c = shark.c + dir[shark.d][1];

                        if(shark.r < 0 || shark.r >= R || shark.c < 0 || shark.c >= C) {
                            shark.r -= dir[shark.d][0]*2;
                            shark.c -= dir[shark.d][1]*2;
                            shark.d = nDir(shark.d);
                        }
                    }
                    sharkQ.offer(shark);
                    map[i][j] = null;
                }
            }
            while (!sharkQ.isEmpty()) {
                Shark shark = sharkQ.poll();
                if(map[shark.r][shark.c] == null) {
                    map[shark.r][shark.c] = shark;
                }else {
                    if(map[shark.r][shark.c].z < shark.z) {
                        map[shark.r][shark.c] = shark;
                    }
                }
            }
        }
        System.out.println(sum);
    }
    public static int nDir(int cur) {
        if(cur == 0) return 1;
        if(cur == 1) return 0;
        if(cur == 2) return 3;
        return 2;
    }
    static class Shark {
        //(r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기
        int r,c,s,d,z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
