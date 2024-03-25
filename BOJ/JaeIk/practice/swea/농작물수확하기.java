package BOJ.JaeIk.practice.swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 농작물수확하기
{
    static int[][] map;
    static int sum;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            int size = Integer.parseInt(br.readLine());
            map = new int[size][size];
            sum=0;

            for(int i=0; i<size; i++) {
                char[] input = br.readLine().toCharArray();
                for(int j=0; j<size; j++) {
                    map[i][j] = Character.getNumericValue(input[j]);
                    sum += map[i][j];
                }
            }

            System.out.println("#"+(tc+1)+" "+getAnswer(map, sum));
        }
    }

    static int getAnswer(int[][] map, int sum) {
        int size = map.length;

        //sum - 우 상
        for(int i=0; i<=size/2-1; i++) {
            for(int j=size/2-i-1; j>=0; j--) {
                sum -= map[i][j];
            }
        }

        //sum - 좌 상
        for(int i=0; i<=size/2-1; i++) {
            for(int j=size/2+1+i; j<size; j++) {
                sum -= map[i][j];
            }
        }

        //sum - 우 하
        for(int i=size/2+1; i<size; i++) {
            for(int j=i-size/2-1; j>=0; j--) {
                sum -= map[i][j];
            }
        }

        //sum - 좌 하
        for(int i=size-1; i>=size/2+1; i--) {
            for(int j=size/2+(size-i); j<size; j++) {
                sum -= map[i][j];
            }
        }

        return sum;
    }
}