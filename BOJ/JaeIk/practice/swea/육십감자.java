package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 육십감자 {
    static String[] names;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String[] arr1 = new String[n];
            String[] arr2 = new String[m];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr1[i] = st.nextToken();
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++){
                arr2[i] = st.nextToken();
            }

            int size = getLCM(n, m);
            names = new String[size];

            List<String> list1 = new ArrayList<>();
            for(int i=0; i<names.length; i+=arr1.length){
                for(int j=0; j<arr1.length; j++){
                    list1.add(i+j, arr1[j]);
                }
            }

            List<String> list2 = new ArrayList<>();
            for(int i=0; i<size; i+=arr2.length){
                for(int j=0; j<arr2.length; j++){
                    list2.add(i+j, arr2[j]);
                }
            }

            for(int i=0; i<size; i++){
                names[i] = list1.get(i)+list2.get(i);
            }


            int Q = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append((tc+1)).append(" ");
            for(int i=0; i<Q; i++){
                int q = Integer.parseInt(br.readLine());

                int idx = (q-1)%size;

                sb.append(names[idx]).append(" ");
            }

            System.out.println(sb);
        }
    }

    static int getLCM(int a, int b){
        int gcd = getGCD(a, b);

        int d1 = a/gcd;
        int d2 = b/gcd;

        return gcd*d1*d2;
    }

    static int getGCD(int a, int b){
        if(b==0)return a;

        return getGCD(b, a%b);
    }
}
