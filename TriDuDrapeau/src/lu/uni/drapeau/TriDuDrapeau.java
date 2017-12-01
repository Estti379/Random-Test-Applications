package lu.uni.drapeau;

import java.util.Arrays;
import java.util.Random;

public class TriDuDrapeau {

	public static void main(String[] args) {
		
		Random generator = new Random(System.currentTimeMillis());
		
		int[] drapeau = new int[50];
		int[] premierIndex = new int[3 + 2];
		int i = 0, n = 0;
		int temp = 0;
		
		for ( i = 0 ; i < drapeau.length ; i++ ) {
			drapeau[i] = generator.nextInt(premierIndex.length - 1);
		}
		
		for ( n = 0 ; n < premierIndex.length ; n++ ) {
			premierIndex[n] = 0;
		}
		
		for ( n = premierIndex.length - 1 ; n > drapeau[0] ; n-- ) {
			premierIndex[n]++;
		}
		
		for ( i = 1 ; i < drapeau.length ; i++ ) {
			
			temp = drapeau[i];
			premierIndex[premierIndex.length - 1] = i;
			
			
			
			for ( n = premierIndex.length - 1 ;
					temp < n ; n-- ) {
				
				drapeau[premierIndex[n]] = drapeau[premierIndex[n - 1]];
				premierIndex[n]++;
			}
			
			drapeau[premierIndex[n]] = temp;
		}
		
		
		
		
		System.out.println();	
		System.out.println(Arrays.toString(drapeau));	
		
	}

}
