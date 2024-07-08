package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {
    static int[] arr = new int[9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++)
            arr[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(arr);
        permutation(9, 7, 0);
    }

    static void permutation(int n, int r, int depth) {
        if (r == depth) {
            int sum = 0;
            for (int i = 0; i < r; i++)
                sum += arr[i];
            
            if (sum == 100) {
                for (int i = 0; i < r; i++)
                    System.out.println(arr[i]);
                System.exit(0);
            }

            return;
        }

        for (int i = depth; i < n; i++) {
            swap(i, depth);
            permutation(n, r, depth + 1);
            swap(i, depth);
        }
    }

    static void swap(int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
