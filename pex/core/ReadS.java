package pex.core;

public class ReadS extends CompositeExpression {

	private  Interpreter _interpreter;

	public ReadS(Interpreter interpreter){
		_interpreter=interpreter;
	}

	public String getAsText(){
		return "(reads)";
	}
	public Literal evaluate(){
		return new StringLiteral(_interpreter.getAppIO().readString());
	}
	public void visitArguments(Visitor visitor){}
}