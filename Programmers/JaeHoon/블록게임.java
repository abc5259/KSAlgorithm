package Programmers.JaeHoon;

public class 블록게임 {
  class Solution {
    public boolean check(int x, int y, int l,int N, int[][] board) {
        if(l == 0) {
            for(int i=0; i<=x; i++) {
                if(board[i][y+1] > 0 || board[i][y+2] > 0)
                    return false;
            }
            
        }
        else if(l == 1) {
            for(int i=0; i<=x+1; i++) {
                if(board[i][y-1] > 0)
                    return false;
            }
        }
        else if(l == 2) {
            for(int i=0; i<=x+1; i++) {
                if(board[i][y+1] > 0)
                    return false;
            }
        }
        else if(l == 3) {
            for(int i=0; i<=x; i++) {
                if(board[i][y-2] > 0 || board[i][y-1] > 0)
                    return false;
            }
        }
        else if(l == 4) {
            for(int i=0; i<=x; i++) {
                if(board[i][y-1] > 0 || board[i][y+1] > 0)
                    return false;
            }
        }
        return true;
    }
    public int solution(int[][] board) {
        int answer = 0;
        
        int[][][] dir = {
            {{1,0},{1,1},{1,2}}, 
            {{1,0},{2,0},{2,-1}},
            {{1,0},{2,0},{2,1}},
            {{1,0},{1,-1},{1,-2}},
            {{1,0},{1,1},{1,-1}}
        };
        
        int N = board.length;
        for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    for(int l=0; l<5; l++) {
                        int sum = 0;
                        int num = board[i][j];
                        for(int k=0; k<3; k++) {
                            int x = i + dir[l][k][0];
                            int y = j + dir[l][k][1];

                            if(x < 0 || x >= N || y < 0 || y >= N || board[x][y] == 0) break;
                            if(num != board[x][y]) break;
                            sum++;
                        }
                        if(sum == 3) {
                            if(check(i,j,l,N,board)) {
                                answer++;
                                System.out.println(board[i][j]);
                                System.out.println("i = " + i + " j = " + j );
                                board[i][j] = 0;
                                for(int d=0; d<3; d++) {
                                    board[i+dir[l][d][0]][j+dir[l][d][1]] = 0;
                                }
                                // isBreakBar= true;
                                break;
                            }
                        }
                    }
                }
            }
        
        return answer;
    }
  }
}
