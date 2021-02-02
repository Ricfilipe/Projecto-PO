package pex.core;

public class Add	extends BinaryExpression{

	public Add(Expression firstArgument, Expression secondArgument){
		super(firstArgument,secondArgument);
	}

	protected String getOperation(){
		return "add";
	}

	public Literal evaluate(){
		IntegerLiteral num1= (IntegerLiteral) (getFirstArgument().evaluate());
		IntegerLiteral num2=(IntegerLiteral) (getSecondArgument().evaluate());
		return new IntegerLiteral(num1.intValue() + num2.intValue());
	}
}