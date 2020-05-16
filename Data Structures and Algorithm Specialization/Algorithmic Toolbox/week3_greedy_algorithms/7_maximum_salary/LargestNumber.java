import java.util.*;
import java.util.Scanner;

public class LargestNumber {
private static String largestNumber(ArrayList<String> a,long n)
    {
String mb="",res="";
while(a.size()!=0)
{
int index=0;
String max=a.get(0);
for(long j=0;j<a.size();j++)
{
mb=max;
max=Isgreater(a.get((int) j),max);
if(mb!=max)
index=(int) j;
}
res=res+max;
a.remove(index);
}
return res;


    }
static String Isgreater(String a,String max)
{
	return Integer.parseInt((a+max))>Integer.parseInt((max+a))? a : max;
}
	/*long i=0;
long min=Math.min(a.length(), max.length());
long j =min;
if(a.equals(max))
{
return max;}
for(i=0;i<min;i++) {
if(a.charAt((int) i)>max.charAt((int) i)) return a;
if(a.charAt((int) i)<max.charAt((int) i)) return max;
if(a.charAt((int) i)==max.charAt((int) i))
continue;
}
if(a.length()<max.length()) {
	while(j<max.length()) {
		if (max.charAt((int)j)>a.charAt((int)(min-1))) return max;
		j++;
	}
	return a;
	}
if(max.length()<a.length()) {
	while(j<a.length()) {	
			if(a.charAt((int)j)>max.charAt((int)(min-1))) return a;
			j++;
	}
	return max;	
}
return " ";
}*/
/*if(max.charAt((int) min)>a.charAt((int) (min-1)))
return max;
else
return a;}
else
if(max.length()<a.length())
if(a.charAt((int) min)>max.charAt((int) (min-1)))
return a;
else
return max;
return "";
}*/
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        ArrayList<String> a = new ArrayList<String>();
       
        for (long i = 0; i < n; i++) {
        String str = scanner.next();
        a.add(str);  
        }
        System.out.println(largestNumber(a,n));
       

}

}