package pex.app;

import pex.core.Aplication;
// import core entities;
import pex.AppIO;
import pex.parser.ParserException;
import pex.app.main.MainMenu;
import java.io.Serializable;

import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.Display;


/**
 * This is a sample client for the expression evaluator.
 * It uses a text-based user interface.
 */
public class App implements AppIO, Serializable{
    private static Aplication _APLICATION ;

    public App() {
        _APLICATION=new Aplication(this);
    }

    /**
     * Writes a string to be presented to the user.
     *
     * @param str the string to write
     **/
    public void println(String str) {
        Display display = new Display();
        display.addNewLine(str);
        display.display();
    }

    /**
     * Reads a string inputed by the user.
     *
     * @return the string written by the user.
     **/
    public String readString() {
        Form f = new Form ();
        InputString i = new InputString(f, "");
        f.parse(); 
        return i.value();
    }


    /**
     * Reads an integer inputed by the user.
     *
     * @return the number written by the user.
     **/
    public int readInteger() {
        Form f = new Form ();
        InputInteger i =new InputInteger (f,"");
        f.parse();
        return i.value();
        }


    /**
     * @param args
     */
    public static void main(String[] args) {
        App app= new App();
        
        String datafile = System.getProperty("import"); //$NON-NLS-1$
        if (datafile != null) {
            try {
                _APLICATION.loadProgram(datafile,"import");
            } catch (ParserException e) {
                // no behavior described: just present the problem
                e.printStackTrace();
            }
        }
        
        MainMenu menu = new MainMenu(_APLICATION);
        menu.open();
    }
}
