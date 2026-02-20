package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()) * 2;

        int min = Integer.MAX_VALUE;

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = n - 1;

        while (start < end) {
            int skill = arr[start++] + arr[end--];
            if (skill < min) {
                min = skill;
            }
        }

        System.out.println(min);
    }
}
// S4 Project Teams 투 포인터
// 6분
// 걍 개쉬움. 무조건 정렬 기준 양옆이라서 다시 풀으니 문제 없음
// n은 5천까지라서 O(N)도 문제없고 또 *2기준이라 투포인터가 정상적으로 작동