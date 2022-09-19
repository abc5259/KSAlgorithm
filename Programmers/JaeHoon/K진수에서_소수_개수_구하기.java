package Programmers.JaeHoon;

public class K진수에서_소수_개수_구하기 {
  class Solution {
    public int solution(int n, int k) {
        StringBuffer sb = new StringBuffer();
        while(n % k != n) {
            sb.append(n % k);
            n /= k;
        }
        sb.append(n);
        String[] arr = sb.reverse().toString().replaceAll("0+"," ").split(" ");
        
        System.out.println(sb);
        int answer = 0;
        
        for(String s: arr) {
          
          if(isPrime(Long.parseLong(s)))    
            answer++;
        }
        return answer;
    }
    public boolean isPrime(long n) {
        if(n == 1) return false;
        for(int i=2; i<=(int)Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
}
