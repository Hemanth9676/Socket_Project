import java.net.*;  
import java.io.*;  
      class Client{  
      public static void main(String args[])throws Exception{  

/*
    ⁕ what is Socket in network programming?

     ✔ Sockect is a Class 
      
    * Why do we need / what is the use of this?
      
     A Socket is an End point of communication b/w two devices.
      

      ex:  
                    we have 2 computers  
            
              🖥            network                       🖥

            🤷‍♂️ the 2 computers communicate each other over a Network
             🤷‍♂️ then they need have a Socket Each of their ends
            ✔ lets say computer A AND B have Socket
            👍once the connection is established between the 2 sockets
            👌 the computer A and B start send and receiving the messages


          ◆  we want send some data from A to B in that case we are going to use Socket is OutputStream
          ◆  from reading data B to A in that time use socket inpitStream.
*/
      Socket s=new Socket("localhost",3333);  

      DataInputStream din=new DataInputStream(s.getInputStream());  

/*
     ----> send the data/String into the server , for sending we are goning making use of OutputStream
     ----> and object will be used  DataOutputStream
              DataOutputStream dout=new DataOutputStream(s.getOutputStream());  

     ----> s.getOutputStream()---> this 's' is the Sockect ref var / Socket OutputStream
      ----> will have  to use flush() method of it, other wise DataOutputStream  has keping data itself, until will write flush() it won't send the data
*/
      DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
     
/*
     ----> we are going to ask user enter a String and we are going send that String in to the Server.
      
     ----> for doing that will have to read the data from the KeyBoard and we will have to send the data over network to the server
    
     ----> we are going to use called as Streams
      
     1. Streams are basically use for Reading  and  writing the data
     2. There is a two  types of Streams

       i. inputStream

       ---->   which is used for reading the data

       ii. OutputStream
        
      ----->   which is used to writing data or sending data

     
    -----> First thing i am doing here to Read the data from the Keyboard.
    -----> that's why i am using BufferReader Object here 
    
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
                                                                       ↡
              ---->  System.in :   this 'in' is an inputStream Object
                                   i. inputStream is capable of to reading one byte data  at a time
                                   ii. this inpiutStream Object deals with  ByteStream of Data.                
                                   iii. we don't want directly , we will take help of  another class  called as InputStreamReader.
                                   iv. this   InputStreamReader class object it's takes the byteStream and gives it as a character Stream
                                   v. now we still don't want deel with one character at a time we want deel with entire String at a time.
                                   vi. so we take a help of anothe class which is called  BufferedReader.
                                   vii. this BufferedReader class Object Reading  capable of entire String at a Time.
                                   viii.so now, with the help of BufferReader Obj Ref to read String from the keyboard.  
                                   ix. i will use like this.
                                              --->  String  str=br.readLine();       
                                   x. readLine() is a method which will wait for the user entere String
                                   xi. once the user enter a String  return the String that it store String Object/ref                     
     
*/
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
 
      String str="",str2="";  
      while(!str.equals("stop")){  


/*

                                    ---> readLine() is a method which will wait for the user entere String
                                    ---> once the user enter a String  return the String that it store String Object/ref    
*/
      str=br.readLine();  
      dout.writeUTF(str);  

//     ----> will have  to use flush() method of it, other wise DataOutputStream  has keping data itself, until will write flush() it won't send the data

      dout.flush();  
//It is used to read a string that has been encoded using the UTF-8 format.
      str2=din.readUTF();  
      System.out.println("Server says: "+str2);  
    }  
 
     dout.close();  
      s.close();  
    }
}