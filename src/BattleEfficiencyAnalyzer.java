import java.util.*;
import java.util.function.*;

public class BattleEfficiencyAnalyzer {

    public static List<Unit> filterUnits(List<Unit> units, Predicate<Unit> condition) {
        List<Unit> result = new ArrayList<>();
        for (Unit unit : units) {
            if (condition.test(unit)) {
                result.add(unit);
            }
        }
        return result;
    }

    public static List<String> transformUnits(List<Unit> units, Function<Unit, String> transformer) {
        List<String> result = new ArrayList<>();
        for (Unit unit : units) {
            result.add(transformer.apply(unit));
        }
        return result;
    }

    public static double averageValue(List<Unit> units, ToDoubleFunction<Unit> metric) {
        if (units.isEmpty()) return 0;
        double sum = 0;
        for (Unit unit : units) {
            sum += metric.applyAsDouble(unit);
        }
        return sum / units.size();
    }

    // 4. Виконання дії над усіма об’єктами
    public static void actOnUnits(List<Unit> units, Consumer<Unit> action) {
        for (Unit unit : units) {
            action.accept(unit);
        }
    }

    public static Unit compareUnits(Unit u1, Unit u2, BiFunction<Unit, Unit, Unit> comparator) {
        return  comparator.apply(u1, u2);
    }
}