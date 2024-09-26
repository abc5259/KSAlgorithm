package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17822 {
    static int N,M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for(int i=1; x*i <= N; i++) {
                int n = x*i;
                rotate(n, d, k);
            }
            remove();
        }
        int sum = 0;
        for(int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }

    static void rotate(int n, int d, int k) {
        if(d == 0) { //시계방향
            int[] arr = new int[M+1];
            for(int i=1; i<=M; i++) {
                int next = (i + k) % (M+1);
                if(i + k >= M+1) next++;
                arr[next] = map[n][i];
            }
            map[n] = arr;
        }
        else { //반시계
            int[] arr = new int[M+1];
            for(int i=1; i<=M; i++) {
                int next = i - k;
                if(next <= 0) {
                    next = M + next;
                }
                arr[next] = map[n][i];
            }
            map[n] = arr;
        }
    }
    static void remove() {
        boolean isRemoved = false;

        int sum = 0;
        int cnt = 0;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=M; j++) {
                if(map[i][j] == 0) continue;

                if(bfs(i, j)) {
                    isRemoved = true;
                }
            }
        }

        if(!isRemoved) {
            for(int j=1; j<=M; j++) {
                for(int i=1; i<=N; i++) {
                    sum += map[i][j];
                    if(map[i][j] > 0) cnt++;
                }
            }
            double avg = (double) sum / cnt;

            for(int j=1; j<=M; j++) {
                for(int i=1; i<=N; i++) {
                    if(map[i][j] == 0) continue;
                    if(map[i][j] > avg) map[i][j] -= 1;
                    else if(map[i][j] < avg) map[i][j] += 1;
                }
            }
        }
    }

    static boolean bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        boolean[][] isVisited = new boolean[N+1][M+1];
        isVisited[row][col] = true;

        Queue<int[]> removeQ = new LinkedList<>();
        removeQ.add(new int[]{row, col});

        while(!q.isEmpty()) {
            int[] curr = q.poll();

            int preCol = curr[1] - 1 >= 1 ? curr[1] - 1 : M;
            int nextCol = curr[1] + 1 <= M ? curr[1] + 1 : 1;
            if(!isVisited[curr[0]][preCol] && map[curr[0]][curr[1]] == map[curr[0]][preCol]) {
                isVisited[curr[0]][preCol] = true;
                removeQ.offer(new int[]{curr[0], preCol});
                q.offer(new int[]{curr[0], preCol});
            }
            if(!isVisited[curr[0]][nextCol] && map[curr[0]][curr[1]] == map[curr[0]][nextCol]) {
                isVisited[curr[0]][nextCol] = true;
                removeQ.offer(new int[]{curr[0], nextCol});
                q.offer(new int[]{curr[0], nextCol});
            }

            if(curr[0] - 1 >= 1) {
                int next = curr[0] - 1;
                if(!isVisited[next][curr[1]] && map[curr[0]][curr[1]] == map[next][curr[1]]) {
                    isVisited[next][curr[1]] = true;
                    q.offer(new int[]{next, curr[1]});
                    removeQ.offer(new int[]{next, curr[1]});
                }
            }
            if(curr[0] + 1 <= N) {
                int next = curr[0] + 1;
                if(!isVisited[next][curr[1]] && map[curr[0]][curr[1]] == map[next][curr[1]]) {
                    isVisited[next][curr[1]] = true;
                    q.offer(new int[]{next, curr[1]});
                    removeQ.offer(new int[]{next, curr[1]});
                }
            }
        }

        if(removeQ.size() > 1) {
            while(!removeQ.isEmpty()) {
                int[] cur = removeQ.poll();
                map[cur[0]][cur[1]] = 0;
            }
            return true;
        }
        return false;
    }
}

