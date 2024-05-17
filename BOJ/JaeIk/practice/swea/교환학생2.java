package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 교환학생2 {
    static int n;
    static int[] week;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());
            week = new int[7];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<7; i++){
                week[i] = Integer.parseInt(st.nextToken());
            }

            int days = 0;
            int start = 0;
            int min = Integer.MAX_VALUE;
            for(int i=0; i<7; i++){
                if(week[i] == 1){
                    start = i;
                    days = 0;
                    int count = n;

                    while(count>0){
                        if(week[start++ % 7]==1)count--;
                        days++;
                    }

                    min = Math.min(days, min);
                }
            }

            System.out.println("#"+(tc+1)+" "+min);
        }
    }
}
