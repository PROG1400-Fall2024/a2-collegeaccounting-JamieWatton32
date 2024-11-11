import javax.swing.*;
import java.util.ArrayList;;
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Staff> staffMembers = new ArrayList<>();

        while (true) {
            // Show initial option dialog
            String[] options = {"Student", "Staff", "Finish"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Choose an option:",
                    "Accounting Application",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null, options,null);

            // Check user selection
            if (choice == 0) { // Student selected
                String name = JOptionPane.showInputDialog("Enter Student's Name:");
                String address = JOptionPane.showInputDialog("Enter Student's Address:");
                int year = validatedYear();

                students.add(new Student(name, address, year));

                // Create and add student to list

            } else if (choice == 1) { // Staff selected
                String name = JOptionPane.showInputDialog("Enter Staff's Name:");
                String address = JOptionPane.showInputDialog("Enter Staff's Address:");
                int yearsOfService = validatedYearsOfService();

                // Create and add staff member to list
                staffMembers.add(new Staff(name, address, yearsOfService));

            } else if (choice == 2) { // Finish selected
                // Run financial processing for students and staff
                break; // Exit the loop and end program
            }
        }
        System.out.println("----------------Students-----------------");
        for(Student student :students){
            System.out.println(student.toString());
        }
        System.out.println("----------------Staff-----------------");
        for(Staff member :staffMembers){
            System.out.println(member.toString());
        }


        double fees = sumFees(students);
        double salaries = sumSalaries(staffMembers);
        double total = fees - salaries;
        System.out.println("\n----------------Accounting Results----------------");
        System.out.println("Incoming: $" + String.format("%.2f", fees));
        System.out.println("Outgoing: $" + String.format("%.2f", salaries));
        System.out.println("Total: $" + String.format("%.2f", total));

    }
    // Loop to ensure the user enters proper year.
    public static int validatedYearsOfService(){
        //Ensure user enters a valid number.
        while (true) {
            try {
                int yearsOfService = Integer.parseInt(JOptionPane.showInputDialog("Enter Staff's Years of Service:"));
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
    public static int validatedYear(){
        //Ensure user enters a valid number.
        while (true) {
            try {
                int year = Integer.parseInt(JOptionPane.showInputDialog("Enter Student's Year (1-4):"));
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

    public static double sumFees(ArrayList<Student> students){
        double sum =0;
        for(Student student: students){
            sum += student.getInvoicedFee();
        }
        return sum;
    }

    public static double sumSalaries(ArrayList<Staff> staff){
        double sum =0;
        for(Staff member: staff){
            sum += member.getMonthlySalary();
        }
        return sum;
    }
}
