import java.net.*;  
import java.io.*;  
 class MyServer{  
        public static void main(String args[])throws Exception{  
/*
    take one ex:
                1. will have a client and server in between a network
                2. we want client and server talk to each other by sending and receving messages over this network.
                3. to do like that we weant socket objects at the both the ends.
                4. take client side socket but server side the server doesn't have socket iniatilly it has serversocket and it's throws exception called IO Exception.
                5. the job of the serverSocket is use to wait for incomming client connection request.
                6. the serverSocket is waiting the request.
                7. as soon it's gets the request it will accept the request.
                8. after the request accepted Scoket object will be created on the Server Side
                9. the connection will be  established b/w those socket objects and the client and server can start sending and receiving the messages.
                10. this is the over all architecture

                
               port no

                1. to create serverSocket Object 
                2. it will accept a argument that is called port number.
                3. port number is basically used identify your application on the Network.

*/


      System.out.println("Waiting for Client..!!");
       ServerSocket ss=new ServerSocket(3333);  


/*
         Wait for Client Connection
          1. i will this statement   Socket s=ss.accept();  

          2. so this accept() method
          3. this will be a blocking call.
          4. it will wait for incomming client connection.
          5. as soon as it's gets connection it will return Socket Object.
*/


       Socket s=ss.accept();  
       System.out.println("Connection is Established");

       DataInputStream din=new DataInputStream(s.getInputStream());  
       DataOutputStream dout=new DataOutputStream(s.getOutputStream());  

/*
       ✔  Read the String which has Client has sent
       ◆ For doing that we should use BufferReagder class Object

    
*/
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
 
       String str="",str2="";  
       while(!str.equals("stop")){  
       str=din.readUTF();  
       System.out.println("client says: "+str);  
/*
        ◼ readLine() is a method which will wait for the user entere String
        ◼ once the user enter a String  return the String that it store String Object/ref    
*/
       str2=br.readLine();  
       dout.writeUTF(str2);  
       dout.flush();  
       }  
     din.close();  
     s.close();  
     ss.close();  
      } 
    }