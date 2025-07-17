package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(N % 2 == 0 ? "SK" : "CY");
    }
}

// S5 돌게임 2 수학
// 그냥 규칙만 파악하면 쉬웠다.