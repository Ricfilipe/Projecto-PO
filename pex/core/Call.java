package pex.core;
import	pex.core.Program;

public class Call	extends UnaryExpression{

	private Program _program;

	public Call(Expression argument, Program program){
		super(argument);
		_program=program;
	}

	protected String getOperation(){
		return "call";
	}

	public Literal evaluate(){
		StringLiteral stringLiteral = (StringLiteral) (getArgument().evaluate());
		Program callProgram = _program.getProgram(stringLiteral.stringValue());
		try{
			return callProgram.execute();
		}catch (NullPointerException e) {
			return new IntegerLiteral(0);
		}
	}
}