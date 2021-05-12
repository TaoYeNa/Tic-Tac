package cs2210as2;

import AS42210.InexistentKeyException;

public class Dictionary implements DictionaryADT {
	private LinkedList[] table;
	private int size = 9973;
	public Dictionary(int size) {
		this.size = size;
		table = new LinkedList[size];
		for (int i=0; i<size; i++) {
			table[i] = new LinkedList();
		}
		//create a table by using the linked list
	}
	
	public int hashf(String key) {
		String[]string = key.split("");
		int value = (int)string[0].charAt(0);
		int mod = 17;
		for(int i= 1; i <key.length(); i++){	//polynomial hashing method
			value=((value*mod) + (int)key.charAt(i)) % size;
		}
		return value;
		
	}
	
	public int put(Data record) throws DuplicatedKeyException{
		String key = record.getKey();
		if (get(key) == null) { 
			                               //then this is the first item we gonna add
			table[hashf(key)].add(record);
			return 0;
		}
		if (table[hashf(key)].is_Duplicate(key)) {
			throw new DuplicatedKeyException();
		}
		table[hashf(key)].add(record);
			return 1;
       }
	
	public void remove(String key) throws InexistentKeyException{
		table[hashf(key)].remove(key);
	}
	public Data get(String key) {
		return table[hashf(key)].search(key);
	}
	public int numDataItems() {
		int count =0;
		for (int i=0; i<size; i++) {
			count += table[i].size();
		}
		return count;
	}
}
