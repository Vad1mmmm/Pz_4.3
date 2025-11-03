package first_ex;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void mainFirst() {
        List<Unit> units = Arrays.asList(
                new Unit("A1", "artillery", 1500, 30, 85, 80),
                new Unit("B1", "infantry", 400, 100, 70, 90),
                new Unit("C1", "recon", 1000, 20, 95, 75)
        );

        List<Unit> goodArtillery = BattleEfficiencyAnalyzer.filterUnits(units,
                u -> u.getType().equals("artillery") && u.getAccuracy() > 80);

        System.out.println(goodArtillery);

        List<String> reports = BattleEfficiencyAnalyzer.transformUnits(units, u -> u.getName() + " -> Accuracy: " + u.getAccuracy());
        System.out.println(reports);

        double averageMorale =  BattleEfficiencyAnalyzer.averageValue(units, Unit::getMorale);
        System.out.printf("%.2f", averageMorale);
        System.out.println(" - average morale");

        BattleEfficiencyAnalyzer.actOnUnits(units, u -> {
            u.setMorale(u.getMorale() + 5);
            System.out.println(u.getName() + " morale boosted");
        });

        Unit better = BattleEfficiencyAnalyzer.compareUnits(units.get(0), units.get(1), (a, b) -> (a.getAccuracy() * a.getAmmo() > b.getAccuracy() * b.getAmmo()) ? a : b);
        System.out.println("Better unit: " +  better);

    }
}
