package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18111 {
    static int N, M, B;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  //세로
        M = Integer.parseInt(st.nextToken());  //가로
        B = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minTime = Integer.MAX_VALUE;
        int maxHeight = 0;

        for (int h=0; h<=256; h++) {
            int time = calculateTime(h);
            if(time == -1) continue;
            if(time <= minTime) {
                minTime = time;
                maxHeight = h;
            }
        }
        System.out.println(minTime + " " + maxHeight);
    }

    static int calculateTime(int h) {
        int time = 0;
        int blockCnt = B;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] > h) {
                    int dif = map[i][j] - h;
                    time += 2 * dif;
                    blockCnt += dif;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] < h) {
                    int needCnt = h - map[i][j];
                    if(blockCnt >= needCnt) {
                        time+=needCnt;
                        blockCnt -= needCnt;
                    }else {
                        return -1;
                    }
                }
            }
        }

        return time;
    }
}
