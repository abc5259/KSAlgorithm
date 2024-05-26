package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        prime = new boolean[1001];
        makePrime();

        int num = 0;
        for(int i=0; i<arr.length; i++){
            if(!prime[arr[i]])num++;
        }

        System.out.println(num);

    }

    static void makePrime(){
        prime[0] = true;
        prime[1] = true;

        for(int i=2; i<=Math.sqrt(1000); i++){
            if(prime[i])continue;

            for(int j=i*i; j<1001; j+=i){
                prime[j] = true;
            }
        }
    }
}
