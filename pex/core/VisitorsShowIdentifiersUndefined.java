package pex.core;
import java.util.Collections;
import java.util.TreeSet;
import java.util.Comparator;

public class VisitorsShowIdentifiersUndefined extends Visitor{
	private TreeSet<String> _identifiersUndefined = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	private TreeSet<String> _identifiersDefined = new TreeSet<String>();

	public void visit(CompositeExpression expression){
		expression.visitArguments(this);
	}
	public void visit(Literal expression){
	}

	public void visit(Identifier expression){
		String identifier=expression.getAsText();
		if(! _identifiersDefined.contains(identifier)){
			_identifiersUndefined.add(identifier);
		}
	}
	public void visit(Set expression){
		String identifier=expression.getFirstArgument().getAsText();
		_identifiersDefined.add(identifier);
		_identifiersUndefined.remove(identifier);
		expression.getSecondArgument().acceptVisitor(this);
		}
	protected String getString(){
		String text = new String();
		for(String identifier:_identifiersUndefined)
			text= text + identifier + "\n";
		return text;
	}
}