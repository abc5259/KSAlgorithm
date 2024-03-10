package Programmers.JaeHoon.level2;

import java.util.*;
public class 혼자_놀기의_달인 {

    class Solution {
        int[] parent;
        public int solution(int[] cards) {
            int answer = 0;
            parent = new int[cards.length+1];
            for(int i=1; i<=cards.length; i++) {
                parent[i] = i;
            }

            for(int i=0; i<cards.length; i++) {
                union(i+1, cards[i]);
            }

            int[] arr = new int[cards.length+1];
            for(int i=0; i<cards.length; i++) {
                int n = find(cards[i]);
                arr[n]++;
            }

            Arrays.sort(arr);
            return arr[arr.length-1] * arr[arr.length-2];
        }

        public int find(int x) {
            if(parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);

            if(x < y) {
                parent[y] = x;
            }else {
                parent[x] = y;
            }
        }
    }
}
