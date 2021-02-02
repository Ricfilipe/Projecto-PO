package pex.app.evaluator;

import pex.parser.ParserException;

import pex.app.BadExpressionException;
import pex.app.BadPositionException;

import pex.core.Program;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Add expression.
 */
public class AddExpression extends ProgramCommand {
    /**
     * @param receiver
     */
    public AddExpression(Program receiver) {
        super(Label.ADD_EXPRESSION, receiver);
    }
    
    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws BadExpressionException, BadPositionException {
        Form f= new Form ();
        InputInteger i= new InputInteger (f, Message.requestPosition());
        InputString s= new InputString(f, Message.requestExpression());
        f.parse();
        try{
        entity().add(i.value(),s.value());
        }catch(IndexOutOfBoundsException e){
            throw new BadPositionException(i.value());
        }catch(ParserException e){
            throw new BadExpressionException(s.value());
        }
    }
}
