package BOJ.JaeIk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1644 {
    static int n;
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        getPrime(n);

        int l=0, r=0;
        int ans=0, sum=2;

        while(l< prime.size() && r< prime.size()){
            if(sum == n){
                ans++;
                sum -= prime.get(l);
                l++;
            }
            else if(sum>n){
                sum -= prime.get(l);
                l++;
            }
            else{
                r++;
                if(r>= prime.size())break;
                sum+=prime.get(r);

            }
        }
        System.out.println(ans);
    }

    static void getPrime(int n) {
        int temp[] = new int[n+1];
        int rootN = (int)Math.sqrt(n);
        for(int i=2; i<=n; i++) {
            temp[i] = i;
        }
        for(int i=2; i<=rootN; i++) {
            if(temp[i] != 0 ) {
                for(int j=i+i; j<=n; j+=i) {
                    temp[j] = 0;
                }
            }
        }
        for(int i=2; i<=n; i++) {
            if(temp[i] != 0) {
                //System.out.println(temp[i]); 디버깅용
                prime.add(temp[i]);
            }
        }
    }
}
