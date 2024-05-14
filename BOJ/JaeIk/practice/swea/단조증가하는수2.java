package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class 단조증가하는수2 {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            n = Integer.parseInt(br.readLine());

            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = -1;
            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    String newNum = String.valueOf(arr[i]*arr[j]);

                    if(check(newNum)){
                        max = Math.max(max, Integer.parseInt(newNum));
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+max);
        }
    }

    static boolean check(String num){
        for(int i=0; i<num.length()-1; i++){
            if(Character.getNumericValue(num.charAt(i)) > Character.getNumericValue(num.charAt(i+1))){
                return false;
            }
        }

        return true;
    }
}
