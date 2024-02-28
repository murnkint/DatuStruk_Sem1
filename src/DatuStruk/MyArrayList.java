package DatuStruk;

import java.util.ArrayList;

public class MyArrayList {
	
	private int[] list;
	private final int  LIST_DEFAULT_SITE = 10;
	private int size = LIST_DEFAULT_SITE;
	private int counter = 0;
	
	//TODO
	//constructor
	public MyArrayList() {
		list = new int[size];
	}
	
	public MyArrayList(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		list = new int[size];
	}
	
	//isEmpty
	public boolean isEmpty() {
		//1. long if-else
		/*if(counter == 0)
			return true;
		else
			return false;
		*/
		//2.short if-else
		//return (counter == 0)? true : false;
		//3.
		return (counter == 0);
	}
	//isFull
	public boolean isFull() {
		return (counter == size);
	}
	//howManyElements
	public int howManyElements() {
		return counter;
	}
	//TODO
	//1. funkcijas dekleracija
	private void resize() {
	//3. aprēķināt newSize
		int newSize = (counter <= 100)? size * 2 :(int)(size * 1.5);
	//4. izveidot listNew ar  newSize izmeru
		int[] listNew = new int [newSize];
	//5. veikt kopēšanas no vecā masīva uz jauno
		for (int i = 0; i < size; i++) {
			listNew[i] = list[i];
		}
		
	//6. nomainām list referenci uz lisNew
		list =listNew;
	//7. izsaukt Gribage Collector
		System.gc();
	//8. size naomainām uz newSize
		size = newSize;
	}
	
	public void add(int el) {
		if(isFull()) resize();
		list[counter++] = el;
	}
	
	public void add(int index, int el) throws Exception{
		if(isFull()) resize();
		if(index < 0 || index > counter) {
			throw new Exception("Kļūda");
		}
		if (index == counter) add(el);
		else {
			for(int i = counter; i > index; i--) {
				list[i] = list[i-1];
			}
			list[index] = el;
			counter++;
		}
	}
	public void remove(int index) throws Exception{
		if(index < 0 || index > counter) {
			throw new Exception("Nav pareizs index");
		}
		if (isEmpty()) throw new Exception("Array is empty and it is not possible to return element");
		
		for(int i = index; i < counter -1; i++) {
			list[i] = list[i+1];
		}
		counter--;
	}
	
	public int get(int index) throws Exception{
		if(index < 0 || index > counter) {
			throw new Exception("Nav pareizs index");
		}
		if (isEmpty()) throw new Exception("Array is empty and it is not possible to return element");
		
		return list[index];
	}
	
	public ArrayList<Integer> search(int el) throws Exception{
		if (isEmpty()) throw new Exception("Array is empty and it is not possible to return element");
		
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		
		for (int i = 0; i < counter; i++) {
			if(list[i] == el) {
				indexes.add(i);
			}
		}
		if(indexes.size() == 0) throw new Exception("Element is not found");
		
		return indexes;
	}
	
	public int[] getNeighbours(int el) throws Exception{
		
		ArrayList<Integer> indexes = search(el);
		
		int neighboursSize = indexes.size();
		
		if((Integer)indexes.get(indexes.size()-1) == (counter -1))
			neighboursSize--;
		int[] neighbours = new int[neighboursSize];
		for (int i = 0; i < neighboursSize; i++) {
			int indexFromSearchTemp = (int)indexes.get(i);
			int indexNeighboursTemp = indexFromSearchTemp+1;
			neighbours[i] = list[indexNeighboursTemp];
			
		}
		return neighbours;
	}
	
	public void print() throws Exception{
		if (isEmpty()) throw new Exception("Array is empty and it is not possible to return element");
		
		for (int i = 0; i < counter; i++) {
			System.out.print(list[i] + " ");
			
		}
		System.out.println();
	}
	
	public void makeEmpty() {
		counter = 0;
		size = LIST_DEFAULT_SITE;
		list = new int[size];
		System.gc();
		
	}
	public void sort() throws Exception{
		if (isEmpty()) throw new Exception("Array is empty");
		for (int i = 0; i < counter; i++) {
			for (int j = 0; j < counter; j++) {
				if(list[i] > list[j]) {
					swap(i, j);
				}
			}	
		}
	}
	
	public void swap(int index1, int index2){
		int tmp = index1;
		index1 = index2;
		index2 = tmp;
	}
	
}

