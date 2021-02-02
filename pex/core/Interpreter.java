package pex.core;

import pex.AppIO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.TreeMap;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public class Interpreter implements Serializable{

	private Map<String,Program> _programs = new TreeMap<String,Program>() ;
	private Map<String,Literal> _identifiers = new HashMap<String,Literal>();
	private String _fileName;
	private AppIO _appio;

	public Interpreter(AppIO appio){
		_appio=appio;
	}

	public void setIdentifier(Identifier id, Literal value){
		_identifiers.put(id.getName(),value);
	}

	public Literal getIdentifier(Identifier id){
		Literal literal = null;
		literal= _identifiers.get(id.getName());
		if(literal==null){
			_identifiers.put(id.getName(),new IntegerLiteral(0));
			return new IntegerLiteral(0);
		}

		return literal;
	}
	
	public void addProgram(Program newProgram){
		_programs.put(newProgram.getName(),newProgram);

	}
	
	public Program getProgram(String name){
		if(_programs.containsKey(name))
			return _programs.get(name);
		return null;
	}
	public void save(String file) throws IOException {
	 _fileName=file;
	 save();
	}
	public void save() throws IOException {
	  ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(_fileName));
	  out.writeObject(this);
	  out.close();
	}

	public static  Interpreter load(String file) throws IOException, FileNotFoundException{
	  	Interpreter interpreter=null;
	  	try{
	  	ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		interpreter = (Interpreter)in.readObject();
	  	in.close();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	  return interpreter;
	}

	public String getFileName(){
		return _fileName;
	}

	public AppIO getAppIO(){

		return _appio;
	}
}