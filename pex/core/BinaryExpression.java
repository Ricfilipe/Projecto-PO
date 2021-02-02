package pex.core;

public abstract class BinaryExpression extends CompositeExpression{
	private Expression _FirstArgument;
	private Expression _SecondArgument;
	public BinaryExpression(Expression first, Expression second){
		_FirstArgument=first;
		_SecondArgument=second;
	}

	public Expression getFirstArgument(){
		return	_FirstArgument;
	}

	public Expression getSecondArgument(){
		return _SecondArgument;
	}
	public String getAsText(){
		return "("+getOperation()+" "+getFirstArgument().getAsText() +" "+getSecondArgument().getAsText() + ")";
	}
	protected abstract String getOperation();

	public void visitArguments(Visitor visitor){
		_FirstArgument.acceptVisitor(visitor);
		_SecondArgument.acceptVisitor(visitor);
	}
}