package BOJ.JaeIk.practice.swea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 최장거리구하기
{
    static List<Integer>[] edges;
    static boolean[] visited;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            edges = new ArrayList[n+1];
            for(int i=0; i<=n; i++) {
                edges[i] = new ArrayList<>();
            }


            for(int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                edges[a].add(b);
                edges[b].add(a);
            }

            int max = 0;
            for(int i=1; i<=n; i++) {
                visited = new boolean[n+1];
                visited[i] = true;
                int compare = dfs(i)+1;
                max = Math.max(max, compare);
            }

            System.out.println("#"+(tc+1)+" "+max);
        }
    }

    static int dfs(int start) {
        int count = 0;
        int answer = 0;

        for(int i=0; i<edges[start].size(); i++) {
            int nextNode = edges[start].get(i);

            if(visited[nextNode])continue;

            visited[nextNode] = true;
            count += dfs(nextNode)+1;
            answer = Math.max(answer, count);

            visited[nextNode] = false;
            count = 0;
        }

        return answer;
    }
}