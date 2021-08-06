import java.time.LocalDate;

public class GoodStudent extends Student {
    private static int count = 0;
    private final String id;
    private double gpa;
    private String bestRewardName;

    public GoodStudent(FullName fullName, LocalDate doB, int gender, String phoneNumber, String universityName, String gradeLevel, double gpa, String bestRewardName) {
        super(fullName, doB, gender, phoneNumber, universityName, gradeLevel);
        this.id = "G_" + count;
        count++;
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                super.toString() +
                "GoodStudent{" +
                ", gpa=" + gpa +
                ", bestRewardName='" + bestRewardName + '\'' +
                '}';
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    public String getId() {
        return id;
    }
}
