package lu.uni.dateDuLendemain;

import java.util.Scanner;

public class DateDuLendemain {

	public static void main(String[] args) {
		Date firstDate = new Date();
		Scanner scanner = new Scanner(System.in);
		
		int day = -1, month = -1 , year = -1;
		int i;
		
		firstDate.displayDate();
		System.out.println();
		
		
		for (i=0;i<2;i++) {
			firstDate.askUserForDate(scanner);
	
			
			firstDate.displayDate();
			System.out.println();
			
			firstDate.addDay();
			
			firstDate.displayDate();
			System.out.println();
		}
		
		scanner.close();
	}

}
