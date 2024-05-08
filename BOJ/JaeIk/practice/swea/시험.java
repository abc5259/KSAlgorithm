package BOJ.JaeIk.practice.swea;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 시험 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            p -= 1;

            int[][] result = new int[n][t];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<t; j++) {
                    result[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //참가자 점수
            int[] score = new int[t];
            for(int i=0; i<n; i++) {
                for(int j=0; j<t; j++) {
                    if(result[i][j] == 0) {
                        score[j]++;
                    }
                }
            }

            int[] nums = new int[n];
            int[] grade = new int[n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<t; j++) {
                    if(result[i][j] == 1) {
                        grade[i]+=score[j];
                        nums[i]++;
                    }

                }
            }


            int totalScore = 0;
            int partOne = 0;
            int partTwo = 0;
            int partThree = 0;
            for(int i=0; i<n; i++) {
                if(grade[i]>grade[p])partOne++;
                else if(grade[p]==grade[i] && nums[p]<nums[i])partTwo++;
                else if(grade[p]==grade[i] && nums[p]==nums[i] && i<p)partThree++;
            }


            totalScore = partOne + partTwo + partThree + 1;

            bw.write("#"+(tc+1)+" "+grade[p]+" "+totalScore+"\n");
        }

        bw.flush();
        bw.close();
    }
}