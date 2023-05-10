package Programmers.JaeHoon;

import java.util.*;
public class 택배_배달과_수거하기 {
    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            Stack<Integer> deliverStack = new Stack<>();
            Stack<Integer> pickupStack = new Stack<>();

            for(int i=0; i<n; i++) {
                deliverStack.push(deliveries[i]);
                pickupStack.push(pickups[i]);
            }

            long answer = 0;
            while(!deliverStack.isEmpty() || !pickupStack.isEmpty()) {
                while(!deliverStack.isEmpty() && deliverStack.peek() == 0) {
                    deliverStack.pop();
                }
                while(!pickupStack.isEmpty() && pickupStack.peek() == 0) {
                    pickupStack.pop();
                }
                answer += Math.max(deliverStack.size(), pickupStack.size())*2;

                int total = cap;
                while(total != 0 && !deliverStack.isEmpty()) {
                    int top = deliverStack.pop();
                    if(total < top) {
                        deliverStack.push(top - total);
                        total = 0;
                    }else {
                        total -= top;
                    }

                }


                total = cap;
                while(total != 0 && !pickupStack.isEmpty()) {
                    int top = pickupStack.pop();
                    if(total < top) {
                        pickupStack.push(top - total);
                        total = 0;
                    }else {
                        total -= top;
                    }
                }
            }
            return answer;
        }
    }
}
