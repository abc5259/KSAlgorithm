package Programmers.JaeHoon;

import java.util.*;
public class 양과_늑대 {

class Solution {
    public int[] Info;
    public int answer = 0;
    public ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
    public void bfs(int idx,int sheep,int wolf,boolean[] visited) {
        if(Info[idx] == 0) sheep++;
        else wolf++;
        
        if(sheep <= wolf) return;
        
        boolean[] newVisited = visited.clone();
        newVisited[idx] = true;
        answer = Math.max(answer,sheep);
        for(int i=0; i<newVisited.length; i++) {
            if(!newVisited[i]) continue;
            for(int next: nodes.get(i)) {
                if(newVisited[next]) continue;
                bfs(next,sheep,wolf,newVisited);
            }
        }
    }
    public int solution(int[] info, int[][] edges) {
        Info = info;
        for(int i=0; i<info.length; i++) {
            nodes.add(new ArrayList<>());
        }
        
        for(int i=0; i<edges.length; i++) {
            nodes.get(edges[i][0]).add(edges[i][1]);
            // nodes.get(edges[i][1]).add(edges[i][0]);
        }
        bfs(0,0,0,new boolean[info.length]);
        return answer;
    }
    
}
}
