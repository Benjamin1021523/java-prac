//多維陣列，ㄎ一尢掉的產物
import java.util.*;

public class MultiArr{
    static int cnt = 0;
    public static void main(String[] args){
        Vector L = new Vector();
        Vector t = L;
        for(int i = 0;i < 5;i++){
            t.add(func(i));
        }

        System.out.println(L);
        for(int i = 0;i < L.size();i++){
            System.out.println(L.elementAt(i));
        }
    }
    static Object func(int i){
        cnt++;
        Vector a = new Vector();
        if(i == 0)  return new Integer(cnt);
        a.add(func(i-1));
        return a;
    }
}
