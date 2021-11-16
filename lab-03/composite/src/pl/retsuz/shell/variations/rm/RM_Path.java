package pl.retsuz.shell.variations.rm;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class RM_Path extends CommandVariation {
    public RM_Path(ICommandVariation next, ICommand parent) {
        super(next, parent, "[a-zA-Z0-9.l\\/_]*");
    }


    @Override
    public void make(String params) {

        Composite c = (Composite) (this.getParent().getContext().getCurrent());
        try {
            c.removeElement(c.findElementByPath(params));

            System.out.println("usunieto '"+params+"'");

        } catch (Exception e) {
            System.out.println("catch: RM exception");
            System.out.println(e);
        }

    }
}
