package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13909 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println((int) Math.sqrt(n));
    }
}

// S5 창문 닫기 정수론
// 입력값이 21억이라서 계속해서 1부터 주어진 테스트케이스 24까지 해봤더니 제곱수 단위로
// 열려있는 창문의 수가 생겨났다
// 그래서 제곱수를 다루는 sqrt 메서드를 통해 입력값의 제곱근을 구했다.