/**
 * 17471 - 게리맨더링 [성공|01:34:43]
 * 골드3, 비트마스킹|DFS, 시도2
 * 
 * 이 풀이는 모든 경우의 수를 comp라는 배열에 표시하여 dfs를 방문하는 방법이다.
 * 또한, 경우의 수마다 무조건 2개의 구역이 가능한 방법으로 나뉘어졌다고 생각하고 인덱스를 하나씩 저장해 dfs를 두 번 돌리며,
 * 그렇게 구해진 총 구역의 갯수가 처음 입력받은 N과 다르다면 가능한 방법이 아닌 불가능한 방법으로 나뉜 것으로 본다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17471_2 {
    // 시간제한 0.5초
    // 백준시는 N개의 구역
    // 구역은 1번부터 N번까지 번호가 매겨짐.
    // 구역을 두 개의 선거구로 나눠야 함.
    // 연결요소 갯수가 2개가 아니면, 불가능한 방법으로 선거구를 나눈 것이다.
    // 무조건 연결요소 갯수가 2개가 되어야 가능한 방법!!!
    // 각 구역을 0 또는 1로 만드는 경우의 수 2^10 * DFS로 연결요소 갯수 파악 10*10 = 102400 = 약 10만?
    
    static int N;
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] people;
    static int ret = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[] comp;

    static class Pair {
        int cnt, sum;

        Pair(int c, int s) {
            cnt = c;
            sum = s;
        }
    }

    static Pair dfs(int here, int hint) {
        Pair p = new Pair(1, people[here]);
        visited[here] = true;

        for (int v : adj.get(here)) {
            if (visited[v]) continue;
            if (comp[v] != comp[here]) continue;
            Pair tmp = dfs(v, hint);
            p.cnt += tmp.cnt;
            p.sum += tmp.sum;
        }

        return p;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
        people = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            people[i] = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken()) - 1;
                adj.get(i).add(v);
                adj.get(v).add(i);
            }
        }

        for (int i = 1; i < (1 << N) - 1; i++) {
            int idx1 = -1, idx2 = -1;
            visited = new boolean[N];
            comp = new int[N];
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) >= 1) { comp[j] = 1; idx1 = j; } 
                else idx2 = j;
            }

            if (idx1 == -1 || idx2 == -1) continue;

            Pair p1 = dfs(idx1, 1);
            Pair p2 = dfs(idx2, 0);
            if (p1.cnt + p2.cnt == N) ret = Math.min(ret, Math.abs(p1.sum - p2.sum));

        }

        if (ret == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ret);
    }
}
