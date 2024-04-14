package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자조작 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            String n = br.readLine();
            arr = new int[n.length()];
            for(int i=0; i<arr.length; i++){
                arr[i] = Character.getNumericValue(n.charAt(i));
            }

            int[] answer = compare();

            System.out.println("#"+(tc+1)+" "+answer[0]+" "+answer[1]);
        }
    }

    static int[] compare(){
        int min = changToInteger(arr);
        int max = changToInteger(arr);
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){

                if(i==0 && arr[j]==0)continue;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                int changed = changToInteger(arr);
                min = Math.min(min, changed);
                max = Math.max(max, changed);

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        return new int[] {min, max};
    }

    static int changToInteger(int[] arr){
        StringBuilder strNum = new StringBuilder();

        for(int i=0; i<arr.length; i++){
            strNum.append(arr[i]);
        }

        return Integer.parseInt(strNum.toString());
    }
}
