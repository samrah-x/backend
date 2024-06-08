/*
o	Properties: title, author, ISBN, category, available (boolean)

 */
import java.util.Date;

public class Book extends Item {
    private String title;
    private String author;
    private String ISBN;
    private String category;
    private boolean isAvailable;
    private Date borrowDate;
    private Date returnDate;
    private long borrowDuration;

// CONSTRUCTORS
    public Book (String title, String author, String ISBN, String category, boolean isAvailable){
        title = this.title;
        author = this.author;
        ISBN = this.ISBN;
        category= this.category;
        isAvailable= true;
    }

// Methods: borrow(), returnBook(), calculateFine(), 
    public void borrow () {
        this.isAvailable = false;
        this.borrowDate = new Date(System.currentTimeMillis());
    }

    public void returnBook() {
        this.borrowDuration = calculateBorrowDurationInDays(borrowDate, returnDate); 
        if (isAvailable) {
            System.out.println("Book is already returned.");
        }
        else {
            this.returnDate = new Date(System.currentTimeMillis());
            this.isAvailable = true;
        }
    }
    // no calculate fine

// getters and setters for all properties
    // SETTERS
    public void setName(String title) {
        title = this.title;
    }
    
    public void setAuthor(String author) {
        author = this.author;
    }
    
    public void setISBN(String ISBN) {
        ISBN = this.ISBN;
    }

    public void setCategory(String category) {
        category= this.category;
    }

    public void setStatus(boolean isAvailable) {
        isAvailable= this.isAvailable;
    }    

    // GETTERS
    public String getAuthor() {
        return author;
    }
    
    public String getISBN() {
        return ISBN;
    }

    public String getCategory() {
        return category;
    }

    public boolean getStatus() {
        return isAvailable;
    }   

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

// Overrides: getID() to return book-specific ID
    @Override
    public String getName() {   
        return title;
    }

    @Override
    public int getID() {
        return super.ID;
    }
    
// borrow date functions 
    public static long calculateBorrowDurationInMilliseconds(Date borrowDate, Date returnDate) {
        return returnDate.getTime() - borrowDate.getTime();
    }
  
    public static long calculateBorrowDurationInDays(Date borrowDate, Date returnDate) {
        long milliseconds = calculateBorrowDurationInMilliseconds(borrowDate, returnDate);
        return milliseconds / (24 * 60 * 60 * 1000); // Conversion to days
    }

    public boolean isAvailable() {
        return isAvailable;
      }
}
