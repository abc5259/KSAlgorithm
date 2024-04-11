package Programmers.GiSeok.lv1;

import java.util.Map;
import java.util.HashMap;

public class 가장_많이_받은_선물 {

    int[] giftScore;
    int[][] giveAndTakeScore;
    int[] nextMonthGiftScore;

    public int solution(String[] friends, String[] gifts) {
        int N = friends.length;

        Map<String, Integer> friendIdx = new HashMap<>();
        giftScore = new int[N];
        giveAndTakeScore = new int[N][N];
        nextMonthGiftScore = new int[N];

        for (int i = 0; i < friends.length; i++)
            friendIdx.put(friends[i], i);
        
        // 선물 지수와 주고 받은 선물 수 계산
        for (String gift : gifts) {
            int giver = friendIdx.get(gift.split(" ")[0]);
            int receiver = friendIdx.get(gift.split(" ")[1]);
            
            giveAndTakeScore[giver][receiver] += 1;
            giftScore[giver] += 1;
            giftScore[receiver] -= 1;
        }
        
        for (int i = 0; i < friends.length; i++) {
            int v1 = friendIdx.get(friends[i]);
            for (int j = i + 1; j < friends.length; j++) {
                int v2 = friendIdx.get(friends[j]);
                
                if (giveAndTakeScore[v1][v2] == giveAndTakeScore[v2][v1]) {
                    if (giftScore[v1] > giftScore[v2])
                        nextMonthGiftScore[v1] += 1;
                    else if (giftScore[v1] < giftScore[v2])
                        nextMonthGiftScore[v2] += 1;
                } else if (giveAndTakeScore[v1][v2] != 0 || giveAndTakeScore[v2][v1] != 0) {
                    if (giveAndTakeScore[v1][v2] > giveAndTakeScore[v2][v1])
                        nextMonthGiftScore[v1] += 1;
                    else if (giveAndTakeScore[v1][v2] < giveAndTakeScore[v2][v1])
                        nextMonthGiftScore[v2] += 1;
                } 
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < friends.length; i++)
            if (answer < nextMonthGiftScore[i])
                answer = nextMonthGiftScore[i];
        
        return answer;
    }
}
