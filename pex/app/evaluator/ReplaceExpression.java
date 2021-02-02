package pex.app.evaluator;

import pex.parser.ParserException;

import pex.app.BadExpressionException;
import pex.app.BadPositionException;

import pex.core.Program;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Replace expression in program.
 */
public class ReplaceExpression extends ProgramCommand {
    /**
     * @param receiver
     */
    public ReplaceExpression(Program receiver) {
        super(Label.REPLACE_EXPRESSION, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws BadExpressionException, BadPositionException {
        Form f= new Form ();
        InputInteger i= new InputInteger (f, Message.requestPosition());
        InputString s= new InputString(f, Message.requestExpression());
        f.parse();
        try{
            entity().replace(i.value(),s.value());
        }catch(IndexOutOfBoundsException e){
            throw new BadPositionException(i.value());
        }catch(ParserException e){
            throw new BadExpressionException(s.value());
        }
    }
}
