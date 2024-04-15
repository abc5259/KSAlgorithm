package BOJ.JaeIk.practice.swea;

import java.util.Arrays;

public class 백만이하의모든소수 {
    public static void main(String[] args) {
        int[] arr = new int[1000001];
        Arrays.fill(arr, 1);

        for(int i=2; i<arr.length; i++){
            if(arr[i] == 0)continue;

            for(int j=2*i; j<arr.length; j+=i){
                arr[j] = 0;
            }
        }

        for(int i=2; i<arr.length; i++){
            if(arr[i] != 0){
                System.out.print(i+" ");
            }
        }
    }
}
