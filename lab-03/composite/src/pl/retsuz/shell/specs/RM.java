package pl.retsuz.shell.specs;

import pl.retsuz.context.IContext;
import pl.retsuz.shell.gen.Command;
import pl.retsuz.shell.gen.ICommand;

public class RM extends Command {
    public RM(IContext ctx, ICommand next) {
        super("rm", ctx, next, null, "Użycie mkdir <nazwa>");
    }
}
