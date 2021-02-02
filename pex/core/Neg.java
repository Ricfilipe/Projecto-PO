package pex.core;
import	pex.core.Program;
public class Neg	extends UnaryExpression{

	public Neg(Expression argument){
		super(argument);
	}

	protected String getOperation(){
		return "neg";
	}

	public Literal evaluate(){
		IntegerLiteral num= (IntegerLiteral) getArgument().evaluate();
		return new IntegerLiteral(-(num.intValue()));
	}
}