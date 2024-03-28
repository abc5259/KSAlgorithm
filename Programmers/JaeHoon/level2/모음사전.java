package Programmers.JaeHoon.level2;

public class 모음사전 {

    class Solution {
        char[] arr = {'A', 'E', 'I', 'O', 'U'};
        char[] words;
        String search;
        int answer;

        public int solution(String word) {
            answer = 0;
            search = word;
            words = new char[5];
            dfs(0);
            return answer;
        }
        public boolean dfs(int depth) {

            if(depth == search.length())  {
                boolean result = true;
                for(int i=0; i<depth; i++) {
                    if(words[i] != search.charAt(i)) result = false;
                }
                if(result) return true;
            }

            if(depth == 5) {
                return false;
            }

            for(int i=0; i<5; i++) {
                words[depth] = arr[i];
                answer++;
                if(dfs(depth+1)) return true;
            }

            return false;

        }
    }
}
