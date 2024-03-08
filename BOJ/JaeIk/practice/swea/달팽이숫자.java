package BOJ.JaeIk.practice.swea;


import java.util.Scanner;
import java.io.FileInputStream;

class 달팽이숫자
{
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int i=0; i<T; i++){
            int length = sc.nextInt();
            int[][] map = new int[length][length];

            int dir = 0;
            int row = 0;
            int col = 0;

            for(int j=1; j<=length*length; j++){
                map[row][col] = j;

                int nextRow = row + dr[dir];
                int nextCol = col + dc[dir];

                //System.out.println(nextRow+" "+nextCol);


                if(nextRow<0 || nextCol<0 || nextRow>=length || nextCol>=length || map[nextRow][nextCol]!=0){
                    dir = (dir+1)%4;
                    //System.out.println("dir : " + dir);
                }

                row = row+dr[dir];
                col = col+dc[dir];
            }

            System.out.println("#"+(i+1));
            for(int k=0; k<length; k++){
                for(int l=0; l<length; l++){
                    System.out.print(map[k][l]+" ");
                }
                System.out.println();
            }
        }
    }
}
