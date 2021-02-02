package pex.core;
import java.util.ArrayList;

public class Seq	extends VariadExpression{

	public Seq(ArrayList<Expression> arguments){
		super(arguments);
	}

	protected String getOperation(){
		return "seq";
	}
	public Literal evaluate(){
		Literal arg=null;
		for(Expression argument:getArgument())
			arg=argument.evaluate();
		return arg;
	}
}

