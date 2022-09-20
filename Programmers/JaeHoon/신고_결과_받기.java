package Programmers.JaeHoon;

import java.util.*;

public class 신고_결과_받기 {

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> set = new HashSet<String>();
        // 신고 누적
        Map<String,Integer> result = new HashMap<String,Integer>();
        // 누가 누굴 신고했는지.
        Map<String,ArrayList<String>> reportMap = new HashMap<String,ArrayList<String>>();
        for(int i=0; i<report.length; i++) {
            if(set.contains(report[i])) continue;
            set.add(report[i]);
            String[] arr = report[i].split(" ");
            // 신고 누적
            if(result.containsKey(arr[1])) 
                result.put(arr[1],result.get(arr[1]) + 1);
            else 
                result.put(arr[1],1);
            // 누가 누굴 신고했는지.
            if(reportMap.containsKey(arr[0])) {
                reportMap.get(arr[0]).add(arr[1]);
            }
            else {
                reportMap.put(arr[0], new ArrayList<>());
                reportMap.get(arr[0]).add(arr[1]);
            }
            
        }
        
        for(int i=0; i<id_list.length; i++) {
            String name = id_list[i];
            if(!reportMap.containsKey(name)) answer[i] = 0;
            else {
                ArrayList<String> values = reportMap.get(name);
                int sum = 0;
                for(String value: values) {
                    if(result.containsKey(value) && result.get(value) >= k) {
                        sum++;
                    }
                }
                answer[i] = sum;
            }
        }
        
        return answer;
    }
}
}
