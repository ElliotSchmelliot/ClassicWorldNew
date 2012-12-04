package main;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.math.*;

import items.EquipmentSet;

public class TestMain {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
		int x = 1000001;
		int i = 6;
		boolean prime = false;
		//Scanner input = new Scanner (System.in);
		//System.out.println("1\n2\n3\n5");
		for (;;) {
			prime = true;
			i = x / 2;
			while (prime == true && i != 1.0) {
				if (x % i == 0) {
					prime = false;
				} else {
					i--;
				}
			}
			if (prime == true) {
				System.out.println(x);
			}
			if ((x - 3) % 10 == 0) {
				x += 4;
			} else {
				x += 2;
			}
		}
	}
}

