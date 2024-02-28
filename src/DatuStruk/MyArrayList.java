package DatuStruk;

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
}
