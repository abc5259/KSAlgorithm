package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(br.readLine());

        int change = 1000 - price;

        int cnt = 0;

        int[] coin = {500, 100, 50, 10, 5, 1};

        for (int i : coin) {
            if (change >= i) {
                cnt += change / i;
                change %= i;
            }
        }
        System.out.println(cnt);
    }
}
// B2 거스름돈 그리디
// 그냥 시간업서어서 바로 풀었다.