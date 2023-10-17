package Programmers.JaeHoon.level2;

import java.util.*;
public class 디펜스_게임 {

    class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;
            int low = 0;
            int high = enemy.length;

            while(low + 1 < high) {
                int mid = (low + high) / 2;
                if(check(enemy,mid,n,k)) low = mid;
                else high = mid;
            }

            return low+1;
        }
        public boolean check(int[] enemy, int target, int n, int k) {
            Integer[] arr = new Integer[target+1];
            for(int i=0; i<target+1; i++) {
                arr[i] = enemy[i];
            }
            Arrays.sort(arr, (a,b) -> b-a);

            for(int e: arr) {
                if(k > 0) k--;
                else {
                    if(n < e) return false;
                    n -= e;
                }
            }
            return true;
        }
    }
}
