//package BOJ.JaeIk;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class BOJ_16926 {
//    static int n,m,r;
//    static int arr[][];
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//        r = Integer.parseInt(st.nextToken());
//        arr = new int[n][m];
//
//        for(int i=0; i<n; i++){
//            st = new StringTokenizer(br.readLine());
//            for(int j=0; j<m ;j++){
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//    }
//
//    static void rotateRTime(int r){
//        int count = (n+m)/2;
//
//        for(int i=0; i<r; i++){
//            for(int j=0; j<count; j++){
//                int temp = arr[j][j];
//
//                for(int k=j+1; k<n-j; k++){
//                    arr[j][k-1] = arr[j][k];
//                }
//
//                for(int k=j+1; k<m-j; k++){
//                    arr[k-1][m-1-j] = arr[k][m-1-j];
//                }
//
//                for(int k=m-j; k>j+1; k--){
//                    arr[]
//                }
//            }
//        }
//    }
//}
