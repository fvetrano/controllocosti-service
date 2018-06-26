package it.eng.tim.costi.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class FormatterUtils {

	private static DecimalFormat df = new DecimalFormat("#.00", new DecimalFormatSymbols(Locale.ITALIAN)); 
	
	
	
	public static String formatCurrency(double number) {
		String resp = ""+number;
		
		resp = df.format(number);
		
		return resp;
		
	}

	public static String formatCurrency(int number) {
		String resp = ""+number;
		resp = df.format(number);
		
		return resp;
	}

	
	public static void main(String[] args) {
		String v1 = formatCurrency(12);
		System.out.println("v1 = ["+v1+"]");
		
		String v2 = formatCurrency(11.59);
		System.out.println("v2 = ["+v2+"]");

		String v3 = formatCurrency(10.3);
		System.out.println("v3 = ["+v3+"]");
		
		String v4 = formatCurrency(12.0);
		System.out.println("v4 = ["+v4+"]");
		
	}
	
}
