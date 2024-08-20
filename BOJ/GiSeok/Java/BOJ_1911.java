/**
 * 1911 - 흙길 보수하기 [실패]
 * 골드5, 그리디/라인스위핑, 시도4
 */
package BOJ.GiSeok.Java;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1911 {
    // 시간제한 2초, 메모리제한 128MB
    // 흙길에 N(1 <= N <= 10,000)개의 물웅덩이가 생김
    // 물웅덩이 위를 덮을 수 있는 길이 L(1 <= L <= 1,000,000) 널빤지를 갯수 제한x 가지고 있다.
    // 물웅덩이 위치에 따라 필요한 널빤지 최소갯수

    static int[][] water;
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        water = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            water[i][0] = Integer.parseInt(st.nextToken());
            water[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(water, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        int wood = 0;
        int ret = 0;
        for (int i = 0; i < N; i++) {
            if (wood >= water[i][1]) continue;

            int cnt = 0;
            if (wood < water[i][0]) {
                cnt = ((water[i][1] - water[i][0]) / L) + (((water[i][1] - water[i][0]) % L) >= 1 ? 1 : 0);
                wood = water[i][0] + cnt * L;
            } else {
                cnt = ((water[i][1] - wood) / L) + (((water[i][1] - wood) % L) >= 1 ? 1 : 0);
                wood = wood + cnt * L;
            }

            ret += cnt;
        }

        System.out.println(ret);
    }
}
