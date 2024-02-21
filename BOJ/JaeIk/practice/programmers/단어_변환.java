package BOJ.JaeIk.practice.programmers;

import java.util.*;

class 단어_변환 {
    static boolean[] visited;
    static int answer;

    public int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        bfs(begin, target, words);

        return answer;
    }

    static void bfs(String begin, String target, String[] words){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(begin, 0));

        while(!queue.isEmpty()){
            Pair current = queue.poll();
            String currentStr = current.str;
            int currentNum = current.num;

            if(currentStr.equals(target)){
                answer = currentNum;
                return;
            }

            for(int i=0; i<words.length; i++){
                if(visited[i])continue;

                int count = 0;
                for(int j=0; j<currentStr.length(); j++){
                    if(currentStr.charAt(j)==words[i].charAt(j)){
                        count++;
                    }
                }

                if(count==currentStr.length()-1){
                    visited[i] = true;
                    queue.add(new Pair(words[i], currentNum+1));
                }

            }
        }
    }
}

class Pair{
    String str;
    int num;

    Pair(String str, int num){
        this.str = str;
        this.num = num;
    }
}
