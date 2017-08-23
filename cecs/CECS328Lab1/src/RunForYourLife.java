
public class RunForYourLife {

	public int Freddy(int a[], int n){
		int maxSum=0;
		for(int i=0; i<n;i++) {
			for(int j=i; j<n; j++){
				int thisSum=0;
				for(int k=i; k<=j; k++) {
					thisSum += a[k];
				}
				if(thisSum > maxSum)
					maxSum=thisSum;
			}
		}
		return maxSum;
	}
	
	public int Susie(int a[], int n){
		int maxSum=0;
		for(int i=0; i< n ; i++){
			int thisSum=0;
			for(int j=i; j< n; j++) {
				thisSum += a[j];
			if(thisSum > maxSum)
				maxSum=thisSum;
			}
		}
		return maxSum;
	}
	public int Johnny(int a[], int left, int right){
		if (a.length == 0 || left == right) {
			if (a.length > 0 && a[left] > 0)
				return a[left];
			return 0;
		}
		int center = (left + right) /2;
		int maxLeftSum= Johnny(a, left, center);
		int maxRightSum=Johnny(a, center+1, right);
		
		int maxLeftBorderSum= 0, leftBorderSum=0;
		for ( int i= center; i >= left; i--){
			leftBorderSum += a[i];
			if(leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum= leftBorderSum;
		}
		
		int maxRightBorderSum= 0, rightBorderSum=0;
		for ( int i= center + 1; i <= right; i++){
			rightBorderSum += a[i];
			if(rightBorderSum > maxRightBorderSum)
				maxRightBorderSum= rightBorderSum;
		}
		return Math.max(maxLeftSum, Math.max(maxRightSum, maxLeftBorderSum + maxRightBorderSum));
	}
	public int Sally(int a[], int n){
		int maxSum= 0, thisSum=0;
			for(int i=0; i< n; i++){
				thisSum += a[i];
				if(thisSum > maxSum)
					maxSum = thisSum;
				else if (thisSum < 0)
					thisSum=0;		
			}
			return maxSum;
	}
}
