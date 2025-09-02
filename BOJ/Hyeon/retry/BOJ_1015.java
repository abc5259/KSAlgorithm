package BOJ.Hyeon.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Pair[] pairs = new Pair[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(val, i);
        }

        Arrays.sort(pairs);

        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            P[pairs[i].index] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int v : P) {
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }

    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.value == o.value) {
                return this.index - o.index;
            }
            return this.value - o.value;
        }
    }
}
// S4 수열 정렬 정렬
// 풀이 1.
// A 배열의 숫자들이 오름차순 정렬(B 배열) 후 최종적으로 몇번째 인덱스로 이동하는지
// 풀이 2.
// if ((A[i] > A[j]) || (A[i] == A[j] && j < i))
// 으로 내앞에 올 카드가 총 몇장인지, 내카드보다 숫자가 크거나, 숫자가 같으면 인덱스가 작을 때를 한다.

// 근데 정렬 문제인데 O(N^2) 보다 O(N*log n)이 나을거 같아서 다시 풀어봤다.
// 값을 기준으로 오름차
// 값이 같으면 인덱스로 오름차 == 사전순으로