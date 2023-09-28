import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N == K) {
            System.out.println(0);
        }else {
            int L = 1;
            ArrayList<Integer> arr = new ArrayList<>();
            while (N > 1) {

                int nextN = N / 2;
                int rest = N % 2;
                if(rest > 0)
                    arr.add(L);
                N = nextN;
                L*=2;
            }
            if(N == 1) {
                arr.add(L);
                N = 0;
            }


            int add = 0;
            if(arr.size() > K) {
                boolean isOk = false;
                for(int i=0; i<arr.size()-1; i++) {
                    add = add + arr.get(i+1) - arr.get(i);
                    arr.set(i+1, arr.get(i+1) * 2);
                    if(arr.size() - (i+1) + N <= K) {
                        if(arr.size() - (i+1) + N == K)
                            isOk = true;
                        break;
                    }
                }
                System.out.println(isOk ? add : -1);
            }else {
                System.out.println(0);
            }
        }
    }
}
