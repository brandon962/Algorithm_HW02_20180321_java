
public class test4105056004 
{
	static int A[] = {-5,-4,-3,10,1,-8,2,5,-9,-4,-2,44,-6,-1,0,1,2,3,-7,50};
	static int len = A.length;
	
	public static void main(String[] args) 
	{
		test4105056004 test = new test4105056004();
		
		//test.doit();
		test.sort(A);
		
		for(int i = 0; i < len; i++)
		{
			System.out.print(A[i] + " ");
		}
		System.out.println();
		test.doit();

	}
	
	
	
	public void doit()
	{
		int a,b,c;
		int start, end;
		for(int i = 0; i < len-3; i++)
		{
			a = A[i];
			start = i+1;
			end = len-1;
			while (start < end)
			{
				b = A[start];
				c = A[end];
				if (a+b+c == 0)
				{
					System.out.println(a + " " + b + " " + c);
					end--;
				}
				else if (a+b+c > 0)
				{
					end--;
				}
				else
				{
					start++;
				}
			}
		}
	}
	
	
	private void swap (int x, int y)
	{
		int temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}
	
	private void quickSortRecursive (int start, int end)
	{	
		if (start >= end)
			return;
		
		int mid = A[end];
		int left = start;
		int right = end - 1;
		
		while (left < right)
		{
			while (A[left] <= mid && left < right)
				left++;
			while (A[right] >= mid && left < right)
				right--;
		
			swap(left, right);
		}
		
		if (A[left] >= A[end])
			swap(left, end);
		else
			left++;
		
		quickSortRecursive(start, left-1);
		quickSortRecursive(left + 1, end);
		
	}
	
	public int [] sort (int [] arrin)
	{
		A = arrin;
		quickSortRecursive(0, A.length - 1);
		return arrin;
	}
	
	
	
}


