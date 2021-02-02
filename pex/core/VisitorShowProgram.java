package pex.core;


public class VisitorShowProgram extends Visitor{
	private String _textProgram = new String();

	public void visit (CompositeExpression expression){
		_textProgram = _textProgram + expression.getAsText()+"\n";
	}
	public void visit(Literal expression){
		_textProgram = _textProgram + expression.getAsText()+"\n";
	}
	public void visit(Identifier expression){
		_textProgram = _textProgram + expression.getAsText()+"\n";
	}
	public void visit(Set expression){
		visit((CompositeExpression)expression);
	}
	protected String getString(){
		return _textProgram;
	}

}