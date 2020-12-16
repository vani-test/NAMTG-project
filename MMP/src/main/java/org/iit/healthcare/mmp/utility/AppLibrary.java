package org.iit.healthcare.mmp.utility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AppLibrary {
	public static String selectFutureDate(int days)
	{
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		Date date = cal.getTime();
       System.out.println(date);
       
       SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
	public String[][] readXLS(String fileName)
	{
		
		return new String[10][10];
	}
	public String[][] readXLSX(String fileName)
	{
		return new String[10][10];
	}
	
	
}
