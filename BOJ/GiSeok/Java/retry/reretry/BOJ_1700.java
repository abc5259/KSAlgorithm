package BOJ.GiSeok.Java.retry.reretry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘이란?
 * "매 선택마다 당장 최적인 답을 선택하여 최종적으로 적합한 결과를 도출하자."
 * ex. 5개의 도시를 한 번씩만 거쳐 여행하고 싶은데, 기름값 절약을 위해 짧은 경로로 이동하고 싶다고 가정
 * 그리디로 각 도시를 이동할때마다 가장 짧은 경로를 선택하여 최적의 합을 도출할 수 있다.
 *
 * 하지만, 그리디는 항상 최적의 해를 보장하지 못한다.
 * 1-1-10-10과 1-1-1-100이 있을 때 그리디는 1-1-1-100을 선택하기 때문이다.
 * 매순간의 최적인 답 선택이 종합적으로 적합한 결과를 도출하는 문제에만 적용할 수 있다.
 * --> 최적 부분 구조
 */
public class BOJ_1700 {

    // 전기용품 사용순서를 통해, 플러그를 빼는 횟수를 최소화
    // 1. 플러그를 뺄 때 남은 횟수가 가장 작은 순서대로 빼기? -> ❌
    // 1 2 3 7
    // 1 3 2 1
    // 2 3
    // 2 3 | 1 1 0 1
    // 2 1 | 0 1 0 1
    // 2 1 | 0 0 0 1
    // 2 7 | 0 0 0 0
    // 임마가 그리디가 안되는 이유는
    /*
    2 8
    1 1 2 3 2 3 1 1 과 같은 케이스가 있다고 해보자.

    남은 횟수 기준으로 뽑는다면 1은 당장 사용되지 않음에도 계속 꽂혀있어서,
    빈번하게 사용되는 2, 3이 번갈아가며 뽑힌다.
    그래서 총 3번 뽑힘.
     */

    // 2. 멀티탭에 꽂혀있는 것 중 가장 나중에 사용되는 애를 제거
    /*
    위에서 당장 사용되지 않는 놈이 횟수가 많아서 꽂혀있는게 문제였으니, 꽂혀있는 애 중 가장 늦게까지 사용되지 않는 놈을 뽑도록 하자.

    그러면,
    2 8
    1 1 2 3 2 3 1 1 케이스에서
    [1, 2]로 꽂혀있는 상황에 3을 만나면 1이 가장 늦게까지 사용되지 않으므로
    [2, 3]이 되어 1을 만날때까지 뽑지않고 사용하다가 비로소 1을 만나야 뽑는다.
    그럼 총 2번을 뽑을 수 있다.
    -> 최적해가 된다.
     */

    static int[] multiTap;
    static int[] usages;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        multiTap = new int[n];
        usages = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int usage = Integer.parseInt(st.nextToken());
            usages[i] = usage;
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            int usage = usages[i];

            if (isAlreadyInsert(usage)) {
                continue;
            }

            if (ifExistsNotUseMultiTapSocketAndInsert(usage)) continue;

            int farSocket = 0;
            int farIdx = 0;
            for (int t = 0; t < multiTap.length; t++) {
                int tmp = multiTap[t];

                int use = Integer.MAX_VALUE;
                for (int c = i+1; c < k; c++) {
                    if (usages[c] == tmp) {
                        use = c;
                        break;
                    }
                }

                if (farSocket < use) {
                    farSocket = use;
                    farIdx = t;
                }
            }

            multiTap[farIdx] = usage;
            ans++;
        }

        System.out.println(ans);
    }

    private static boolean ifExistsNotUseMultiTapSocketAndInsert(int usage) {
        for (int i = 0; i < multiTap.length; i++) {
            if (multiTap[i] == 0) {
                multiTap[i] = usage;
                return true;
            }
        }

        return false;
    }

    private static boolean isAlreadyInsert(int usage) {
        for (int i = 0; i < multiTap.length; i++) {
            if (multiTap[i] == usage) return true;
        }
        return false;
    }
}
