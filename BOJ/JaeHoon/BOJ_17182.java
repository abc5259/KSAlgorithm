package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17182 {
    static int N,K;
    static int[][] dist;
    static boolean[] isVisited;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                for(int l=0; l<N; l++) {
                    if(dist[i][l] > dist[i][j] + dist[j][l]) {
                        dist[i][l] = dist[i][j] + dist[j][l];
                    }
                }
            }
        }

        isVisited = new boolean[N];
        solve(K,0,0);
        System.out.println(answer);

    }
    public static void solve(int v, int d, int depth) {
        if(depth == N-1) {
            answer = Math.min(d,answer);
            return;
        }
        isVisited[v] = true;
        for(int i=0; i<N; i++) {
            if(isVisited[i]) continue;
            solve(i, d + dist[v][i],depth+1);
        }
        isVisited[v] = false;
    }

    static class Node {
        int v,w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
