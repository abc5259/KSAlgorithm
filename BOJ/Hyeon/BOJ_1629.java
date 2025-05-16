package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    static long C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B));

    }

    static long pow(long A, long B) {
        if (B == 0) return 1;
        long half = pow(A, B / 2);
        long half2 = (half * half) % C;
        if (B % 2 == 0) {
            return half2;
        } else {
            return (half2 * (A % C)) % C;
        }
    }
}

// S1 곱셈 분할정복
// retry