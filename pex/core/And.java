package pex.core;

public class And	extends BinaryExpression{

	public And(Expression firstArgument, Expression secondArgument){
		super(firstArgument,secondArgument);
	}

	protected String getOperation(){
		return "and";
	}
	public Literal evaluate(){
		if(((IntegerLiteral)(getFirstArgument().evaluate())).intValue()!=0 && ((IntegerLiteral)(getSecondArgument().evaluate())).intValue()!=0)
			return new IntegerLiteral(1);
		return new IntegerLiteral(0);
	}
}