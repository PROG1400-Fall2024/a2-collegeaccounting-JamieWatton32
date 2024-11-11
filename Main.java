

import javax.swing.*;
import java.util.ArrayList;;
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Staff> staffMembers = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();
        // Only way to break loop is to select "Finished" or to close the program.
        while (true) {
            // Show initial option dialog
            String[] options = {"Student", "Staff", "Finish"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Choose an option:",
                    "Accounting Application",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, options,null);


            if (choice == 0) { // Student selected
                String name = JOptionPane.showInputDialog("Enter Student's Name:");
                // handle null or "cancelled". Sends user back to beginning and nothing added to list
                if(name == null){
                    continue;
                }
                String address = JOptionPane.showInputDialog("Enter Student's Address:");

                if(address == null){
                    continue;
                }
                int year = validatedYear();
                //See comment in validatedYear()
                if(year == -1){
                    continue;
                }
                students.add(new Student(name, address, year));


            } else if (choice == 1) { // Staff selected
                String name = JOptionPane.showInputDialog("Enter Staff's Name:");

                if(name == null){
                    continue;
                }
                String address = JOptionPane.showInputDialog("Enter Staff's Address:");

                if(address == null){
                    continue;
                }
                int yearsOfService = validatedYearsOfService();

                if(yearsOfService == -1){
                    continue;
                }
                staffMembers.add(new Staff(name, address, yearsOfService));

            } else if (choice == 2) {
                printResults(students, staffMembers);
                break;
            }
        }



    }

    public static void printResults(ArrayList<Student> students, ArrayList<Staff> staffMembers){
        //Handle empty array cases. Allows both or just one of either to be printed. Say the accountant only wanted the
        //outgoing or incoming.

        if(!students.isEmpty()) {
            System.out.println("----------------Students-----------------");
            for (Student student : students) {
                System.out.println(student.toString());
            }

        }
        if(!staffMembers.isEmpty()){
            System.out.println("----------------Staff-----------------");
            for(Staff member :staffMembers) {
                System.out.println(member.toString());
            }
        }
        double fees = sumFees(students); //0 if empty
        double salaries = sumSalaries(staffMembers); // 0 if empty
        double total = fees - salaries;
        if(total < 0) {

        }
        System.out.println("\n----------------Accounting Results----------------");
        System.out.println("Incoming: $" + String.format("%.2f", fees));
        //I didnt want - signs in the report if there is a deficit but instead to have the () things
        if(total < 0 ) {
            System.out.println("Outgoing: $" + String.format("%.2f", salaries));
            System.out.println("Total: $" + String.format("(%.2f)", -total));
        }else{
            System.out.println("Outgoing: $" + String.format("%.2f", salaries));
            System.out.println("Total: $" + String.format("%.2f", total));
        }
    }
    public static int validatedYear(){
        //Ensure user enters a valid number.
        while (true) {
            try {
                String input = JOptionPane.showInputDialog("Enter Student's Year (1-4):");
                // -1 return code to indicate null//cancelled input
                if(input == null){
                    return -1;
                }
                int year = Integer.parseInt(input);
                if (year >= 1 && year <= 4) {
                    return year;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a year between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value between 1 and 4.");
            }
        }
    }
    // Loop to ensure the user enters proper year.
    public static int validatedYearsOfService(){
        //Ensure user enters a valid number.
        while (true) {
            try {
                String input = JOptionPane.showInputDialog("Enter Staff's Years of Service:");

                if(input == null){
                    return -1;
                }
                int yearsOfService = Integer.parseInt(input);
                if (yearsOfService > 0 && yearsOfService < 30) {
                    return yearsOfService;
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a year between 1 and 30.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a numeric value between 1 and 30.");
            }
        }

    }

    //Sum of all student fees
    public static double sumFees(ArrayList<Student> students){
        if(students.isEmpty()){
            return 0;
        }
        double sum = 0;
        for(Student student: students){
            sum += student.getInvoicedFee();
        }
        return sum;
    }
    //sum of all staff salaries
    public static double sumSalaries(ArrayList<Staff> staff){
        if(staff.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for(Staff member: staff){
            sum += member.getMonthlySalary();
        }
        return sum;
    }
}
