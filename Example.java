import java.util.*;

public class Example{
    public static void main(String[] args){
        List<Integer> a = new ArrayList<Integer>();
        for(int i = 0;i < 5;i++)    a.add(i);
        List<Integer> b = a;
        for(int i:a)    System.out.print(i + " ");
        System.out.println();
        for(int i:b)    System.out.print(i + " ");
        System.out.println();
    }
}
//b初始化時使用了和a同樣的一塊記憶體
//就像linux指令的ln -h一樣