package Programmers.GiSeok.lv2;

public class 도넛과_막대그래프 {
    class Solution {
        public int[] solution(int[][] edges) {
            
            int[][] edgeCost = new int[1000001][2];
            
            // 들어오는 정점 1, 나가는 정점 0 == 막대
            // 들어오는 정점 2, 나가는 정점 2 == 8자
            // 들어오는 정점 0, 나가는 정점 >= 2 == key
            for (int[] edge : edges) {
                edgeCost[edge[0]][1] += 1;
                edgeCost[edge[1]][0] += 1;
            }
            
            int[] answer = {0, 0, 0, 0};
            
            for (int v = 1; v < 1000001; v++) {
                if (edgeCost[v][0] == 0 && edgeCost[v][1] >= 2)
                    answer[0] = v;
                else if (edgeCost[v][0] >= 1 && edgeCost[v][1] == 0)
                    answer[2] += 1;
                else if (edgeCost[v][0] >= 2 && edgeCost[v][1] == 2)
                    answer[3] += 1;
            }
            
            answer[1] = (edgeCost[answer[0]][1] - answer[2] - answer[3]);
            
            return answer;
        }
    }
}
