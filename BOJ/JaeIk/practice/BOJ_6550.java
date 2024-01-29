package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6550 {
    static boolean flag=false;
    static int count=0;
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while((input = br.readLine()) != null){
            flag=false;
            st = new StringTokenizer(input);

            String s = st.nextToken();
            String t = st.nextToken();

            int idx = 0;
            for(int i=0; i<t.length(); i++){
                if(s.charAt(idx)==t.charAt(i)){
                    idx++;
                }
                if(idx==s.length()){
                    flag=true;
                    break;
                }
            }
            String answer = flag?"Yes":"No";
            System.out.println(answer);
        }

    }
}
