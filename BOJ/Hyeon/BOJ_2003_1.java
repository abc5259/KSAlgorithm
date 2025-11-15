package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        int start = 0;
        int end = 0;

        int sum = arr[start];

        while (start < N) {
            if (sum < M && end < N - 1) {
                sum += arr[++end];
            } else {
                if (sum == M) {
                    cnt++;
                }
                sum -= arr[start++];
            }
        }
        System.out.println(cnt);
    }
}
// S4 수 들의 합 2 투 포인터?
// 27분
// start 와 end를 각각 두고 sum 을 통해서 누적해서 빼고 한다
// 일단 주어진 시간이 0.5초이기에 N^2연산은 하면안됐고 투 포인터로 O(N) 연산한다
// while 의 조건인 start < N 은 start 포인터가 배열의 끝까지 갈 때를 확인하는 것이다
// sum < M 은 합이 모자라서 확장이 필요한 것이고 ArrayIndexOutOfBound 주의
// else 에 대해서는 축소이다.