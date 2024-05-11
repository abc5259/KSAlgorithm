package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 최장경로2 {
    static int max = 0;
    static boolean[] visited;
    static Stack<Integer> stack;
    static int n, m;
    static List<List<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new ArrayList<>();
            for(int i=0; i<=n; i++){
                map.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                map.get(start).add(end);
                map.get(end).add(start);
            }

            int result = -1;

            stack = new Stack<>();
            for(int i=1; i<=n; i++){
                visited = new boolean[n+1];
                visited[i] = true;
                result = Math.max(result, dfs(i)+1);
            }


            System.out.println("#"+(tc+1)+" "+result);
        }
    }

    static int dfs(int start){
        int count = 0;
        int answer = 0;

        for(int i=0; i<map.get(start).size(); i++){
            int next = map.get(start).get(i);

            if(!visited[next]){
                visited[next] = true;
                count += dfs(next)+1;

                answer = Math.max(answer, count);
                visited[next] = false;
                count = 0;
            }
        }

        return answer;
    }
}
