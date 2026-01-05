package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(br.readLine());

        int change = 1000 - price;

        int[] coins = {500, 100, 50, 10, 5, 1};

        int cnt = 0;

        for (int coin : coins) {
            if (change >= coin) {
                cnt += change / coin;
                change %= coin;
            }
        }
        System.out.println(cnt);
    }
}
// B2 거스름돈 그리디
// 4분
// 일단 지불한 금액과 주어진 1000에서 차이인 change 를 통해서
// 그리디로 가장 작은 cnt를 얻기위한 반복문으로 조건을 통해서 증감식으로 계산한다.