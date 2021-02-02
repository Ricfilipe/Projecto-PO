package pex.core;

public abstract class Literal extends Expression{

	public Literal evaluate(){
		return this;
	}
	public void acceptVisitor(Visitor visitor){
		visitor.visit(this);
	}
	public abstract String toString();
}