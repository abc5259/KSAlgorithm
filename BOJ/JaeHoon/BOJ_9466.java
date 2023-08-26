package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BOJ_9466 {
    static int N;
    static int[] students;
    static boolean[] isVisited;
    static boolean[] done;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            students = new int[N+1];
            isVisited = new boolean[N+1];

//            answer = N;
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }
            answer = 0;
            done = new boolean[N+1];
            for(int i=1; i<=N; i++) {
                if(!done[i]) {
                    dfs(i);
                }
            }

//            int answer = 0;
//            for(int i=1; i<=N; i++) {
//                if(!isVisited[i]) answer--;
//            }

            sb.append(N - answer).append('\n');
        }
        System.out.println(sb);
    }
    public static void dfs(int n) {
        if(done[n]) return;

        if(isVisited[n]) {
            done[n] = true;
            answer++;
        }

        isVisited[n] = true;
        dfs(students[n]);
        done[n] = true;
        isVisited[n] = false;
    }
}
