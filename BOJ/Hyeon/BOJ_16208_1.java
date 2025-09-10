package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16208_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }

        long res = 0;
        for (int i = N - 1; i > 0; i--) {
            sum -= arr[i];
            res += sum * arr[i];
        }
        System.out.print(res);
    }
}

// S5 귀찮음 누적합 + 수학 other sol
// N 만쓰면된다
// 일단 곱셈연산을 통해서 가운데를 굳이 잘라서 안해도되더라고 맨끝에꺼만 1개씩 떼면서 그 sum 값을
// 줄이다 보면 res 와 연산해서 누적합해서 값을 가질 수 있다
// 뒤부터 순회하면 된다.
// 0부터 i-1번까지의 막대합 * i번째 막대의 길이라고 하면된다.