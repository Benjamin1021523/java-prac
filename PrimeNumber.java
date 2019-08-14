//印出1~10000間的質數
public class PrimeNumber{
    public static void main(String[] args){
        int n = 9974;//No prime number in 9974 ~ 10000
        boolean[] arr = new boolean[n];
        for(int i = 2;i < n;i++){
            if(!arr[i]){
                for(int j = i+i;j < n;j += i){
                    arr[j] = true;
                }
            }
        }
        int cnt = 0;
        for(int i = 2;i < n;i++){
            if(!arr[i]){
                System.out.printf(i + " ");
                ++cnt;
                if(cnt % 10 == 0)   System.out.println();
            }
        }
        System.out.println();
    }
}