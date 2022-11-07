package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class 단어뒤집기2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean check = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '<'){
                while(!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
                System.out.print("<");
                check = true;
            }else if(c == ' '){
                while (!stack.isEmpty()){
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }else if(c == '>'){
                check = false;
                System.out.print(">");
            }else{
                if(check){
                    System.out.print(c);
                }else{
                    stack.push(c);
                }
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
