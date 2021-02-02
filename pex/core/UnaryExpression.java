package pex.core;

public abstract class UnaryExpression extends CompositeExpression{
	private Expression _argument;

	public UnaryExpression(Expression argument){
		_argument=argument;
	}

	protected Expression getArgument(){
		return _argument;
	}

	public String getAsText(){
		return "("+getOperation()+" "+getArgument().getAsText() + ")";
	}
	protected abstract String getOperation();

	public void visitArguments(Visitor visitor){
		_argument.acceptVisitor(visitor);
	}
}