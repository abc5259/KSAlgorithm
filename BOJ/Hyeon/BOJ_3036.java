package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3036 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        int idx = 1;
        while (idx < N) {
            int first = arr[0];
            int second = arr[idx++];

            int gcd = getGCD(first, second);

            sb.append(first / gcd).append("/").append(second / gcd).append("\n");
        }
        System.out.println(sb);
    }

    static int getGCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}
// S4 링 수학
// 7분
// 그냥 두수의 최대공약수를 구해서 수를 나누는걸 구하는거였다
// 유클리드 호제법 즉 최대공약수를 얻는 수식을 상기하자
// a 와 b 가 있을 때 b가 0이 될때까지 반복할거다 즉 a 가 최대공약수가 남게
// b의 값을 기억해뒀다가 b에는 a를 b로 나눈 나머지를 넣는다 즉 b의 수가 줄어들것이다
// 그리고 a 의 값은 기억해둔 b 로 대체한다 즉 b 는 점점더 작아지고 a 는 기억한 b로 나누면서 진행한다?
