package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_2668 {
    static int[] downArr;
    static boolean[] isVisited;
    static List<Integer> list = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isVisited = new boolean[N+1];
        downArr = new int[N+1];
        for(int i=1; i<=N; i++) {
            int n = Integer.parseInt(br.readLine());
            downArr[i] = n;
        }

        for(int i=1; i<=N; i++) {
            isVisited[i] = true;
            solve(i,i);
            isVisited[i] = false;
        }

        StringBuilder sb = new StringBuilder();
        list.sort((a,b) -> a - b);
        System.out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);
    }

    public static void solve(int start, int target) {
        if(!isVisited[downArr[start]]) {
            isVisited[downArr[start]] = true;
            solve(downArr[start], target);
            isVisited[downArr[start]] = false;
        }

        if(target == downArr[start]) {
            list.add(target);
        }
    }
}
