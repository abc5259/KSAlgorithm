package Programmers.JaeHoon.level2;

import java.util.*;
public class 숫자카드_나누기 {

    class Solution {
        public int solution(int[] arrayA, int[] arrayB) {
            int answer = 0;

            int a = arrayA[0];
            for(int i=1; i<arrayA.length; i++) {
                a = gcd(a, arrayA[i]);
            }

            List<Integer> lists = new ArrayList<>();

            for(int i=1; i<=a; i++) {
                if(a % i == 0) lists.add(i);
            }

            for(int i=lists.size()-1; i>=0; i--) {
                if(isOk(arrayB,lists.get(i))) {
                    answer = lists.get(i);
                    break;
                }
            }

            int b = arrayB[0];
            for(int i=1; i<arrayB.length; i++) {
                b = gcd(b, arrayB[i]);
            }

            lists = new ArrayList<>();

            for(int i=1; i<=b; i++) {
                if(b % i == 0) lists.add(i);
            }

            for(int i=lists.size()-1; i>=0; i--) {
                if(isOk(arrayA,lists.get(i))) {
                    answer = Math.max(answer, lists.get(i));
                    break;
                }
            }


            return answer;
        }

        public boolean isOk(int[] arr, int value) {
            for(int i=0; i<arr.length; i++) {
                if(arr[i] % value == 0)  {
                    return false;
                }
            }
            return true;
        }
        public int gcd(int a, int b) { // a > b 일때
            if(b == 0) return a;	// gcd를 찾았다면 그 몫을 return
            else return gcd(b, a % b);
        }
    }
}
