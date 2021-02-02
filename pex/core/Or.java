package pex.core;
public class Or	extends BinaryExpression{

	public Or(Expression firstArgument, Expression secondArgument){
		super(firstArgument,secondArgument);
	}

	protected String getOperation(){
		return "or";
	}
	public Literal evaluate(){

		if(((IntegerLiteral)(getFirstArgument().evaluate())).intValue()!=0 || ((IntegerLiteral)(getSecondArgument().evaluate())).intValue()!=0)
			return new IntegerLiteral (1);
		return new IntegerLiteral(0);
	}
}