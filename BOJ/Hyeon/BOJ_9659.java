package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_9659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(br.readLine());

        if (N.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
// S3 돌 게임 5 숫자
// 5분
// 1조라서 이게 O(N)만 되도 시간 초과인데 그냥 O(1) 밖에 없다 생각했는데 보니까
// BigInteger 로 받고 홀수짝수의 개념