package pex.core;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public abstract class Visitor {

	public abstract void visit(CompositeExpression expression);

	public abstract void visit(Literal expression);

	public abstract void visit(Identifier expression);

	public abstract void visit(Set expression);

	public String visitExpressions(List<Expression> expressions, Visitor visitor){
		for(Expression expression:expressions){
			expression.acceptVisitor(visitor);
		}
		return getString();

	}

	protected abstract String getString();
}