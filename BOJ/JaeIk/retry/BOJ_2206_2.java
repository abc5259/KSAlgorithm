package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206_2 {
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    static int[][] map;
    static boolean[][][] visited;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m][2];

        map = new int[n][m];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j=0; j<m; j++){
                char character = line.charAt(j);
                int digitValue = Character.getNumericValue(character);
                map[i][j] = digitValue;
            }
        }

        bfs();

    }

    static void bfs(){
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(0,0,1,false));
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            Location current = queue.poll();

            if (current.row == n - 1 && current.col == m - 1) {
                System.out.println(current.sequence);
                return;
            }

            for(int i=0; i<4; i++){
                int nextRow = current.row + dr[i];
                int nextCol = current.col + dc[i];

                if(nextRow<0 || nextRow>=n || nextCol<0 || nextCol>=m)continue;

                //벽일 때
                if(map[nextRow][nextCol] == 0){
                    if(!current.isDestroyed){
                        queue.offer(new Location(nextRow, nextCol, current.sequence+1, true));
                        visited[nextRow][nextCol][1] = true;
                    }
                }

                //벽이 아닐 때
                if(map[nextRow][nextCol] == 1){
                    //부순 적 없는 경우
                    if(!current.isDestroyed && ! visited[nextRow][nextCol][0]){
                        queue.offer(new Location(nextRow, nextCol, current.sequence+1, false));
                        visited[nextRow][nextCol][0] = true;
                    }
                    //부순 적 있는 경우
                    if(current.isDestroyed && ! visited[nextRow][nextCol][0]){
                        queue.offer(new Location(nextRow, nextCol, current.sequence+1, true));
                        visited[nextRow][nextCol][0] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}

class Location{
    int row;
    int col;
    int sequence;
    boolean isDestroyed;

    Location(int row, int col, int sequence, boolean isDestroyed){
        this.row = row;
        this.col = col;
        this.sequence = sequence;
        this.isDestroyed = isDestroyed;
    }
}
