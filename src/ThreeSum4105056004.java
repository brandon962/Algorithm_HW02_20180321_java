
public class ThreeSum4105056004 extends ThreeSum
{
	int Arr[];
	
	public static void main(String[] args)
	{
		int A[] = {-5,-4,-3,10,1,-8,2,5,5,-9,-4,-2,44,-6,-1,0,1,2,3,-7,50,-5};
		int B[] = {10,20,71,8,13,14,89,23,55,100,90,89,33,44};
		ThreeSum4105056004 test = new ThreeSum4105056004();
		System.out.println(test.T_sum(B));
	}

	public int T_sum(int[] A) 
	{
		this.Arr = A;
		int cont = 0, a,b,c,len = Arr.length,start, end;
		quickSortRecursive(0, len - 1);
		for(int i = 0; i < len; i++)
			System.out.print(A[i] + " ");
		System.out.println("");
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
					cont++;
					end--;
				}
				else if (a+b+c > 0)
					end--;
				else
					start++;
			}
		}
		
		
		return cont;
	}
	
	
	private void quickSortRecursive (int start, int end)
	{	
		if (start >= end)
			return;
		
		int temp,left = start,right = end-1;
		System.out.println("start=" + start);
		System.out.println("end=" + end);
		System.out.println("pivot=" + Arr[end]);
		while (left < right)
		{
			while (Arr[left] <= Arr[end] && left < right)
				left++;
			while (Arr[right] >= Arr[end] && left < right)
				right--;
			temp = Arr[left];
			Arr[left] = Arr[right];
			Arr[right] = temp;
			
		}
		
		if (Arr[left] > Arr[end])
		{
			temp = Arr[left];
			Arr[left] = Arr[end];
			Arr[end] = temp;
		}
		else
			left++;
		
		System.out.println("after pivot=" + left);
		for(int i = 0; i < Arr.length; i++)
			System.out.print(i+ "\t");
		System.out.println("");
		for(int i = 0; i < Arr.length; i++)
			System.out.print(Arr[i]+"\t");
		System.out.println("");
		quickSortRecursive(start, left-1);
		quickSortRecursive(++left, end);
		
	}
}
