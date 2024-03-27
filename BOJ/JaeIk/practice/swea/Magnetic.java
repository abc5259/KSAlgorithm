package BOJ.JaeIk.practice.swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Magnetic
{
    static int N = 1;
    static int S = 2;
    static int[][] map;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++) {
            int size = Integer.parseInt(br.readLine());

            map = new int[size][size];
            for(int i=0; i<size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<size; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#"+(tc+1)+" "+getAnswer(size));
        }
    }

    static int getAnswer(int size) {
        int answer=0;

        for(int i=0; i<size; i++) {
            int count = 0;
            for(int j=0; j<size; j++) {
                if(map[j][i] == N) {
                    count = 1;
                }
                if(count==1 && map[j][i] == S) {
                    answer++;
                    count = 0;
                }
            }
        }

        return answer;
    }
}