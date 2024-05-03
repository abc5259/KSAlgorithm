package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 공과잡초 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            String grass = br.readLine();

            int sum = 0;
            for(int i=0; i<grass.length(); i++){
                if(grass.charAt(i)=='(') {
                    if(i+1>=grass.length())continue;
                    if (grass.charAt(i + 1) == ')' || grass.charAt(i + 1) == '|') {
                        sum++;
                    }
                }
                else if(grass.charAt(i)=='|'){
                    if(i+1<grass.length() && grass.charAt(i+1)==')'){
                        sum++;
                    }
                }
            }

            System.out.println("#"+(tc+1)+" "+sum);
        }
    }
}
