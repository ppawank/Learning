class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int[] acopy=new int[m];
	   for(int i=0;i<m;i++)
	   {
		acopy[i]=nums1[i];
	   }
	   int i=0;
	   int j=0;
	   int k=0;
	   while(i<m&&j<n)
	   {
			if(acopy[i]<=nums2[j])
			{
				nums1[k++]=acopy[i];
				i++;
			}
			else
			{
				nums1[k++]=nums2[j];
				j++;
			}
	   }
	   while(i<m)
	   {
		nums1[k++]=acopy[i++];
	   }
	   while(j<n)
	   {
		nums1[k++]=nums2[j++];
	   }

    }
}