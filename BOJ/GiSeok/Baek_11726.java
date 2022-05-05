package BOJ.GiSeok;

/*
BaekJoon - 11726 2xN 타일링 (05/04 수)

1. 더할 수록 사이즈가 기하급수적으로 커져서 분배법칙을 이용해 더하기 전에 나머지를 구한다.
   나머지 분배법칙 (A + B) % p = ((A % p) + (B % p)) % p
2. 어차피 long형이라서 둘이 더해서 나머지를 구하면 됨
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Baek_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+3];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < N+1; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 10007l;
        
        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }
}