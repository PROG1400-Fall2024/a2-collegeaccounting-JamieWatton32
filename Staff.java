public class Staff extends Person {
    private int yearsOfService;
    private double salary;
    //Salary is calculated based on base pay + pay based on experience so i put it into
    public Staff(String name, String address, int yearsOfService) {
        super(name,address);
        double payScale = 500.0 * yearsOfService;
        double basePay = 50000.0;
        this.salary = basePay + payScale;
        this.yearsOfService = yearsOfService;

    }

    public int getYearsOfService() {
        return this.yearsOfService;
    }

    public double getSalary(){
       return this.salary;
    }

    public double getMonthlySalary(){
        return this.salary/26;
    }
    // I put this here with the thought that years of service would be auto incremented yearly
    // so this would ran instead of doing a new constructor. It doesnt take any arguments so if the
    // service property doesnt change then the salary doesnt.
    public void setSalary(){
        double payScale = 500.0 * this.yearsOfService;
        double basePay = 50000.0;
        this.salary = basePay + payScale;
    }
    public void setYearsOfService(int yearsOfService) {
        this.yearsOfService = yearsOfService;
    }


    @Override
    public String toString() {
        return "name = " + this.getName() + " "
                + "address = " + this.getAddress() + " "
                + "years = " + this.yearsOfService + " "
                + "salary = " + this.salary;
    }
}
