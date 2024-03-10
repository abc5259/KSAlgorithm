package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;

class 파리퇴치
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc=0; tc<T; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] map = new int[n][n];

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    map[i][j] = sc.nextInt();
                }
            }



            int answer = getAnswer(map, n, m);
            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static int getAnswer(int[][] map, int n, int m){
        int size = map.length;

        int max = Integer.MIN_VALUE;
        for(int i=0; i<=n-m; i++){
            for(int j=0; j<=n-m; j++){
                int sum = 0;

                for(int k=0; k<m; k++){
                    for(int l=0; l<m; l++){
                        sum += map[i+k][j+l];
                    }
                }

                if(max < sum)max = sum;
            }
        }

        return max;
    }
}