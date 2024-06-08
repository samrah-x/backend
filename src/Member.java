/*
	Properties: name, contactInfo, borrowingHistory (list of loans)
	Methods: borrowBook(Book book), returnBook(Book book), viewHistory(), getters and setters for all properties
 */

import java.util.ArrayList;

public class Member {
    private String name;
    private long contactNo;
    private String emailId;
    private ArrayList<Loan> borrowingHistory = new ArrayList<>();

    public Member(String name, long contactNo, String emailId) {
        name = this.name;
        contactNo = this.contactNo;
        emailId = this.emailId;
    }

    // GETTERS
    public String getName() {
        return name;
    }

    public long getContactNo() {
        return contactNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getBorrowingHistory() {
        return borrowingHistory.toString();
    }

    // SETTERS
    public void setName(String name) {
        name = this.name;
    }

    public void setContactNo(long contactNo) {
        contactNo = this.contactNo;
    }

    public void setEmailId(String emailId) {
        emailId = this.emailId;
    }

    public void setBorrowingHistory(Loan loan) {
        borrowingHistory.add(loan);
    }

    public void borrowBook(Book book) {
        book.borrow();
    }

    public void returnBook(Book book) {
        book.returnBook();
    }

    public void viewHistory() {
        System.out.println(getBorrowingHistory());
    }

}
