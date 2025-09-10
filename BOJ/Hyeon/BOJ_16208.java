package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16208 {
    static long sum = 0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        cal(0, N - 1);
        System.out.println(sum);
    }

    static void cal(int start, int end) {
        if (end == start) {
            return;
        }

        int tmp = (start + end) / 2 + 1;

        long l = 0, r = 0;
        for (int i = start; i < tmp; i++) {
            l += arr[i];
        }
        for (int i = tmp; i <= end; i++) {
            r += arr[i];
        }

        sum += (l * r);
        cal(start, tmp - 1);
        cal(tmp, end);
    }
}
// S5 귀찮음 분할 정복
// 전체 막대 배열을 (start  + end) / 2  지점을 기준으로 절반씩 나누는 재귀방식 사용

// 자르는 순서가 주어진 arr 그대로 인줄 알고 푼 것이다.
// N이 50만이고 sum의 값은 int 초과이다 그래서 long으로 치환
// 병합정렬 방식을 사용해서 Nlog N이다.

