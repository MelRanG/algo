import java.io.*;
import java.util.*;
class Main {
    static int N;
    static int[] arr;
    static boolean[] firstVisit, secondVisit;
    static List<Integer> firstList, secondList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        firstVisit = new boolean[N+1]; secondVisit = new boolean[N+1];
        for (int i = 1; i < N+1; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i] = n;
        }
        firstList = new ArrayList<>();
        secondList = new ArrayList<>();
        for (int i = 1; i < N+1; i++) {
            if(firstVisit[i] || secondVisit[arr[i]]) continue;
            dfs(i);
        }
        System.out.println(firstList.size());
        for (int i:firstList
             ) {
            System.out.println(i);
        }
    }

    static boolean dfs(int start){
        if(firstVisit[start] || secondVisit[arr[start]]){
            return check();
        }
        firstVisit[start] = true;
        secondVisit[arr[start]] = true;
        firstList.add(start);
        secondList.add(arr[start]);
        if(!dfs(arr[start])){
            firstVisit[start] = false;
            secondVisit[arr[start]] = false;
            firstList.remove(Integer.valueOf(start));
            secondList.remove(Integer.valueOf(arr[start]));
            return false;
        }
        return true;
    }

    static boolean check(){
        if(firstList.size() != secondList.size()) return false;
        Collections.sort(firstList);
        Collections.sort(secondList);
        for (int i = 0; i < firstList.size(); i++) {
            if(firstList.get(i) != secondList.get(i)) return false;
        }
        return true;
    }

}