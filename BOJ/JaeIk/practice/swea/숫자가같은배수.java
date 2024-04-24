package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자가같은배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());
            String origin = String.valueOf(n);

            StringBuilder sb = new StringBuilder();
            sb.append("1");
            for(int i=0; i<origin.length(); i++){
                sb.append("0");
            }
            int hi = Integer.parseInt(sb.toString());

            boolean flag = false;
            int originNum=n;
            int mul = 2;
            while(true){
                int changed = originNum*mul++;

                if(changed >= hi){
                    break;
                }

                if(check(n, changed)){
                    flag = true;
                    break;
                }
            }

            String answer = (flag)?"possible":"impossible";

            System.out.println("#"+(tc+1)+" "+answer);
        }


    }

    static boolean check(int origin, int changed){
        String originStr = String.valueOf(origin);
        int[] arr1 = new int[originStr.length()];
        for(int i=0; i< originStr.length(); i++){
            arr1[i] = originStr.charAt(i);
        }
        Arrays.sort(arr1);

        String changedStr = String.valueOf(changed);
        int[] arr2 = new int[changedStr.length()];
        for(int i=0; i<changedStr.length(); i++){
            arr2[i] = changedStr.charAt(i);
        }
        Arrays.sort(arr2);

        for(int i=0; i< arr1.length; i++){
            if(arr1[i] != arr2[i])return false;
        }

        return true;
    }
}
