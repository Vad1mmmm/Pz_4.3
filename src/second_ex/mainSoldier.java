package second_ex;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Command {
    void execute(Soldier soldier);
}

public class mainSoldier {
    public static void mainStart() {

        List<Soldier> soldiers = Arrays.asList(
                new Soldier("Vanya", "sniper", 20, 4),
                new Soldier("Petro", "medic", 10, 450),
                new Soldier("Vasya", "engeener", 50, 600)
        );
        System.out.println("-----------------------Attack command-----------------------");
        CommandRelaySystem.broadcast(soldiers, Soldier::attack);
        System.out.println("-----------------------Reload? if ammo count < 5-----------------------");
        Predicate<Soldier> lowAmmo = s -> s.getAmmo() < 5;
        CommandRelaySystem.conditionalBroadcast(soldiers, lowAmmo, Soldier::reload);
        System.out.println("-----------------------chain commands-----------------------");
        Command attack = CommandRelaySystem.chainCommands(Soldier::rest, Soldier::attack);
        CommandRelaySystem.broadcast(soldiers, attack);
        System.out.println("-----------------------Random command-----------------------");
        Supplier<Command> randomCommand = () -> {
            if (new Random().nextBoolean())
                return Soldier::attack;
            else {
                return Soldier::reload;
            }
        };
        CommandRelaySystem.supply(soldiers, randomCommand);

    }
}
