import java.util.ArrayList;
import java.util.Date;

public class Member {
  private String name;
  private long contactNo;
  private String emailId;
  private ArrayList<Loan> borrowingHistory = new ArrayList<>();

  public Member(String name, long contactNo, String emailId) {
    this.name = name;
    this.contactNo = contactNo;
    this.emailId = emailId;
  }

  // Getters
  public String getName() {
    return name;
  }

  public long getContactNo() {
    return contactNo;
  }

  public String getEmailId() {
    return emailId;
  }

  // Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setContactNo(long contactNo) {
    this.contactNo = contactNo;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  // Borrowing methods with potential error handling
  public boolean borrowBook(Book book) {
    if (book.isAvailable()) {
      book.borrow();
      borrowingHistory.add(new Loan(book, this, new Date())); // Update history with new loan
      return true;
    } else {
      System.out.println("Book \"" + book.getName() + "\" is not currently available.");
      return false;
    }
  }

  public void returnBook(Book book) {
    book.returnBook();
  }

  // Improved viewHistory with formatted output
  public ArrayList<Loan> viewHistory() {
    if (borrowingHistory.isEmpty()) {
      System.out.println("No borrowing history found.");
      return borrowingHistory;
    }

    System.out.println("Borrowing History:");
    for (Loan loan : borrowingHistory) {
      System.out.println("- Book: " + loan.getBook().getName());
      // You can display additional loan details like borrow date, return date, fine amount (if applicable) here
    }
    return borrowingHistory;
  }

  // Private method to avoid direct manipulation of borrowingHistory (optional)
  private void addToBorrowingHistory(Loan loan) {
    borrowingHistory.add(loan);
  }
}
