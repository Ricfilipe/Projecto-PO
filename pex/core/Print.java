package pex.core;
import pex.app.App;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Print	extends VariadExpression{

private  Interpreter _interpreter;

	public Print(ArrayList<Expression> argument, Interpreter interpreter){
		super(argument);
		_interpreter=interpreter;
	}

	protected String getOperation(){
		return "print";
	}

	public Literal evaluate(){
		Literal arg = null;
		String text = new String();
		for(Expression argument:getArgument()){
			arg = argument.evaluate();
			text = text + arg.toString();
		}
		_interpreter.getAppIO().println(text);
		return arg;
	}
}