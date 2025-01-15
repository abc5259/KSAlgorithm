package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_2195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String P = br.readLine();
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i=0; i<S.length(); i++) {
            char key = S.charAt(i);
            List<Integer> list = map.getOrDefault(key, new ArrayList<>());
            list.add(i);
            map.put(key, list);
        }
        System.out.println(map);
        int index = 0;
        int answer = 0;
        while (index < P.length()) {
            char key = P.charAt(index);
            List<Integer> list = map.get(key);
            int max = 0;
            for(int i=0; i<list.size(); i++) {
                int size = 0;
                int iIndx  = index;
                for(int j=list.get(i); j<S.length(); j++) {
                    if(iIndx >= P.length()) break;
                    if(S.charAt(j) == P.charAt(iIndx)) {
                        iIndx++;
                        size++;
                    }else {
                        break;
                    }
                }
                max = Math.max(max, size);
            }
            answer++;
            index += max;
        }
        System.out.println(answer);
    }
}
