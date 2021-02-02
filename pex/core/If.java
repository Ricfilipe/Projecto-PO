package pex.core;
public class If	extends TernaryExpression{

	public If(Expression firstArgument, Expression secondArgument, Expression thridArgument){
		super(firstArgument,secondArgument,thridArgument);
	}

	protected String getOperation(){
		return "if";
	}
	public	Literal evaluate(){

		if(((IntegerLiteral)(getFirstArgument().evaluate())).intValue()!=0)
			return getSecondArgument().evaluate();
		return getThirdArgument().evaluate();
	}
}
