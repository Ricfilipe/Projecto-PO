package pex.core;

public abstract class CompositeExpression extends Expression{

	public void acceptVisitor(Visitor visitor){
		visitor.visit(this);
	}
	public abstract void visitArguments(Visitor visitor);
}