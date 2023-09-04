package BOJ.JaeIk;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10870 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        System.out.println(solve(n));

    }

    static int solve(int n){
        if(n==1 || n==2)return 1;

        return solve(n-1) + solve(n-2);
    }
}
