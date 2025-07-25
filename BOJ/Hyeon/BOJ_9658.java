package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.print((N % 7 == 1 || N % 7 == 3) ? "CY" : "SK");
    }
}

// S2 돌게임 4 수
// DP가 아니라 순서대로해서 내가 상대방을 이길 수 있게 혹은
// 상대방이 질 수 있게 베스킨 라빈스 게임하듯 하면된다.
//  페르소나를 나눠서 한다.