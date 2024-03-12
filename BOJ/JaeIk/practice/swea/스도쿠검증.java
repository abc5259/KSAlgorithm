package BOJ.JaeIk.practice.swea;

import java.util.Scanner;
class 스도쿠검증
{
    static Scanner sc;
    public static void main(String args[]) throws Exception
    {
        sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int tc=0; tc<T; tc++){
            int[][] map = initMap();

            System.out.println("#"+(tc+1)+" "+solve(map));
        }
    }


    static int solve(int[][] map){
        //행 검사
        for(int i=0; i<9; i++){
            int[] mapper = new int[10];
            for(int j=0; j<9; j++){
                mapper[map[i][j]-1]++;
            }

            for(int j=0; j<9; j++){
                if(mapper[j] != 1){
                    return 0;
                }
            }
        }

        //열 검사
        for(int i=0; i<9; i++){
            int[] mapper = new int[10];
            for(int j=0; j<9; j++){
                mapper[map[j][i]-1]++;
            }

            for(int j=0; j<9; j++){
                if(mapper[j] != 1){
                    return 0;
                }
            }
        }

        //부분 그리드 검사
        for(int i=0; i<9; i+=3){
            for(int j=0; j<9;j+=3){

                int[] mapper = new int[10];
                for(int k=i; k<i+3; k++){
                    for(int l=j; l<j+3; l++){
                        mapper[map[k][l]-1]++;
                    }
                }

                for(int k=0; k<9; k++){
                    if(mapper[k] != 1){
                        return 0;
                    }
                }
            }
        }

        return 1;
    }

    static int[][] initMap(){
        int[][] map = new int[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                map[i][j] = sc.nextInt();
            }
        }

        return map;
    }
}