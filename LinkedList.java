package cs2210as2;

import AS42210.InexistentKeyException;

public class LinkedList {
	private int size;
	private LinkedNode head;
	private LinkedNode end;
	
	public LinkedList() {  //constructor
		head = null;
		size = 0;
		end = null;
		
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public Data search(String key) {
		LinkedNode curr;
		curr = head;
		if(size == 0) {
			return null;
		}
		while(curr.getNext() != null) {
			if(curr.getCode().getKey().equals(key)) {
				return curr.getCode();
			}
			curr = curr.getNext();
		}
		if(curr.getNext() ==null &&curr.getCode().getKey().equals(key)) {
			return curr.getCode(); //if what we want find is the last in the list
		}
		return null;
	}
	
	public void add(Data item ) {
		LinkedNode h = new LinkedNode(item);
		if(size!= 0) {	  //when there is more than 1 item in the linked list
			h.setPrev(end);
			h.setNext(null);
			end.setNext(h);
			end = h;
		}
		else {     //when there is nothing in the linked list
			h.setNext(null);
			h.setPrev(null);
			head = h;
			end = h;
		}
		size++;
	}
	public void remove(String key) throws InexistentKeyException {
		LinkedNode curr;
		curr = head;
		if(size == 0) { // if the list is empty
			throw new InexistentKeyException();
		}
		if(size == 1) { // if only one item in the list
			head = null;
			end =null;
			size =0;
			return;
		}
		if(curr.getCode().getKey().equals(key)) { //if item we want remove is the head
			head = head.getNext();
			head.setPrev(null);
			size--;
			return;
		}
		else {    //the item we want remove was in the some place in the list
			while(curr.getNext()!= null) {
				if(curr.getCode().getKey().equals(key)) {
					curr.getPrev().setNext(curr.getNext());
					curr.getNext().setPrev(curr.getPrev());
					break;
				}
				curr = curr.getNext();
			}
		}
		if(curr.getNext() ==null &&curr.getCode().getKey().equals(key) ) {
			end.getPrev().setNext(null);
			end = end.getPrev();
		}    // if the one we moved is the last one in the linked list
		else{
			throw new InexistentKeyException(); //if there's no certain key in the list
		}
		size--;
		
	}
	public int size() {
		return size;
	}
	public boolean is_Duplicate(String key) {
		LinkedNode curr;
		curr = head;
		while(curr.getNext()!= null) {
			if(curr.getCode().getKey().equals(key)) {
				return true;
			}
			curr = curr.getNext();
		}
		if(curr.getCode().getKey().equals(key) ) {
			return true;
		}
		return false;
	}
	
	
	
}
