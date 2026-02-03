public class SalaryWorker extends Worker {

    double annualSalary;

    @Override
    public String toString() {
        return "SalaryWorker{" +
                super.toString() +
                " annualSalary=" + annualSalary +
                "}";
    }

    public SalaryWorker(String id, String firstName, String lastName, String title, int YOB, double annualSalary) {
        super(id, firstName, lastName, title, YOB, 0.0);
        this.annualSalary = annualSalary;
    }

    public SalaryWorker(Worker worker, double annualSalary) {
        super(worker.getId(), worker.getFirstName(), worker.getLastName(), worker.getTitle(), worker.getYOB(), worker.getHourlyPayRate());
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);

        System.out.println("Weekly pay for: " + getFirstName() + " " + getLastName());
        System.out.println("Annual Salary: " + String.format("$%.2f", this.annualSalary));
        System.out.println("Weekly Pay: " + String.format("$%.2f", weeklyPay));
        System.out.println("The weekly pay is a fraction of the yearly salary (annual salary / 52)");
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
        retString += " " + DQ + "hourlyPayRate" + DQ + ":" + DQ + getHourlyPayRate() + DQ + ",";
        retString += " " + DQ + "annualSalary" + DQ + ":" + DQ + this.annualSalary + DQ + ",";
        retString += " " + DQ + "YOB"  + DQ + ":" + getYOB() + "}";

        return retString;
    }

    @Override
    public String toXMLRecord()
    {
        String retString = "";

        retString = "<SalaryWorker>" + "<ID>" + getId() + "</ID>";
        retString += "<firstName>" + getFirstName() + "</firstName>";
        retString += "<lastName>" + getLastName() + "</lastName>";
        retString += "<title>" + getTitle() + "</title>";
        retString += "<hourlyPayRate>" + getHourlyPayRate() + "</hourlyPayRate>";
        retString += "<annualSalary>" + this.annualSalary + "</annualSalary>";
        retString += "<YOB>" + getYOB() + "</YOB></SalaryWorker>";


        return retString;
    }

    @Override
    public String toCSVRecord()
    {
        return getId() + ", " + getFirstName() + "," + getLastName() + ", " + getTitle() + ", " + getYOB() + ", " + getHourlyPayRate() + ", " + this.annualSalary;
    }
}
