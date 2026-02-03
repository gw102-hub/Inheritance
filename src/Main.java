//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {


    ArrayList<Worker> workers = new ArrayList<Worker>();

    Worker worker1 = new Worker("000001", "Peter", "Adam", "Mr.", 1990, 22.50);
    Worker worker2 = new Worker("000002", "Adam", "Chunk", "Mr.", 1980, 30.50);
    Worker worker3 = new Worker("000003", "Bill", "Adam", "Mr.", 1995, 25.50);



    SalaryWorker salaryWorker1 = new SalaryWorker("000001", "Adam", "Peter", "Mr", 2001, 65000.00);
    SalaryWorker salaryWorker2 = new SalaryWorker("000002", "Peter", "Parker", "Mr", 2002, 65000.00);
    SalaryWorker salaryWorker3 = new SalaryWorker("000003", "Adam", "Sandler", "Mr", 1930, 65000.00);

    workers.add(worker1);
    workers.add(worker2);
    workers.add(worker3);
    workers.add(salaryWorker1);
    workers.add(salaryWorker2);
    workers.add(salaryWorker3);

    double[] weeklyHours = {40, 60, 40};

    for (int week = 1; week<= 3; week++) {
        System.out.println("=".repeat(20));
        System.out.println("Week" + week + "Pay");
        System.out.println("Hours Worked" + weeklyHours[week - 1]);
        System.out.println("=".repeat(20));

        for (Worker w : workers) {
            String name = w.getFirstName() + " " + w.getLastName();
            String type;
            String rateOrSal;
            double hours = weeklyHours[week - 1];
            double regPay = 0;
            double overtimePay = 0;
            double totalPay = w.calculateWeeklyPay(hours);

            if (w instanceof SalaryWorker) {
                type = "Salary";
                SalaryWorker sw = (SalaryWorker) w;

                rateOrSal = String.format("$%.2f/yr", sw.getAnnualSalary());
                regPay = totalPay;
            } else {
                type = "Hourly";
                rateOrSal = String.format("$%.2f/hr", w.getHourlyPayRate());

                if (hours <= 40) {
                    regPay = hours * w.getHourlyPayRate();
                } else {
                    regPay = 40 * w.getHourlyPayRate();
                    overtimePay = (hours - 40) * w.getHourlyPayRate() * 1.5;
                }
            }

            System.out.println(String.format("%-20s %-15s %-15s %-15.2f $%-14.2f $%-14.2f $%-14.2f",
                    name, type, rateOrSal, hours, regPay, overtimePay, totalPay));
        }

        System.out.println("=".repeat(100));
        System.out.println();
    }
    System.out.println("=".repeat(20));
    System.out.println("3 week summary");
    System.out.println("=".repeat(20));

    System.out.println(String.format("%-20s %-15s %-20s", "Employee Name", "Type", "Total 3-Week Pay"));
    System.out.println("=".repeat(60));

    for (Worker w : workers) {
        double threeWeekPay = 0;
        for (double hours : weeklyHours) {
            threeWeekPay += w.calculateWeeklyPay(hours);
        }

        String type = (w instanceof SalaryWorker) ? "Salary" : "Hourly";
        System.out.println(String.format("%-20s %-15s $%-19.2f",
                w.getFirstName() + " " + w.getLastName(), type, threeWeekPay));
    }
}
