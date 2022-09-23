package Programmers.JaeHoon;

import java.util.*;
public class 성격_유형_검사하기 {

class Solution {
    public Map<String,Integer> map = new HashMap<>();
    public int[] check(int num) {
        if(num == 1) {
            return new int[]{0,3};
        }
        else if(num == 2) {
            return new int[]{0,2};
        }
        else if(num == 3) {
            return new int[]{0,1};
        }
        else if(num == 4) {
            return new int[]{-1,0};
        }
        else if(num == 5) {
            return new int[]{1,1};
        }
        else if(num == 6) {
            return new int[]{1,2};
        }
        else {
            return new int[]{1,3};
        }
    };
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] category = {"R","T","C","F","J","M","A","N"};
        String[][] categorys = {{"R","T"},{"C","F"},{"J","M"},{"A","N"}};
        for(String mbti:category) {
            map.put(mbti,0);
        }
        for(int i=0; i<survey.length; i++) {
            String[] mbits = survey[i].split("");
            int[] choice = check(choices[i]);
            if(choice[0] == -1) continue;
            map.put(mbits[choice[0]],map.get(mbits[choice[0]]) + choice[1]);
        }
        for(String[] mbtis: categorys) {
            answer += getMbti(mbtis);
        }
        return answer;
    }
    public String getMbti(String[] mbtis) {
        if(map.get(mbtis[0]) > map.get(mbtis[1])) {
            return mbtis[0];
        }
        else if(map.get(mbtis[0]) < map.get(mbtis[1])){
            return mbtis[1];
        }
        Arrays.sort(mbtis);
        return mbtis[0];
    }
}
}
