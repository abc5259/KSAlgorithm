package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ_10974 {
    static int N;
    static int[] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = i + 1;
            sb.append(input[i]).append(" ");
        }
        while (perm()) {
            sb.append("\n");
            for (int i : input) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    static boolean perm() {
        int left = N - 1;
        while (left > 0 && input[left - 1] > input[left]) {
            left--;
        }
        if (left == 0) {
            return false;
        }
        int right = N - 1;
        while (left < right && input[left - 1] > input[right]) {
            right--;
        }
        swap(left - 1, right);

        right = N - 1;
        while (left < right) {
            swap(left, right);
            left++;
            right--;
        }
        return true;
    }

    static void swap(int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
}
// S3 모든 순열 순열
// 걍 다음 순열 넥스트 퍼뮤테이션 써서 풀었다.
// 조건 걸어서 참이면 계속해서 StringBuilder에 저장
// 스왑하고 left right 로 반복문 걸어서 자리 바꾸는 거도 유의