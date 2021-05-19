package DynamicProgramming;

public class FibonacciSeries {

	public int fib(int n) {
		if(n==0)
			return 0;
		
		if(n==1)
			return 1;
		
		return fib(n-1)+fib(n-2);
	}
	
	// Down up approach
	public int fibOptimized(int n) {
		int[] arr = new int[n+1];
		arr[0]=0;
		arr[1]=1;
		for(int i=2;i<=n;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr[n];
	}
	
	// Top down approach
	public int fibMemoization(int[] memo, int n) {
		if(memo[n]==0) {
			if(n<2) {
				memo[n]=n;
			}else {
				memo[n]=fibMemoization(memo,n-1)+fibMemoization(memo,n-2);
			}
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
		FibonacciSeries obj = new FibonacciSeries();
		System.out.println(obj.fib(10));	//55
		System.out.println(obj.fibOptimized(10));	//55
		System.out.println(obj.fibMemoization(new int[10+1],10));	//55

	}

}
