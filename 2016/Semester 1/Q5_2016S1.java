public class Q5_2016S1 {
    public static void main(String[] args) {
        Rebate rebateCard = new Rebate("John Lim", "1111222233334444");
        Point pointCard = new Point("John Lim", "5555666677778888");

        // Sample expenditures
        String[][] transactions = {
            {"Grocery", "Saturday", "124.80"},
            {"Other", "Friday", "64.80"},
            {"Fuel", "Sunday", "94.50"},
            {"Utility", "Friday", "100.00"},
            {"Other", "Tuesday", "220.00"}
        };

        // Process each transaction
        for (String[] transaction : transactions) {
            String type = transaction[0];
            String day = transaction[1];
            double amount = Double.parseDouble(transaction[2]);

            rebateCard.calculateReward(type, day, amount);
            pointCard.calculateReward(type, day, amount);
        }

        // Print card details
        System.out.println(rebateCard);
        System.out.println();
        System.out.println(pointCard);

        // Determine the best card
        String bestCard = rebateCard.getTotalCash() > pointCard.getTotalCash() ? "Cash Rebate Card" : "Point Reward Card";
        System.out.println("The best card is " + bestCard);
    }
}
                
class CreditCard {
    private String cardholder;
    private String cardNum;
    private String cardType;
    private double totalCash;

    public CreditCard(String cardholder, String cardNum, String cardType) {
        this.cardholder = cardholder;
        this.cardNum = cardNum;
        this.cardType = cardType;
        this.totalCash = 0;
    }

    public double getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(double totalCash) {
        this.totalCash = totalCash;
    }

    @Override
    public String toString() {
        return "Credit Card : " + cardholder + " (" + cardNum + ")" +
               "\nCard Type  : " + cardType +
               "\nTotal Cash Reward : " + String.format("%.4f", totalCash);
    }
}


class Rebate extends CreditCard {
    public Rebate(String cardholder, String cardNum) {
        super(cardholder, cardNum, "Cash Rebate");
    }

    public void calculateReward(String type, String day, double amount) {
        double rate = 0;
        if (type.equalsIgnoreCase("fuel")) {
            rate = 0.08;
        } else if (type.equalsIgnoreCase("utility")) {
            rate = 0.05;
        } else if (type.equalsIgnoreCase("grocery")) {
            rate = 0.02;
        } else {
            rate = 0.002;
        }
        setTotalCash(getTotalCash() + (amount * rate));
    }
}


class Point extends CreditCard {
    public Point(String cardholder, String cardNum) {
        super(cardholder, cardNum, "Point Reward");
    }

    public void calculateReward(String type, String day, double amount) {
        double multiplier = 1; // Default multiplier

        if (day.equalsIgnoreCase("Friday")) {
            multiplier = 2; // Double points on Friday
        } else if (day.equalsIgnoreCase("Saturday")) {
            multiplier = 3; // Triple points on Saturday
        } else if (day.equalsIgnoreCase("Sunday")) {
            multiplier = 4; // Quadruple points on Sunday
        }

        double points = amount * multiplier;
        double cashEquivalent = points * 0.01; // Convert points to cash
        setTotalCash(getTotalCash() + cashEquivalent);
    }
}

