package pex.core;
public class While	extends BinaryExpression{

	public While(Expression firstArgument, Expression secondArgument){
		super(firstArgument,secondArgument);
	}

	protected String getOperation(){
		return "While";
	}
	public Literal evaluate(){
		Expression arg1 = getFirstArgument();
		while(((IntegerLiteral)arg1.evaluate()).intValue()!=0){
			getSecondArgument().evaluate();
		}	
		return new IntegerLiteral(0);
	}
}