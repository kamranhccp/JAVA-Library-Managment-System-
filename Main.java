//CODE Created by: Kamran Mansoor
//Distributed by Instagram@kamran_hccp
//Instgram Page for Fun/Sharing my Views: Instgram@programming_is_my_life_

package Library_Management_Sys;

import java.io.Reader;
import java.util.*;

public class Main {

    Scanner input = new Scanner(System.in);
    static Scanner inputStatic = new Scanner(System.in);

    static int choise = 0;
    static int back_option = 1;

    static int bookID;
    static int readerID;
    static int d; // day
    static int m; // month
    static int y; // year

    static Librarian l = new Librarian(111, "1234", "a", "AA", "Teacher", 123456789, "Cairo", "A@gmail.com", true);
    static Library_Management_Sys.Reader r = new Library_Management_Sys.Reader(111, "1234", "a", "AA", "Teacher", 123456789, "Cairo", "A@gmail.com", false);

    //static Reader r = new Reader(222, "5678", "b", "BB", "Student", 987654321, "Giza", "B@gmail.com", false);

    public static void main(String[] args) {
        l.preRegistered();  //Calls a method that has some data initialed into

        ///--> Main >< Menu <--///
        do {
            back_option = 1;     //To Enter the (Do --> While) LOOP
            cls();

            System.out.print("""
                    <==========================================>
                       | WELCOME TO COMSATS LIBRARY SYSTEM |
                    <==========================================>\n
                    """);
            ////--> Options <--////
            System.out.print("""
                      <====Main MENU====>
                        1: Register User.
                        2: Search Book.
                        3: Add Reader to Book.
                        4: Remove Reader from Book.
                        5: Add new Book(s).
                        6: Remove Book(s).
                        7: Rent/Buy Book.
                        8: Block Reader.
                        9: Search User.
                        10: Check Return Date.
                        11: Display Books.
                        12: Display Readers.
                        13: Number of Books.
                        14: Number of Readers.
                        15: Pay Late Fine.
                        0: Exit. 
                    """);

            try {
                System.out.print("SELECT YOUR OPTION: ");
                choise = inputStatic.nextInt();
            }
            catch(Exception e){
                System.out.println("Sorry!Enter valid option!.");
            }
            switch (choise) {
                case 1:     //Register User
                    cls();
                    if (Login() == 1) {
                        l.addReader();
                    } else {
                        System.out.println("Sorry you aren't Allowed to do This Operation!");
                    }

                    Back_Option(back_option);     //Returns to Menu
                    continue;
                    //////////////////////////////////////////////////

                case 2:     //Search Book
                    cls();

                    if (Login() != 0) {
                        System.out.print("Enter Book ID: ");
                        bookID = inputStatic.nextInt();
                        System.out.println("Book's Name is: " + l.Search_For_Book(bookID));
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 3:     //Add Reader to Book
                    cls();

                    if (Login() == 1) {
                        System.out.print("Enter Reader ID: ");
                        readerID = inputStatic.nextInt();

                        System.out.print("Enter Book ID: ");
                        bookID = inputStatic.nextInt();

                        System.out.print("Enter Reader Name: ");
                        String readerName = inputStatic.next();

                        l.Add_ReaderToBook(readerID, bookID, readerName);
                    } else {
                        System.out.println("Sorry! you aren't Allowed to do yhis Operation/");
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 4:     //Remove Reader from Book
                    cls();
                    if (Login() == 1) {
                        System.out.print("Enter Book ID: ");
                        bookID = inputStatic.nextInt();

                        l.Remove_ReaderFromBook(bookID);
                    } else {
                        System.out.println("Sorry you aren't Allowed to do This Operation");
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 5:     //Add new Books
                    cls();
                    if (Login() == 1) {
                        l.addBook();
                    } else {
                        System.out.println("Sorry you aren't Allowed to do This Operation");
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 6:     //Remove Books
                    cls();
                    if (Login() == 1) {
                        System.out.print("Enter Book ID: ");
                        bookID = inputStatic.nextInt();

                        l.removeBook(bookID);
                    } else {
                        System.out.println("Sorry! you aren't Allowed to do this Operation.");
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 7:     //Rent/Buy Book
                    cls();
                    if (Login() != 0) {
                        l.rentBook();
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 8:     //Block Reader
                    cls();
                    if (Login() == 1) {
                        System.out.print("Enter Reader ID: ");
                        readerID = inputStatic.nextInt();

                        l.blockUser(readerID);
                    } else {
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 9:     //Search User
                    cls();
                    if (Login() == 1) {
                        System.out.print("Enter User's ID: ");
                        readerID = inputStatic.nextInt();
                        System.out.println("User's Name is:" + l.searchUser(readerID));
                    } else {
                        System.out.println("Sorry! you aren't Allowed to do this Operation.");
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 10:     //Check Return Date
                    cls();
                    if (Login() == 1) {
                        System.out.print("Enter Rental Date:-");

                        System.out.print("Day: ");
                        d = inputStatic.nextInt();

                        System.out.print("Month: ");
                        m = inputStatic.nextInt();

                        System.out.print("Year: ");
                        y = inputStatic.nextInt();

                        if (l.checkReturnDate(d, m, y)) {
                            System.out.println("Valid Date, Haven't Exceeded a Week");
                        } else {
                            System.out.println("Invalid Date, Exceeded a Week");
                        }
                    } else {
                        System.out.println("Sorry! you aren't Allowed to do this Operation.");
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 11:     //Display Books
                    cls();
                    if (Login() != 0) {
                        l.displayBooks();
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 12:     //Display Readers
                    cls();
                    if (Login() == 1) {
                        l.displayReaders();
                    } else {
                        System.out.println("Sorry! you aren't Allowed to do this Operation.");
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 13:     //Number of Books
                    cls();
                    if (Login() == 1) {
                        Librarian.booksNum();
                    } else {
                        System.out.println("Sorry! you aren't Allowed to do this Operation.");
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 14:     //Number of Readers
                    cls();
                    if (Login() == 1) {
                        Librarian.readerNum();
                    } else {
                        System.out.println("Sorry! you aren't Allowed to do this Operation.");
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 15:     //Pay Fine
                    cls();
                    if (Login() != 0) {
                        System.out.print("Enter Reader ID: ");
                        readerID = inputStatic.nextInt();

                        System.out.print("Enter Book ID: ");
                        bookID = inputStatic.nextInt();

                        System.out.print("Enter Rental Date:-");

                        System.out.print("Day: ");
                        d = inputStatic.nextInt();

                        System.out.print("Month: ");
                        m = inputStatic.nextInt();

                        System.out.print("Year: ");
                        y = inputStatic.nextInt();

                        if (l.checkReturnDate(d, m, y)) {
                            System.out.println("No Fine, You will Pay Book's Price Only: "
                                    + "Pay: " + l.payFine(readerID, bookID, d, m, y));
                        } else {
                            System.out.println("Fine 10%, You will Pay Book's Price + Fine:-"
                                    + "Pay: " + l.payFine(readerID, bookID, d, m, y));
                        }
                    }

                    Back_Option(back_option);
                    continue;
                    //////////////////////////////////////////////////

                case 0:     //EXIT
                    cls();
                    System.out.println("<==Program  End!==>"
                            + "   | ThankYou |   ");
                    back_option = 0;
                    //////////////////////////////////////////////////
            }

        } while (back_option != 0);     //LOOP ==>During Back_fn is true
    } //End Of Program

    public static int Login() {
        int Id;
        String Password;

        {//Input Part
            System.out.println("Please Login First! \n");

            System.out.print("Enter User ID: ");
            Id = inputStatic.nextInt();

            System.out.print("Enter Password: ");
            Password = inputStatic.next();
        }

        {//Check Part
            if (Id == l.getId() && Password.equals(l.getPassword())) {
                //Librarian role
                cls();
                return 1;
            }
            else if (Id == r.getId() && Password.equals(r.getPassword())) {
                //Reader role
                cls();
                return 2;
            }
            else {
                //Invalid and try again
                cls();
                System.out.println("Oops! Invalid Login. \n");
            }
        }
        return 0;
    }

    public static boolean Back_Option(int back_option) {
        System.out.print("For Return to Menu,Enter '0': ");
        back_option = inputStatic.nextInt();

        if (back_option == 0) {
            return true;     //Back Succeed,, Returning to Menu
        }

        while (back_option != 0) { //Invalid input & Try again
            System.out.print("For Return to Menu,Enter '0': ");

            back_option = inputStatic.nextInt();

            if (back_option == 0) {
                return true;
            }
        }
        cls();
        return false;
    }

    public static void cls() {
        /*-> the screen is cleared
        by adding 50 lines in series
        it can be called through cls();
         */
        for (int i = 1; i <= 2; i++) {
            System.out.print("\n");
        }
    }
}
