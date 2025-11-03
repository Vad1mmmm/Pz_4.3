package second_ex;

import java.util.*;
import java.util.function.*;

public class CommandRelaySystem {

    public static void broadcast(List<Soldier> soldiers, Command command) {
        for (Soldier soldier : soldiers) {
            command.execute(soldier);
        }
    }

    public static void conditionalBroadcast(List<Soldier> soldiers, Predicate<Soldier> condition, Command command) {
        for (Soldier soldier : soldiers) {
            if (condition.test(soldier)) {
                command.execute(soldier);
            }
        }
    }

    public static Command chainCommands(Command c1, Command c2) {
        return c -> {
            c1.execute(c);
            c2.execute(c);
        };
    }

    public static void supply(List<Soldier> soldiers, Supplier<Command> commandSupplier) {
        Command generate = commandSupplier.get();
        for (Soldier soldier : soldiers) {
            generate.execute(soldier);
        }
    }
}