package Programmers.JaeHoon;

import java.util.*;

public class 순위_검색 {

class Solution {
    static Map<String, ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for(int i=0; i<info.length; i++) {
            dfs(0,"",info[i].split(" "));
        }
        
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        for(int i=0; i<keys.size(); i++) {
               ArrayList<Integer> value = map.get(keys.get(i));
               Collections.sort(value);
        }
        
        for(int i=0; i<query.length; i++) {
            String q = query[i].replaceAll(" and ", "");
            String[] newQuery = q.split(" ");
            
            String key = newQuery[0];
            int findScore = Integer.parseInt(newQuery[1]);
            
            if(!map.containsKey(newQuery[0])) {
                answer[i] = 0;
                continue;
            }
            
            ArrayList<Integer> scores = map.get(key);
            
            int low = 0;
            int high = scores.size() - 1;
            
            while(low <= high) {
                int middle = (low+high) / 2;
                if(scores.get(middle) < findScore) {
                    low = middle + 1;
                }else {
                    high = middle - 1;                
                }
            }
            answer[i] = scores.size() - low;
        }
        return answer;
    }
    public void dfs(int depth,String key,String[] info) {
        if(depth == 4) {
            if(!map.containsKey(key)) {
                ArrayList<Integer> value = new ArrayList<>();
                value.add(Integer.parseInt(info[4]));
                map.put(key,value);
            }else {
                map.get(key).add(Integer.parseInt(info[4]));
            }
            return;
        }
        dfs(depth+1,key+"-", info);
        dfs(depth+1, key+info[depth], info);
    }
}
}
