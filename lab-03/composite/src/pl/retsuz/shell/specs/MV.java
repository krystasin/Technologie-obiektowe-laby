package pl.retsuz.shell.specs;

import pl.retsuz.context.IContext;
import pl.retsuz.shell.gen.Command;
import pl.retsuz.shell.gen.ICommand;

public class MV extends Command {
    public MV(IContext ctx, ICommand next) { super("mv", ctx, next, null, "Użycie mv <sciezka_z> <sciezka_do>");    }
}
