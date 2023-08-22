package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ_16926 {
    static int[] rotated;
    static int[] c;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        arr = new int[n][m];


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotate(0, n, m, r);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void rotate(int k, int n, int m, int r){

        for(int i=0; i<Math.min(n,m)/2; i++){
            int[] chain = getchain(k, n-k*2, m-k*2, arr);
            int pos = chain.length - r%chain.length -1;

            rotated = new int[chain.length];
            int[] rot1 = Arrays.copyOfRange(chain, 0, pos+1);
            int[] rot2 = Arrays.copyOfRange(chain, pos+1, chain.length);
            System.arraycopy(rot2, 0, rotated, 0, rot2.length);
            System.arraycopy(rot1, 0, rotated, rot2.length, rot1.length);

            putchain(k,n-k*2,m-k*2,arr, rotated);

            k++;
        }
    }

    static int[] getchain(int k, int n, int m, int[][] arr){
        c = new int[2*(n+m-2)];

        int row = k, col = k, x=0;

        for(int i=0; i<n-1; i++){
            c[x] = arr[row][col];
            x++;
            if(i<n-1)row++;
        }
        for(int i=0; i<m-1; i++){
            c[x] = arr[row][col];
            x++;
            if(i<m-1)col++;
        }
        for(int i=0; i<n-1; i++){
            c[x] = arr[row][col];
            x++;
            if(i<n-1)row--;
        }
        for(int i=0; i<m-1; i++){
            c[x] = arr[row][col];
            x++;
            if(i<m-1)col--;
        }

        return c;
    }

    static int[][] putchain(int k, int n, int m, int[][] arr, int[] rotated){
        int row = k, col = k, x=0;

        for(int i=0; i<n-1; i++){
            arr[row][col] = rotated[x];
            x++;
            if(i<n-1)row++;
        }
        for(int i=0; i<m-1; i++){
            arr[row][col] = rotated[x];
            x++;
            if(i<m-1)col++;
        }
        for(int i=0; i<n-1; i++){
            arr[row][col] = rotated[x];
            x++;
            if(i<n-1)row--;
        }
        for(int i=0; i<m-1; i++){
            arr[row][col] = rotated[x];
            x++;
            if(i<m-1)col--;
        }

        return arr;
    }
}
