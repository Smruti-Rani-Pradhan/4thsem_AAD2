
public class Interval_Scheduling {
	public static int[] Earliest_Finish_Time(int n,int s[],int f[]) {
		int k=0;
		int S[]= {};
		for(int j=0;j<n;j++) {
			if(f[k]<=s[j]) {
				S[j]=j;
				k=j;
			}
		}
		return S;
	}
	public static void main(String[] args) {
		int s[]= {1,3,0,5,6,8,8,2,12};
		int f[]= {6,7,9,9,10,11,12,14,16};
		int n=s.length;
		int S[]=Earliest_Finish_Time(n,s,f);
		System.out.println(S);
	}

}
