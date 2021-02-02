package pex.core;
public class Gt	extends BinaryExpression{

	public Gt(Expression firstArgument, Expression secondArgument){
		super(firstArgument,secondArgument);
	}

	protected String getOperation(){
		return "gt";
	}
	public Literal evaluate(){

		IntegerLiteral num1= (IntegerLiteral) (getFirstArgument().evaluate());
		IntegerLiteral num2=(IntegerLiteral) (getSecondArgument().evaluate());
		if (num1.intValue() > num2.intValue())
			return new IntegerLiteral (1);
		return new IntegerLiteral (0);
	}
}