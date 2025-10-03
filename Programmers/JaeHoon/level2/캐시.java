package Programmers.JaeHoon.level2;

import java.util.*;

public class 캐시 {

    class Solution {
        // 시작 3시 15분
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            Set<String> set = new HashSet<>();
            Deque<String> cache = new ArrayDeque<>();
            for(int i=0; i<cities.length; i++) {
                String city = cities[i].toLowerCase();
                if(set.contains(city)) {
                    answer++;
                    Stack<String> stack = new Stack<>();
                    while(!cache.peekFirst().equals(city)) {
                        stack.push(cache.pollFirst());
                    }
                    cache.offerLast(cache.pollFirst());
                    while(stack.size() > 0) {
                        cache.offerFirst(stack.pop());
                    }
                }else {
                    if(cacheSize == 0) {
                        answer+=5;
                        continue;
                    }
                    if(cache.size() == cacheSize) {
                        set.remove(cache.pollFirst());
                    }
                    set.add(city);
                    cache.offerLast(city);
                    answer+=5;
                }
                // System.out.println(cache);
            }
            return answer;
        }
    }
}
