/**
 * 17471 - 게리맨더링 [성공|01:34:43]
 * 골드3, 비트마스킹|DFS, 시도2
 * 
 * 이 풀이는 입력받는 그래프(city)까지 비트마스킹을 활용해서 표현
 * 그렇게해서 모든 경우의 수를 돌려보면서 1 또는 0이면서 방문하지 않았으면 dfs를 돌려 연결요소 갯수를 세어준다.
 * 이 때, 1 또는 0인 경우가 합해서 3개 이상이 되면, cnt == 2에 걸러져 갱신되지 않는다.
 * 
 * 또한, dfs에서 같은 구역만 방문하기 위해 비트마스킹으로 주어진 경우의 수 중에서
 * 해당 정점의 비트와 hint를 비교해 같은 경우에만 방문한다.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17471 {
    // 시간제한 0.5초
    // 백준시는 N개의 구역
    // 구역은 1번부터 N번까지 번호가 매겨짐.
    // 구역을 두 개의 선거구로 나눠야 함.
    // 연결요소 갯수가 2개가 아니면, 불가능한 방법으로 선거구를 나눈 것이다.
    // 무조건 연결요소 갯수가 2개가 되어야 가능한 방법!!!
    // 각 구역을 0 또는 1로 만드는 경우의 수 2^10 * DFS로 연결요소 갯수 파악 10*10 = 102400 = 약 10만?
    
    static int N;
    static int[] people;
    static int[] city;
    static int ret = Integer.MAX_VALUE;

    static boolean[] visited;

    static int dfs(int here, int n, int hint) {
        int sum = people[here];
        visited[here] = true;

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if((city[here] & (1 << i)) >= 1) {
                if ((n & (1 << i)) >= 1 && hint == 1)
                    sum += dfs(i, n, hint);
                else if ((n & (1 << i)) == 0 && hint == 0)
                    sum += dfs(i, n, hint);
            }
        }

        return sum;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        city = new int[N];
        people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            people[i] = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken()) - 1;
                city[i] = city[i] | (1 << v);
                city[v] = city[v] | (1 << i);
            }
        }

        for (int i = 1; i < (1 << N) - 1; i++) {
            int cnt = 0;
            int sum = 0;
            visited = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (visited[j]) continue;
                if ((i & (1 << j)) >= 1) {
                    sum += dfs(j, i, 1);
                    cnt++;
                } else if ((i & (1 << j)) == 0) {
                    sum = Math.abs(sum - dfs(j, i, 0));
                    cnt++;
                }
            }

            if (cnt == 2) ret = Math.min(ret, sum);
        }

        if (ret == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ret);
    }
}
