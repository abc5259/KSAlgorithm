package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 최대상금2트 {
    static int max;
    static String info;
    static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            info = st.nextToken();
            num = Integer.parseInt(st.nextToken());

            max = 0;
            if(num>info.length()){
                num = info.length();
            }
            dfs(info, 0);

            System.out.println("#"+(tc+1)+" "+max);
        }
    }

    static void dfs(String changed, int depth){
        if(depth == num) {
            max = Math.max(intArrToInteger(changed), max);
            return;
        }

        for(int i=0; i<changed.length()-1; i++){
            for(int j=i+1; j<changed.length(); j++){
                String changedStr = change(i, j, changed);
                dfs(changedStr, depth+1);
            }
        }
    }

    static int[] strToIntArr(String str){
        int[] changedArr = new int[str.length()];
        for(int k=0; k<changedArr.length; k++){
            changedArr[k] = Character.getNumericValue(str.charAt(k));
        }

        return changedArr;
    }

    static int intArrToInteger(String arr){
        int[] changedArr = strToIntArr(arr);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<arr.length(); i++){
            sb.append(changedArr[i]);
        }

        return Integer.valueOf(sb.toString());
    }

    static String change(int i, int j, String change){
        int[] changedArr = strToIntArr(change);

        int temp = changedArr[i];
        changedArr[i] = changedArr[j];
        changedArr[j] = temp;

        StringBuilder sb = new StringBuilder();
        for(int k=0; k<change.length(); k++){
            sb.append(changedArr[k]);
        }
        return sb.toString();
    }
}
