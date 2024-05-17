package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자조작2 {
    static int min;
    static int max;
    static int[] number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            char[] input = br.readLine().toCharArray();

            number = new int[input.length];
            for(int i=0; i<number.length; i++){
                number[i] = Character.getNumericValue(input[i]);
            }

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            update();

            for(int i=0; i<number.length-1; i++){
                for(int j=i+1; j< number.length; j++){
                    if(i==0 && number[j] == 0)continue;
                    process(i, j);
                }
            }

            System.out.println("#"+(tc+1)+" "+min+" "+max);
        }

    }

    static void process(int idx1, int idx2){
        int temp = number[idx1];
        number[idx1] = number[idx2];
        number[idx2] = temp;

        update();

        temp = number[idx1];
        number[idx1] = number[idx2];
        number[idx2] = temp;
    }

    static void update(){
        StringBuilder sb = new StringBuilder();

        for(int i=0; i< number.length; i++){
            sb.append(number[i]);
        }

        max = Math.max(max, Integer.parseInt(sb.toString()));
        min = Math.min(min, Integer.parseInt(sb.toString()));
    }
}
