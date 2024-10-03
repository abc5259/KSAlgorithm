package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1956 {
    static int V,E;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int[][] dist = new int[V+1][V+1];
        for(int i=0; i<=V; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dist[a][b] = w;
        }

        for(int i=1; i<=V; i++) {
            for(int s=1; s<=V; s++) {
                for(int e=1; e<=V; e++) {
                    if(dist[s][i] == Integer.MAX_VALUE || dist[i][e] == Integer.MAX_VALUE) continue;
                    dist[s][e] = Math.min(dist[s][i] + dist[i][e], dist[s][e]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=1; i<=V; i++) {
            min = Math.min(min, dist[i][i]);
        }

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

}
