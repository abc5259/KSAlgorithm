package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2018_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 1;
        int start = 1;
        int end = 1;

        int sum = start;
        while (end != N) {
            if (sum == N) {
                cnt++;
                sum -= start++;
            } else if (sum > N) {
                sum -= start++;
            } else {
                sum += ++end;
            }
        }
        System.out.println(cnt);
    }
}
// S5 수들의 합 5 투 포인터
// 10분
// 그냥 숫자가 2개로 주어지고 2개의 숫자를 움직여서 합이 될 경우
// 스타를 빼고 더 갯수가 작은 거로 해서 sum이 N이 될때를 찾음
// 1부터 1까지로 하고 N이 end 와 같을 때를 탈출 조건으로 걸기위해 처음부터
// sum 도 start 로 초기화하고 cnt 도 1로 시작한다.