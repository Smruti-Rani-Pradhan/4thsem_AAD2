
import java.util.Arrays;
public class Fractional_Knapsack {
	private class Items implements Comparable<Items>{
		int p,w;
		double d;
		Items(int profit,int weight){
			p=profit;
			w=weight;
			d=(double)p/w;
		}
		public int compareTo(Items x) {
			return (int)(x.d-this.d);
		}
	}
	public double maximizeProfit(int[]p,int[]w,int c) { //c=capacity
		double maxProfit=0;
		int n=w.length;
		Items[] itemList=new Items[n];
		for(int i=0;i<n;i++) {
			itemList[i]=new Items(p[i],w[i]);
		}
		Arrays.sort(itemList);
		for(int i=0;i<n;i++) {
			if(c-itemList[i].w>=0) {
				c=c-itemList[i].w;
				maxProfit=maxProfit+itemList[i].p;
			}else {
				maxProfit=maxProfit+(itemList[i].d*c);
				break;
			}
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		int[] p= {60,40,90,120};
		int[] w= {10,40,20,30};
		int c=50;
		Fractional_Knapsack obj=new Fractional_Knapsack();
		System.out.println("Maximum Profit:"+obj.maximizeProfit(p, w, c));
	}
}
