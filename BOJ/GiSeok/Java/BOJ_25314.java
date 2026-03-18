package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_25314 {

    // int long을 붙일때마다 4바이트씩 증가.
    // 4바이트 long int
    // 8바이트 long long int
    // ... n/4 int

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n/4; i++) {
            System.out.print("long ");
        }
        System.out.println("int");
    }
}
