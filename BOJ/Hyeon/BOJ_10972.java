package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10972 {
    static int N;
    static int[] input;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        input = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        next_perm();
        System.out.print(sb);
    }

    static void next_perm() {
        int left = N - 1;
        while (left > 0 && input[left - 1] > input[left]) {
            left--;
        }
        if (left == 0) {
            sb.append(-1);
            return;
        }

        int right = N - 1;
        while (right > left && input[left - 1] > input[right]) {
            right--;
        }
        swap(left - 1, right);
        Arrays.sort(input, left, N);

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

// S3 다음 순열 순열
// next permutation 이고 구현을 처음부터 다져봤다.
// 일단 left 와 right 로 나누는 것이 중요하다.
// 왼쪽에서 오른쪽으로 증가할 때 다음 순열이 동작한다. 왜냐면 다음 순열이 더 큰값이 와야 하니까 최종적으로는 제일 큰수가 만들어 진다.
// 그렇다면 단계별로 나눠본다
// 1. 가장 오른쪽 끝에서 시작한다 이는 left가 된다.
// 2. left가 0보다 크고 left-1 보다 값이 크면 left-1 왼쪽으로 벽이 생성된다.
// 2-1. left-1이 더 크면 인덱스를 --해서 left보다 작은 값을 찾아야 나중에 자리를 바꿀 수 있다.

// 3. left가 0이 아닌지를 판단하고
// 3. right 를 만들어서 left의 -1과 비교한다. 근데 left-1 보다 클 경우 자리를 바꾼다.
// 3-1. right 가 더 작다면 right를 -- 해서 더 큰수를 찾는다.
// 4. swap 하고 나서 우측쪽의 숫자들을 오름차순한다. 이가 순열의 구분동작이다.