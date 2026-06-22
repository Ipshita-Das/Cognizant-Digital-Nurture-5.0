package Data_Structures_Algorithms;

public class FinancialForecast {

    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialInvestment = 5000.00;
        double annualGrowthRate = 0.07;
        int forecastingYears = 10;

        double predictedValue = calculateFutureValue(initialInvestment, annualGrowthRate, forecastingYears);
        
        System.out.printf("Predicted future value after %d years: $%.2f%n", forecastingYears, predictedValue);
    }
}