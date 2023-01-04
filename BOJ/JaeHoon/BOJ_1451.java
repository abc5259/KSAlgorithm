package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1451 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] square = new int[N+1][M+1];

    for(int i=1; i<=N; i++) {
      String s = br.readLine();
      for(int j=1; j<=M; j++) {
        square[i][j] = s.charAt(j-1) - '0';
      }
    }

    long answer = 0;
    for(int i=1; i<=N-2; i++) {
      for(int j=1; j<=N-i-1; j++) {
        long a = 0,b = 0,c = 0;
        for(int row=1; row<=i; row++) {
          for(int col=1; col<=M; col++) {
            a += square[row][col];
          }
        }
        for(int row=i+1; row<=i+j; row++) {
          for(int col=1; col<=M; col++) {
            b += square[row][col];
          }
        }
        for(int row=i+j+1; row<=N; row++) {
          for(int col=1; col<=M; col++) {
            c += square[row][col];
          }
        }
        answer = Math.max(answer, a*b*c);
      }
    }

    for(int i=1; i<=M-2; i++) {
      for(int j=1; j<=M-i-1; j++) {
        long a = 0,b = 0,c = 0;
        for(int col = 1; col <= i; col++) {
          for(int row=1; row<=N; row++) {
            a += square[row][col];
          }
        }
        for(int col = i+1; col <= i+j; col++) {
          for(int row=1; row<=N; row++) {
            b += square[row][col];
          }
        }
        for(int col = i+j+1; col <= M; col++) {
          for(int row=1; row<=N; row++) {
            c += square[row][col];
          }
        }
        answer = Math.max(answer, a*b*c);
      }
    }

    for(int i=1; i<=M-1; i++) {
      for(int k=1; k<=N-1; k++) {
        long a = 0,b = 0,c = 0;
        for(int col=1; col<=i; col++) {
          for(int row=1; row<=N; row++) {
            a += square[row][col];
          }
        }
        for(int col=i+1; col<=M; col++) {
          for(int row=1; row<=k; row++) {
            b += square[row][col];
          }
          for(int row=k+1; row<=N; row++) {
            c += square[row][col];
          }
        }
        answer = Math.max(answer, a*b*c);
      }
    }

    for(int i=1; i<=M-1; i++) {
      for(int k=1; k<=N-1; k++) {
        long a = 0,b = 0,c = 0;
        for(int col=1; col<=i; col++) {
          for(int row=1; row<=k; row++) {
            b += square[row][col];
          }
          for(int row=k+1; row<=N; row++) {
            c += square[row][col];
          }
        }
        for(int col=i+1; col<=M; col++) {
          for(int row=1; row<=N; row++) {
            a += square[row][col];
          }
        }
        answer = Math.max(answer, a*b*c);
      }
    }

    for(int i=1; i<=N-1; i++) {
      for(int k=1; k<=M-1; k++) {
        long a = 0,b = 0,c = 0;
        for(int row=1; row<=i; row++) {
          for(int col=1; col<=M; col++) {
            a += square[row][col];
          }
        }
        for(int row=i+1; row<=N; row++) {
          for(int col=1; col<=k; col++) {
            b += square[row][col];
          }
          for(int col=k+1; col<=M; col++) {
            c += square[row][col];
          }
        }
        answer = Math.max(answer, a*b*c);
      }
    }

    for(int i=1; i<=N-1; i++) {
      for(int k=1; k<=M-1; k++) {
        long a = 0,b = 0,c = 0;
        for(int row=1; row<=i; row++) {
          for(int col=1; col<=k; col++) {
            b += square[row][col];
          }
          for(int col=k+1; col<=M; col++) {
            c += square[row][col];
          }
        }
        for(int row=i+1; row<=N; row++) {
          for(int col=1; col<=M; col++) {
            a += square[row][col];
          }
        }
        answer = Math.max(answer, a*b*c);
      }
    }
    System.out.println(answer);
  }
}
