package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_9519 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int X = Integer.parseInt(br.readLine());
    String str = br.readLine();
    ArrayList<String> arr = new ArrayList<>();

    int end = str.length() % 2 == 1 ? str.length()-2 : str.length()-1;
    arr.add(str);
    String answer = null;
    for(int i=1; i<=X; i++) {
      char[] s = new char[str.length()];
      int index = 0;
      for(int j=0; j<str.length(); j+=2) {
        s[index++] = arr.get(i-1).charAt(j);
      }
      for(int j=end; j>=1; j-=2) {
        s[index++] = arr.get(i-1).charAt(j);
      }
      String newStr = new String(s);

      if(newStr.equals(arr.get(0))) { //규칙발견
        X %= i;
        answer = arr.get(X);
        break;
      }

      arr.add(newStr);
    }
    System.out.println(answer == null ? arr.get(X) : answer);
  }
}
