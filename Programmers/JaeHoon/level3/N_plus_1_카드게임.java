package Programmers.JaeHoon.level3;
import java.util.*;

public class N_plus_1_카드게임 {

    class Solution {
        public int solution(int coin, int[] cards) {
            int answer = 0;

            int N = cards.length;
            int M = N / 3;

            int[] deck = new int[M];
            for(int i=0; i<M; i++) {
                deck[i] = cards[i];
            }

            List<Integer> pickDeck = new ArrayList<>();
            boolean[] isUsed = new boolean[N];
            boolean isAdd = false;
            if(M >= N) {
                return 1;
            }
            for(int k=M; k<N+2; k+=2) {
                answer++;
                if(k >= N) {
                    break;
                }
                pickDeck.add(cards[k]);
                pickDeck.add(cards[k+1]);

                //1. 내 덱에서 만들 수 있는 경우
                boolean isOk = false;
                for(int i=0; i<M-1; i++) {
                    if(isOk) break;
                    if(deck[i] == 0) continue;
                    for(int j=i+1; j<M; j++) {
                        if(deck[j] == 0) continue;
                        if(deck[i] + deck[j] == N + 1) {
                            isOk = true;

                            deck[i] = 0;
                            deck[j] = 0;
                            break;
                        }
                    }
                }


                if(isOk) continue;
                if(coin < 1) break;

                //2. 내 덱에서 하나 + 뽑은 덱에서 하나
                for(int i=0; i<M; i++) {
                    if(isOk) break;
                    if(deck[i] == 0) continue;
                    for(int j=0; j<pickDeck.size(); j++) {
                        if(isUsed[j]) continue;
                        if(deck[i] + pickDeck.get(j) == N + 1) {

                            deck[i] = 0;
                            isUsed[j] = true;
                            isOk = true;
                            coin--;
                            break;
                        }
                    }
                }

                if(isOk) continue;
                if(coin < 2) break;

                for(int i=0; i<pickDeck.size()-1; i++) {
                    if(isOk) break;
                    if(isUsed[i]) continue;
                    for(int j=i+1; j<pickDeck.size(); j++) {
                        if(isUsed[j]) continue;
                        if(pickDeck.get(i) + pickDeck.get(j) == N + 1) {
                            isUsed[i] = true;
                            isUsed[j] = true;
                            coin-=2;
                            isOk = true;
                            break;
                        }
                    }
                }

                if(!isOk) break;
            }


            return answer;
        }
    }
}
