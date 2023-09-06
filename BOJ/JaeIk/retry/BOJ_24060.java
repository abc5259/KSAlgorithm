package BOJ.JaeIk.retry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24060 {
    static int num;
    static int[] temp;
    static int count = 0;
    static int K;
    static int result = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] arr = new int[num];

        temp = new int[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < num ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, 0, arr.length - 1);
        System.out.print(result);

    }

    static void mergeSort(int A[], int low, int high){

        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(A, low, mid);
            mergeSort(A, mid + 1, high);
            merge(A, low, mid, high);
        }
    }

    static void merge(int A[], int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        int t = 0;


        while(i <= mid && j <= high){
            if(A[i] <= A[j]){
                temp[t++] = A[i++];
            }else{
                temp[t++] = A[j++];
            }
        }

        while(i <= mid){
            temp[t++] = A[i++];
        }

        while(j <= high){
            temp[t++] = A[j++];
        }

        t = 0;
        i = low;

        while(i <= high){
            count++;
            if(count==K){
                result = temp[t];
                break;
            }
            A[i++] = temp[t++];
        }
    }
}
