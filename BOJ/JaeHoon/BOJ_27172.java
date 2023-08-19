package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_27172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];
        int INF = 1000001;
        boolean[] isUsed = new boolean[INF];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            isUsed[cards[i]] = true;
        }

        int[] score = new int[INF+1];
//        for(int i=0; i<N; i++) {
//            score[cards[i]] = i+1;
//        }

        for(int i=0; i<N; i++) {
            int card = cards[i];
            for(int j=card*2; j<INF; j+=card) {
                if(isUsed[j]) {
                    score[card]++;
                    score[j]--;
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i: cards) {
            sb.append(score[i] + " ");
        }
        System.out.println(sb);
    }
    static class Player {
        int id,card,score;

        public Player(int id, int card) {
            this.id = id;
            this.card = card;
        }
    }
}
