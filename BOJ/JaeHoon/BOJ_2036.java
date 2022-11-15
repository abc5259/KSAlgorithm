package BOJ.JaeHoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2036 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Long> plusArr = new ArrayList<>();
    ArrayList<Long> minusArr = new ArrayList<>();
    Queue<Long> zeroQueue = new LinkedList<>();
    Queue<Long> oneQueue = new LinkedList<>();
    for(int i=0; i<n; i++) {
      long num = Integer.parseInt(br.readLine());
      if(num == 1)
        oneQueue.offer(num);
      else if(num < 0)
        minusArr.add(num);
      else if(num > 0)
        plusArr.add(num);
      else 
        zeroQueue.offer(num);
    }
    Collections.sort(minusArr);
    Collections.sort(plusArr,Collections.reverseOrder());

    BigInteger total= new BigInteger("0");
    int limit = plusArr.size() % 2 == 0 ? plusArr.size() : plusArr.size() - 1;
    for(int i=0; i<limit; i+=2) {
      total = total.add(BigInteger.valueOf(plusArr.get(i)*plusArr.get(i+1)));
    }
    if(plusArr.size() % 2 != 0)
      total = total.add(BigInteger.valueOf(plusArr.get(plusArr.size()-1)));
    
    limit = minusArr.size() % 2 == 0 ? minusArr.size() : minusArr.size() - 1;  
    for(int i=0; i<limit; i+=2) {
      total = total.add(BigInteger.valueOf(minusArr.get(i)*minusArr.get(i+1)));
    }
    if(minusArr.size() % 2 != 0) {
      if(zeroQueue.isEmpty()) {
        total = total.add(BigInteger.valueOf(minusArr.get(minusArr.size()-1)));
      }
    }


    total = total.add(BigInteger.valueOf(oneQueue.size()));
    System.out.println(total);
  }
}
