package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();


        for (int i = L; i <= 100; i++) {
            int sum = i * (i - 1) / 2;

            if (N < sum) {
                break;
            }
            int tmp = N - sum;
            if (tmp % i == 0) {
                int add = tmp / i;
                for (int j = 0; j < i; j++) {
                    sb.append(j + add).append(" ");
                }
                System.out.println(sb);
                return;
            }
        }
        System.out.println(-1);
    }
}
// S2 수열의 합 구현, 수학
// 22분
// 일단 먼저 i가 자리수를 고려해서 L의 개수가 100보다 크면 -1을 리턴해야하기에 L부터 점진적으로 100까지 증가시킨 반복문을 해서
// 또 0부터 자리수-1까지해서 연속된 수의 합을 구한다 이는 수학의 합공식으로 n(n-1)/2 썼다. 3개의 Length 라면 0 1 2 해서 합이 3이 된다.
// 그다음 sum이 N보다 크다면 해당하는 길이로는 더이상 안된다는것이기 떄문에 기저사례로 -1을 출력해버린다.
// 이게 통과가되면 N에서 sum 을 빼고 tmp 라는 임시값에서 현재의 임시값이 길이 즉 i 의 배수라면
// 몫만큼 j에다가 각각 더해주면 자연스레 증가하는 수열이 만들어진다
// 그래서 나누어 떨어진다면 하고 아니면 다음 자리수로 가서 add를 j반복문에 넣어서 sb로 출력한다