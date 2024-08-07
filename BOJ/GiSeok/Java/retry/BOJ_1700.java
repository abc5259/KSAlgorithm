/**
 * 1700 - 멀티탭 스케줄링 [실패|01:19:59]
 * 골드1, 그리디, 시도5
 * 
 * 사용량이 적은 애를 뽑으려고 했는데, 그건 답이 아니다.
 * 메모리 스케줄링의 한 알고리즘인 Optimal 알고리즘을 사용해야 한다.
 * 즉, 가장 먼 미래에 사용되는 콘센트부터 뽑는 것이다.
 * 단, 주의할 점이 이미 사용중인 콘센트 중에서 먼 미래에 사용되지 않는 콘센트가 있을 수 있다.
 * 이 경우 사용하지 않는 콘센트를 뽑는 것이 최적해가 됨
 */
package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1700 {
    // 시간제한 2초, 메모리제한 128MB
    // 한 개의 멀티탭... 수 많은 전자기기
    // 전기용품의 사용순서를 기반으로 플러그를 최소한으로 빼자!!

    static boolean[] visited = new boolean[101];
    static int N, K;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int size = 0;
        int[] seq = new int[K];
        for (int i = 0; i < K; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
            if (size < N && !visited[seq[i]]) { visited[seq[i]] = true; size++; }
        }

        
        int ret = 0;
        for (int i = size; i < K; i++) {
            if (!visited[seq[i]] && size < N) { visited[seq[i]] = true; size++; }
            else if (!visited[seq[i]] && size >= N) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = i + 1; j < K; j++)
                    if (visited[seq[j]] && !list.contains(seq[j])) list.add(seq[j]);

                if (list.size() == N) visited[list.get(list.size() - 1)] = false;
                else {
                    for (int j = 0; j < i; j++) if (visited[seq[j]] && !list.contains(seq[j])) { visited[seq[j]] = false; break; }
                }

                visited[seq[i]] = true;
                ret++;
            }
        }

        System.out.println(ret);
    }
}
