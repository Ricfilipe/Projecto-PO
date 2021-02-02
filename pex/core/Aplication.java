package pex.core;

import pex.AppIO;
import java.io.IOException;
import pex.parser.NewParser;
import pex.parser.ParserException;

public class Aplication{
	private Interpreter _interpreter;
	private Boolean _save;
	private AppIO _appio;


	public Aplication(AppIO appio){
		_appio=appio;
		_interpreter = new Interpreter(_appio);
	}

	public void newInterpreter(Interpreter interpreter){
		_interpreter=interpreter;

	}


	public void newInterpreter(){
		_interpreter=new Interpreter(_appio);
		_save = false;
	}

	public void addProgram(Program program){
		_interpreter.addProgram(program);
		_save=false;
	}

	public void addProgram(String name){
		_interpreter.addProgram(new Program(name,_interpreter));
		_save=false;
	}
	
	public Program getProgram(String name){
		return _interpreter.getProgram(name);
	}

	public void saveProgram(String file, Program program) throws IOException {
		program.save(file);
		}

	public void save(String file) throws IOException {
		_interpreter.save(file);
		_save = true;

	}
	public void save() throws IOException{
		_interpreter.save();
		_save=true;
	}

	public void loadProgram(String fileName, String name)throws ParserException{
		try{
		NewParser parser = new NewParser();
        Program program = parser.parseFile(fileName,name,_interpreter);
        addProgram(program);
        }catch (Exception x ){
        	 throw new ParserException() ;
        }
	}
	public Boolean saved (){
		return _save;
	}

	public Boolean hasFileName(){
		return _interpreter.getFileName()!=null;
	}




}