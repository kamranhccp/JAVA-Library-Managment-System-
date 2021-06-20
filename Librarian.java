package Library_Management_Sys;

import java.util.*;
import java.time.LocalDate;

public class Librarian extends Person implements User {

    Scanner input = new Scanner(System.in);

    private int id;
    private String password;
    public static int bookCounter = 0;
    public static int readerCounter = 0;
    ArrayList<Reader> reader_list = new ArrayList<Reader>(50);
    ArrayList<Book> book_list = new ArrayList<Book>(50);

    public Librarian() {
    }

    public Librarian(int id, String password, String fName, String lName, String type, long phone, String address, String email, boolean isBlock) {
        super(fName, lName, type, phone, address, email, isBlock);
        this.id = id;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public boolean book_id_Existance(Book book) {   ///  BOOK ALREADY EXISTS
        for (int i = 0; i < bookCounter; i++) {
            if (book.getId() == book_list.get(i).getId()) {
                System.out.println("Book ID already Exists!");
                return false;
            }
        }
        return true;
    }

    public void addBook(Book newBook) {
        book_list.add(bookCounter, newBook);
    }

    public void preRegistered() {
        { //Pre-Registered => Readers
            Reader[] regReader = new Reader[6];

            regReader[0] = new Reader(1, "111", "Adil", "Farooq", "Student", 242552525, "Faisalabad", "adil121@gmail.com", false);
            regReader[1] = new Reader(2, "222", "Moeez", "Awaan", "Student",242552525, "Punjab", "moeez_awaan@gmail.com", true);
            regReader[2] = new Reader(3, "333", "Hamza", "Akhtar", "Child", 242552525, "Faisalabad", "hamzaakhtar23@gmail.com", true);
            regReader[3] = new Reader(4, "444", "Yasir", "Khan", "Student",242552525, "Mardan", "yasir_ales@gmail.com", true);
            regReader[4] = new Reader(5, "555", "Khalid", "Sayed", "Student", 242552525, "Malakand", "khalid_insi@gmail.com", false);
            regReader[5] = new Reader(6, "666", "Hassan", "Khan", "Student",242552525, "Swabi", "hassan_sha@gmail.com", true);



            for (int i = 0; i < regReader.length; i++) {
                this.addReader(regReader[i]);
                readerCounter++;
            }
        }

        { //Pre-Registered => Books
            Book[] regBook = new Book[10];

            regBook[0] = new Book(1, "Programming", 80.0f, "KamranHccp", "HCCP-Publishers");
            regBook[1] = new Book(2, "English", 25.5f, "Haider", "KHA-Publishers");
            regBook[2] = new Book(3, "Maths", 30.7f, "Aleesha", "KHA-Publishers");
            regBook[3] = new Book(4, "History", 45.0f, "KamranHccp", "KHA-Publishers");
            regBook[4] = new Book(5, "Science", 50.2f, "Haider", "KHA-Publishers");
            regBook[5] = new Book(6, "Geography", 36.8f, "Aleesha", "KHA-Publishers");
            regBook[6] = new Book(7, "Physics", 43.0f, "KamranHccp", "KHA-Publishers");
            regBook[7] = new Book(8, "Psychology", 12.3f, "Aleesha", "KHA-Publishers");
            regBook[8] = new Book(9, "Chemistry", 63.5f, "Haider", "KHA-Publishers");
            regBook[9] = new Book(10, "Biology", 73.2f, "KamranHccp", "KHA-Publishers");

            for (int i = 0; i < regBook.length; i++) {
                this.addBook(regBook[i]);
                bookCounter++;
            }
        }
    }

    public void addBook() {
        System.out.print("Enter number of books you want to add: ");
        int number = input.nextInt();

        if (number <= (50 - bookCounter)) {
            for (int i = 0; i < number; i++) {
                System.out.print("Enter book_id: ");
                int book_id = input.nextInt();

                System.out.print("Enter Name of the book: ");
                String name = input.next();

                System.out.print("Enter Price of the book: ");
                float price = input.nextFloat();

                System.out.print("Enter Author of the book: ");
                String author = input.next();

                System.out.print("Enter Publisher of the book: ");
                String publisher = input.next();

                Book newBook = new Book(book_id, name, price, author, publisher);

                if (this.book_id_Existance(newBook)) {
                    this.addBook(newBook);
                    bookCounter++;
                }
            }
        } else {
            System.out.println("Array of Books is Full!");
        }
    }

    public static void booksNum() {
        System.out.println("\nThere are (" + bookCounter + ") Books in the Library.");
    }

    @Override
    public int searchBook(int book_id) {
        for (int i = 0; i < bookCounter; i++) {
            if (book_id == book_list.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String Search_For_Book(int book_id) {
        if (this.searchBook(book_id) != -1) {
            return book_list.get(book_id - 1).getName();
        } else {
            System.out.println("ID not found");
            return "Null";
        }
    }

    public void removeBook(int book_id) {
        book_id -= 1;

        if (this.searchBook(book_id) != -1 /* SEARCH IF book id EXISTS or NOT */) {
            book_list.remove(book_id);
            bookCounter--;
        } else {
            System.out.println("ID not found");
        }
    }

    public void displayBooks() { // DISPLAY ALL BOOKS
        System.out.println("");
        for (int i = 0; i < bookCounter; i++) {
            System.out.println("<====BOOKS AVAILABLE====> \n"
                    + " | Book ID: " + book_list.get(i).getId() + " "
                    + " | Book Name: " + book_list.get(i).getName() + " "
                    + " | Book Price: " + book_list.get(i).getPrice() + " "
                    + " | Book Author: " + book_list.get(i).getAuthor() + " "
                    + " | Book Publisher: " + book_list.get(i).getPublisher());
        }
    }

    public boolean reader_id_Existance(Reader reader) {
        for (int i = 0; i < readerCounter; i++) {
            if (reader.getId() == reader_list.get(i).getId()) {
                System.out.println("Reader ID already Exists");
                return false;
            }
        }
        return true;
    }

    public void addReader(Reader newReader) {
        reader_list.add(readerCounter, newReader);
    }

    public void addReader() {
        System.out.print("Enter number of readers you want to add: ");
        int number_reader = input.nextInt();

        if (number_reader <= (50 - readerCounter)) {
            for (int i = 0; i < number_reader; i++) {
                System.out.print("Enter Reader's ID: ");
                int id = input.nextInt();

                System.out.print("Enter Reader's Password: ");
                String password = input.next();

                System.out.print("Enter Reader's First Name: ");
                String fName = input.next();

                System.out.print("Enter Reader's Last Name: ");
                String lName = input.next();

                System.out.print("Enter Reader's Type: ");
                String type = input.next();

                System.out.print("Enter Reader's Phone Number: ");
                long phone = input.nextLong();

                System.out.print("Enter Reader's Address: ");
                String address = input.next();

                System.out.print("Enter Reader's Email: ");
                String email = input.next();

                System.out.print("Is the reader Blocked(true/false): ");
                boolean isBlock = input.nextBoolean();

                Reader newReader = new Reader(id, password, fName, lName, type, phone, address, email, isBlock);
                if (this.reader_id_Existance(newReader)) {
                    this.addReader(newReader);
                    readerCounter++;
                }
            }
        } else {
            System.out.println("No space to add more Users!");
        }
    }

    @Override
    public int searchUser(int user_id) {
        for (int i = 0; i < readerCounter; i++) {
            if (user_id == reader_list.get(i).getId()) {
                return i;
            }
        }
        return -1;
    }

    public void removeUser(int user_id) {
        user_id -= 1;

        if (this.searchUser(user_id) != -1 /* IF Reader ID EXISTS or NOT*/) {
            reader_list.remove(user_id);
            readerCounter--;
        } else {
            System.out.println("Sorry! Reader not found.");
        }
    }

    public static void readerNum() {
        System.out.println("There are (" + readerCounter + ") Readers in the Library");
    }

    public void displayReaders() {
        System.out.println("");
        for (int i = 0; i < readerCounter; i++) {
            System.out.println(
                      "Reader's ID: " +reader_list.get(i).getId() + " | "
                    + "Reader's FirstName: " + reader_list.get(i).getfName() + " | "
                    + "Reader's LastName: " + reader_list.get(i).getlName() + " | "
                    + "Reader's Type: " + reader_list.get(i).getType() + " | "
                    + "Reader's PhoneNumber: " + reader_list.get(i).getPhone() + " | "
                    + "Reader's Address: " + reader_list.get(i).getAddress() + " | "
                    + "Reader's Email: " + reader_list.get(i).getEmail() + " | "
                    + "Reader's Block Face: " + reader_list.get(i).isIsBlock());
        }
    }

    public void Add_ReaderToBook(int reader_id, int book_id, String name) {
        if (this.searchUser(reader_id) != -1 && this.searchBook(book_id) != -1) {
            if (reader_list.get(reader_id).isIsBlock() && book_list.get(book_id).getReader_id() != 0) {
                System.out.println("Reader is Blocked or Book already Rented");
            } else {
                book_list.get(book_id).setReader_name(name);
                book_list.get(book_id).setReader_id(reader_id);
            }
        } else {
            System.out.println("Reader or Book not Found");
        }
    }

    public void Remove_ReaderFromBook(int book_id) {
        if (this.searchBook(book_id) != -1) {
            book_list.get(book_id).setReader_name(null);
            book_list.get(book_id).setReader_id(0);
        } else {
            System.out.println("Sorry! Book not found.");
        }
    }

    public void blockUser(int user_id) {
        if (this.searchUser(user_id) != -1) {
            reader_list.get(user_id).setIsBlock(true);
        } else {
            System.out.println("Sorry! Reader not found.");
        }
    }

    public Boolean checkReturnDate(int day, int month, int year) {
        LocalDate weekAgo = LocalDate.now().minusWeeks(1);
        LocalDate rentDate = LocalDate.of(year, month, day);
        if (rentDate.compareTo(weekAgo) >= 0 && rentDate.compareTo(weekAgo) <= 7) {
            return true; //Valid
        } else {
            return false; //Not-Valid
        }
    }

    public float payFine(int reader_id, int book_id, int day, int month, int year) {
        if (this.checkReturnDate(day, month, year)) {
            return book_list.get(book_id).getPrice();
        } else {
            //If checkReturnDate() is => False => then Fine 10% of the Book's Price
            return (book_list.get(book_id).getPrice() + (book_list.get(book_id).getPrice()) * 0.1f);
        }
    }

    @Override
    public void rentBook() {
        System.out.print("Enter Reader id: ");
        int readerId = input.nextInt();

        System.out.print("Enter Book id: ");
        int bookId = input.nextInt();

        if (this.searchUser(readerId) != -1 && this.searchBook(bookId) != -1) {
            if (reader_list.get(readerId).isIsBlock() && book_list.get(bookId).getReader_id() != 0) {
                System.out.println("Reader is Blocked or Book already Rented");
            } else {
                System.out.println("Enter Rental date =>");
                System.out.print("Day: ");
                int d = input.nextShort();
                System.out.print("Month: ");
                int m = input.nextShort();
                System.out.print("Year: ");
                int y = input.nextInt();

                if (this.checkReturnDate(d, m, y)) {
                    System.out.println("It is a Week ago, Neither Block or Fined!");
                } else {
                    System.out.println("Exceeded a week, You are Blocked with Fine 10%.");
                    reader_list.get(readerId).setIsBlock(true);
                }

                System.out.println("You Should pay: " + payFine(readerId, bookId, d, m, y));
            }
        } else {
            System.out.println("Reader or Book not Found.");
        }
    }


    /////////////////

    /*
    book_01 = (1, "Programming", 80.0f, "KamranHccp", "HCCP-Publishers");
    regBook[1] = new Book(2, "English", 25.5f, "Haider", "KHA-Publishers");
    regBook[2] = new Book(3, "Maths", 30.7f, "Aleesha", "KHA-Publishers");
    regBook[3] = new Book(4, "History", 45.0f, "KamranHccp", "KHA-Publishers");
    regBook[4] = new Book(5, "Science", 50.2f, "Haider", "KHA-Publishers");
    regBook[5] = new Book(6, "Geography", 36.8f, "Aleesha", "KHA-Publishers");
    regBook[6] = new Book(7, "Physics", 43.0f, "KamranHccp", "KHA-Publishers");
    regBook[7] = new Book(8, "Psychology", 12.3f, "Aleesha", "KHA-Publishers");
    regBook[8] = new Book(9, "Chemistry", 63.5f, "Haider", "KHA-Publishers");
    regBook[9] = new Book(10, "Biology", 73.2f, "KamranHccp", "KHA-Publishers");
     */
}