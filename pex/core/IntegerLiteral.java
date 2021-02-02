package pex.core;

public class IntegerLiteral  extends Literal{

	private int _value;

	public IntegerLiteral( Boolean value){
		if (value)
			_value=1;
		_value=0;
	}

	public IntegerLiteral( int value){
		_value=value;
	}

	public String getAsText(){
		return "" + intValue();
	}

	public int intValue(){
		return _value;
	}
	public String toString(){
		return ""+intValue();
	}
}