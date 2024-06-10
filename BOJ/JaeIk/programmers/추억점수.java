package BOJ.JaeIk.programmers;

import java.util.*;

class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }

        int[] result = new int[photo.length];
        for(int i=0; i<photo.length; i++){
            int score = 0;
            for(int j=0; j<photo[i].length; j++){
                Integer value = map.get(photo[i][j]);

                if(value == null)continue;
                score += value;
            }
            result[i] = score;
        }

        return result;
    }
}