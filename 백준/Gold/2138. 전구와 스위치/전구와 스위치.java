import java.io.*;
import java.util.*;
class Main {
    static int N;
    static String obj, target;
    static boolean[] targetType;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        obj = br.readLine();
        target = br.readLine();
        boolean[] objType1 = new boolean[N];
        boolean[] objType2 = new boolean[N];
        targetType = new boolean[N];
        for (int i = 0; i < N; i++) {
            if(obj.charAt(i) == '1'){
                objType1[i] = true;
                objType2[i] = true;
            }if(target.charAt(i) == '1') targetType[i] = true;
        }
        //1번째 스위치 온
        objType1[0] = !objType1[0];
        objType1[1] = !objType1[1];
        int count = Integer.MAX_VALUE;
        count = Math.min(on(1,objType1),count);
        count = Math.min(on(0,objType2),count);
        if(count == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(count);
    }

    static int on(int status, boolean[] objType){
        int count = 0;
        if(status == 1) count++;
        for (int i = 1; i < N; i++) {
            if(objType[i-1] != targetType[i-1]){
                objType[i-1] = !objType[i-1];
                objType[i] = !objType[i];
                if(i+1 < N) objType[i+1] = !objType[i+1];
                count++;
            }
        }
        return check(count, objType);
    }
    static int check(int count, boolean[] objType){
        for (int i = 0; i < N; i++) {
            if(objType[i] != targetType[i]) return Integer.MAX_VALUE;
        }
        return count;
    }

}