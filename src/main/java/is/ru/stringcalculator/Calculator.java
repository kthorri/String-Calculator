package is.ru.stringcalculator;

import java.util.*;

public class Calculator {

	public static int add(String text){
		String num = text;
		if (text.contains("//")) {
			num = convertDelimiters(text);
		}
		if(num.equals("")){
			return 0;
		}
		else if(num.contains(",") | num.contains("\n")){
			return sum(splitNumbers(num));
		}
		else
			return 1;
	}

	private static String convertDelimiters(String original) {
		char[] str = original.toCharArray();
		char[] shorterstr = new char[str.length-4];
		char delim = str[2];
		for (int i = 4; i < str.length; i++) {
			if (delim == str[i]) {
				str[i] = ',';
			}
			shorterstr[i-4] = str[i];
		}
		return String.valueOf(shorterstr);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		return numbers.split(",|\n");
	}
      
  private static int sum(String[] numbers){
 	  int total = 0;
 	  ArrayList<Integer> negatives = new ArrayList<Integer>();
    for(String number : numbers){
    	Integer n = toInt(number);
    	if (n < 0) {
    		negatives.add(n);
    	}
    	else if (n <= 1000) {
    		total += toInt(number);
    	}
		}
		if (!negatives.isEmpty()) {
			String negs = negatives.toString();
			negs = negs.substring(1, negs.length() - 1);
			throw new RuntimeException("Negatives not allowed: " + negs);
		}
		return total;
  }
}