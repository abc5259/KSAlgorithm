package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1644 {
    static ArrayList<Integer> prime = new ArrayList<>();
    static boolean[] isPrime;
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        isPrime = new boolean[n+1];

        getPrimeNumbers(n);

        int start = 0;
        int end = 0;
        int count = 0;
        while(start<=end && end<= prime.size()-1){
            if(sum==n){
                count++;
            }

            if(sum<n){
                sum += prime.get(end++);
            }

            else{
                sum -= prime.get(start++);
            }
        }

        boolean flag=false;
        for(int i=0; i<prime.size(); i++){
            if(prime.get(i) == n)flag=true;
        }
        int result = (flag) ?count+1 :count;
        System.out.println(result);
    }

    static void getPrimeNumbers(int number){
        isPrime[0] = isPrime[1] = true;

        for(int i=2; i*i<=number; i++){
            if(!isPrime[i]){
                for(int j=i*i; j<=number; j+=i){
                    isPrime[j] = true;
                }
            }
        }

        for(int i=1; i<=number; i++){
            if(!isPrime[i]){
                prime.add(i);
            }
        }
    }
}


