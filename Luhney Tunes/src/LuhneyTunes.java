import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LuhneyTunes {
	static int counter123 = 0;
	
	public static void main(String[] args) {
	
// DigitGetterTest:
// System.out.println(digitGetter(987654321, 4));
		
	 readLines("List Of Numbers");
	 System.out.println(counter123 + " of these numbers are valid.");
	}
		
	
	public static void luhneyToons(int[] numbersToEval) {
		int sum = 0;
		for(int i = 0; i < numbersToEval.length; i++) {
			sum += (addDigits(getNewNumberFromArray(doubleEveryOther(addDigitsToArray(numbersToEval[i])))))%10;
		}
		if(sum%10 == 0) {
			System.out.println("Pass");
			
			counter123 ++;
			
		}
		else {
			System.out.println("Fail");
		}
		
		
	}
	
	public static void readLines(String fileName)
	{
		String line = null;

		try
			{
				FileReader fileReader = new FileReader(fileName);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				while ((line = bufferedReader.readLine()) != null)
					{
						
						// luhneyToons(readAndSplit(line));
						easyWay(line);
					}
				bufferedReader.close();
			} catch (FileNotFoundException ex)
			{
				System.out.println("Unable to open file '" + fileName + "'");
			} catch (IOException ex)
			{
				System.out.println("Error reading file '" + fileName + "'");
			}

	}
	
	
	public static void easyWay(String line)
		{
			int[] digits = new int[16];
			int multiplier = 1;
			for( int i = 0; i < digits.length ; i ++) {
				multiplier = 2 / ( i % 2  + 1);
				digits [i] = multiplier * Integer.parseInt(line.substring(i, i + 1));	
				
					
				
			}
			
			
		}


	public static int[] readAndSplit(String line){
	int theLength = 0;
	int i =0;
		while(theLength == 0) {
			if(line.length() <= 8*i) {
			theLength = i;
			}
			i++;
		}
	int[] numbersToEval = new int[theLength];
	for(int j = 0; j < numbersToEval.length; j++) {
		if(j == numbersToEval.length -1) {
			numbersToEval[j] = Integer.parseInt(line.substring(8*j, line.length()));
		}
		else {
		numbersToEval[j] = Integer.parseInt(line.substring(8*j, 8*(j+1)));
				
		}
	}
	
	
	
	return numbersToEval;
	}
	
	
	public static int getNewNumberFromArray(int[] theDigits) {
		int sum = 0;
		int counter = 0;
		for(int i = theDigits.length - 1; i >= 0; i--) {
			sum+= (int) theDigits[i] * Math.pow(10, counter);
			counter++;
		}
		return sum;
	}
	
	public static int[] doubleEveryOther(int[] theDigits) {
		
		for(int i = 0; i < theDigits.length; i = i + 2) {
			theDigits[i] = 2*theDigits[i];
			if(theDigits[i] > 9) {
				theDigits[i] = theDigits[i]%10 + 1;
			}
		}
		return theDigits;
	}
	
	public static int[] addDigitsToArray(long number) {
	int[] theDigits = new int[(int) (Math.log10(number) + 1)];
	for(int i = 1; i <= theDigits.length; i++) {
		theDigits[i - 1] =  (int) digitGetter(number, i);
	} 
	return theDigits;
	}
	
	public static int addDigits(long number) {
		int sum = 0;
		for(int i = 1; i <= Math.log10(number) + 1; i++) {
			sum+= digitGetter(number, i);
		}
		return sum;
	}
	public static long digitGetter(long number, int digitPlace) {
		return (long) ((long)(number%Math.pow(10, (long)(Math.log10(number) + 1 - digitPlace) + 1))/(long)(Math.pow(10, (long)(Math.log10(number) + 1 - digitPlace)))); 
	}

}
