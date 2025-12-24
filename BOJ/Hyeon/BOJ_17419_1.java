package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_17419_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String binary = br.readLine();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (binary.charAt(i) == '1') {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
// S4 비트가 넘쳐흘러 비트 마스킹
// 20분
// 아니 100만 자리래서 String 인줄 알았는데 그냥 1의 갯수 세면된다.