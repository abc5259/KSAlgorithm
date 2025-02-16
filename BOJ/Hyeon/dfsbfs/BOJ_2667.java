package BOJ.Hyeon.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2667 {
    static int[][] matrix; // 인접 행렬 선언
    static int N; // 입력값의 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N]; // 인접행렬 개수

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }
        // 입력값으로 초기화

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    cnt = 0;
                    list.add(dfs(i, j));
                }
            }
        }
        // 1일때 dfs에 넣고 cnt로 반환값으로 아파트의 단지수를 만든다.
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (Integer i : list) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
        // 출력문 오름차순 까지
    }

    static ArrayList<Integer> list = new ArrayList<>();
    // 이건 각 아파트의 단지 수 리스트
    static int cnt;
    // 단지수를 세는 정수
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    // 4방 탐색
    static int dfs(int y, int x) {
        matrix[y][x] = 0; // 방문 여부
        cnt++; // 단지수

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && nx < N && ny < N && matrix[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
        return cnt;
    }
}

// S1 단지번호 붙이기 DFS
// 일단 아파트 별로 1을 계속해서 넣기 위해, 그리고 방문여부를 1을 0으로 만드는 것으로 한다.
// 인접한 아파트 단지를 끝까지 탐색하는 DFS를 선정하였고 방문을 다했으면 다시 DFS를 반복문으로 돌려서
// 1인값을 입력받아서 푼다.1일 때는 새로운 아파트로 확인되어 DFS를 가동하고 dfs를 할 때마다 그 아파트 단지의
// 총 아파트 수를 리턴 받게 만든다.
// 아파트의 수는 어레이 리스트의 size로 해결하고 오름차순과 함께 리스트에 저장된 아파트 수를 출력한다.
