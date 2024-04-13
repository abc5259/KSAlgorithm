package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 교환학생 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            int[] week = new int[7];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<7; i++){
                week[i] = Integer.parseInt(st.nextToken());
            }

            int min = Integer.MAX_VALUE;
            for(int i=0; i<7; i++){
                if(week[i] == 1){
                    int startDate = i;
                    int count = 0;

                    while(true){
                        if(week[startDate++%7] == 1){
                            count++;
                        }

                        if(count == n){
                            min = Math.min(min, startDate-i);
                            break;
                        }
                    }
                }
            }


            System.out.println("#"+(tc+1)+" "+min);
        }
    }
}
