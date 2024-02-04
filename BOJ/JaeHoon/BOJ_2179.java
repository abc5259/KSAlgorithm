package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2179 {
    static int N;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new String[N];

        for(int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }

        int max = 0;

        String answer = arr[0] + "\n" + arr[1];

        for(int i=0; i<N; i++) {
            for(int j=i+1; j<N; j++) {
                String a = arr[i];
                String b = arr[j];

                int cnt = 0;
                int index = 0;

                while (a.length() > index &&
                        b.length() > index &&
                        a.charAt(index) == b.charAt(index)) {
                    cnt++;
                    index++;
                }

                if(max < cnt) {
                    max = cnt;
                    answer = a +"\n" + b;
                }

            }
        }
        System.out.println(answer);
    }
}
