/*
  
  
                                                                        Experiment no. 7
                                                            Aim:Implementation of Stop and Wait using program
 */

import java.io.*;
import java.net.*;

public class receiver{
ServerSocket receiver;
Socket connection=null;
ObjectOutputStream out;
ObjectInputStream in;
String packet,ack,data="";
int i=0,sequence=0;
receiver(){}
public void run(){
try{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
receiver = new ServerSocket(2004,10);
System.out.println("waiting for connection...");
connection=receiver.accept();
sequence=0;
System.out.println("Connection established :");
out=new ObjectOutputStream(connection.getOutputStream());
out.flush();
in=new ObjectInputStream(connection.getInputStream());
out.writeObject("connected .");
do{
try{
packet=(String)in.readObject();
if(Integer.valueOf(packet.substring(0,1))==sequence){
data+=packet.substring(1);
sequence=(sequence==0)?1:0;
System.out.println("\n\nreceiver>"+packet);
}
else
{
System.out.println("\n\nreceiver>"+packet +" duplicate data");
}
if(i<3){
out.writeObject(String.valueOf(sequence));i++;
}
else{
out.writeObject(String.valueOf((sequence+1)%2));
i=0;
}
}
catch(Exception e){}
}while(!packet.equals("end"));
System.out.println("Data recived="+data);
out.writeObject("connection ended .");
}
catch(Exception e){}
finally{
try{
in.close();
out.close();
receiver.close();
}
catch(Exception e){}
}
}
public static void main(String args[]){
receiver s=new receiver();
while(true){
s.run();
}
}
}

// Output:-

// aiktc@CO-LAB1-12:~/2$ java receiver.java  
// waiting for connection...
// Connection established :


// receiver>0H


// receiver>1e


// receiver>0l


// receiver>1l


// receiver>1l duplicate data


// receiver>0o


// receiver>1 


// receiver>0F


// receiver>0F duplicate data


// receiver>1a


// receiver>0r


// receiver>1h


// receiver>1h duplicate data


// receiver>0a


// receiver>1a


// receiver>0n


// receiver>0n duplicate data
// Data recived=Hello Farhaan
// waiting for connection...
