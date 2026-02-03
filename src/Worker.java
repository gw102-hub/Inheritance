public class Worker extends Person {

    double hourlyPayRate;

    @Override
    public String toString() {
        return "Worker{" +
                super.toString() +
                " hourlyPayRate=" + hourlyPayRate +
                "}";
    }

    public Worker(String id, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
        super(id, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public Worker(Person person, double hourlyPayRate) {
        super(person.getId(), person.getFirstName(), person.getLastName(), person.getTitle(), person.getYOB());
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * this.hourlyPayRate;
        } else {
            double regPay = 40 * this.hourlyPayRate;
            double overTimeHours = hoursWorked - 40;
            double overTimePay = overTimeHours * this.hourlyPayRate * 1.5;
            return regPay + overTimePay;
        }
    }

    public void displayWeeklyPay(double hoursWorked) {
        double regHours = Math.min(hoursWorked, 40);
        double overTimeHours = Math.max(0, hoursWorked - 40);
        double regPay = regHours * this.hourlyPayRate;
        double overTimePay = overTimeHours * this.hourlyPayRate * 1.5;
        double totalPay = calculateWeeklyPay(hoursWorked);

        System.out.println("Weekly Pay for:" + getFirstName() + " " + getLastName());
        System.out.println("Regular Hours: " + regHours);
        System.out.println("Reg Pay: " + String.format("$%.2f", regPay));
        System.out.println("Overtime Hours: " + overTimeHours);
        System.out.println("Overtime Pay: " + String.format("$%.2f", overTimePay));
        System.out.println("Total Pay: " + String.format("$%.2f", totalPay));
    }

    @Override
    public String toJSONRecord()
    {
        String retString = "";
        char DQ = '\u0022';
        retString =  "{" + DQ + "IDNum" + DQ + ":" + DQ + getId() + DQ + ",";
        retString += DQ + "firstName" + DQ + ":" + DQ + getFirstName() + DQ + ",";
        retString += " " + DQ + "lastName"  + DQ + ":" + DQ + getLastName() + DQ + ",";
        retString += " " + DQ + "title" + DQ + ":" + DQ + getTitle() + DQ + ",";
        retString += " " + DQ + "hourlyPayRate" + DQ + ":" + DQ + this.hourlyPayRate + DQ + ",";
        retString += " " + DQ + "YOB"  + DQ + ":" + getYOB() + "}";

        return retString;
    }

    @Override
    public String toXMLRecord()
    {
        String retString = "";

        retString = "<Worker>" + "<ID>" + getId() + "</ID>";
        retString += "<firstName>" + getFirstName() + "</firstName>";
        retString += "<lastName>" + getLastName() + "</lastName>";
        retString += "<title>" + getTitle() + "</title>";
        retString += "<hourlyPayRate>" + this.hourlyPayRate + "</hourlyPayRate>";
        retString += "<YOB>" + getYOB() + "</YOB></Worker>";


        return retString;
    }

    @Override
    public String toCSVRecord()
    {
        return getId() + ", " + getFirstName() + "," + getLastName() + ", " + getTitle() + ", " + this.hourlyPayRate + ", " + getYOB();
    }
}
