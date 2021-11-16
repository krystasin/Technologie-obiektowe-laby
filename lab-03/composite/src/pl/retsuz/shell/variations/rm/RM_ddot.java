package pl.retsuz.shell.variations.rm;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class RM_ddot extends CommandVariation {
    public RM_ddot(ICommandVariation next, ICommand parent) { super(next, parent, "\\.\\.");    }

    @Override
    public void make(String params) {

        System.out.println("[nie mozna usunac folderu w ktorym sie znajdujesz]");
/*        Composite c= (Composite) (this.getParent().getContext().getCurrent());
        if(c.getParent()!=null) {
            c = (Composite) c.getParent();
            this.getParent().getContext().setCurrent(c);
        }else{
            System.out.println("Brak elementu nadrzędnego.");
        }*/
    }
}