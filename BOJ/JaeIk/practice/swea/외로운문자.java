package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 외로운문자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            String input = br.readLine();
            char[] arr = input.toCharArray();

            for(int i=0; i<arr.length-1; i++){
                for(int j=i+1; j<arr.length; j++){
                    if(arr[i]=='0')continue;
                    if(arr[i]==arr[j]){
                        arr[i]='0';
                        arr[j]='0';
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            List<Character> list = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                if(arr[i] != '0'){
                    list.add(arr[i]);
                }
            }
            Collections.sort(list);

            if(!list.isEmpty()){
                for(int i=0; i<list.size(); i++){
                    sb.append(list.get(i));
                }
            }

            String result = (list.isEmpty())?"Good" :sb.toString();

            System.out.println("#"+(tc+1)+" "+result);
        }
    }
}
