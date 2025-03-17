
public class StringMatching {

	
		public static int BruteForceSearch(String str1,String str2) {
			char[] text=str1.toCharArray();
			char[] pattern=str2.toCharArray();
			int i=0,j=0;
			int n=text.length;
			int m=pattern.length;
			while(i<=n-m) {
				j=0;
				while(j<m && pattern[j]==text[i+j]) {
					j++;
				}
				if(j==m)
					return (i);
				i++;
			}
			return -1;
			
	}
	public static void main(String[] args) {
		String str1="algorithm design";
		String str2="design";
		System.out.println("Pattern found at "+BruteForceSearch(str1,str2));

	}

}
