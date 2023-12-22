import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Salary: ");
        double salary = scanner.nextDouble();
        System.out.print("Enter Year cost: ");
        double yearCost = scanner.nextDouble();
        System.out.print("Enter Tax reduction: ");
        double taxReduce = scanner.nextDouble();
        System.out.print("\nYou have other income?: ");

        double total;
        if (scanner.next().equals("Y")) {
            System.out.print("Input other income: ");
            double otherIncome = scanner.nextDouble();
            total = salary * 12 - yearCost - taxReduce + otherIncome;
            System.out.println("Income : (" + salary + "x12) – " + yearCost + " – " + taxReduce + " + " + otherIncome + " = " + total);
        } else {
            total = salary * 12 - yearCost - taxReduce;
            System.out.println("Income : (" + salary + "x12) – " + yearCost + " – " + taxReduce + " = " + total);
        }

        System.out.println("Tax is " + getTaxRate(total) + "%");

        double tax = 0;

        if (total > 150000) {
            double temp = (total >= 300000) ? 7500 : 0.05 * getTaxMod(total);
            System.out.println("Cal Tax 5% * "+((total >= 300000) ? 150000 : getTaxMod(total))+" = "+temp);
            tax += temp;
        }
        if (total > 300000) {
            double temp = (total >= 500000) ? 20000 : 0.1 * getTaxMod(total);
            System.out.println("Cal Tax 10% * "+((total >= 500000) ? 200000 : getTaxMod(total))+" = "+temp);
            tax += temp;
        }
        if (total > 500000) {
            double temp =(total >= 750000) ? 37500 : 0.15 * getTaxMod(total);
            System.out.println("Cal Tax 15% * "+((total >= 750000) ? 250000 : getTaxMod(total))+" = "+temp);
            tax += temp;
        }
        if (total > 750000) {
            double temp =(total >= 1000000) ? 50000 : 0.2 * getTaxMod(total);
            System.out.println("Cal Tax 20% * "+((total >= 1000000) ? 250000 : getTaxMod(total))+" = "+temp);
            tax += temp;
        }
        if (total > 1000000) {
            double temp = (total >= 2000000) ? 250000 : 0.25 * getTaxMod(total);
            System.out.println("Cal Tax 25% * "+((total >= 2000000) ? 1000000 : getTaxMod(total))+" = "+temp);
            tax += temp;
        }
        if (total > 2000000) {
            double temp = (total >= 5000000) ? 900000 : 0.3 * getTaxMod(total);
            System.out.println("Cal Tax 30% * "+((total >= 5000000) ? 3000000 : getTaxMod(total))+" = "+temp);
            tax += temp;
        }
        if (total > 5000000) {
            double temp = 0.35 * getTaxMod(total);
            System.out.println("Cal Tax 35% * "+getTaxMod(total)+" = "+temp);
            tax += temp;
        }

        System.out.println("Your Tax = "+((tax <= 0) ? "Free Tax" : tax+" BTH"));

    }

    private static int getTaxRate(double total) {
        if (total >= 5000001) return 35;
        else if (total >= 2000001) return 30;
        else if (total >= 1000001) return 25;
        else if (total >= 750001) return 20;
        else if (total >= 500001) return 15;
        else if (total >= 300001) return 10;
        else if (total >= 150001) return 5;
        else return 0;
    }

    private static double getTaxMod(double total) {
        if (total <= 150000) return total;
        else if (total <= 300000) return total - 150000;
        else if (total <= 500000) return total - 300000;
        else if (total <= 750000) return total - 500000;
        else if (total <= 1000000) return total - 750000;
        else if (total <= 2000000) return total - 1000000;
        else if (total <= 5000000) return total - 2000000;
        else return total - 5000000;
    }
}