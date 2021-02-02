package pex.app.main;

import java.io.IOException;

import pex.core.Aplication;
import pex.core.Program;
//FIXME import used core classes
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Write (save) program to file.
 */
public class WriteProgram extends Command<Aplication> {
    /**
     * @param receiver
     */
    public WriteProgram(Aplication receiver) {
        super(Label.WRITE_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
        Form f = new Form();
        InputString name = new InputString(f,Message.requestProgramId());
        InputString fileName = new InputString(f,Message.programFileName());
        f.parse();
        Program program = entity().getProgram(name.value());
        if(program == null)
            new Display().add(Message.noSuchProgram(name.value())).display();
        else{
            try{
                entity().saveProgram(fileName.value(),program);
            }catch(IOException x){
                throw new InvalidOperation();
            }
        }

    }
}
