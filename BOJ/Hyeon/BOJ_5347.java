package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5347 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = getGCD(a, b);

            sb.append(getLCM(a, b, gcd)).append("\n");
        }
        System.out.println(sb);
    }

    static int getGCD(int a, int b) {

        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    static long getLCM(int a, int b, int gcd) {
        return (long) a / gcd * b;
    }
}
// S5 LCM 유클리드 호제법
// 20분
// 아ㅣ니 계산 실수해서 하루종일 이러고있었네 개 쉬운문젠데.
// 그리고 a랑 b가 100만인지 몰라서 문제에 암만 찾아도 범위가없길래 int로 최소공배수 구했더만 long 이었네.