public class PerformanceReview {
    private int employeeId;
    private int rating; // 1 to 5
    private String feedback;

    public PerformanceReview(int employeeId, int rating, String feedback) {
        this.employeeId = employeeId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public int getEmployeeId() { return employeeId; }
    public int getRating() { return rating; }
    public String getFeedback() { return feedback; }

    public String toString() {
        return "Rating: " + rating + "/5 | Feedback: " + feedback;
    }
}
