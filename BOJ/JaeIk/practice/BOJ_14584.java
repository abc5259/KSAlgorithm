package BOJ.JaeIk.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14584 {
    static StringBuilder shifted;
    static String[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String crypt = br.readLine();
        int n = Integer.parseInt(br.readLine());

        input = new String[n];
        for(int i=0; i<n; i++){
            input[i] = br.readLine();
        }

        for(int i=0; i<=25; i++){
            shifted = new StringBuilder();
            for(int j=0; j<crypt.length(); j++){
                shifted.append(shift(crypt.charAt(j), i));
            }


            for(int k=0; k<n; k++){
                if(shifted.toString().contains(input[k])){
                    System.out.println(shifted);
                    return;
                }
            }
        }
    }

    static char shift(char input, int i){
        char shiftedChar = (char)((input-'a'+i) % 26 + 'a');
        return shiftedChar;
    }
}
