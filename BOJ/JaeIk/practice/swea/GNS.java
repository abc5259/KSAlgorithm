package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.function.BiFunction;

public class GNS {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int length = Integer.parseInt(st.nextToken());

            int[] intArr = new int[length];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<length; i++){
                String num = st.nextToken();
                intArr[i] = strToInt(num);
            }

            Arrays.sort(intArr);

            String[] strArr = new String[length];
            for(int i=0; i<intArr.length; i++){
                strArr[i] = intToStr(intArr[i]);
            }

            System.out.println("#"+(tc+1));
            for(int i=0; i<strArr.length; i++){
                System.out.print(strArr[i]+" ");
            }
            System.out.println();
        }
    }

    static int strToInt(String num){
        if(Objects.equals(num, "ZRO"))return 0;
        if(Objects.equals(num, "ONE"))return 1;
        if(Objects.equals(num, "TWO"))return 2;
        if(Objects.equals(num, "THR"))return 3;
        if(Objects.equals(num, "FOR"))return 4;
        if(Objects.equals(num, "FIV"))return 5;
        if(Objects.equals(num, "SIX"))return 6;
        if(Objects.equals(num, "SVN"))return 7;
        if(Objects.equals(num, "EGT"))return 8;
        if(Objects.equals(num, "NIN"))return 9;

        return 0;
    }

    static String intToStr(int num){
        if(num==0)return "ZRO";
        if(num==1)return "ONE";
        if(num==2)return "TWO";
        if(num==3)return "THR";
        if(num==4)return "FOR";
        if(num==5)return "FIV";
        if(num==6)return "SIX";
        if(num==7)return "SVN";
        if(num==8)return "EGT";
        if(num==9)return "NIN";
        return " ";
    }
}
