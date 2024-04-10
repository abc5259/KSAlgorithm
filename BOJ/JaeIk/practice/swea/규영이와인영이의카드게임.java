package BOJ.JaeIk.practice.swea;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.*;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 규영이와인영이의카드게임 {
    static boolean[] isSelected;
    static int win_case;
    static int lose_case;
    static int[] kyu;
    static int[] in;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int tc=0; tc<T; tc++) {
            isSelected = new boolean[19];
            kyu = new int[9];
            st = new StringTokenizer(br.readLine());

            //규영
            for(int i=0; i<9; i++) {
                kyu[i] = Integer.parseInt(st.nextToken());
                isSelected[kyu[i]] = true;
            }

            win_case = 0;
            lose_case = 0;
            dfs(0, 0);

            System.out.println("#"+(tc+1)+" "+win_case+" "+lose_case);
        }
    }

    static void dfs(int n, int total_score) {
        if(n==9) {
            if(171-total_score < total_score) {
                win_case++;
            }else if(171-total_score > total_score){
                lose_case++;
            }
            return;
        }

        for(int i=1; i<=18; i++) {
            if(isSelected[i])continue;
            isSelected[i] = true;

            if(kyu[n] > i) {
                dfs(n+1, total_score+kyu[n]+i);
            }else {
                dfs(n+1, total_score);
            }

            isSelected[i] = false;
        }
    }
}
