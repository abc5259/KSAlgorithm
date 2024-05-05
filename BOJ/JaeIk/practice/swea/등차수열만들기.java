package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 등차수열만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int[] arr = new int[3];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            if(arr[1]-arr[0] == arr[2]-arr[1]){
                System.out.println("#"+(tc+1)+" "+0.0);
                continue;
            }

            double a = arr[0];
            double b = arr[1];
            double c = arr[2];

            System.out.println("#"+(tc+1)+" "+Math.abs((c-b)-(b-a))/2.0);
        }
    }
}
