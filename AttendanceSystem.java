import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class Scratch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocalDate date = LocalDate.now();
        List<String> callstudent = new ArrayList<>();
        //                        1           +       1          +        1           +       1          = 4 SO ANG students.length  KAY 4 TANAN
        String students[] = {"Actub, Kylle Nichole", "Acaylar, rashed", "Hinayon stephanie", "Ej Pactolerin"};
        int box[][] = new int[students.length][4];
        //students.length KAY GIIHAP RA NIYA ANG SULOD SA students THEN ANG [4]KAY 4 COLUMN NA
        //SO ANG student.length IS ROW THEN ANG [4] COLUMNS
        int dys=0;
        int check = 0;
        int day = 0;

        String username = "admin";
        String password = "pass";

        // Login Screen
        while(true) {

            System.out.print("Enter Username: ");
            String user = input.next();
            System.out.print("Enter Password: ");
            String pass = input.next();

            if (username.equalsIgnoreCase(user) && password.equalsIgnoreCase(pass)) {
                break;
            } else {
                System.out.println("Invalid input Please Try Again");
            }

        }
        while(true) {
            System.out.println("\n==== Attendance System ====");
            System.out.println("1. Attendance");
            System.out.println("2. View Attendance Records");
            System.out.println("3. Logout");
            System.out.println("4. Shutdown");
            System.out.print("Enter number: ");
            String menu = input.next();

            if(menu.equals("1")){//Attendance

                while(true) {
                    LocalDate classDate = date.plusDays(day);
                    String formattedDate = classDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                    System.out.println("\nClass on " + formattedDate + " starts at 7:30 AM.");

                    for (int b = 0; b < students.length; b++) {
                        while (true) {
                            System.out.print("Name: " + students[b] +
                                    "\n1.Present" +
                                    "\n2.Late" +
                                    "\n3.Absent" +
                                    "\n4.Excuse" +
                                    "\nEnter number: ");
                            String attendance = input.next();
                            if (attendance.equals("1")) {
                                box[b][0]++;//ANG box[b] MGA ROW box[0] FIRST COLUMN
                                break;
                            } else if (attendance.equals("2")) {
                                box[b][1]++;//box[1]  SECOND COLUMN
                                break;
                            } else if (attendance.equals("3")) {
                                box[b][2]++;//box[2] THIRD COLUMN
                                break;
                            } else if (attendance.equals("4")) {
                                box[b][3]++;//box[3]  FORTH COLUMN
                                break;
                            } else {
                                System.out.println("\nWrong input\n");
                            }
                        }

                    }

                    dys++;//COUNT SA CLASS OF DAY



                    LocalDate classDates = date.plusDays(day);
                    String currentDate = date.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

                    String afterDate = classDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                    System.out.println();
                    System.out.println("Class on " + currentDate + " to " + afterDate + " days of school = " + dys);

                    System.out.println("\nStudent name\t\tPresent\t\tLate\t\tAbsent\t\tExcuse");
                    for (int b = 0; b < students.length; b++) {
                        int present = box[b][0];//GE KUHA RA NIYA ANG DATA SA BOX FIRST COLUMN
                        int late = box[b][1];//GE KUHA RA NIYA ANG DATA SA BOX SECOND COLUMN
                        int absent = box[b][2];//GE KUHA RA NIYA ANG DATA SA BOX THIRD COLUMN
                        int excuse = box[b][3];//GE KUHA RA NIYA ANG DATA SA BOX FORTH COLUMN
                        System.out.printf("%-24s%-16d%-16d%-16d%-16d\n", students[b], present, late, absent, excuse);


                    }

                    System.out.print("You want to take attendance \n[1]Yes\n[2]No\nEnter Number: ");
                    String checker=input.next();
                    if(checker.equals("1")) {
                        day++;
                    }else if(checker.equals("2")){
                        day++;
                        break;
                    }else {
                        break;
                    }




                }



            }else if(menu.equals("2")){//View Attendance Records
                System.out.println("\nStudent name\t\tPresent\t\tLate\t\tAbsent\t\tExcuse\t\tRate");
                for (int b = 0; b < students.length; b++) {
                    int present = box[b][0];//GE KUHA RA NIYA ANG DATA SA BOX FIRST COLUMN
                    int late = box[b][1];//GE KUHA RA NIYA ANG DATA SA BOX SECOND COLUMN
                    int absent = box[b][2];//GE KUHA RA NIYA ANG DATA SA BOX THIRD COLUMN
                    int excuse = box[b][3];//GE KUHA RA NIYA ANG DATA SA BOX FORTH COLUMN
                    double rate = (100) * 0.20 * (present + late) / dys;//CALCULATION SA RATE
                    System.out.printf("%-24s%-16d%-16d%-16d%-16d%-2s\n", students[b], present, late, absent, excuse, String.format("%.2f", rate) + "%");

                }
                System.out.println("\n\tA student who is failing to meet the attendance requirements");
                for(int a = 0;a<students.length;a++) {
                    if (box[a][2] >= 3) {
                        System.out.println(students[a]);
                    }
                }


            }else if(menu.equals("3")){
                System.out.println("\nLogging out\n");
                main(args);
            }else if(menu.equals("4")){
                System.out.println("\nShutdown\n");
                break;
            }else {
                System.out.println("\nWrong input\n");

            }
        }


    }

}
