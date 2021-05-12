package cs2210as2;

public class LinkedNode {
	LinkedNode next;
	LinkedNode previous;
	Data code;

	public LinkedNode(Data code) { //construct the node
	this.code = code;
	next = null;
}
	public LinkedNode getNext(){ //getter method
	return next;
}
	public Data getCode(){
	return code;
}
	public void setNext(LinkedNode next_A){
	next=next_A;
}
	public void setPrev(LinkedNode prev_A){
	previous = prev_A;	
	}
	public LinkedNode getPrev(){ //getter method
	return previous;
	}
	public void set_entry(Data code_1){ // set the entry 
	code = code_1;
}
}