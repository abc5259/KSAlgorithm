package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 두문자어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String a = st.nextToken();
            String b = st.nextToken();
            String c = st.nextToken();

            StringBuilder sb = new StringBuilder();

            sb.append(a.substring(0,1).toUpperCase()).append(b.substring(0,1).toUpperCase()).append(c.substring(0,1).toUpperCase());

            System.out.println("#"+(tc+1)+" "+sb);

        }
    }
}
