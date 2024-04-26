package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 직사각형길이찾기 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            arr = new int[101];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<3; i++){
                int idx = Integer.parseInt(st.nextToken());
                arr[idx]++;
            }

            int result = 0;
            for(int i=0; i<101; i++){
                if(arr[i]==1 || arr[i]==3)result = i;
            }

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
