import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
	  int n1=s.length();
	  int n2 =t.length();
	  int [][] a= new int[n2+1][n1+1];
	  int [] b = new int[n1];
	  int [] c = new int[n2];
	  if(s.charAt(0)==t.charAt(0)) a[0][0]=0;
	  else a[0][0]=1;
	  for(int i=0;i<n1;i++) {
		  b[i]=s.charAt(i);
	  }
	  for(int i=0;i<n2;i++) {
		  c[i]=t.charAt(i);  
	  }
	  for(int i=0;i<n2+1;i++) {
		   a[i][0]=i;
	  }
	  for(int i=0;i<n1+1;i++) {
		  a[0][i]=i;
	  }
	  for(int i=1;i<n2+1;i++) {
		  for(int j=1;j<n1+1;j++) {
			  if(c[i-1]==b[j-1]) {
				  a[i][j]=a[i-1][j-1];
			  }
			  else {
				  a[i][j]=Math.min(a[i-1][j-1]+1,Math.min(a[i-1][j]+1, a[i][j-1]+1));
			  }
		  }
	  }
	
	  
	  return a[n2][n1];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
