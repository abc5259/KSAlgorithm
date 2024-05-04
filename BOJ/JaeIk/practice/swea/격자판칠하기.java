package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 격자판칠하기 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            char[][] map = new char[n][m];
            for(int i=0; i<n; i++){
                String input = br.readLine();

                for(int j=0; j<m; j++){
                    map[i][j] = input.charAt(j);
                }
            }

            boolean flag = true;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j] != '?'){
                        flag = bfs(map, n, m, i, j);
                        break;
                    }
                }
            }

            String result = (flag)? "possible": "impossible";

            System.out.println("#"+(tc+1)+" "+result);
        }
    }

    static boolean bfs(char[][] map, int n, int m, int row, int col){
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];
            char nowPattern = map[nowRow][nowCol];
            char possible = ' ';
            if(nowPattern == '#')possible = '.';
            else if(nowPattern == '.')possible = '#';

            for(int i=0; i<4; i++){
                //다음 칸 인덱스
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=n || nextCol>=m)continue;
                if(visited[nextRow][nextCol])continue;

                //다음 칸 문양
                int nextPattern = map[nextRow][nextCol];

                //현재와 다음이 같으면 끝
                if(nowPattern==nextPattern)return false;
                //다음 패턴이 옳으면 지나감
                if(nextPattern==possible) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[] {nextRow, nextCol});
                    continue;
                }
                //다음 패턴이 미지정 이면 지정함
                if(nextPattern == '?'){
                    map[nextRow][nextCol] = possible;
                }

                visited[nextRow][nextCol] = true;
                queue.add(new int[] {nextRow, nextCol});
            }
        }
        return true;
    }
}
