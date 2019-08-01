package co.grandcircus;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lab7 {
	
	public static void main(String[] args) {
		//calling methods into main class to run
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter a Valid Name: ");
		scan.nextLine();
		boolean testValidate = validateLetters("jgi");
		System.out.println(testValidate);
		
		System.out.println("Please enter a Valid Email: ");
		scan.nextLine();
		System.out.println(isEmailValid("kevbutler310@gmail.com"));
		
		System.out.println("Please enter a Valid Phone Number: ");
		scan.nextLine();
		System.out.println(isPhoneNumberValid("333-333-3333"));
		
		System.out.println("Please Enter a Valid Date: ");
		scan.nextLine();
		System.out.println((isValidDate("03/10/1991")));
		
	}

	public static boolean validateLetters(String txt) {

	    String regx = "^[a-zA-Z ]+$";
	    Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
	    Matcher matcher = pattern.matcher(txt);
	    return matcher.find();
	    
	}
	/** isEmailValid: Validate email address using Java reg ex.
	* This method checks if the input string is a valid email address.
	* @param email String. Email address to validate
	* @return boolean: true if email address is valid, false otherwise.
	*/
	public static boolean isEmailValid(String email){
	boolean isValid = false;
	/*
	Email format: A valid email address will have following format:
	        [\\w\\.-]+: Begins with word characters, (may include periods and hyphens).
		@: It must have a '@' symbol after initial characters.
		([\\w\\-]+\\.)+: '@' must follow by more alphanumeric characters (may include hyphens.).
	This part must also have a "." to separate domain and subdomain names.
		[A-Z]{2,4}$ : Must end with two to four alphabets.
	(This will allow domain names with 2, 3 and 4 characters e.g pa, com, net, wxyz)
	Examples: Following email addresses will pass validation
	abc@xyz.net; ab.c@tx.gov
	*/
	//Initialize regex for email.
	String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	CharSequence inputStr = email;
	//Make the comparison case-insensitive.
	Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
	Matcher matcher = pattern.matcher(inputStr);
	if(matcher.matches()){
	isValid = true;
	}
	return isValid;
	}
	/** isPhoneNumberValid: Validate phone number using Java reg ex.
	* This method checks if the input string is a valid phone number.
	* @param email String. Phone number to validate
	* @return boolean: true if phone number is valid, false otherwise.
	*/
	public static boolean isPhoneNumberValid(String phoneNumber){
	boolean isValid = false;
	/* Phone Number formats: (nnn)nnn-nnnn; nnnnnnnnnn; nnn-nnn-nnnn
		^\\(? : May start with an option "(" .
		(\\d{3}): Followed by 3 digits.
		\\)? : May have an optional ")" 
		[- ]? : May have an optional "-" after the first 3 digits or after optional ) character. 
		(\\d{3}) : Followed by 3 digits. 
		 [- ]? : May have another optional "-" after numeric digits.
		 (\\d{4})$ : ends with four digits.
	         Examples: Matches following phone numbers:
	         (123)456-7890, 123-456-7890, 1234567890, (123)-456-7890
	*/
	//Initialize reg ex for phone number. 
	String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
	CharSequence inputStr = phoneNumber;
	Pattern pattern = Pattern.compile(expression);
	Matcher matcher = pattern.matcher(inputStr);
	if(matcher.matches()){
	isValid = true;
	}
	return isValid;
	}
	public static boolean isValidDate(String d) 
    { 
        String regex = "^(1[0-2]|0[1-9])/(3[01]"
                       + "|[12][0-9]|0[1-9])/[0-9]{4}$"; 
        Pattern pattern = Pattern.compile(regex); 
        Matcher matcher = pattern.matcher((CharSequence)d); 
        return matcher.matches(); 
    } 
	    
	
}
