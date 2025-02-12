package BOJ.Hyeon.feb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int res = 0;
        while (N > 1) {
            if (N % 5 == 0) {
                res += N / 5;
                N %= 5;
            } else {
                N -= 3;
                res++;
            }
        }
        System.out.println(N > 0 ? -1 : res);
    }
}
// S4 설탕배달 그리디
// 개쉽게 풀었다. 예전에 풀었는데 다시한번 풀었고 N개의 갯수가 남았을 때를 기준으로
// while 반복문을 돌리고 0보다 클경우에는 -1을 리턴하고 아니면 res에 추가된 수를 반환한다.
// 그리디라서 5라는 큰거부터 고려햇고 5로 나누어 떨어지지않는거면
// 반드시 3이 섞여있다고 판단했다.