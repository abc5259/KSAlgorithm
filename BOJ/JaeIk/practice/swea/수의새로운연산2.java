package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수의새로운연산2 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        map = new int[301][301];
        initMap();

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            int[] pIdx = searchIdx(p);
            int[] qIdx = searchIdx(q);

            int newX = pIdx[0] + qIdx[0];
            int newY = pIdx[1] + qIdx[1];

            int result = map[newX][newY];

            System.out.println("#"+(tc+1)+" "+result);
        }
    }

    static int[] searchIdx(int number){
        int[] idx = new int[2];
        for(int i=1; i<=300; i++){
            for(int j=1; j<=300; j++){
                if(map[i][j] == number){
                    idx[0] = i;
                    idx[1] = j;
                    break;
                }
            }
        }

        return idx;
    }

    static void initMap(){
        for(int i=1; i<=300; i++){
            int x = i;
            for(int j=1; j<=300; j++){
                if(i==1 && j==1){
                    map[i][j]=1;
                    continue;
                }
                else if(i>1 && j==1){
                    map[i][j] = map[i-1][j] + x;
                    continue;
                }

                map[i][j] = map[i][j-1] + x++;
            }
        }
    }
}
