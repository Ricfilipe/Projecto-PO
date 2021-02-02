package pex.core;
public class Ne	extends BinaryExpression{

	public Ne(Expression firstArgument, Expression secondArgument){
		super(firstArgument,secondArgument);
	}

	protected String getOperation(){
		return "ne";
	}
	public Literal evaluate(){
		if(((IntegerLiteral)(getFirstArgument().evaluate())).intValue() != ((IntegerLiteral)(getSecondArgument().evaluate())).intValue())
			return new IntegerLiteral(1);
		return new IntegerLiteral(0);
	}
}