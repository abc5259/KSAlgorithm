package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9372 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

            }
            sb.append(N - 1).append("\n");
        }
        System.out.println(sb);
    }
}
// S4 상근이의 여행 신장 트리
// 복습 BFS 로 풀었다가..
// 25분
// 아니 최단거리를 구하라고 해서 bfs 하면서 최단거리를 구하려 했는데
// 문제를 푸니까 모든 국가는 연결되어있다 이는 연결 그래프라는 뜻이고
// 나는 adj 를 쓰면서 퍼져나갈줄 알았는데 그냥 다 연결되어있었다.
// 방문한 나라는 카운트를 안한다했다 이는 bfs 로 방문을 안하는 줄 알았는데 이미 연결된 곳을 또 연결 안한다
// 그래서 맨처음 국가를 제외한 -1 국가를 방문하기 위해 노드를 구한다