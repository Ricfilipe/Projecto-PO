package pex.app.main;

import pex.core.Aplication;
import pex.core.Program;
import pex.parser.ParserException;
import pex.app.BadSourceFileException;
//FIXME import used core classes
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Read existing program.
 */
public class ReadProgram extends Command<Aplication> {
    /**
     * @param receiver
     */
    public ReadProgram(Aplication receiver) {
        super(Label.READ_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute()throws BadSourceFileException{
        Form f = new Form();
        InputString name = new InputString(f,Message.programFileName());
        f.parse();
        try{
        entity().loadProgram(name.value(),name.value());
        }catch(ParserException x)
        {
            throw new BadSourceFileException(Message.fileNotFound(name.value()));
        }

    }
}
