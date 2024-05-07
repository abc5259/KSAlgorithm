package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 길찾기 {
    static boolean flag;
    static List<List<Integer>> list;
    static int n;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for(int i=0; i<200; i++) {
                list.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                list.get(start).add(end);
            }

            visited = new boolean[100];

            flag = false;
            dfs(0);

            int answer = flag?1:0;

            System.out.println("#"+T+" "+answer);

        }
    }

    static void dfs(int start) {
        visited[start] = true;

        List<Integer> now = list.get(start);

        if(start == 99) {
            flag = true;
            return;
        }

        if(now.size()==0)return;

        for(int i=0; i<now.size(); i++) {
            int next = now.get(i);

            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}