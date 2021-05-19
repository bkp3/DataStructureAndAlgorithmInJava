package DynamicProgramming;
import java.util.*;

/*

ABCDGH
AEDFHR

Length of LCS is :- 3
ADH

*/

public class LongestCommonSubsequence {

	private static String X,Y;
	private static int M,N;
	private static int dp[][];
	
	public LongestCommonSubsequence(String str1, String str2) {
		this.X=str1;
		this.Y=str2;
		this.M=str1.length();
		this.N=str2.length();
		dp = new int[M+1][N+1];
	}
	
	public void lcs() {
		
		for(int i=0;i<=M;i++) {
			for(int j=0;j<=N;j++) {
				if(i==0 || j==0) {
					dp[i][j]=0;
				}else if(X.charAt(i-1) == Y.charAt(j-1)) {
					dp[i][j]=dp[i-1][j-1]+1;
				}else {
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		
		int ans=dp[M][N];
		
		System.out.println("Length of LCS is :- "+ans);
		
		char[] res = new char[ans+1];
		res[ans]='\u0000';
		int i=M;
		int j=N;
		
		while(i>0 && j>0) {
			if(X.charAt(i-1) == Y.charAt(j-1)) {
				res[ans-1]=X.charAt(i-1);
				i--;
				j--;
				ans--;
			}else if(dp[i-1][j] > dp[i][j-1]) {
				i--;
			}else {
				j--;
			}
		}
		
		for(int k=0;k<=dp[M][N];k++) {
			System.out.print(res[k]);
		}
            
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1=sc.next();
		String str2=sc.next();
		LongestCommonSubsequence obj = new LongestCommonSubsequence(str1,str2);
		obj.lcs();

	}

}
