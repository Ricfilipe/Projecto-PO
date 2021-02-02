package pex.core;

public class StringLiteral extends Literal {

	private String _value;

	public StringLiteral(String value){
		_value=value;
	}
	public  String getAsText(){
		return '"'+ stringValue() + '"';
	}

	public String stringValue(){
		return _value;
	}
	public String toString(){
		return stringValue();
	}
}