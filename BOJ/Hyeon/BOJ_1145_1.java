package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1145_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    // 최소 공배수 구하기
                    int tmp = lcm(arr[i], arr[j]);
                    int res = lcm(arr[k], tmp);

                    min = Math.min(min, res);
                }
            }
        }
        System.out.println(min);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
// B1 적어도 대부분의 배수 완전탐색
// another sol
// 일단 최소 공배수를 구한다 최소 공배수는 두 수의 곱에서 최대 공약수를 나눠준다
// 그럼최대공약수를 구해야겠지
// 배열의 길이는 5개고 거기서 3개의 최소공배수를 구하는 거니까 3중 반복문 해서
// 각 3개의 값에서 최소 공배수중 가장 최소 값을 구한다
// 근데 최소공배수를 구하려면 두수의 곱에서 최대공약수로 나눠야되는데
// 최대공약수는 유클리드 호제법으로 계산한다.
