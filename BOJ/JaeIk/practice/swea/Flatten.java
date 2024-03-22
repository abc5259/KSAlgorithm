package BOJ.JaeIk.practice.swea;


import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Flatten
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int dump = Integer.parseInt(br.readLine());
            int[] box = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<100; i++) {
                box[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println("#"+(test_case)+" "+getAnswer(dump, box));
        }
    }

    static int getAnswer(int dump, int[] box) {
        for(int i=0; i<dump; i++) {
            Arrays.sort(box);
            box[0]++;
            box[99]--;
        }
        Arrays.sort(box);
        return box[99]-box[0];
    }
}