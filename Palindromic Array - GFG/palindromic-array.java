//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] a, int n)
           {
                  //add code here.
                   //add code here.
                  for(int i = 0; i < n; i++){
                      
                    //   Logic of palindrome number in java
                      int arrNum = 0;
                      int count = a[i];
                      int original = count;
                      
                      while(count > 0){
                          int rem = count % 10;
                          arrNum = (arrNum * 10) + rem;
                          count = count / 10;
                      }
                      
                      if(arrNum != original){
                          return 0;
                      }
                  }
                  return 1;
           }
}