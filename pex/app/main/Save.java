package pex.app.main;

import java.io.IOException;
import pex.core.Aplication;

//FIXME import used core classes
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

/**
 * Save to file under current name (if unnamed, query for name).
 */
public class Save extends Command<Aplication> {
    /**
     * @param receiver
     */
    public Save(Aplication receiver) {
        super(Label.SAVE, receiver);
    }

    /** @see pt.utl.ist.po.ui.Command#execute() */
    @Override
    public final void execute() throws InvalidOperation {
        try{
            if (!entity().hasFileName()){
                Form f = new Form();
                InputString fileName = new InputString(f,Message.newSaveAs());
                f.parse();
                entity().save(fileName.value());}
            else
                entity().save();

        }catch (IOException x){
            throw new InvalidOperation();
        } 
    }
}
