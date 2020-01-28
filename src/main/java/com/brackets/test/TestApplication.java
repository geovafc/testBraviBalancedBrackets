package com.brackets.test;

import org.apache.logging.log4j.util.Strings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
		CheckBrackets application = new CheckBrackets();
		int finish = 1;
		while (finish==1){
			Scanner read = new Scanner(System.in);
			String breackets;
			System.out.println("Enter a sequence of brackets: ");
			breackets = read.nextLine();
			System.out.println(application.checkIfbracketsIsValid(breackets));
			System.out.println("1 to continue and 0 to end the program: ");
			finish = read.nextInt();

		}


	}

}
