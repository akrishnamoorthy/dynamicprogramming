package datastructures.graph;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.net.*;
import java.io.*;

public class Request {

    public static void main(String args[]) throws IOException {
        URL url = new URL("http://api.stagingcareerbuilder.xyz/general/getaccesstoken?language=en");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("token" , "1bded055096e50be11a32d0e73f20cc3");
        System.out.println(connection.getResponseCode());
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        System.out.println(reader.readLine());

    }
}
