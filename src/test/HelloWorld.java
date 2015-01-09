package test;

import static spark.Spark.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import spark.*;

class HelloWorld {

   /*public static void main(String[] args) {
	   //get("/hello", (Request req, Response res) -> "Hello World");

      get("/hello",new Route() {
         @Override
         public Object handle(Request request, Response response) {
            return "Hello World!";
         }
      });

   }*/
   
   public static void main(String[] args) throws Exception {
       String host = "192.168.100.68";
       InetAddress inetAddress = InetAddress.getByName(host);

       String hostName = inetAddress.getHostName();
       //for (int port = 0; port <= 65535; port++) {
           try {
               //Socket socket = new Socket(hostName, port);
        	   Socket socket = new Socket(hostName, 9443);
               String text = hostName + " is listening on port " + "80";
               System.out.println(text);
               socket.close();
           } catch (IOException e) {
               String s = hostName + " is not listening on port " + "80";
               System.out.println(s);
           }
       //}
   }

}
