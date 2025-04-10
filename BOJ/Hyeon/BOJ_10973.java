package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10973 {
    static int N;
    static int[] input;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        prev_perm();
        System.out.print(sb);
    }

    static void prev_perm() {
        int left = N - 1;
        while (left > 0 && input[left - 1] < input[left]) {
            left--;
        }
        if (left == 0) {
            sb.append(-1);
            return;
        }
        int right = N - 1;
        while (right >= left && input[left - 1] < input[right]) {
            right--;
        }
        swap(left - 1, right);
        right = N - 1;
        while (left < right) {
            swap(left, right);
            left++;
            right--;
        }
        for (int i : input) {
            sb.append(i).append(" ");
        }
    }

    static void swap(int a, int b) {
        int tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
}

// S3 이전 순열 순열
// 다음 순열을 구하듯이 풀면된다. 내림차순 하는게 포인트
// 그리고 인덱스 관리에 주의해야되고 right는 left와 같아도 된다.

// 오름차순 방법 양쪽 끝의 인덱스를 가운데로 가져오는 투 포인터 처럼 하면 된다.