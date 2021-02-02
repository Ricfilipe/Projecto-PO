package pex.core;
import pex.core.Program;

public class Identifier extends Expression{

	private String _name; 
	private Program _program;

	public Identifier(String name, Program program){
		_program=program;
		_name=name;
	}

	public String getAsText(){
		return _name;
	}

	public String getName(){
		return _name;
	}

	public Literal evaluate(){
		return _program.getIdentifierValue(this);
	}
	public void acceptVisitor(Visitor visitor){
		visitor.visit(this);
	}
}