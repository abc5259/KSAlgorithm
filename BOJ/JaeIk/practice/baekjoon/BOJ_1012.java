package BOJ.JaeIk.practice.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class BOJ_1012
{
    static int count;
    static int m, n, cabbageAmount;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] map;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            cabbageAmount = Integer.parseInt(st.nextToken());

            count = 0;
            map = new int[m][n];
            for(int i=0; i<cabbageAmount; i++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());

                map[row][col] = 1;
            }

            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(map[i][j] == 1) {
                        bfs(i, j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(int row, int col) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[] {row, col});

        while(!queue.isEmpty()) {
            Integer[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            for(int i=0; i<4; i++) {
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=m || nextCol>=n)continue;
                if(map[nextRow][nextCol] == 1) {
                    queue.offer(new Integer[] {nextRow, nextCol});
                    map[nextRow][nextCol] = 0;
                }
            }
        }

        count++;
    }
}