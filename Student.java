public class Student extends Person {
    private int year;
    private double fee;

    public Student(String name, String address, int year) {
        super(name, address);
        this.year = year;
        // 2900 is base here because it makes it easy to have 1 year = 3000, 2 year = 3100
        this.fee = 2900 + (year*100);
    }
    public double getYear(){
        return this.year;
    }

    public double getFee() {
        return fee;
    }


    public double getInvoicedFee(){
        return this.fee/2;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "name = " + this.getName()+ " "
                + "address = " + this.getAddress()+ " "
                + "year = " + this.year+ " "
                + "fee = " + this.fee;
    }
}
