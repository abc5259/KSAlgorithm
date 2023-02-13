package BOJ.GiSeok.Java;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] weights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            weights[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(weights);

        int sum = 1;
        for (int i = 0; i < N; i++) {
            if (weights[i] > sum)
                break;
            sum += weights[i];
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }
}
