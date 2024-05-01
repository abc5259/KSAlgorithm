package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int connect = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        for(int i=0; i<connect; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            map[start][end] = 1;
            map[end][start] = 1;
        }

        int result = bfs(n, map);

        System.out.println(result);
    }

    static int bfs(int n, int[][] map){
        int sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        queue.add(1);
        visited[1] = true;

        while(!queue.isEmpty()){
            int nowNode = queue.poll();

            for(int i=1; i<=n; i++){
                if(visited[i])continue;

                if(map[nowNode][i] == 1){
                    //System.out.println(i);
                    visited[i] = true;
                    queue.add(i);
                    sum++;
                }
            }
        }

        return sum;
    }
}
