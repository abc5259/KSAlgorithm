package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_23630 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int size = 0;

        while (max != 0) {
            max /= 2;
            size++;
        }

        int[] cnt = new int[size];

        for (int i = 0; i < N; i++) {
            int tmp = arr[i];

            int idx = 0;
            while (tmp > 0) {
                if ((tmp & 1) == 1) {
                    cnt[idx]++;
                }
                tmp >>= 1;
                idx++;
            }
        }
        int len = 0;
        for (int l : cnt) {
            len = Math.max(len, l);
        }
        System.out.println(len);

    }
}
// S2 가장 긴 부분 수열 구하기 그리디, 비트마스킹
// 50분
// 큰 실수 trouble shooting
// 이진수 에 대한 정수가 아닌 비트를 십진수에 대한 정수로 인식해버렸다
// Integer.toBinaryString을 통해서 정수 를 문자열 이진수로 만들어 버렸고
// Integer.parseInt() 를 통해서 다시 십진수로 만들어서 예를들어 tmp 가 5라면 결과값은 101이라는 3자리수 숫자가 되었다
// 이를 통해 기존의 5 를 통해서 비트 연산을 해야됐고
// 끝자리가 1인기준으로 cnt 배열의 카운트를 올려서 통계를 매겨 max 의 값을 결과로 내었다.