package Programmers.JaeHoon.level3;

import java.util.*;
public class 보석_쇼핑 {

    class Solution {
        public int[] solution(String[] gems) {
            int[] answer = {};
            Map<String, Integer> map = new HashMap<>();

            for(int i=0; i<gems.length; i++) {
                map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            }

            int left = 0;
            int right = gems.length - 1;
            Map<String, Integer> delMap = new HashMap<>();
            int[] result = {0, gems.length-1};

            while(left <= right) {
                if(map.get(gems[right]) > 1) {
                    map.put(gems[right], map.get(gems[right]) - 1);
                    delMap.put(gems[right], delMap.getOrDefault(gems[right],0) + 1);
                    right--;
                    if(right - left  < result[1] - result[0]) {
                        result[0] = left;
                        result[1] = right;
                    }
                }
                else if(map.get(gems[left]) > 1) {
                    map.put(gems[left], map.get(gems[left]) - 1);
                    delMap.put(gems[left], delMap.getOrDefault(gems[left],0) + 1);
                    left++;
                    if(right - left  < result[1] - result[0]) {
                        result[0] = left;
                        result[1] = right;
                    }
                }else {
                    break;
                }
            }


            while(left <= right) {
                if(map.get(gems[left]) > 1) {
                    map.put(gems[left], map.get(gems[left]) - 1);
                    left++;
                }
                else if(map.get(gems[left]) == 1) {
                    if(delMap.getOrDefault(gems[left],0) > 0) {
                        boolean isOk = false;
                        for(int i=right+1; i<gems.length; i++) {

                            if(gems[i].equals(gems[left])) {
                                isOk = true;
                                right = i;
                                left++;
                                break;
                            }else {
                                map.put(gems[i], map.get(gems[i]) + 1);
                            }
                        }
                        if(!isOk) break;
                    }else {
                        break;
                    }
                }

                if(right - left  < result[1] - result[0]) {
                    result[0] = left;
                    result[1] = right;
                }
            }
            if(left > right) return result;

            return new int[]{result[0]+1, result[1]+1};
        }
    }
}
