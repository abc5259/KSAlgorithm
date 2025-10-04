package Programmers.GiSeok.lv2.kakao;

import java.util.*;

public class 이모티콘_할인행사 {

    private List<Integer> sales = new ArrayList<>();
    private int plusUsers = 0;
    private int buyPrice = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, users, emoticons);
        int[] answer = {plusUsers, buyPrice};

        return answer;
    }

    void dfs(int cnt, int[][] users, int[] emoticons) {
        if (cnt == emoticons.length) {
            int plus = 0;
            int buy = 0;

            for (int i = 0; i < users.length; i++) {
                int total = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (sales.get(j) < users[i][0]) continue;
                    total += emoticons[j] - (emoticons[j] * sales.get(j) / 100);
                }

                if (total >= users[i][1]) {
                    plus++;
                } else {
                    buy += total;
                }
            }

            if (plus >= plusUsers) {
                if (plusUsers < plus) {
                    buyPrice = buy;
                } else {
                    buyPrice = Math.max(buyPrice, buy);
                }
                plusUsers = plus;
            }

            return;
        }

        for (int sale = 10; sale <= 40; sale += 10) {
            sales.add(sale);
            dfs(cnt+1, users, emoticons);
            sales.remove(cnt);
        }
    }
}
