package BOJ.GiSeok.Java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());
            int[] qdnp = new int[4];

            qdnp[0] = C / 25;
            C %= 25;

            qdnp[1] = C / 10;
            C %= 10;

            qdnp[2] = C / 5;
            C %= 5;

            qdnp[3] = C / 1;

            for (int idx = 0; idx < 4; idx++)
                System.out.print(qdnp[idx] + " ");
            System.out.println();
        }
    }
}
