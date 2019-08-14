//單純的讀檔印出，使用個物件還要自己在以外的地方加throws真是麻煩
import java.io.*;
public class ReadFile{
    public static void main(String[] args) throws IOException{
        String name = "Example.java";
        String charset = "utf8";
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(name),
                charset
            )
        );
        String Line;
        while((Line = reader.readLine()) != null){
            System.out.println(Line);
        }
    }
}