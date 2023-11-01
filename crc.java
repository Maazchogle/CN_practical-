//data and key are accepted and 0s are also appended at the end of the data
//define array size after accepting input from the user

import java.util.Scanner;
class crc
{
public static void main(String [] args)
{

int [] data=new int[15];
int [] key=new int[5];
int [] rem=new int[5];

Scanner sc=new Scanner(System.in);
System.out.println("Enter the size of the data");
int m=sc.nextInt();

System.out.println("Enter the size of the key");
int m1=sc.nextInt();

System.out.println("Enter the data::");
for(int i=0;i<m;i++)
{
data[i]=sc.nextInt();
}

System.out.println("Enter the Key::");
for(int j=0;j<m1;j++)
{
key[j]=sc.nextInt();
}

//appending n-1 0s at the end of the data
for(int k=0;k<m1-1;k++)     
{
data[m+k]=0;
}

System.out.println("Data after appending 0");

for(int k=0;k<m+m1-1;k++)
{
System.out.print(data[k]);
}


int c=0;
//xoring starting 4..working fine
for(int k=0;k<m1;k++)
{
if((data[k]==0 && key[k]==0)|| (data[k]==1 && key[k]==1))
{
rem[k]=0;
}

else
{
rem[k]=1;
}
}

//printing the xoring result of the 1st four digits
System.out.println("\nFirst Remainder");
for(int k=0;k<m1;k++)
{
System.out.print(rem[k]);
}
System.out.print("\n");


for(int i1=m1;i1<m+m1-1;i1++)
{
if(rem[0]==0)
{
for(int i=0;i<m1-1;i++)
{
rem[i]=rem[i+1];
}

rem[m1-1]=data[i1];

}
else
{
//System.out.println("sameeeeeeeeeeeee");
}

System.out.println("\nShifted Remainder is as follows::");

for(int i=0;i<m1;i++)
{
System.out.print(rem[i]);
}
System.out.println("\n");

if(rem[0]==1)
{
for(int i11=0;i11<m1;i11++)
{
if((rem[i11]==0 && key[i11]==0)|| (rem[i11]==1 && key[i11]==1))
{
rem[i11]=0;
}

else
{
rem[i11]=1;
}

}

System.out.println("Remainder after XORing");

for(int i=0;i<m1;i++)
{
System.out.print(rem[i]);
}

}
}

System.out.println("The message to be sent is ::");

/*for(int i=1;i<m1-1;i++)
{
data[m+i-1]=rem[i];
}
*/


for(int i=0;i<m1-1;i++)
{
data[m+i]=rem[i+1];
}


for(int i=0;i<m+m1-1;i++)
{
System.out.println(data[i]);
}

}
}
