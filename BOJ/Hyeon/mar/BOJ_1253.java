package BOJ.Hyeon.mar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (two(arr, i)) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static boolean two(int[] arr, int idx) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (sum == arr[idx]) {
                if (idx == hi) {
                    hi--;
                    continue;
                } else if (idx == lo) {
                    lo++;
                    continue;
                } else {
                    return true;
                }
            }
            if (sum > arr[idx]) {
                hi--;
            } else {
                lo++;
            }
        }
        return false;
    }
}

// G4 좋다 투포인터
// 맞왜틀 6번이나 했다. 주어진 테케는 빈약해서 자꾸 제출할 수 밖에 없었다.
