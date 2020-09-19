package supermarket__billing.exception;

public class CartDoesNotContainParticularItem extends RuntimeException{
	public CartDoesNotContainParticularItem(String message)
	{
		super(message);
	}
}
