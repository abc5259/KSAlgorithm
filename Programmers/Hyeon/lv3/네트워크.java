package Programmers.Hyeon.lv3;

public class 네트워크 {
    class Solution {
        int n;
        boolean[] visit;
        int[][] computers;

        public int solution(int n, int[][] computers) {
            visit = new boolean[n];
            this.computers = computers;
            this.n = n;

            int answer = 0;

            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    answer++;
                    dfs(i);
                }
            }
            return answer;
        }

        void dfs(int num) {
            visit[num] = true;

            for (int i = 0; i < n; i++) {
                if (computers[num][i] == 1 && !visit[i]) {
                    dfs(i);
                }
            }
        }
    }
}
// lv3 네트워크 DFS
// 30분
// 일단 고려해야되는 점이 모든 컴퓨터를 다 탐색하는 거였다 완전 탐색 결이었고
// 그래서 컴퓨터를 내가 주어진 2차원만 보고 좌표평면으로 이동한다 생각했다 사실 그래프의 번호로 이동하는건데
// trouble shooting
// 그래서 내가 4방향 탐색으로 좌표로 움직였는데 그게 아니었고
// 사실 컴퓨터가 DFS 를 타고 내려가서 어느 컴퓨터까지 방문이 되냐만 궁금하기에
// visit 을 1차원으로만 써도됐다 사실상 넘겨주는 값은 현재의 컴퓨터 번호일 뿐
// 그래서 dfs 들어가기전에 횟수를 올려주고 방문여부 체크하고 해당 컴퓨터의 배열을 반복해서
// 연결되어있고 방문 안한 컴퓨터를 탐색하고자 한다
// 기저사례가 없어 헷갈렸던 문제이고
// 사실상 섬의 개수 처럼 BFS로도 풀 수 있을 거 같다.