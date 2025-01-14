package calculator4.calculators;

import java.util.ArrayList;
import java.util.List;

public class GenericCalculator {
    private ArrayList<Double> results = new ArrayList<>();

    public boolean isDigit(String number) {
        return (number.chars().allMatch(Character::isDigit));
    }

    public void addResult(Double result) {
        this.results.add(result);
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public List<Double> getBiggerList(Double num3) {
        return this.results.stream()
                .filter(num -> num3 < num)
                .toList();
    }
}
