package BOJ.JaeIk.practice.swea;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class 회문2
{
    static String[][] map;
    static int SIZE = 100;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++) {
            int number = Integer.parseInt(br.readLine());
            map = new String[SIZE][SIZE];

            for(int i=0; i<SIZE; i++) {
                map[i] = br.readLine().split("");
            }

            System.out.println("#"+number+" "+getAnswer());
        }
    }

    static int getAnswer() {
        int max_length = Integer.MIN_VALUE;
        boolean flag;

        for(int token=1; token<=100; token++) {
            //세로 탐색
            for(int i=0; i<100; i++) {
                for(int j=0; j<100-token+1; j++) {
                    flag = true;

                    for(int k=0; k<token/2; k++) {
                        //j번째 문자에서 token만큼 뒤로 간 후 k만큼 앞으로 온다.
                        if(!map[i][j+k].equals(map[i][j+token-1-k])) {
                            flag=false;
                            break;
                        }
                    }
                    if(flag)max_length = Math.max(max_length, token);
                }
            }

            //가로 탐색
            for(int i=0; i<100; i++) {
                for(int j=0; j<100-token+1; j++) {
                    flag = true;

                    for(int k=0; k<token/2; k++) {
                        if(!map[j+k][i].equals(map[j+token-1-k][i])) {
                            flag=false;
                            break;
                        }
                    }
                    if(flag)max_length = Math.max(max_length, token);
                }
            }
        }

        return max_length;
    }
}