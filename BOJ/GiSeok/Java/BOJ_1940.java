/**
 * 1940 - 주몽 [성공/19:41]
 * 조합, 실버4, 시도4
 * 
 * 2개의 재료를 뽑아 M이 되는 경우의 수를 찾는다. => 조합
 * 시간복잡도를 계산해보면 nC2 (1 <= n <= 15,000) => 약 1억
 * 시간제한이 2초이므로 충분히 조합으로 해결이 가능하다.
 * 
 * 하지만, 공간복잡도를 생각 못해서 2번 틀린 문제이다.
 * 처음에 재귀함수로 풀었는데 2~3번을 뽑는 소규모 조합에는 반복문이 더 효율적임.
 * 반복문 사용 시 ArrayDeque의 사용은 없어도 되기 때문에 이를 제거하지 않아 메모리 초과가 발생함.
 */
package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1940 {
    // 갑옷을 만드는 재료들은 각각 고유 번호를 가짐.
    // 갑옷은 두 개의 재료로 만든다.
    // 두 재료의 고유한 번호 합 M (1 <= M <= 10,000,000)
    // 자신이 만들고 있는 재료를 갖고 갑옷을 몇 개나?
    // N개(1 <= N <= 15,000)의 재료와 M이 주어졌을 때, 몇 개의 갑옷?
    // N을 2개씩 뽑아 M이 되는 것을 찾아라.

    // 조합을 생각해볼 수 있겠다. nC2 = 112,492,500 1억
    // 재귀함수 => 메모리 초과
    // 2개를 뽑는 것이니 반복문으로 변경 => 메모리 초과
    // ArrayDeque의 문제.

    static int[] items;
    static int N, M;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        items = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            items[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (items[i] + items[j] == M) cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}
