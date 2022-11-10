package backjun;

import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class 팰린드롬만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        for(int i=0; i<s.length(); i++){
            if(isPalindrom(s.substring(i))){
                System.out.println(s.length() + i);
                return;
            }
        }
    }

    static boolean isPalindrom(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != stack.pop()) return false;
        }
        return true;
    }
}
