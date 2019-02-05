/*
 * This program asks for either a file input or a console input and then either converts that input into binary form or decimal form
 * Author: Pranav Sharma
 * Date: 9/13/18
 */

import java.io.File;
import java.util.Scanner;
public class Application {
	
	public Application(){
		Scanner scanner = new Scanner(System.in);
		// asks to enter either a file or an input
		System.out.println("Type \"file\" to enter a file or \"input\" to use the console");
		String input = scanner.nextLine();
		String numberInput = "";
		String answer = "";
		boolean keepGoing = true;
		// checks if file, is so it reads the file and copies it to variable
		// "numberInput", or if its a console input it copies that value to
		// "numberInput"
		if (input.equals("file")) {
			try {
				System.out.println("Enter your file name");
				String fileInput = scanner.nextLine();
				Scanner fileScanner = new Scanner(new File(fileInput));
				numberInput = fileScanner.nextLine();
			} catch (Exception E) {
				System.out.println("File not found");
				keepGoing = false;
			}
		} else if (input.equals("input")) {
			System.out.println("Enter your input");
			numberInput = scanner.nextLine();
		} else {
			System.out.println("Invalid input");
		}
		// only continues program if file was found or console input is valid
		if (keepGoing == true) {
			System.out.println("If you would like to convert from binary to decimal type \"btd\"");
			System.out.println("if you would like to convert from decimal to binary type \"dtb\"");
			input = scanner.nextLine();
			// if user chose to convert from decimal to binary then converts here
			if (input.equals("dtb")) {
				int number = Integer.parseInt(numberInput);
				int power = (int) (Math.log10(number) / Math.log10(2));
				for (int index = power; index >= 0; index--) {
					if ((int) (number / Math.pow(2, index)) == 1) {
						answer = answer + "1";
						number = (int) (number % Math.pow(2, index));
					} else {
						answer = answer + "0";

					}
				}
				// if user chose to convert from binary to decimal then converts here
			} else if (input.equals("btd")) {
				int number = 0;
				int power = 0;
				for (int index = numberInput.length() - 1; index >= 0; index--) {
					if (numberInput.charAt(index) == '1') {
						number = (int) (number + Math.pow(2, power));
					}
					power++;
				}
				answer = Integer.toString(number);
			}
			// prints out converted version
			System.out.println("The converted version is: " + answer);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Application();
	}
}
