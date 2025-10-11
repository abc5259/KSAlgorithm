package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = M; i <= N; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) {
                    sum += j * j;
                    min = Math.min(min, j * j);
                }
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
// B2 완전제곱수 완전탐색
// 4분
// 그냥 i가 M이상 N 이하인데 여기서 완전제곱수만을 추출해야되는데 완전 제곱수는 1부터 어떤 수의 제곱까지
// 그게 N이상 M 이하의 범위내에서 움직여야되니까
// 2중 반복문을 사용하고 거기에서 j*j가 i로 일치해야 그게 값을 가지고 sum 이 0이면 그냥 도루묵으로 -1을 출력한다.