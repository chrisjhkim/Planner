package planner.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import planner.entity.TimerDetailHistory;

public class PlannerTestUtil {
	private static final String FILE_NAME = "detailId";
	public static void saveToFile(String input) {
		try {
//			File myObj = new File("filename.txt");
			FileWriter myWriter = new FileWriter(FILE_NAME);
			myWriter.write(input);
			myWriter.close();
			System.out.println("Successfully wrote to the file. " + input);
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
	}
	
	public static String readFile() {
		try {
			File myObj = new File(FILE_NAME);
			Scanner myReader = new Scanner(myObj);
			String result = null;
			while (myReader.hasNextLine()) {
				result = myReader.nextLine();
			}
			myReader.close();
			return result;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
			return null;
		}
	}

	public static void saveDetailId(TimerDetailHistory detail) {
		saveToFile(String.valueOf(detail.getId()));
	}
	public static Integer getDetailIdFromFile() {
		return Integer.parseInt(readFile());
	}
}

