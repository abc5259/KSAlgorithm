package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 재미있는오셀로게임2 {
    static int n;
    static int[] dr = {0, 0, 1, -1, -1, 1, 1, -1};
    static int[] dc = {1, -1, 0, 0, -1, -1, 1, 1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            map = new int[n][n];
            initMap(n);

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken())-1;
                int col = Integer.parseInt(st.nextToken())-1;
                int color = Integer.parseInt(st.nextToken());

                map[row][col] = color;

                List<Integer> directionList = getDirection(row, col, color);

                process(directionList, row, col, color);
            }

            int b = 0;
            int w = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(map[i][j] == 1){
                        b++;
                    }
                    if(map[i][j] == 2){
                        w++;
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+b+" "+w);
        }
    }

    static void exploreDirection(int direction, int row, int col, int color){
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {row, col});
        boolean flag = false;
        int diffColor = (color==1)?2:1;

        while(true){
            int nextRow = list.get(list.size()-1)[0] + dr[direction];
            int nextCol = list.get(list.size()-1)[1] + dc[direction];

            if(nextRow<0 || nextCol<0 || nextRow>=n || nextCol>=n || map[nextRow][nextCol]==0)break;
            //if(map[nextRow][nextCol] == 0)continue;
            if(map[nextRow][nextCol] == color){
                flag = true;
                break;
            }

            if(map[nextRow][nextCol]==diffColor){
                list.add(new int[] {nextRow, nextCol});
            }
        }

        if(flag){
            for(int i=1; i<list.size(); i++){
                int getRow = list.get(i)[0];
                int getCol = list.get(i)[1];

                map[getRow][getCol] = color;
            }
        }
    }

    static void process(List<Integer> list, int row, int col, int color){
        for(int i=0; i<list.size(); i++){
            int direction = list.get(i);

            exploreDirection(direction, row, col, color);
        }
    }

    static List<Integer> getDirection(int row, int col, int color){
        int diffColor = (color==1)?2:1;

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<8; i++){
            int nextRow = row+dr[i];
            int nextCol = col+dc[i];

            if(nextRow<0 || nextCol<0 || nextRow>=n || nextCol>=n)continue;

            if(map[nextRow][nextCol] != color){
                list.add(i);
            }
        }

        return list;
    }


    static void initMap(int n){
        map[n/2-1][n/2-1] = 2;
        map[n/2-1][n/2] = 1;
        map[n/2][n/2-1] = 1;
        map[n/2][n/2] = 2;
    }
}
