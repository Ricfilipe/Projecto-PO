package pex.core;

public class Mod	extends BinaryExpression{

	public Mod(Expression firstArgument, Expression secondArgument){
		super(firstArgument,secondArgument);
	}

	protected String getOperation(){
		return "mod";
	}

	public Literal evaluate(){
		IntegerLiteral num1= (IntegerLiteral) (getFirstArgument().evaluate());
		IntegerLiteral num2=(IntegerLiteral) (getSecondArgument().evaluate());
		return new IntegerLiteral(num1.intValue() %num2.intValue());
	}
}