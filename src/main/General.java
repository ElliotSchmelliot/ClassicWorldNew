package main;

import java.util.List;
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

	public static void printList(List list) {
		for (int i = 1; i <= list.size(); i++) {
			System.out.println(i + ") " + list.get(i - 1));
		}
	}

}
