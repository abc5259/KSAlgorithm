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

class 회문1
{
    static char[][] map;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++) {
            int p_size = Integer.parseInt(br.readLine());
            map = new char[8][8];
            for(int i=0; i<8; i++) {
                String inputLine = br.readLine();

                for(int j=0; j<8; j++) {
                    map[i][j] = inputLine.charAt(j);
                }
            }

            System.out.println("#"+(tc+1)+" "+getAnswer(p_size));
        }
    }

    static int getAnswer(int p_size) {
        boolean flag;
        int answer=0;

        for(int i=0; i<8; i++) {
            for(int j=0; j<8-p_size+1; j++) {

                //가로 탐색
                flag = true;
                for(int k=0; k<p_size/2; k++) {
                    if(map[i][j+k] != map[i][j+p_size-1-k]) {
                        flag=false;
                    }
                }
                if(flag)answer++;

                //세로 탐색
                flag = true;
                for(int k=0; k<p_size/2; k++) {
                    if(map[j+k][i] != map[j+p_size-1-k][i]) {
                        flag=false;
                    }

                }
                if(flag)answer++;
            }
        }

        return answer;
    }
}