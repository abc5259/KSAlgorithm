package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> sum = new HashSet<>();

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < (1 << N); i++) {
            int value = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    value += arr[j];
                }
            }
            sum.add(value);
        }
        int idx = 1;

        while (true) {
            if (!sum.contains(idx)) {
                System.out.println(idx);
                break;
            }
            idx++;
        }
    }
}

// S1 부분 수열의 합 부분집합
// 저번에 풀었던 부분수열의 합2 의 풀이를 유사하게 했다. 쉽게 풀었다.