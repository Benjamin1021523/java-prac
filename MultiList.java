import java.util.*;

public class MultiList{
    static int cnt = 0;
    public static void main(String[] args){
        List L = new ArrayList();
        List t = L;
        for(int i = 0;i < 5;i++){
            t.add(func(i));
        }
        L.add(12.3);

        L.set(3, new ArrayList(){{
            for(int i = 0;i < ((ArrayList)L.get(3)).size();i++)
                add(((ArrayList)L.get(3)).get(i));
            add("qwer");
            add(false);
        }});
        //等價
        List a = (ArrayList)L.get(4);
        a.add(1);  a.add(2);

        L.set(2, new ArrayList(){{
            add(func(2));  add(func(3));  add(func(4));
        }});

        L.add(new HashSet(){{
            add("a");  add("b");  add("c");  add("d");
        }});

        System.out.println(L);
        PrintList.PrintList(L);
    }
    static boolean isLeaf(Object a){
        try{
            List x = (ArrayList)a;
            return false;
        }
        catch(Exception e){
            return true;
        }
    }
    static Object func(int i){
        cnt++;
        List a = new ArrayList();
        if(i == 0)  return new Integer(cnt);
        a.add(func(i-1));
        return a;
    }
}

class PrintList{
    static final String split = " .. ";
    static void PrintList(List a){
        System.out.println("[");
        for(int i = 0;i < a.size();i++)
            print(a.get(i), 1);
        System.out.println("]");
    }
    private static void print(Object a, int depth){
        String front = "";
        for(int i = 0;i < depth;++i)    front += split;
        if(MultiList.isLeaf(a)){
            System.out.println(front + "[ " + a + " ]");
            return;
        }
        List x = (ArrayList)a;
        System.out.println(front + "[");
        for(int i = 0;i < x.size();i++)
            print(x.get(i), depth + 1);
        System.out.println(front + "]");
    }
}
