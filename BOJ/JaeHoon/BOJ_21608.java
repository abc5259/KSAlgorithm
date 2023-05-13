package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21608 {
    static int[][] seat;
    static int[] student;
    static boolean[][] likeNum;
    static int N;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        seat = new int[N][N];
        student = new int[N*N];
        likeNum = new boolean[N*N + 1][N*N + 1];
        for(int i=0; i<N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            student[i] = num;

            for(int j=0; j<4; j++) {
                likeNum[num][Integer.parseInt(st.nextToken())] = true;
            }
        }

        for(int i=0; i<N*N; i++) {
            setSeat(student[i]);
        }

        int total = 0;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int likeCnt = 0;
//                sb.append(seat[i][j] + " ");
                for(int d=0; d<4; d++) {
                    int x = i + dx[d];
                    int y = j + dy[d];
                    if (x < 0 || x >= N || y < 0 || y >= N) continue;
                    if(likeNum[seat[i][j]][seat[x][y]]) {
                        likeCnt += 1;
                    }
                }
                if(likeCnt != 0)
                    total += Math.pow(10,likeCnt-1);
            }
            sb.append("\n");
        }
//        System.out.println(sb);
        System.out.println(total);
    }
    public static void setSeat(int num) {

        Seat maxSeat = new Seat();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(seat[i][j] != 0) continue;
                int likeCnt = 0;
                int emptyCnt = 0;
                for(int d=0; d<4; d++) {
                    int x = i + dx[d];
                    int y = j + dy[d];
                    if(x < 0 || x >= N || y < 0 || y >= N) continue;
                    if(seat[x][y] == 0) emptyCnt++;
                    else {
                        if(likeNum[num][seat[x][y]]) likeCnt++;
                    }

                }
//                System.out.println("i = " + i + " j = " + j + " likeCnt = " + likeCnt + " empty = " + emptyCnt);
                if(maxSeat.likeCnt < likeCnt) {
                    maxSeat.likeCnt = likeCnt;
                    maxSeat.emptyCnt = emptyCnt;
                    maxSeat.r = i;
                    maxSeat.c = j;
                }
                if(maxSeat.likeCnt == likeCnt && maxSeat.emptyCnt < emptyCnt) {
                    maxSeat.emptyCnt = emptyCnt;
                    maxSeat.r = i;
                    maxSeat.c = j;
                }
            }
        }
//        System.out.println("maxSeat R = " + maxSeat.r + " maxSeat C = " + maxSeat.c);
        seat[maxSeat.r][maxSeat.c] = num;
    }
    static class Seat {
        int likeCnt = -1,emptyCnt,r,c;
    }
}
