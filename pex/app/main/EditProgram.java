package pex.app.main;

import pex.core.Aplication;
import pex.core.Program;

//FIXME import used core classes
import pex.app.evaluator.EvaluatorMenu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;


/**
 * Open menu for managing programs.
 */
public class EditProgram extends Command<Aplication> {

    /**
     * @param receiver
     */
    public EditProgram(Aplication receiver) {
        super(Label.MANAGE_PROGRAM, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() {
        Form f = new Form();
        InputString name = new InputString(f,Message.requestProgramId());
        f.parse();
        String nameString = name.value();
        Program program = entity().getProgram(nameString);
        if(program == null)
            new Display().add(Message.noSuchProgram(nameString)).display();
        else{
            EvaluatorMenu menu = new EvaluatorMenu(program);
            menu.open();
    }

    }
}
