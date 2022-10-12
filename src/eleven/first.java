package eleven;

/**
 * 이진수 앤드연산
 */
public class first {
    public static void main(String[] args) {
        int[] arr = new int[] {2,3,8,13,7};
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            int value = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(Integer.parseInt(Integer.toBinaryString(value & arr[j])) > 0){
                    count++;
                    value = Integer.parseInt(Integer.toBinaryString(value & arr[j]), 2);
                }
            }
            max = Math.max(max, count);
        }
        System.out.println(max);
    }
}
