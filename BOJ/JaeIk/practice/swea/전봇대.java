package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 전봇대 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            int[][] arr = new int[n][2];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                arr[i][0] = start;
                arr[i][1] = end;
            }

            int count = 0;
            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    int[] pole1 = arr[i];
                    int[] pole2 = arr[j];

                    if(pole1[0]<pole2[0] && pole2[1]<pole1[1]){
                        count++;
                        continue;
                    }
                    if(pole1[0]>pole2[0] && pole2[1]>pole1[1]){
                        count++;
                        continue;
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+count);
        }
    }
}
