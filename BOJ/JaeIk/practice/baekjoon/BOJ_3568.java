package BOJ.JaeIk.practice.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_3568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        List<String> result = new ArrayList<>();
        for(int i=1; i<input.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(input[0]);

            for(int j=input[i].length()-1; j>=0; j--){
                if(input[i].charAt(j)==',' || input[i].charAt(j)==';')continue;

                if(input[i].charAt(j) == ']'){
                    sb.append("[]");
                    j--;
                    continue;
                }else if(input[i].charAt(j) == '*' || input[i].charAt(j) == '&'){
                    sb.append(input[i].charAt(j));
                }

                if(isEnd(input[i].charAt(j))){
                    sb.append(" ");

                    for(int k=0; k<=j; k++){
                        sb.append(input[i].charAt(k));
                    }
                    sb.append(";");
                    break;
                }
            }

            result.add(sb.toString());
        }

        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    static boolean isEnd(char c){
        return c != '*' && c != '&' && c != '[' && c != ']';
    }
}
