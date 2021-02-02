package pex.app.main;

import pex.core.Aplication;

//FIXME import used core classes
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/**
 * Create new program.
 */
public class NewProgram extends Command<Aplication> {

    /**
     * @param receiver
     */
    public NewProgram(Aplication receiver) {
        super(Label.NEW_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        Form f = new Form();
        InputString name = new InputString(f,Message.requestProgramId());
        f.parse();
        entity().addProgram(name.value());
    }
}
