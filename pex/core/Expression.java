package pex.core;
import java.io.Serializable;

public abstract class Expression implements Serializable{

	public abstract String getAsText();
	public abstract void acceptVisitor(Visitor visitor);
	public abstract Literal evaluate();
}