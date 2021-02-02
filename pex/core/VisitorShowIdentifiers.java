package pex.core;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Comparator;

public class VisitorShowIdentifiers extends Visitor{
	private TreeSet<String> _identifiers = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);

	public void visit(CompositeExpression expression){
		expression.visitArguments(this);
	}
	public void visit(Literal expression){
	}

	public void visit(Identifier expression){
		String identifier=expression.getAsText();
		_identifiers.add(identifier);
	}
	public  void visit(Set expression){
		String identifier= (expression.getFirstArgument().getAsText());
			_identifiers.add(identifier);
		expression.getSecondArgument().acceptVisitor(this);
	}

	protected String getString(){
		String text = new String();
		for(String identifier:_identifiers)
			text= text + identifier + "\n";
		return text;
	}
}