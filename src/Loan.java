
/* 
    Properties: book, member, borrowedDate, dueDate, fineAmount
    Methods: calculateFine(), getters and setters for all properties
*/
import java.util.Calendar;
import java.util.Date;

public class Loan {
    private Book book;
    private Member member;
    private Date borrowDate;
    private Date returnDate;
    private Date dueDate;
    private double fineAmount;

    public Loan (Book book, Member member, Date borrowDate) {
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        // this.returnDate = returnDate;
        calculateDueDate(borrowDate);
        this.fineAmount = 0.0; 
    }

    public void calculateDueDate(Date borrowDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(borrowDate);
        calendar.add(Calendar.DAY_OF_YEAR, 7);
        this.dueDate = calendar.getTime();
    }

    public double calculateFine(Date returnDate) {
        // Check if overdue
        if (returnDate.after(dueDate)) {
            long overdueDays = (returnDate.getTime() - dueDate.getTime()) / (1000 * 60 * 60 * 24);
            return overdueDays * 50;
        } 
        else {
            // No fine if not overdue
            return 0.0;
        }
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
        this.fineAmount = calculateFine(returnDate); // Recalculate fine upon setting return date
    }

    public Book getBook() {
        return this.book;
    } 
}
