/*
	prefix sums:
	if i want from l to r (1 indexed) inclusive do pre[r], pre[l-1]
	*/
	/*fenwickTree
	if i want from l to r (0 indexed) inclusive do r+1, l //use this one, as it will always start from 0
	if i want from l to r (1 indexed) inclusive do r, l-1
	 */
	static class FenwickTree{
		int arr[];
		public FenwickTree(int size) {
			arr=new int[size+1];
		}
		//0 indexed
		public void update(int index, int amt) {
			index++;
			while(index<arr.length) {
				arr[index]+=amt;
				index+=(index&-index);
			}
		}
		public void build(int a[]) {
			for(int i=0;i<a.length;i++) {
				update(i, a[i]);
			}
		}
		public void fastBuild(int a[]) {
			for(int i=1;i<=a.length;i++) {
				arr[i]+=a[i-1];
				int index=i+(i&-i);//next index that it contributes to
				if(index<=a.length) {
					arr[index]+=arr[i];
				}
			}
		}
		//inclusive from 0 to index
		public long prefixSum(int index){
			long res=0;
			index+=1;
			while(index!=0) {
				res+=arr[index];
				index-=(index&-index);
			}
			return res;
		}
		//0 to n, normal prefix sums
		public long prefixRange(int index1, int index2) {
			index1--;
			index2--;
			return prefixSum(index2)-prefixSum(index1);
		}
	}
