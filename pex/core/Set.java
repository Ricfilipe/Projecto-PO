package pex.core;

public class Set	extends BinaryExpression{

	private Program _program;

	public Set(Expression firstArgument, Expression secondArgument, Program program){
		super(firstArgument,secondArgument);
		_program=program;
	}

	protected String getOperation(){
		return "set";
	}
	public Literal evaluate(){
		Literal arg2 = getSecondArgument().evaluate();
		_program.setIdentifierValue((Identifier)getFirstArgument(),arg2);
		return arg2;
	}
	public void acceptVisitor(Visitor visitor){
		visitor.visit(this);
	}
}