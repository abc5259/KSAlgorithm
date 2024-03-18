package Programmers.JaeHoon.level3;

public class 백십_옮기기 {
    class Solution {
        public String[] solution(String[] s) {
            String[] answer = new String[s.length];

            for(int i=0; i<s.length; i++) {
                if(s[i].length() <= 3) {
                    answer[i] = s[i];
                    continue;
                }


                int index = 0;
                String str = s[i];
                int count = 0;
                int sp = 0;
                char[] stack = new char[str.length()];
                while(true)
                {
                    if(sp >= 3)
                    {
                        int end = sp-1;
                        if(stack[end] == '0'&&stack[end-1] == '1'&&stack[end-2] == '1')
                        {
                            sp -=3;
                            count++;
                        }
                        else if(index >= str.length()) break;
                        else stack[sp++]=str.charAt(index++);
                    }
                    else if(index >= str.length()) break;
                    else stack[sp++]=str.charAt(index++);
                }
                str = new String(stack).substring(0, sp);

                StringBuilder sb = new StringBuilder();
                for(int cnt=0; cnt<count; cnt++) {
                    sb.append("110");
                }

                String result;
                StringBuilder strSb = new StringBuilder(str);
                int idx = str.lastIndexOf('0');
                if(idx != -1) {
                    if(idx + 1 == str.length()) {
                        strSb.append(sb.toString());
                    }else {
                        strSb.insert(idx+1,sb.toString());
                    }
                    result = strSb.toString();
                }else {
                    sb.append(strSb);
                    result = sb.toString();
                }
                answer[i] = result;
            }


            return answer;
        }

    }
}
