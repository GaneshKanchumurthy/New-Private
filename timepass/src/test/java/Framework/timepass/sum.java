package Framework.timepass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class sum {

	public static void main(String[] args) {
		List <Integer> even = new ArrayList<Integer> ();
		List <Integer> odd = new ArrayList<Integer> ();
		
		for (int i=0; i< 101;i++) {
			if (i%2==0) {
				even.add(i);
			}else {
				odd.add(i);
			}
			
		}
		int sumeven = 0;
		for (int j=0; j<even.size();j++ )
		{
			
			sumeven = even.get(j)+ sumeven;
		}
		System.out.println(sumeven);
		
		int sumodd = 0;
		for (int k=0; k<odd.size();k++ )
		{
			
			sumodd = odd.get(k)+ sumodd;
		}
		System.out.println(sumodd);
		
System.out.println(Collections.min(even));
System.out.println(Collections.max(odd));

		

	}}
	



