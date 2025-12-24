package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_17419 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String binary = br.readLine();

        BigInteger K = new BigInteger(binary, 2);

        int cnt = 0;

        while (!K.equals(BigInteger.ZERO)) {
            cnt++;
            K = K.subtract(K.and(K.not().add(BigInteger.ONE)));
        }
        System.out.println(cnt);
    }
}
// S4 비트가 넘쳐흘러 BigInteger
// 20분
// 아니 100만 자리래서 String 인줄 알았는데