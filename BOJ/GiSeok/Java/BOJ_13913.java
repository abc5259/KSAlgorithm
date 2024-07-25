/**
 * 13913 - 숨바꼭질 4 [성공(반례힌트)|01:30:46]
 * 골드4, BFS
 * 
 * 범위를 잘 보고 풀자.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_13913 {
    // 시간제한 2초

    static int N, K;
    static int[] visited = new int[100001];
    static int[] detector = new int[100001];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) break;

            for (int next : new int[]{now-1, now+1, 2*now}) {
                if (next < 0 || next > 100000) continue;
                if (visited[next] != 0) continue;

                visited[next] = visited[now] + 1;
                detector[next] = now;
                q.add(next);
            }
        }

        Stack<Integer> stk = new Stack<>();
        bw.write(visited[K] - 1 + "\n");
        for (int i = K; i != N; i = detector[i])
            stk.push(i);
        stk.push(N);
        while (!stk.isEmpty())
            bw.write(stk.pop() + " ");
        bw.flush();
        bw.close();
    }
}
