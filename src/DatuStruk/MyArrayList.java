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
		return size;
	}

}
