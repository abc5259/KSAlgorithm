package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
    static int[] dx = {0, 1, 0, -1}; // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는
    static int[] dy = {1, 0, -1, 0};
    static int N,M;
    static int[][] arr;
    static int[][] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0; i<R; i++) rotate();

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    static void rotate() {

        for(int t=0; t<Math.min(N,M)/2; t++) { // 회전 시킬 그룹의 갯수 구하기
            int x = t;
            int y = t;

            int temp = arr[x][y]; // 마지막에 넣을 값 미리 빼놓음

            int idx = 0; // 우, 하, 좌, 상 방향으로 이동하며 반시계 방향으로 값 넣을 인덱스
            while(idx < 4) { // 왼쪽으로 넣는, 위로 넣는, 오른쪽으로 넣는, 아래로 넣는 연산을 차례로 수행
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                // 범위 안이라면
                if(nx < N-t && ny < M-t && nx >= t && ny >= t) {
                    arr[x][y] = arr[nx][ny];
                    x = nx;
                    y = ny;
                }
                // 범위를 벗어났다면 다음 방향으로 어감
                else {
                    idx++;
                }

            }

            arr[t+1][t] = temp; // 빼 놓은 값 넣어 줌
        }

    }
}
