package lu.uni.dateDuLendemain;

import java.util.Scanner;

/**
 * This class performs different actions on and with a date of the type
 * DD/MM/YYYY.<br>
 * <br>
 * NOTE: When an object is created with this class the default value will
 * be 01/01/0001.
 * 
 * @author estti379
 * @version 1.3 (17/10/2017)
 */



/*
 * TODO list:
 * 
 *   // static int getDaysDifference(Date firstDate, Date secondDate)
 * 	 
 */



public class Date {

	private int year, month, day;
	
	
	Date(){
		year = 1;
		month = 1;
		day = 1;
	}
	
	
	/**
	 * Display the objet's stored date on the console with format DD/MM/YYYY.<br>
	 * NOTE: it doesn't skip lines.
	 */
	void displayDate() {
		displayDate(getDay(), getMonth(), getYear());
	}
	
	
	/**
	 * Display the objet's stored date on the console with format DD/MM/YYYY.<br>
	 * NOTE: it doesn't skip lines.
	 */
	static void displayDate(Date myDate) {
		displayDate(myDate.getDay(), myDate.getMonth(), myDate.getYear() );
	}
	
	
	/**
	 * Display the input date on the console with format DD/MM/YYYY.<br>
	 * NOTE: it doesn't skip lines.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 */
	static void displayDate(int day, int month, int year) {
		if ( day < 10 ) {System.out.print("0");}
		System.out.print(day + "/");
		if ( month < 10 ) {System.out.print("0");}
		System.out.print(month + "/");
		
		if ( (year < 1000) && (year >= 100) ) {
			System.out.print("0");
		} else if ( (year < 100) && (year >= 10) ) {
			System.out.print("00");
		} else if ( year < 10 ) {
			System.out.print("000");
		}
		
		System.out.print(year);
	}
	
	/**
	 * Checks if the input date is valid. <br>
	 * Year has to be between 1 and 9999. <br>
	 * Month between 1 and 12. day between 1 and 28-31, depending on month.
	 * 
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	static boolean isDateValid(int day, int month, int year) {
		boolean dateValid = true;
		
		/*
		 * Value of "dateValid" stays true, unless one of the 3 next 
		 * condition structures makes it false.
		 */
		if ( (year < 1) || (year > 9999) ) {
			dateValid = false;
			System.out.println();
			System.out.println("ERROR - isDateValid: Year has to be between 0 "
								+"and 9999!");
		}
		
		/*
		 * NOTE: this whole structure can be replace by the structure that comes 
		 * right after.
		 */
//		if ( (month < 1) || (month > 12) ) {
//			dateValid = false;
//			System.out.println();
//			System.out.println("EROOR - isDateValid: Month has to be between 0 "
//							+"and 12!");	
//		}
		
		/* getLastDayOfMonth returns "-1" if the month is not valid.*/
		if ( ( getLastDayOfMonth(month, isLeapYear(year) ) ) == -1 ) {
			dateValid = false;
			System.out.println();
			System.out.println("ERROR - isDateValid: Month has to be between 0 "
							    +"and 12!");	
		}
	
		if ( (day < 1)) {
			dateValid = false;
			System.out.println();
			System.out.println("ERROR - isDateValid: Day has to be at least 1!");
		} else if ( day > getLastDayOfMonth(month, isLeapYear(year) ) ) {
			dateValid = false;
			System.out.println();
			System.out.println("ERROR - isDateValid: Day is not valid for the month "
								+"used as input!");
		}
		
		return dateValid;
	}
	
	
	/**
	 * Checks if the stored date is valid.<br>
	 * Year has to be between 0 and 9999.<br>
	 * Month between 1 and 12. day between 1 and 28-31, depending on month. 
	 * @return
	 */
	boolean isDateValid() {
		return isDateValid(getDay(), getMonth(), getYear() );
	}
	
	
	/**
	 * Checks if the stored date is valid.<br>
	 * Year has to be between 0 and 9999.<br>
	 * Month between 1 and 12. day between 1 and 28-31, depending on month.
	 * @param myDate
	 * @return
	 */
	static boolean isDateValid(Date myDate) {
		return myDate.isDateValid();
	}
	
	
	/**
	 * Checks if the input year is a leap year.
	 * 
	 * @param year
	 * @return
	 */
	static boolean isLeapYear(int year) {
		boolean leapYear = false;
			if ( (year % 4) != 0 ) {
				leapYear = false;
			} else if ( (year % 100) != 0 ) {
				leapYear = true;
			} else if ( (year % 400) != 0 ) {
				leapYear = false;
			} else {
				leapYear = true;
			}
		return leapYear;
	}
	
	
	/**
	 * Checks if the year of the stored date is a leap year.
	 * 
	 * @return
	 */
	boolean isLeapYear() {
		return isLeapYear(getYear() );
	}
	
	
	/**
	 * Checks if the year of the stored date is a leap year.
	 * 
	 * @param myDate
	 * @return
	 */
	static boolean isLeapYear(Date myDate) {
		return myDate.isLeapYear();
	}
	
	
	
	/**
	 * Changes date to the input values.
	 * 
	 * @param newDay
	 * @param newMonth
	 * @param newYear
	 * @return Returns <CODE>true</CODE> if change was successful.<br>
	 * Else, it returns <CODE>false</CODE>.
	 */
	boolean setDate(int newDay, int newMonth, int newYear) {
		boolean success = false;
		if ( isDateValid(newDay, newMonth, newYear) ) {
			setDay(newDay);
			setMonth(newMonth);
			setYear(newYear);
			success = true;
		} else {
			success = false;
		}
		return success;
	}
	
	
	/**
	 * Changes day of the stored date to the input value.
	 * 
	 * @param newDay
	 * @return
	 */
	boolean setDay(int newDay) {
		boolean success = false;
		if ( isDateValid(newDay, getMonth(), getYear() ) ) {
			day = newDay;
			success = true;
		} else {
			success = false;
		}
		return success;
	}
	
	
	/**
	 * Changes month of the stored date to the input value.
	 * 
	 * @param newMonth
	 * @return
	 */
	boolean setMonth(int newMonth) {
		boolean success = false;
		if ( isDateValid(getDay(), newMonth, getYear() ) ) {
			month = newMonth;
			success = true;
		} else {
			success = false;
		}
		return success;
	}
	
	
	/**
	 * Changes year of the stored date to the input value.
	 * 
	 * @param newYear
	 * @return
	 */
	boolean setYear(int newYear) {
		boolean success = false;
		if ( isDateValid(getDay(), getMonth(), newYear) ) {
			year = newYear;
			success = true;
		} else {
			success = false;
		}
		return success;
	}
	
	
	/**
	 * 
	 * @return Value stored for the day of the Date object
	 */
	int getDay() {
		return day;
	}
	
	
	/**
	 * 
	 * @return Value stored for the month of the Date object
	 */
	int getMonth() {
		return month;
	}
	
	
	/**
	 * 
	 * @return Value stored for the year of the Date object
	 */
	int getYear() {
		return year;
	}
	
	
	/**
	 * Returns the last day possible of a month.<br>
	 * Takes leap years into account.<br>.
	 * 
	 * @param month
	 * @param leapYear Boolean to indicate if the year used is a leap year or not.
	 * @return Returns -1 if the input month is invalid.
	 */
	static int getLastDayOfMonth(int month, boolean leapYear) {
		int lastDayOfMonth = 0;
		
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			lastDayOfMonth = 31 ;
			break;
			
		case 4: case 6: case 9: case 11: 
			lastDayOfMonth = 30 ;
			break;
			
		case 2: 
			if ( leapYear ) {
				lastDayOfMonth = 29 ;
			} else {
				lastDayOfMonth = 28 ;
			}
			break;
			
		default:  // Month is not between 1 and 12 (inclusive)
			System.out.println();
			System.out.println("EROOR - getMaxDayOfMonth: Month has to be between " 
			+ "0 and 12!");
			lastDayOfMonth = -1 ;
			break;
			
		}// End switch
		
		return lastDayOfMonth;
	}
	
	
	/**
	 * Returns the last day possible of a month.<br>
	 * Year is supposed to NOT be a leap year.<br>.
	 * 
	 * @param month
	 * @return Returns -1 if the input month is invalid.
	 */
	static int getLastDayOfMonth(int month) {
		return getLastDayOfMonth(month, false);
	}
	
	
	/**
	 * Adds the value of "days" to the stored date. <br>
	 * Handles changes in months and years, if needed.
	 * 
	 * @param days
	 * @return
	 */
	boolean addDays(int days) {
		boolean success = false;
		int tempDay, tempMonth, tempYear;
		
		/* Avoid working on invalid dates.*/
		if ( !(isDateValid(this) ) ) {
			success = false;
		} else {
			if (days < 0) {
				return subtractDays( - days );
			} else {
				tempMonth = getMonth();
				tempYear = getYear();
				tempDay = getDay() + days;
				
				// Add days. Change month and year accordingly.
				while (tempDay > getLastDayOfMonth(tempMonth,
												   isLeapYear(tempYear) ) ) {
					tempDay = tempDay - getLastDayOfMonth(tempMonth,
														  isLeapYear(tempYear) );
					tempMonth++;
					if( tempMonth > 12 ) {
						tempYear++;
						tempMonth = 1;
						}
				}
				
				// Check if new date is valid.
				if( isDateValid(tempDay, tempMonth, tempYear) ) {
					success = true;
					setDate(tempDay, tempMonth, tempYear);
				} else {
					success = false;
				}
				
			}
		}
		return success;
	}
	
	
	/**
	 * Adds 1 day to the stored date. <br>
	 * Handles changes in months and years, if needed.
	 * @return
	 */
	boolean addDay() {
		return addDays(1);
	}
	
	
	/**
	 * Subtracts the value of "days" to the stored date. <br>
	 * Handles changes in months and years, if needed.
	 * 
	 * @param days
	 * @return
	 */
	boolean subtractDays(int days) {
		boolean success = false;
		int tempDay, tempMonth, tempYear;
		
		/* Avoid working on invalid dates.*/
		if ( !(isDateValid(getDay(), getMonth(), getYear() ) ) ) {
			success = false;
		} else {
			if (days < 0) {
				return addDays( - days );
			} else {
				tempMonth = getMonth();
				tempYear = getYear();
				tempDay = getDay();
				
				// Subtract days. Change month and year accordingly.
				while ( (tempDay - days) < 1 ) {
					days = days - tempDay;
					tempDay = getLastDayOfMonth(tempMonth, isLeapYear(tempYear));
					tempMonth--;
					if( tempMonth < 1 ) {
						tempYear--;
						tempMonth = 12;
						}
					tempDay = getLastDayOfMonth(tempMonth, isLeapYear(tempYear));
				}
				tempDay = tempDay - days;
				
				// Check if new date is valid.
				if( isDateValid(tempDay, tempMonth, tempYear) ) {
					success = true;
					setDate(tempDay, tempMonth, tempYear);
				} else {
					success = false;
				}
			}	
		}
		return success;
	}
	
	
	/**
	 * Subtracts 1 day to the stored date. <br>
	 * Handles changes in months and years, if needed. 
	 * @return
	 */
	boolean subtractDay() {
		return subtractDays(1);
	}
	
	
	/**
	 * Compares 2 dates and returns <CODE>true</CODE> if the first Date is 
	 * bigger(later).<br>
	 * It returns <CODE>false</CODE> too if both Dates are exactly the same!
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	static boolean isBiggerThan(Date firstDate, Date secondDate) {
		boolean firstBigger = false;
			
		if ( firstDate.getYear() != secondDate.getYear() ) {
			
			if ( firstDate.getYear() > secondDate.getYear() ) {
				firstBigger = true;
			} else { firstBigger = false; }
			
		} else if ( firstDate.getMonth() != secondDate.getMonth() ) {
			
			if ( firstDate.getMonth() > secondDate.getMonth() ) {
				firstBigger = true;
			} else { firstBigger = false; }				
		
		} else {
			
			if ( firstDate.getDay() > secondDate.getDay() ) {
				firstBigger = true;
			} else { firstBigger = false; }	
			
		}
			
		return firstBigger;
	}
	
	
	/**
	 * Compares stored date with input date. <br>
	 * Returns <CODE>true</CODE> if the input Date is bigger(later).<br>
	 * It returns <CODE>false</CODE> too if both Dates are exactly the same! 
	 * @param secondDate
	 * @return
	 */
	boolean isBiggerThan(Date secondDate) {
		return isBiggerThan(this, secondDate);
	}
	
	/**
	 * Compares 2 dates and returns <CODE>true</CODE> if dates are the same.<br>
	 * @param firstDate
	 * @param secondDate
	 * @return
	 */
	static boolean areDatesEqual(Date firstDate, Date secondDate){
		
		/*
		 * NOTE: isBiggerThan returns "false" if the 2 inputs are equal,
		 * or when the second input is smaller.
		 * Thus, if both next 2 "isBiggerThan" statements are false together,
		 * then both dates are equal.
		 */
		return  !( isBiggerThan(firstDate, secondDate) )
			 && !( isBiggerThan(secondDate, firstDate) );
	}
	
	/**
	 * Compares stored date to input and returns <CODE>true</CODE> if dates are 
	 * the same.<br>
	 * @param secondDate
	 * @return
	 */
	boolean areDatesEqual(Date secondDate) {
		return areDatesEqual(this, secondDate);
	}

	
	
	/**
	 * Checks if the dateToTest is between or equal to both date limits given as 
	 * input.<br>
	 * Order of limits doesn't matter.
	 * @param dateToTest
	 * @param firstLimit
	 * @param secondLimit
	 * @return
	 */
	static boolean isBetween2Dates(Date dateToTest, Date firstLimit,
								   Date secondLimit) {
		boolean dateIsBetween = false;
		boolean dateIsBiggerOrEqualToFirst, dateIsLowerOrEqualToSecond;
		
		/*
		 * First limit shouldn't be bigger. If it is, restart the method with 
		 * limits switched.
		 */
		if ( isBiggerThan(firstLimit, secondLimit) ) {
			dateIsBetween = isBetween2Dates(dateToTest, secondLimit, firstLimit);
		} else {
			
			/*
			 * Check dateToTest is bigger or equal to first limit.
			 * 				""	is lower or equals to second limit.
			 */
			dateIsBiggerOrEqualToFirst = ( isBiggerThan(dateToTest, firstLimit) )
									  || ( areDatesEqual(dateToTest, firstLimit) );
			dateIsLowerOrEqualToSecond = ( !(isBiggerThan(dateToTest, secondLimit) ) )
									  || ( areDatesEqual(dateToTest, secondLimit) );
			
			if ( dateIsBiggerOrEqualToFirst && dateIsLowerOrEqualToSecond ) {
				dateIsBetween = true;
			} else { dateIsBetween = false; }
			
		}
		
		return dateIsBetween;
	}
	
	
	/**
	 * Checks if the stored date is between or equal to both date limits given 
	 * as input.<br>
	 * Order of limits doesn't matter.
	 * @param firstLimit
	 * @param secondLimit
	 * @return
	 */
	boolean isBetween2Dates(Date firstLimit, Date secondLimit) {
		return isBetween2Dates(this, firstLimit, secondLimit);
	}
	
	
	/**
	 * Copies stored date into the target Date object.
	 * @param targetDate
	 * @return
	 */
	boolean copyDateTo(Date targetDate) {
		boolean success = false;
		
		if ( !(isDateValid() ) ) {
			success = false;
		} else {
			targetDate.setDate(getDay(), getMonth(), getYear() );
			success = true;
		}
		
		return success;
	}
	
	
	/**
	 * Copies the values from input Date into stored Date.. 
	 * @param sourceDate
	 * @return
	 */
	boolean copyDateFrom(Date sourceDate)  {
		return sourceDate.copyDateTo(this);
	}
	
	
	/**
	 * Asks user for a Date until a valid date is inputed. <br>
	 * Stores that date in object.
	 */
	void askUserForDate(Scanner scanner) {
//		Scanner scanner = new Scanner(System.in); /*Warnings about "scanner" not getting closed*/
		int tempDay = 0, tempMonth = 0, tempYear = 0;
		
		do {
			System.out.println("Type in a date: (format DD/MM/YYYY)");
			System.out.println("Day:");
			tempDay = scanner.nextInt();
			System.out.println("Month:");
			tempMonth = scanner.nextInt();
			System.out.println("Year:");
			tempYear = scanner.nextInt();
		} while ( !(isDateValid(tempDay, tempMonth, tempYear) ) );
		
		setDate(tempDay, tempMonth, tempYear);
		
//		scanner.close();  /* Fatal error if used a second time!!*/
	}
}