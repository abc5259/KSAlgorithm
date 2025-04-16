package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888 {
    static int[] op;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[N - 1];

        st = new StringTokenizer(br.readLine());
        int idx = 0;

        for (int i = 0; i < 4; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            while (cnt-- > 0) {
                op[idx++] = i;
            }
        }

        int[] tmp = new int[N];

        do {
            calculate(arr, tmp);
            max = Math.max(tmp[N - 1], max);
            min = Math.min(tmp[N - 1], min);
        } while (next_perm());

        System.out.println(max);
        System.out.println(min);
    }

    private static void calculate(int[] arr, int[] tmp) {
        System.arraycopy(arr, 0, tmp, 0, N);
        for (int i = 1; i < N; i++) {
            switch (op[i - 1]) {
                case 0:
                    tmp[i] = tmp[i - 1] + tmp[i];
                    break;
                case 1:
                    tmp[i] = tmp[i - 1] - tmp[i];
                    break;
                case 2:
                    tmp[i] = tmp[i] * tmp[i - 1];
                    break;
                case 3:
                    tmp[i] = tmp[i - 1] / tmp[i];
                    break;
            }
        }
    }

    static boolean next_perm() {
        int left = N - 2;

        while (left > 0 && op[left - 1] >= op[left]) {
            left--;
        }
        if (left == 0) {
            return false;
        }
        int right = N - 2;
        while (op[left - 1] >= op[right]) {
            right--;
        }
        swap(left - 1, right);
        right = N - 2;
        while (left < right) {
            swap(left, right);
            left++;
            right--;
        }
        return true;
    }

    static void swap(int a, int b) {
        int tmp = op[a];
        op[a] = op[b];
        op[b] = tmp;
    }
}

// S1 연산자 끼워넣기 순열
// 다음 순열을 통해서 연산자의 순열을 구해서 연산자별로 계산하여 최종값을 대소 관계를 구하는 것
// 일단 순열을 사용할 때 넥스트 퍼뮤테이션 방식을 썻기 때문에 리버스 하는 과정과 swap을 구현했다.
// 그리고 계속해서 비교하기 위해 copy 배열을 사용했다.