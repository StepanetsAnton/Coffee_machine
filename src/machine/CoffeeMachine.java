package machine;
import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    public void setMoney(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }
    public int getWater() {
        return water;
    }
    public void setWater(int water) {
        this.water = water;
    }
    public int getCups() {
        return cups;
    }
    public void setCups(int cups) {
        this.cups = cups;
    }
    public int getBeans() {
        return beans;
    }
    public void setBeans(int beans) {
        this.beans = beans;
    }
    public int getMilk() {
        return milk;
    }
    public void setMilk(int milk) {
        this.milk = milk;
    }
    public CoffeeMachine(int water,int milk,int beans,int cups,int money){
        setWater(water);
        setMilk(milk);
        setBeans(beans);
        setCups(cups);
        setMoney(money);
    }
    public void statusCheck(){
        System.out.println("The coffee machine has:\n"+getWater()+" ml of water\n"+getMilk()+" ml of milk\n"+getBeans()+" g of coffee beans\n"+getCups()+" disposable cups\n"+"$"+getMoney()+" of money\n");
    }
    public void buy(int water, int milk, int beans, int cost){
        if(getWater()<water){
            System.out.println("Sorry, not enough water!\n");
        }else{
            if(getMilk()<milk){
                System.out.println("Sorry, not enough milk!\n");
            }else{
                if(getBeans()<beans){
                    System.out.println("Sorry, not enough beans!\n");
                }else{
                    if(getCups()==0){
                        System.out.println("Sorry, not enough cups!\n");
                    }else{
                        System.out.println("I have enough resources, making you a coffee!\n");
                        setWater(getWater()-water);
                        setMilk(getMilk()-milk);
                        setBeans(getBeans()-beans);
                        setMoney(getMoney()+cost);
                        setCups(getCups()-1);
                    }
                }
            }
        }
    }
    public void fill(int water, int milk, int beans,int cups){
        setWater(getWater()+water);
        setMilk(getMilk()+milk);
        setBeans(getBeans()+beans);
        setCups(getCups()+cups);
    }
    public void take(){
        setMoney(0);
    }
    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine(400,540,120,9,550);
        Scanner scanner = new Scanner(System.in);
        String action = "";
        while (!action.equals("exit")){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.next();
            switch (action) {
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffee = scanner.next();
                    switch (coffee) {
                        case "1":
                            machine.buy(250, 0, 16, 4);
                            break;
                        case "2":
                            machine.buy(350, 75, 20, 7);
                            break;
                        case "3":
                            machine.buy(200, 100, 12, 6);
                            break;
                        case "back":
                            break;
                        default:
                            System.out.println("You have only 3 options!");
                            break;
                    }
                }
                case "fill" -> {
                    System.out.println("Write how many ml of water you want to add:");
                    int water = scanner.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int milk = scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int beans = scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    int cups = scanner.nextInt();
                    machine.fill(water, milk, beans, cups);
                }
                case "take" -> {
                    System.out.println("I gave you " + machine.getMoney() + "\n");
                    machine.take();
                }
                case "remaining" -> machine.statusCheck();
            }
        }
    }
}

