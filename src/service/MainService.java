package service;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import DatuStruk.MyArrayList;

public class MainService {

	public static void main(String[] args) {
	
		File file = new File("numbers.txt");
		
		MyArrayList myList = new MyArrayList(0);
		try {
			myList = ReadFromFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		myList.add(100);
		myList.add(200);
		myList.add(-100);
		try {
			myList.print();//100 200 -100
			myList.add(1, 1000);
			myList.print();//100 1000 200 -100
			myList.remove(0);
			myList.print();//1000 200 -100
			myList.add(200);
			myList.add(200);
			myList.print();//1000 200 -100 200 200
			System.out.println(myList.search(200));//1 3 4
			System.out.println(Arrays.toString(myList.getNeighbours(200)));//-100 200
			myList.print();//1000 200 -100 200 200
			myList.sort();
			myList.print();
			
			myList.makeEmpty();
			myList.add(100000);
			myList.print();//100000
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static MyArrayList ReadFromFile(File file) throws Exception{
		Scanner sc = new Scanner(file);
		MyArrayList listFromTextFile = new MyArrayList(0);
		while (sc.hasNextLine()) {
			listFromTextFile.add(Integer.valueOf(sc.nextLine()));
		}
		sc.close();
		return listFromTextFile;
	}

}