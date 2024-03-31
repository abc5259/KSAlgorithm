package BOJ.JaeIk.practice.baekjoon;

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

class BOJ_1074
{
    static int n, r, c;
    static int answer = 0;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, n);
        solve(0, 0, size);
    }

    static void solve(int row, int col, int size) {
        if(size == 1) {
            System.out.println(answer);
            return;
        }

        //area1
        int newSize = size/2;
        if(r<row+newSize && c<col+newSize) {
            solve(row, col, newSize);
        }
        //area2
        if(r<row+newSize && c>=col+newSize) {
            answer += (size*size)/4;
            solve(row, col+newSize, newSize);
        }
        //area3
        if(r>=row+newSize && c<col+newSize) {
            answer += ((size*size)/4)*2;
            solve(row+newSize, col, newSize);
        }
        //area4
        if(r>=row+newSize && c>=col+newSize) {
            answer += ((size*size)/4)*3;
            solve(row+newSize, col+newSize, newSize);
        }
    }
}
