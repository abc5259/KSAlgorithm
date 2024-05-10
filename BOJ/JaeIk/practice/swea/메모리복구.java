package BOJ.JaeIk.practice.swea;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 메모리복구 {
    static int[] origin;
    public static void main(String[] args) throws IOException{
        BufferedReader bReader = new BufferedReader(new java.io.InputStreamReader(System.in));
        int T = Integer.parseInt(bReader.readLine());

        for(int tc=0; tc<T; tc++) {
            char[] input = bReader.readLine().toCharArray();
            int[] arr = new int[input.length];

            for(int i=0; i<input.length; i++) {
                arr[i] = input[i]-'0';
            }

            origin = new int[input.length];
            java.util.Arrays.fill(origin, 0);

            int answer = 0;
            while(true) {
                int sum = 0;

                for(int i=0; i<input.length; i++) {
                    if(arr[i] != origin[i]) {
                        change(i, input.length, arr[i]);
                        break;
                    }else sum++;
                }

                if(sum==input.length)break;

                answer++;
            }

            System.out.println("#"+(tc+1)+" "+answer);
        }

    }

    static void change(int start, int end, int number){
        for(int i=start; i<end; i++) {
            origin[i] = number;
        }
    }
}