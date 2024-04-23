package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.StringTokenizer;

public class 안경이없어 {
    static List<Character> bro1 = new ArrayList<>(Arrays.asList('C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));
    static List<Character> bro2 = new ArrayList<>(Arrays.asList('A', 'D', 'O', 'P', 'Q', 'R'));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str1 = st.nextToken();
            String str2 = st.nextToken();

            if(str1.length() != str2.length()){
                System.out.println("#"+(tc+1)+" "+"DIFF");
                continue;
            }

            int sum = 0;
            for(int i=0; i<str1.length(); i++){
                char c1 = str1.charAt(i);
                char c2 = str2.charAt(i);

                if(isBro1(c1) && isBro1(c2)){
                    sum++;
                } else if (isBro2(c1) && isBro2(c2)) {
                    sum++;
                } else if (isB(c1) && isB(c2)) {
                    sum++;
                }
            }

            String answer = (sum==str1.length())?"SAME":"DIFF";

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static boolean isBro1(char c){
        if(bro1.contains(c))return true;

        return false;
    }

    static boolean isBro2(char c){
        if(bro2.contains(c))return true;

        return false;
    }

    static boolean isB(char c){
        if(c=='B')return true;
        return false;
    }
}
