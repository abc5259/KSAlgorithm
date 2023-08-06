package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_14889 {
    private static int n;
    private static int[][] map;
    private static Boolean[] visited;
    private static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new Boolean[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0,0);
        System.out.println(Min);
    }

    private static void combination(int idx, int count){
        if(count == n/2){
            difference();
            return;
        }

        for(int i=idx; i<n; i++){
            if(visited[i] == false){
                visited[i] = true;
                combination(idx+1, count+1);
                visited[i] = false;
            }
        }
    }

    private static void difference(){
        int start = 0;
        int link = 0;

        for(int i=0; i<n-1; i++){
            for(int j=0; j<n; j++){
                //combination에서 visited가 true인 index2개
                //visited가 false인 index 2개를 정해준다
                //그 기준에 따라서 start와 link의 능력치가 정해진다
                if(visited[i]==true&&visited[j]==true){
                    start += map[i][j];
                    start += map[j][i];
                }
                else if(visited[i]==false&&visited[j]==false){
                    link += map[i][j];
                    link += map[j][i];
                }
            }
        }

        int value = Math.abs(start-link);

        if(value!=0){
            System.out.println(value);
        }

        Min = Math.min(value, Min);
    }
}