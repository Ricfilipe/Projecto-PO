package pex.core;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.io.IOException;
import pex.parser.NewParser;
import pex.parser.ParserException;

/**
 * Classe Programa permite a criacao de programas que sao compostos por um ArrayList
 * de expressoes, o programa pode ser transformado num ficheiro texto que contem as  
 * expressoes que o compõem e pode ser executado, avaliando as expressões
 * 
 * 
 * @author Grupo 53, Ricardo Filipe e José Costa
 */

public class Program implements Serializable{

	 /**
	 * Interpretador responsavel por este programa.
	 */
	private Interpreter _interpreter;

	/** Program name. */
	private String _name;

	/** Expressions. */
	private List<Expression> _expressions;

	 /**
	 * Constructor.
	 * 
	 * @param name
	 *            Program name.
	 * @param interpreter
	 *             Interpretador responsavel pelo programa.
	 */

	public Program(String name,Interpreter interpreter){
		_name = name;
		_interpreter = interpreter;
		_expressions = new ArrayList<Expression>();
	}

	 /**
	 * Adiciona uma expressao na posicao referida no programa 
	 * a e verifica se a expressao e possivel, caso a posicao for igual ao
	 * numero de expressoes ela e inserida no fim. Se a expressao invalida vai 
	 * lançar a excepcao ParserException e se a posicao inserida nao existir vai ser 
	 * lancada IndexOutOfBoundsException.
	 * 
	 * @param idx
	 *            a posicao em que ela vai ser posicionada.
	 * @param expression
	 *            a expressao que vai ser adicionada.
	 *
	 * @throws ParserException a expressao invalida
	 *
	 * @throws IndexOutOfBoundsException posicao inserida nao existe
	 */

	public void add (int idx, String expression)throws IndexOutOfBoundsException, ParserException{
		_expressions.add(idx,new NewParser().parseString(expression,this, _interpreter));
	}

	 /**
	 * Troca a expressao numa posicao dada com uma expressao dada tambem 
	 * a e verifica se a expressao e possivel. Se a expressao nao for 
	 * invalida vai lançar a excepcao ParserException e se a posicao 
	 * inserida nao fizer sentido vai ser lancada IndexOutOfBoundsException.
	 * 
	 * @param idx
	 *            a posicao da expressao que vai ser trocada.
	 * @param expression
	 *            a expressao que vai ser inserida.
	 *
	 * @throws ParserException a expressao invalida
	 *
	 * @throws IndexOutOfBoundsException posicao inserida nao existe
	 */

	public void replace(int idx, String expression)throws IndexOutOfBoundsException, ParserException{
		_expressions.set(idx,new NewParser().parseString(expression,this,_interpreter));
	}


	/**
	 * Associa uma expressao Literal ao Identifier, isto associacao e valida
	 * para todos os programas que se econtram no mesmo interpretador.
	 * 
	 * @param id
	 *            Identifier
	 * @param value
	 *            a expressao que vai ser associada ao Identifier.
	 *
	 */

	public void setIdentifierValue(Identifier id, Literal value){
		_interpreter.setIdentifier(id,value);
	}

	 /**
	 * Devolve o valor associado ao Identifier do Programa, 
	 * caso ele nao esteja associado a nenhum valor o seu valor e 0.
	 *
	 * 
	 * @param id
	 *            Identifier.
	 *
	 * @return a expressao associada ao Identifier
	 */

	public Literal getIdentifierValue(Identifier id){
		return _interpreter.getIdentifier(id);
	}

	 /**
	 * Executa o programa, avalia todas as expressoes e devolve o resultado
	 * da ultima avaliacao do programa.
	 *
	 * Se a expressao no tempo de execução for incorrecta e lancada uma excepcao ClassCastException.
	 *
	 * @throws ClassCastException
	 *
	 * @return resultado da ultima expressao
	 */

	public Literal execute(){
		Literal literal = null;
		for(Expression expression:_expressions)
			literal = expression.evaluate();
		return literal;
	}

	 /**
	 * Insere um conjunto de expressoes no final do programa.
	 * 
	 * @param expressions
	 *            uma conjunto de expressoes
	 *
	 */

	public void set(Collection<Expression> expressions){
		_expressions.addAll(expressions);
	}

	 /**
	 * Transforma todas expressoes do programa numa String que os compoem.
	 *
	 *@return String com todas expressoes do programa.
	 */

	public String getAsText(){
		Visitor visitor = new VisitorShowProgram();
		return visitor.visitExpressions(_expressions,visitor);
	}

	 /**
	 * Procura um programa, que tenha o mesmo interpretador responsavel, 
	 * com um certo nome.
	 * 
	 * @param name
	 *            nome de um Programa.
	 *
	 * @return Caso exista um programa com aquele devolve o programa, caso contrario null.
	 */

	public Program getProgram(String name){
		return _interpreter.getProgram(name);
	}

	 /**
	 * Retorna o nome do Programa.
	 * a e verifica se a expressao e possivel.
	 * 
	 * @return nome do programa
	 *			
	 */

	protected String getName(){
		return _name;
	}

	 /**
	 * Guarda as expressoes que compoem o programa num ficheiro texto.
	 *
	 * 
	 * @param fileName
	 *            nome do ficheiro que vai ser criado
	 *
	 * @throws IOException caso aconteca um erro ao guardar o ficheiro.
	 */

	public void save(String fileName) throws IOException {
		FileOutputStream out = new FileOutputStream(fileName);
        OutputStreamWriter osw = new OutputStreamWriter(out);
        osw.write(this.getAsText());
     	osw.close();
	}

	 /**
	 * Retorna uma String com o todos os Identificadores no Programa.
	 * A String contem um Identificador por linha e por ordem alfabetica.
	 * 
	 * @return String com os Identificadores
	 *			
	 */

	public String showIdentifiers(){
		Visitor visitor =new VisitorShowIdentifiers();
		return visitor.visitExpressions(_expressions,visitor);
	}


	 /**
	 * Retorna uma String com os Identificadores não definidos no Programa.
	 * A String contem um Identificador por linha e por ordem alfabetica.
	 * 
	 * @return String com os Identificadores não definidos
	 *			
	 */

	public String showIdentifiersUndefined(){
		Visitor visitor = new VisitorsShowIdentifiersUndefined();
		return visitor.visitExpressions(_expressions,visitor);
	}
}
