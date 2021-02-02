package pex.core;
import	pex.core.Program;
public class Not	extends UnaryExpression{

	public Not(Expression argument){
		super(argument);
	}

	protected String getOperation(){
		return "not";
	}

	public Literal evaluate(){
		IntegerLiteral num= (IntegerLiteral) (getArgument().evaluate());
		if(num.intValue()== 0)
			return new IntegerLiteral(1);
		return new IntegerLiteral(0);
	}
}