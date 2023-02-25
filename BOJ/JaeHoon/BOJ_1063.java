package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1063 {
  static int[][] map;
  static int kingPosX, kingPosY, stonePosX, stonePosY;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String kingStrPos = st.nextToken();
    String stoneStrPos = st.nextToken();
    int N = Integer.parseInt(st.nextToken());

    map = new int[9][9];
    kingPosX = 9 - (kingStrPos.charAt(1) - '0');
    kingPosY = kingStrPos.charAt(0) - 'A' + 1;

    stonePosX = 9 - (stoneStrPos.charAt(1) - '0');
    stonePosY = stoneStrPos.charAt(0) - 'A' + 1;

    for(int i=0; i<N; i++) {
      String move = br.readLine();
      int[] kingPos = pos(kingPosX, kingPosY, move);
      

      if(stonePosX == kingPos[0] && stonePosY == kingPos[1]) {
        int[] stonePos = pos(stonePosX, stonePosY, move);

        if(stonePos[0] == kingPos[0] && stonePos[1] == kingPos[1]) continue;

        kingPosX = kingPos[0];
        kingPosY = kingPos[1];

        stonePosX = stonePos[0];
        stonePosY = stonePos[1];
      }else {
        kingPosX = kingPos[0];
        kingPosY = kingPos[1];
      }
    }
    int resultKingX = 9 - kingPosX;
    char resultKingY = (char)(kingPosY + 'A' - 1);
    int stoneX = 9 - stonePosX;
    char stoneY = (char)(stonePosY + 'A' - 1);

    System.out.println(resultKingY +""+ resultKingX);
    System.out.println(stoneY +""+ stoneX);
  }
  public static int[] pos(int x, int y, String move) {
    if(move.equals("R")) {
      if(y + 1 <= 8) y++;
    }
    else if(move.equals("L")) {
      if(y - 1 > 0) y--;
    }
    else if(move.equals("B")) {
      if(x + 1 <= 8) x++;
    }
    else if(move.equals("T")) {
      if(x - 1 > 0) x--;
    }
    else if(move.equals("RT")) {
      if(y + 1 <= 8 && x - 1 > 0) {
        y++;
        x--;
      }
    }
    else if(move.equals("LT")) {
      if(y - 1 > 0 && x - 1 > 0) {
        y--;
        x--;
      }
    }
    else if(move.equals("RB")) {
      if(y + 1 <= 8 && x + 1 <= 8) {
        y++;
        x++;
      }
    }
    else if(move.equals("LB")) {
      if(y - 1 > 0 && x + 1 <= 8) {
        y--;
        x++;
      }
    }
    return new int[]{x,y};
  }
}
