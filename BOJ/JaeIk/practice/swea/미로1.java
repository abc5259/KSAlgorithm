package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import javax.imageio.IIOException;

public class 미로1 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=0; t<10; t++){
            int tc = Integer.parseInt(br.readLine());
            int[] start = new int[2];
            int[] end = new int[2];

            //map, start, end 초기화
            int[][] map = new int[16][16];
            for(int i=0; i<16; i++){
                String line = br.readLine();

                for(int j=0; j<16; j++){
                    map[i][j] = Character.getNumericValue(line.charAt(j));

                    if(map[i][j] == 2){
                        start[0] = i;
                        start[1] = j;
                    }
                    else if(map[i][j] == 3){
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }

            int result = (bfs(map, start[0], start[1]))?1 :0;

            System.out.println("#"+(tc)+" "+result);

        }
    }

    static boolean bfs(int[][] map, int row, int col){
        boolean flag = false;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[16][16];
        queue.add(new int[] {row, col});
        visited[row][col] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];

            if(map[nowRow][nowCol]==3){
                flag = true;
                break;
            }

            for(int i=0; i<4; i++){
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if(nextRow<0 || nextCol<0 || nextRow>=16 || nextCol>=16)continue;
                if(visited[nextRow][nextCol])continue;
                if(map[nextRow][nextCol] != 1){
                    visited[nextRow][nextCol] = true;
                    queue.add(new int[] {nextRow, nextCol});
                }
            }
        }

        return flag;
    }
}
