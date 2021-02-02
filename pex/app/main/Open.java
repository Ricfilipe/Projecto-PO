package pex.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import pex.core.Aplication;
import pex.core.Interpreter;
//FIXME import used core classes

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Open existing interpreter.
 */
public class Open extends Command<Aplication> {
    /**
     * @param receiver
     */
    public Open(Aplication receiver) {
        super(Label.OPEN, receiver);
    }

    /** @see pt.tecnico.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
        Form f = new Form();
        InputString fileName = new InputString(f,Message.openFile());
        f.parse();
        try{
            entity().newInterpreter( Interpreter.load(fileName.value()));
            }
            catch(FileNotFoundException x){
                new Display().add(Message.fileNotFound(fileName.value())).display();
            }
            catch (IOException x){
                throw new InvalidOperation();
            }

    }   
}
