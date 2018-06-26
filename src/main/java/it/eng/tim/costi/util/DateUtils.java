package it.eng.tim.costi.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import it.eng.tim.costi.model.web.PeriodType;

public class DateUtils {

	 //public static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
	 //public static final SimpleDateFormat datePresentationFormatter = new SimpleDateFormat("dd/MM/yy");
	 
	 public static DateRange getDateRange(String period) {
		 
		 SimpleDateFormat datePresentationFormatter = new SimpleDateFormat("dd/MM/yy");
		 SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		 
		 DateRange range = new DateRange();
		 String startNPATDate = "";
		 String endNPATDate = "";
		 
		 String startPresentationDate = "";
		 String endPresentationDate = "";
		 
		 
		 GregorianCalendar now = new GregorianCalendar();
		 LocalDateTime bankAuthDate = LocalDateTime.now();
		 
		 if(period.equals(PeriodType.PROF10.toString())) {
			 //7 giorni
			 endNPATDate = dateFormatter.format(now.getTime());
			 endPresentationDate = datePresentationFormatter.format(now.getTime());
			 
			 now.add(Calendar.DATE, -7);
			 startNPATDate = dateFormatter.format(now.getTime());
			 startPresentationDate = datePresentationFormatter.format(now.getTime());
		 }
		 else if(period.equals(PeriodType.PROF11.toString())) {
			 //30 giorni
			 endNPATDate = dateFormatter.format(now.getTime());
			 endPresentationDate = datePresentationFormatter.format(now.getTime());
			 
			 now.add(Calendar.DATE, -30);
			 startNPATDate = dateFormatter.format(now.getTime());
			 startPresentationDate = datePresentationFormatter.format(now.getTime());
	 
		 }
		 else {
			 //mese precedente  TBD

			 endNPATDate = dateFormatter.format(now.getTime());
			 endPresentationDate = datePresentationFormatter.format(now.getTime());
			 
			 now.add(Calendar.DATE, -30);
			 startNPATDate = dateFormatter.format(now.getTime());
			 startPresentationDate = datePresentationFormatter.format(now.getTime());
		 }
		 
		 range.setStartNPATDate(startNPATDate);
		 range.setEndNPATDate(endNPATDate);
		 range.setEndPresentationDate(endPresentationDate);
		 range.setStartPresentationDate(startPresentationDate);
		 
		 return range;
		 
		 
	 }
	 
	 
	 
	 public static void main(String[] args) {
		 DateRange range = getDateRange("PROF10");
		 System.out.println("Date Range: " + range);
		 
		 DateRange range2 = getDateRange("PROF11");
		 System.out.println("Date Range2: " + range2);
		 
		 
	}
}
