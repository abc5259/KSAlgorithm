package BOJ.JaeIk.practice.swea;

import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class 숫자를정렬하자 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int tc=0; tc<T; tc++) {
            int size = sc.nextInt();

            int[] arr = new int[size];
            for(int i=0; i<size; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            System.out.print("#"+(tc+1)+" ");
            for(int i=0; i<size; i++) {
                System.out.print(arr[i]+" ");
            }
        }
    }
}
