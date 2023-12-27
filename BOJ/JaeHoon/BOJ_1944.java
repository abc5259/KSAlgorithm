package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1944 {
    static char[][] map;
    static boolean[][] isVisited;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,-1,1};
    static int N,M;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        isVisited = new boolean[N][N];
        parents = new int[2600];
        int[] start = new int[2];
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 'S' || map[i][j] == 'K') {
                    bfs(new int[]{i,j});
                }
            }
        }

        for(int i=0; i<parents.length; i++) parents[i] = i;

        int answer = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int a = find(curr[0]);
            int b = find(curr[1]);

            if(a == b) continue;

            union(a,b);
            answer += curr[2];
            cnt++;
        }
        System.out.println(cnt == M ? answer : -1);
    }
    public static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a <= b) {
            parents[b] = a;
        }else {
            parents[a] = b;
        }
    }
    public static void bfs(int[] start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0],start[1],0});
        for(int i=0; i<N; i++) Arrays.fill(isVisited[i],false);

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for(int i=0; i<4; i++) {
                int nextX = curr[0] + dx[i];
                int nextY = curr[1] + dy[i];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if(map[nextX][nextY] == '1') continue;
                if(isVisited[nextX][nextY]) continue;

                isVisited[nextX][nextY] = true;
                if(map[nextX][nextY] == 'K') {
                    pq.offer(new int[]{start[0] * N + start[1], nextX * N + nextY, curr[2] + 1});
                }
                q.offer(new int[]{nextX, nextY, curr[2] + 1});
            }
        }
    }
}
