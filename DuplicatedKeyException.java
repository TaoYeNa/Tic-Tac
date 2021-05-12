package cs2210as2;

public class DuplicatedKeyException extends RuntimeException {
	public DuplicatedKeyException(){
		super("the key is already exist");
	}
}
