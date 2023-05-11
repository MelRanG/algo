import java.io.*;
import java.util.*;
class Main {

    static String a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        int right = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) == 'a') right++;
        }
        int left = 0;
        int bcnt = 0;
        for (int i = 0; i < right; i++) {
            if(a.charAt(i) == 'b') bcnt++;
        }
        int min = 10000;
        while(left < a.length()){
            if(a.charAt(left) == 'b') bcnt--;
            if (right < a.length()) { // Add this line to check if 'right' is within bounds.
                if(a.charAt(right) == 'b') bcnt++;
            }
            left++;
            right = (right + 1) % a.length();
            min = Math.min(min, bcnt);
        }
        System.out.println(min);
    }

}