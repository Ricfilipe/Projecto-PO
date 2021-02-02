package pex.core;


public class ReadI extends CompositeExpression {
	private  Interpreter _interpreter;

	public ReadI(Interpreter interpreter){
		_interpreter=interpreter;
	}

	public String getAsText(){
		return "(readi)";
	}
	public Literal evaluate(){
		return new IntegerLiteral(_interpreter.getAppIO().readInteger());
	}

	public void visitArguments(Visitor visitor){}
}