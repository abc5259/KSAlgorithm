package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        boolean[] prime = new boolean[N+1];
        prime[0] = prime[1] = true;
        for(int i=2; i*i<=N; i++){
            if(!prime[i]) for(int j=i*i; j<=N; j+=i) prime[j]=true;
        }
        for(int i=1; i<=N;i++){
            if(!prime[i]) arr.add(i);
        }

        if(arr.size() > 0) {
            int l = 0;
            int r = 0;
            int sum = arr.get(0);
            int answer = 0;
            while (l <= r) {
                if(sum >= N) {
                    if(sum == N) answer++;
                    sum -= arr.get(l);
                    l++;
                }else {
                    r++;
                    if(r >= arr.size()) break;
                    sum += arr.get(r);
                }
            }
            System.out.println(answer);
        }else {
            System.out.println(0);
        }
    }
}
