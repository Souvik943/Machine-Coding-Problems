package questions.Design_Uber.strategy.FareCalculation;

import java.time.LocalTime;

public class NightTimeStrategy implements FareCalculator {
    @Override
    public double calculateSurge(double fare) {
        LocalTime localTime = LocalTime.now();
        if(localTime.isAfter(LocalTime.of(22,0)) && localTime.isBefore(LocalTime.of(6, 0))) {
            return fare * 0.2;
        }
        return 0;
    }
}
