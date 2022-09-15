package Programmers.JaeHoon;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 메뉴_리뉴얼 {

class Solution {
    static Map<String, Integer> hashmap = new HashMap<String, Integer>();
    
    class Order {
        String menu;
        int cnt;
        Order(String menu, int cnt) {
            this.menu = menu;
            this.cnt = cnt;
        }
    }
    
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<Order> answer = new ArrayList<>();
        for(String order:orders) {
            for(int i=0; i<course.length; i++) {
                solve(course[i],0,order,"",0);
            }
        }
        for (Map.Entry<String, Integer> pair : hashmap.entrySet()) {
            if(pair.getValue() <= 1) continue;
            
            boolean isAdd = true;
            for(Iterator<Order> it = answer.iterator(); it.hasNext();) {
                Order curr = it.next();
                if(curr.menu.length() == pair.getKey().length()) {
                    if(curr.cnt > pair.getValue()) {
                        isAdd = false;
                        continue;
                    }
                    else if(curr.cnt < pair.getValue()) {
                        it.remove();
                        continue;
                    }
                }
             }
             if(isAdd)
                answer.add(new Order(pair.getKey(),pair.getValue()));
        }
        
        ArrayList<String> result = new ArrayList<>();
        for(int i=0; i<answer.size(); i++) {
            result.add(answer.get(i).menu);
        }
        Collections.sort(result);
        return result;
    }

    public void solve(int limit, int depth, String s, String result,int cnt) {
        if(cnt > limit) {
            return;
        }
        if(depth == s.length()) {
            result = Stream.of(result.split(""))
                    .sorted()
                    .collect(Collectors.joining());
            if(cnt == limit) {
                if(hashmap.containsKey(result)) {
                    hashmap.put(result,hashmap.get(result) + 1);
                }else {
                    hashmap.put(result,1);
                }   
            }
            return;
        }
        solve(limit,depth+1,s,result,cnt);
        solve(limit,depth+1,s,result+s.charAt(depth)+"",cnt+1);
    }
  }
}
