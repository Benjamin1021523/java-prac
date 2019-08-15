package mypackages.net;

import java.io.*;
import java.net.*;

import javax.net.ssl.HttpsURLConnection;

public class ConnectWeb{
    public static void https(String target){
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
    public static void http(String target){
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
