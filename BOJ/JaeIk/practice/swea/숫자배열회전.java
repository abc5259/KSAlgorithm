package BOJ.JaeIk.practice.swea;

import java.util.*;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;


class 숫자배열회전
{
    static BufferedReader br;
    public static void main(String args[]) throws Exception
    {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int size = Integer.parseInt(br.readLine());
            int[][] arr = initArr(size);

            int[][] rotated90 = rotate(arr);
            int[][] rotated180 = rotate(rotated90);
            int[][] rotated270 = rotate(rotated180);

            System.out.println("#"+(tc+1)+" ");

            for(int i=0; i<size; i++) {
                for(int j=0; j<size; j++) {
                    System.out.print(rotated90[i][j]);
                }
                System.out.print(" ");

                for(int j=0; j<size; j++) {
                    System.out.print(rotated180[i][j]);
                }
                System.out.print(" ");

                for(int j=0; j<size; j++) {
                    System.out.print(rotated270[i][j]);
                }
                System.out.println();
            }

        }

    }

    static int[][] rotate(int[][] arr){
        int[][] rotated = new int[arr.length][arr.length];

        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length; j++) {
                rotated[i][j] = arr[arr.length-1-j][i];
            }
        }

        return rotated;
    }


    static int[][] initArr(int size) throws IOException {
        int[][] arr = new int[size][size];

        for(int i=0; i<size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        return arr;
    }
}

