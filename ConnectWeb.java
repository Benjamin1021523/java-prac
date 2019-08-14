import java.io.*;
import java.net.*;

public class ConnectWeb{
    public static void main(String[] args){
        http();
        https();
    }
    static void https(){//https目前失敗
        String target = "https://gist.githubusercontent.com/Benjamin1021523/1701eb96206b779e1595ce0cc3f82466/raw/fc71033195bdec93457f39fe26cbef74701dcce2/Example.java";
    }
    static void http(){
        String target = "http://127.0.0.1:5000/show/";
        try{
            URL url = new URL(target);
            InputStream stream = url.openStream();
            String content = readAll(stream, "UTF-8");
            System.out.print(content);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    static String readAll( InputStream stream, String charcode ) throws IOException{
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(stream, charcode)
        );
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line+"\n");
        }
        return sb.toString();
    }
}
