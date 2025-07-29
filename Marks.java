import java.util.Scanner;

public class Marks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];

        System.out.println("Commands:");
        System.out.println("add [studentID]");
        System.out.println("update [studentID] [subjectID]");
        System.out.println("average_s [subjectID]");
        System.out.println("average [studentID]");
        System.out.println("total [studentID]");
        System.out.println("grades");
        System.out.println("exit");

        while (true) {
            System.out.print("Enter command: ");
            String command = sc.next();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting...");
                break;
            }

            switch (command.toLowerCase()) {
                case "add": {
                    int studentID = sc.nextInt();
                    if (studentID < 1 || studentID > n) {
                        System.out.println("Invalid student ID.");
                        break;
                    }
                    System.out.println("Enter marks for Math, Chemistry, Physics:");
                    for (int i = 0; i < 3; i++) {
                        marks[studentID - 1][i] = sc.nextInt();
                    }
                    System.out.println("Marks added for student " + studentID);
                    break;
                }
                case "update": {
                    int studentID = sc.nextInt();
                    int subjectID = sc.nextInt();
                    if (studentID < 1 || studentID > n || subjectID < 1 || subjectID > 3) {
                        System.out.println("Invalid student or subject ID.");
                        break;
                    }
                    System.out.print("Enter new mark: ");
                    int newMark = sc.nextInt();
                    marks[studentID - 1][subjectID - 1] = newMark;
                    System.out.println("Mark updated for student " + studentID);
                    break;
                }
                case "average_s": {
                    int subjectID = sc.nextInt();
                    if (subjectID < 1 || subjectID > 3) {
                        System.out.println("Invalid subject ID.");
                        break;
                    }
                    int total = 0;
                    for (int i = 0; i < n; i++) {
                        total += marks[i][subjectID - 1];
                    }
                    double average = (double) total / n;
                    System.out.println("Average mark for subject " + subjectID + " is " + average);
                    break;
                }
                case "average": {
                    int studentID = sc.nextInt();
                    if (studentID < 1 || studentID > n) {
                        System.out.println("Invalid student ID.");
                        break;
                    }
                    int sum = 0;
                    for (int mark : marks[studentID - 1]) {
                        sum += mark;
                    }
                    double avg = (double) sum / 3;
                    System.out.printf("Average marks for student %d: %.2f\n", studentID, avg);
                    break;
                }
                case "total": {
                    int studentID = sc.nextInt();
                    if (studentID < 1 || studentID > n) {
                        System.out.println("Invalid student ID.");
                        break;
                    }
                    int total = 0;
                    for (int mark : marks[studentID - 1]) {
                        total += mark;
                    }
                    System.out.println("Total marks for student " + studentID + ": " + total);
                    break;
                }
                case "grades": {
                    System.out.println("Grades Summary:");
                    System.out.println("StudentID\tMath\tChemistry\tPhysics");
                    for (int i = 0; i < n; i++) {
                        System.out.print((i + 1) + "\t\t");
                        for (int j = 0; j < 3; j++) {
                            System.out.print(getGrade(marks[i][j]) + "\t\t");
                        }
                        System.out.println();
                    }
                    break;
                }
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }

        sc.close();
    }

    public static String getGrade(int score) {
        if (score >= 90) return "Grade A";
        if (score >= 80) return "Grade B";
        if (score >= 70) return "Grade C";
        if (score >= 60) return "Grade D";
        return "Fail";
    }
}
