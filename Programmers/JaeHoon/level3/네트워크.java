package Programmers.JaeHoon.level3;

public class 네트워크 {
  class Solution {
    boolean[] visited;
    int n;
    int[][] computers;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        this.computers = computers;
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            answer++;
            dfs(i);
        }
        return answer;
    }
    
    public void dfs(int curr) {
        visited[curr] = true;
        
        for(int i=0; i<computers[curr].length; i++) {
            if(computers[curr][i] == 0 || visited[i]) continue;
            dfs(i);
        }
    }
  }
}
