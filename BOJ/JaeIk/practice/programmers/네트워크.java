package BOJ.JaeIk.practice.programmers;

import java.util.*;

class 네트워크 {
    int answer = 0;
    static boolean[]visited;

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for(int i=0; i<n; i++){
            if(visited[i])continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);

            while(!queue.isEmpty()){
                int current = queue.poll();
                visited[current] = true;

                for(int j=0; j<n; j++){
                    if(current!=j && computers[current][j]==1 && !visited[j]){
                        queue.add(j);
                    }
                }
            }
            answer++;
        }

        return answer;
    }
}

