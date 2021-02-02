package pex.core;

public abstract class TernaryExpression extends CompositeExpression {
	private	Expression _FirstArgument;
	private	Expression _SecondArgument;
	private	Expression _ThirdArgument;

	public TernaryExpression(Expression first, Expression second, Expression thrid){
		_FirstArgument=first;
		_SecondArgument=second;
		_ThirdArgument=thrid;
	}
	public  Expression getFirstArgument(){
			return _FirstArgument;
	}
	public Expression getSecondArgument(){
			return _SecondArgument;
	}
	public Expression getThirdArgument(){
			return _ThirdArgument;
	}
	public String getAsText(){
		return "("+getOperation()+" "+getFirstArgument().getAsText() +" "+getSecondArgument().getAsText() +" "+getThirdArgument().getAsText() + ")";
	}
	protected abstract String getOperation();

	public void visitArguments(Visitor visitor){
		_FirstArgument.acceptVisitor(visitor);
		_SecondArgument.acceptVisitor(visitor);
		_ThirdArgument.acceptVisitor(visitor);
	}
}