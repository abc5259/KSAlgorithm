package BOJ.Hyeon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16935 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        while (R-- > 0) {
            change(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void change(String op) {
        int N = arr.length;
        int M = arr[0].length;

        switch (op) {
            case "1":
                int left = 0;
                int right = N - 1;
                while (left < right) {
                    swap(left, right);
                    left++;
                    right--;
                }
                break;
            case "2":
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M / 2; j++) {
                        int tmp = arr[i][j];
                        arr[i][j] = arr[i][M - j - 1];
                        arr[i][M - j - 1] = tmp;
                    }
                }
                break;
            case "3":
                int[][] tmp_3 = new int[M][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        tmp_3[j][N - 1 - i] = arr[i][j];
                    }
                }
                arr = tmp_3;
                break;
            case "4":
                int[][] tmp_4 = new int[M][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        tmp_4[M - 1 - j][i] = arr[i][j];
                    }
                }
                arr = tmp_4;
                break;

            case "5":
                int halfN = N / 2;
                int halfM = M / 2;

                int[][] tmp_5 = new int[halfN][halfM];
                for (int i = 0; i < halfN; i++) {
                    System.arraycopy(arr[i], 0, tmp_5[i], 0, halfM);
                }
                for (int i = 0; i < halfN; i++) {
                    System.arraycopy(arr[i + halfN], 0, arr[i], 0, halfM);
                }
                for (int i = 0; i < halfN; i++) {
                    System.arraycopy(arr[i + halfN], halfM, arr[i + halfN], 0, halfM);
                }
                for (int i = 0; i < halfN; i++) {
                    System.arraycopy(arr[i], halfM, arr[i + halfN], halfM, halfM);
                }
                for (int i = 0; i < halfN; i++) {
                    System.arraycopy(tmp_5[i], 0, arr[i], halfM, halfM);
                }
                break;
            case "6":
                halfN = N / 2;
                halfM = M / 2;

                int[][] tmp_6 = new int[halfN][halfM];
                for (int i = 0; i < halfN; i++) {
                    System.arraycopy(arr[i], 0, tmp_6[i], 0, halfM);
                }
                for (int i = 0; i < halfN; i++) {
                    System.arraycopy(arr[i], halfM, arr[i], 0, halfM);
                }
                for (int i = 0; i < halfN; i++) {
                    System.arraycopy(arr[i + halfN], halfM, arr[i], halfM, halfM);
                }
                for (int i = 0; i < halfN; i++) {
                    System.arraycopy(arr[i + halfN], 0, arr[i + halfN], halfM, halfM);
                }
                for (int i = 0; i < halfN; i++) {
                    System.arraycopy(tmp_6[i], 0, arr[i + halfN], 0, halfM);
                }
                break;
        }
    }

    static void swap(int left, int right) {
//        int[] tmp = new int[arr[left].length];
//        System.arraycopy(arr[left], 0, tmp, 0, arr[left].length);
//        깊은 복사 노노 얕은 복사만 해도됨 원시타입처럼
        int[] tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}

// G5 배열 돌리기 3 브루트포스+ 시뮬레이션
// 와진짜 오래 풀었다 코드길이 개어이없네
// 일단 각 동작마다 그대로 수행하면되고
// switch 구문에서 해당 동작 수행
// 1번연산 그냥 배열 끼리 reverse, 2번 연산 좌우 값 바꾸기 reverse
// 3번연산 4번연산 각도 돌리기인데 임시로 NM바뀐 배열만들어서 돌려가지고 대입하고 앞으로 NM 대신 length 쓰기
// trouble shooting 어레이 아웃오브바운드 NM에서 계속 붙잡혔다가 length 로 탈출
// 5번 6번은 말그대로 반복문 5번반복 1개 저장해서 돌리기 때문에 rotate 개념