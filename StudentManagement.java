import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    // constructor

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // getter methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;

    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d Name: %-15s Marks: %-3f", id, name, marks);
    }

}

public class StudentManagement {

    private static ArrayList<Student> st = new ArrayList<>();
    private static Scanner s = new Scanner(System.in);

    public static void addStudent() {
        System.out.println("Enter id:");
        int id = s.nextInt();
        s.nextLine();
        System.out.println("Enter Name:");
        String name = s.nextLine();
        System.out.println("Enter Marks:");
        double marks = s.nextDouble();
        st.add(new Student(id, name, marks));
        System.out.println("student added succesfully");

    }

    public static void viewStudent() {
        if (st.isEmpty()) {
            System.out.println("no students found");
        } else {
            for (Student std : st) {
                System.out.println(std);
            }
        }
    }

    public static void updateStudent() {
        System.out.println("Enter ID :");
        int id = s.nextInt();
        s.nextLine();
        for (Student std : st) {
            if (std.getId() == id) {
                System.out.println("Enter new name:");
                String name = s.nextLine();
                System.out.print("Enter new marks:");
                double marks = s.nextDouble();
                std.setName(name);
                std.setMarks(marks);
                System.out.println("student updated successfully");
                return;
            }
        }
        System.out.println("student not found");
    }

    public static void deleteStudent() {
        System.out.print("Enter ID : ");
        int id = s.nextInt();

        for (Student std : st) {
            if (std.getId() == id) {
                st.remove(std);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n -----student record management---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = s.nextInt();
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudent();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    running = false;
                    System.out.println("exit");
                }
                default -> System.out.println("Invalid choice");
            }
        }

    }
}