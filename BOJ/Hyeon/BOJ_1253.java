package BOJ.Hyeon;

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
            } else if (sum > arr[idx]) {
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
// 일단 주요한 점이 주어 진 수를 제외하고 다른 두 수의 합인데, 계속해서 본인을 넣는 경우를 제외하지 못했다
// -5 0 5가 있으면 1개만 되는데 본인을 넣어서 더하는 경우를 포함하였다.
// 일단 index 를 기준으로 lo와 hi를 두었고 탈출 조건으로 sum 과 주어진 값을 비교한다.
// 이때 idx가 lo거나 hi일 경우 인덱스의 위치를 옮겨야하고 아니면 true 를 반환한다.
// 만약 sum과 다르다면 hi와 lo의 인덱스를 조절한다.
// false 가 출력될 때까지 간다면 탈출이 안되는 수이다.