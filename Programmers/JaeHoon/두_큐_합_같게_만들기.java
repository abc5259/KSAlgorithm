package Programmers.JaeHoon;

import java.util.*;
public class 두_큐_합_같게_만들기 {

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1Sum = 0;
        long q2Sum = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++) {
            q1Sum += queue1[i];
            q2Sum += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        HashSet<String> set = new HashSet<>();
        long half = (q1Sum+q2Sum) / 2;
        if ((q1Sum + q2Sum) % 2 == 1)
            return -1;
        int p1 = 0;
        int p2 = 0;
        int limit = queue1.length*2;
        while(q1Sum != q2Sum) {
            if(p1 > limit || p2 > limit) return -1;
            if(q1Sum == 0 || q2Sum == 0) {
                return -1;
            }
            if(q1Sum < half && q2Sum > half) {
                p1++;
                int removeItem = q2.poll();
                q1.offer(removeItem);
                q1Sum += removeItem;
                q2Sum -= removeItem;
            }
            else if(q1Sum > half && q2Sum < half) {
                p2++;
                int removeItem = q1.poll();
                q2.offer(removeItem);
                q2Sum += removeItem;
                q1Sum -= removeItem;
            }
        }
        return q1Sum == q2Sum ? p1+p2 : -1;
    }
}
}
