package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다트게임 {
    static int[] score = {20, 40, 60, 80, 100, 120, 140, 160, 180, 200};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            int total_score = 0;
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                double x = Double.parseDouble(st.nextToken());
                double y = Double.parseDouble(st.nextToken());

                double temp = Math.pow(x,2) + Math.pow(y,2);

                for(int j=0; j<10; j++){
                    double num = Math.sqrt(temp);
                    if(num <= score[j]){
                        int point = 11-(score[j]/20);
                        total_score += point;
                        break;
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+total_score);
        }
    }
}
