package main;

import java.util.Scanner;

public class General {
	public void printFile(String intro, String fileName, Scanner input) {
		
	}
	
	public static int roundUp(double x) {
		if (x % 1 == 0) {
			return (int)x;
		} else {
			return (int)(x + 1);
		}
	}
}
