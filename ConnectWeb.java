import java.io.*;
import java.net.*;

import javax.net.ssl.HttpsURLConnection;

public class ConnectWeb{
    public static void main(String[] args){
        if(args.length == 0){
            System.out.println("範例：");
            System.out.println("******HTTP part******");
            http();
            System.out.println("\n******HTTPS part******");
            https();
        }
        else{
            for(String i:args){
                if(i.substring(0, 5) == "https"){
                    https(i);
                }
                else{
                    http(i);
                }
            }
        }
    }
    static void https(String target){
        try{
            System.out.println(visit_https(target));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    static void https(){
        String target = "https://gist.githubusercontent.com/Benjamin1021523/1701eb96206b779e1595ce0cc3f82466/raw/fc71033195bdec93457f39fe26cbef74701dcce2/Example.java";
        try{
            System.out.println(visit_https(target));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    static String visit_https(String target) throws IOException{
        URL url = new URL(target);
        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
        String TextContent = readAll(con.getInputStream(), "UTF-8");
        return TextContent;
    }
    static void http(String target){
        try{
            System.out.println(visit_http(target));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    static void http(){
        String target = "http://127.0.0.1:5000/show/";
        try{
            System.out.println(visit_http(target));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    static String visit_http(String target) throws IOException{
        URL url = new URL(target);
        InputStream stream = url.openStream();
        String TextContent = readAll(stream, "UTF-8");
        return TextContent;
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
