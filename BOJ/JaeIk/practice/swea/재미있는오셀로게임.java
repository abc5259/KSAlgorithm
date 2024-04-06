package BOJ.JaeIk.practice.swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class 재미있는오셀로게임
{
    static int black, white;
    static int[] dx = {1, -1, 0, 0,  -1, 1, -1, 1};
    static int[] dy = {0, 0, 1, -1,  -1, -1, 1, 1};
    static int[][] map;
    static int n, m;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            //map 초기화
            map = new int[n+1][n+1];
            map[n/2][n/2] = 2;
            map[n/2][n/2+1] = 1;
            map[n/2+1][n/2] = 1;
            map[n/2+1][n/2+1] = 2;

            //게임 시작
            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());

                map[x][y] = color;

                crashEnemy(x, y, color);
            }

            black = 0;
            white = 0;
            //통계
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(map[i][j] == 1)black++;
                    if(map[i][j] == 2)white++;
                }
            }

            System.out.println("#"+(tc+1)+" "+black+" "+white);
        }
    }

    static void crashEnemy(int x, int y, int color) {

        //탐색
        for(int i=0; i<8; i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];

            boolean flag = false;
            while(nextX>=1 && nextY>=1 && nextX<=n && nextY<=n && map[nextX][nextY]!=0){
                if(map[nextX][nextY] == color){
                    flag = true;
                    break;
                }

                nextX += dx[i];
                nextY += dy[i];
            }

            while(flag){
                if(nextX==x && nextY==y)break;

                map[nextX][nextY] = color;
                nextX -= dx[i];
                nextY -= dy[i];
            }
        }
    }
}