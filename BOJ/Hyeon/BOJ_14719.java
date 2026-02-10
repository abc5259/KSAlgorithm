package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int raining = 0;

        for (int i = 1; i < W - 1; i++) {
            int leftMax = 0;
            for (int l = 0; l < i; l++) {
                leftMax = Math.max(leftMax, arr[l]);
            }
            int rightMax = 0;
            for (int r = i; r < W; r++) {
                rightMax = Math.max(rightMax, arr[r]);
            }
            int min = Math.min(leftMax, rightMax);

            if (min > arr[i]) {
                raining += min - arr[i];
            }
        }
        System.out.println(raining);
    }
}
// G5 빗물 구현?
// 34분
// 일단 양옆은 절대 안되는 구조고 그러면 1번 인덱스부터 시작해야되는데
// 1번 인덱스 기준으로는 0번 인덱스와 2번 인덱스에서 끝까지 중에서 큰 것까지 고려해야된다
// 그래서 그 양쪽을 비교했을 때 작은값보다 현재가 더 작아야 빗물이 찬다
// 그래서 나는 바로 양옆만 구별했다가 나올 수 있는 최대값을 구해야 했다 그래서 W,H 가 500이니까
// N^2 도 무리없다고 생각해서 양옆을 구해서 최고값을 구한 후 그중 가장 작은 높이에서
// 내 높이를 뺴서 값을 구해갔다.