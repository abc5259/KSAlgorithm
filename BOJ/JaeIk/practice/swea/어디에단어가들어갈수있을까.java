package BOJ.JaeIk.practice.swea;

import java.util.Scanner;

class Solution
{
    static Scanner sc;
    public static void main(String args[]) throws Exception
    {
        sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc=0; tc<T; tc++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            //map 초기화
            int[][] map = initMap(n);

            //map 탐색
            int answer = exploreWidth(map, n, m) + exploreLength(map, n, m);

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static int exploreWidth(int[][] map, int n, int m){
        int count = 0;
        int totalCount = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    count++;
                }
                else if(count>0 && map[i][j]==0){
                    if(count==m){
                        totalCount++;
                    }
                    count=0;
                }
            }
            if(count==m){
                totalCount++;
            }
            count=0;
        }

        return totalCount;
    }

    static int exploreLength(int[][] map, int n, int m){
        int count = 0;
        int totalCount = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[j][i] == 1){
                    count++;
                }
                else if(count>0 && map[j][i]==0){
                    if(count==m){
                        totalCount++;
                    }
                    count=0;
                }
            }
            if(count==m){
                totalCount++;
            }
            count=0;
        }
        return totalCount;
    }

    static int[][] initMap(int n){
        int[][] map = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }
        return map;
    }
}