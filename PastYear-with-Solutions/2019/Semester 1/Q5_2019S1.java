public class Q5_2019S1 {
    public static void main(String[] args) {
        SpecialDelivery delivery1 = new SpecialDelivery("Ali","Ahmad",4.4,false,false);
        SpecialDelivery delivery2 = new SpecialDelivery("Ah Chong","Fatimah",63.1,false,false);
        SpecialDelivery delivery3 = new SpecialDelivery("FSKTM, UM","FK, UM",32.5,true,false);
        SpecialDelivery delivery4 = new SpecialDelivery("Ang","Liew",19.0,true,true);

        System.out.println(delivery1.toString());
        System.out.println(delivery2.toString());
        System.out.println(delivery3.toString());
        System.out.println(delivery4.toString());

        double totalCost = delivery1.totalCost() + delivery2.totalCost() + delivery3.totalCost() + delivery4.totalCost();
        System.out.println("The total shipping cost is RM " + String.format("%.2f", totalCost));
    }
}

class Delivery {
    private String sender;
    private String recipient;
    private double weight;
    
    public String getSender(){
        return sender;
    }
    
    public String getRecipient(){
        return recipient;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public Delivery(String sender, String recipient, double weight){
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;  
    }
    
    public double totalCost(){
        double totalCost = 0.0;
        if(weight >= 5){
            totalCost += weight*2.80;
        }else if(weight > 5 && weight <= 20){
            totalCost += weight*5.20;
        }else if(weight > 20 && weight <= 50){
            totalCost += weight*7.00;
        }else if(weight > 50){
            totalCost += weight*8.60;
        }
        return totalCost;
    }
    
    @Override
    public String toString(){
        return "From: " + sender + " " + "To: " + recipient + "\n" +
                "Weight of Package: " + String.format("%.1f", weight) + " kg\n"+
                "Shipping Cost: RM " + String.format("%.2f", totalCost());
    }
}

class SpecialDelivery extends Delivery {
    private boolean WeekendDelivery;
    private boolean NighttimeDelivery;
    
    public SpecialDelivery(String sender, String recipient, double weight, boolean WeekendDelivery, boolean NighttimeDelivery){
        super(sender, recipient, weight);
        this.WeekendDelivery = WeekendDelivery;
        this.NighttimeDelivery = NighttimeDelivery;
    }
    
    @Override
    public double totalCost(){
        double totalCost = super.totalCost();
        if(WeekendDelivery){
            totalCost += 50;
        }else if(NighttimeDelivery){
            totalCost = totalCost * 1.20;
        }
        return totalCost;
    }
    
    @Override
    public String toString(){
        //To get the same output with parent class:
        String output = super.toString() + '\n';
        
        if(WeekendDelivery){
            output += "Weekend Delivery\n";
        }else if(NighttimeDelivery){
            output += "NighttimeDelivery";
        }
        
        return output;
    }
}