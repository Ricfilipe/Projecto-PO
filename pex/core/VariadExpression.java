package pex.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class VariadExpression extends CompositeExpression{

	private ArrayList<Expression> _arguments;

	public VariadExpression(ArrayList<Expression> arguments){
		_arguments=arguments;
	}

	public ArrayList<Expression> getArgument(){
		return _arguments;
	}
	public String getAsText(){
		String argumentString = new String();
		for (Expression argument : getArgument()){
			argumentString = argumentString + " " + argument.getAsText();
		}
		return "("+getOperation()+ argumentString + ")";
	}
	protected abstract String getOperation();

	public void visitArguments(Visitor visitor){
		for (Expression argument : getArgument()){
			argument.acceptVisitor(visitor);
		}
	}
}