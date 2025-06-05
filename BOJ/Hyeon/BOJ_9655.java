package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(N % 2 == 1 ? "SK" : "CY");
    }
}

// S5 돌 게임 수학
// 걍 개쉬움 점화식도 아닌 규칙찾기