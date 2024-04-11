package BOJ.JaeIk.practice.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 정곤이의단조증가하는수 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            int n = Integer.parseInt(br.readLine());

            arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> increases = getIncreases(arr);
            int answer = (increases.isEmpty())?-1:getMax(increases);

            System.out.println("#"+(tc+1)+" "+answer);
        }
    }

    static int getMax(List<Integer> increases){
        int max = Integer.MIN_VALUE;

        for(int number : increases){
            if(number>max)max=number;
        }

        return max;
    }

    static List<Integer> getIncreases(int[] arr){
        List<String> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        //곱한 결과 배열 초기화
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                list.add(String.valueOf(arr[i]*arr[j]));
            }
        }

        //단조 증가수 리스트 초기화
        for(int i=0; i<list.size(); i++){
            char[] number = list.get(i).toCharArray();

            boolean increase = false;
            for(int j=0; j<number.length-1; j++){
                int nowDigit = Character.getNumericValue(number[j]);
                int nextDigit = Character.getNumericValue(number[j+1]);

                if(nowDigit <= nextDigit)increase=true;
                else {
                    increase=false;
                    break;
                }
            }

            if(increase){
                result.add(Integer.parseInt(list.get(i)));
            }
        }

        return result;
    }
}
