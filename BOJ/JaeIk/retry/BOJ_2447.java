package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2447 {
    static StringBuilder sb = new StringBuilder();
    static char[][] map;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = '*';
            }
        }

        recur(0,0,n,false);


        //왜 string builder를 쓰지않고 배열 그대로 출력하면 시간초과 생기는지?
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                sb.append(map[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void recur(int x, int y, int n, boolean isBlank){
        if(isBlank){
            for(int i=x; i<x+n; i++){
                for(int j=y; j<y+n; j++){
                    map[i][j] = ' ';
                }
            }
            return;
        }

        if(n == 1){
            map[x][y] = '*';
            return;
        }

        int count=0;
        int size = n/3;
        //size 만큼 좌표가 이동되어야한다!
        for(int i=x; i<x+n; i+=size){
            for(int j=y; j<y+n; j+=size){
                count++;
                if(count == 5){
                    recur(i,j,size,true);
                }
                else {
                    recur(i,j,size,false);
                }
            }
        }
    }
}
