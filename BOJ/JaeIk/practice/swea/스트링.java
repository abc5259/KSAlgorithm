package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class 스트링
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc=0; tc<10; tc++) {
            int number = Integer.parseInt(br.readLine());
            String token = br.readLine();
            String str = br.readLine();

            System.out.println("#"+(tc+1)+" "+getAnswer(token, str));
        }
    }

    static int getAnswer(String token, String str) {
        int count = 0;

        for(int i=0; i<=str.length()-token.length(); i++) {
            if(token.equals(str.substring(i, i+token.length())))count++;
        }

        return count;
    }
}