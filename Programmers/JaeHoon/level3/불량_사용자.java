package Programmers.JaeHoon.level3;

import java.util.*;
public class 불량_사용자 {

    class Solution {
        Map<String, List<String>> map;
        Map<String, Integer> usedMap;
        boolean[] isUsed;
        Map<String, Integer> userIdxMap = new HashMap<>();
        int answer = 0;
        String[] bannedId;
        int[] arr;
        Set<String> results = new HashSet<>();
        public int solution(String[] user_id, String[] banned_id) {
            bannedId = banned_id;
            for(int i=0; i<user_id.length; i++) {
                userIdxMap.put(user_id[i], i);
            }

            map = new HashMap<>();
            usedMap = new HashMap<>();

            for(int i=0; i<banned_id.length; i++) {
                //이미 있으면 넘김
                if(map.containsKey(banned_id[i])) continue;

                map.put(banned_id[i], new ArrayList<>());

                for(int j=0; j<user_id.length; j++) {
                    if(banned_id[i].length() != user_id[j].length()) {
                        continue;
                    }

                    boolean isOk = true;
                    for(int k=0; k<banned_id[i].length(); k++) {
                        if(banned_id[i].charAt(k) == '*') continue;
                        if(banned_id[i].charAt(k) != user_id[j].charAt(k)) {
                            isOk = false;
                            break;
                        }
                    }

                    if(isOk) {
                        map.get(banned_id[i]).add(user_id[j]);
                    }
                }
                usedMap.put(banned_id[i], 0);
            }

            isUsed = new boolean[user_id.length];
            arr = new int[banned_id.length];
            solve(0);


            return answer;
        }

        public void solve(int depth) {
            // System.out.println("depth = " + depth + " arr = " + Arrays.toString(arr));
            if(depth == bannedId.length) {
                int[] arr2 = arr.clone();
                Arrays.sort(arr2);
                String s = Arrays.toString(arr2);

                if(!results.contains(s)) {
                    // System.out.println(s);
                    results.add(s);
                    answer++;
                }
                return;
            }

            List<String> userArr = map.get(bannedId[depth]);

            for(String user: userArr) {
                int idx = userIdxMap.get(user);
                if(isUsed[idx]) continue;
                isUsed[idx] = true;
                arr[depth] = idx;

                solve(depth + 1);

                arr[depth] = -1;
                isUsed[idx] = false;
            }
        }

    }

}
