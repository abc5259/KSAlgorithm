package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] res = new int[3];
        int[] liquids = new int[N];
        for (int i = 0; i < N; i++) {
            liquids[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquids);
        long min = Long.MAX_VALUE;

        for (int i = 0; i < N - 2; i++) {
            int lo = i + 1;
            int hi = N - 1;

            while (lo < hi) {
                long sum = (long) liquids[i] + liquids[lo] + liquids[hi];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    res[0] = liquids[i];
                    res[1] = liquids[lo];
                    res[2] = liquids[hi];
                }
                if (sum > 0) {
                    hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    System.out.println(res[0] + " " + res[1] + " " + res[2]);
                    return;
                }
            }
        }
        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }
}
// G3 세 용액 투 포인터
// 투 포인터의 개념을 새로 배운거 같다. 고정되어있는 포인터를 이용하는거니까
// 만약 3개의 좌표를 이용해야 될 때 시작점을 고정하고 그뒤의 두 점을 움직여서 나머지 포인터로 활용하는 문제였다.
// trouble shooting
// 처음부터 완전 테스트케이스랑 다 맞았는데도 틀린 이유는 포인터를 잘못 사용한거다
// 투 포인터면 포인터는 움직이지 않은채로 비교해야되는데 내가 i를 가운데서 계속 탐색시켜서 틀렸다.