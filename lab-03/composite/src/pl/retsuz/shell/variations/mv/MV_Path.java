package pl.retsuz.shell.variations.mv;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class MV_Path extends CommandVariation {
    public MV_Path(ICommandVariation next, ICommand parent) {
        super(next, parent, "[a-zA-Z0-9.l\\/_]*");
    }


    @Override
    public void make(String params) {

        Composite c = (Composite) (this.getParent().getContext().getCurrent());
        try {
            c.findElementByPath(params);




        } catch (Exception e) {
            System.out.println("catch: MV exception");
            System.out.println(e);
        }

    }
}
