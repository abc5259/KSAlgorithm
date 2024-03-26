package BOJ.JaeIk.practice.swea;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class sum
{
    static int[][] map;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++) {
            int case_number = Integer.parseInt(br.readLine());
            map = new int[100][100];

            for(int i=0; i<100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println("#"+(tc+1)+" "+getAnswer());
        }
    }

    static int getAnswer() {
        int max = 0;

        //각 행의 합 비교
        for(int i=0; i<100; i++) {
            int sum = 0;
            for(int j=0; j<100; j++) {
                sum += map[i][j];
            }
            max = Math.max(max, sum);
        }

//		//각 열의 합 비교
        for(int i=0; i<100; i++) {
            int sum = 0;
            for(int j=0; j<100; j++) {
                sum += map[j][i];
            }
            max = Math.max(max, sum);
        }

//		//대각선 비교
        int sum = 0;
        for(int i=0; i<100; i++) {
            sum += map[i][i];
        }
        max = Math.max(max, sum);
//
        sum = 0;
        for(int i=0; i<100; i++) {
            sum += map[i][99-i];
        }
        max = Math.max(max, sum);

        return max;

    }
}
