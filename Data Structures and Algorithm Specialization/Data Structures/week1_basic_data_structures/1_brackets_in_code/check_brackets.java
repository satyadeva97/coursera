import java.util.*;
import java.io.*;
import java.lang.*;
public class check_brackets {
 public static void main(String[] args) throws IOException{
	 InputStreamReader in = new InputStreamReader(System.in);
	 BufferedReader reader = new BufferedReader(in);
	 String text = reader.readLine();
	 int p=0;
	 Stack<brack> st = new Stack<brack>();
	 for(int i=0;i<text.length();i++) {
		 if( text.charAt(i)== '[' || text.charAt(i)== '(' || text.charAt(i)== '{') {
			 brack b = new brack(text.charAt(i),i);
			 if(st.empty()) {
				 p = i+1; 
			 }
			 st.push(b);
		 }
		 if( text.charAt(i)== ']' || text.charAt(i)== ')' || text.charAt(i)== '}') {
			 if(st.empty()) {
				 System.out.println(i+1);
				 return; 
			 }
			 brack c = st.pop();// brack
			 if(c.Match(text.charAt(i))) {
				 continue;
			 }
			 else {
				 System.out.println(i+1);
				 return;
			 }
			 
		 }
		 
	 }
	 if(st.empty()) {
		 System.out.println("Success");
		 return;
	 }
	 else {
		 System.out.println(p);
		 return;
	 }
	 
	 
 }
}
class brack{
	char type;
	int position;
	brack(char type, int position){
		this.type = type;
		this.position = position;
	}
	boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }
}
