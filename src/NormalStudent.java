import java.time.LocalDate;

public class NormalStudent extends Student {
    private static int count = 0;
    private final String id;
    private int TOIEC; //diem TOIEC
    private double entryTestScore;

    public NormalStudent(FullName fullName, LocalDate doB, int gender, String phoneNumber, String universityName, String gradeLevel, int TOIEC, double entryTestScore) {
        super(fullName, doB, gender, phoneNumber, universityName, gradeLevel);
        this.id = "N_" + count;
        count++;
        this.TOIEC = TOIEC;
        this.entryTestScore = entryTestScore;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                super.toString() +
                "NormalStudent{" +
                ", TOIEC=" + TOIEC +
                ", entryTestScore=" + entryTestScore +
                '}';
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        NormalStudent.count = count;
    }

    public String getId() {
        return id;
    }

    public int getTOIEC() {
        return TOIEC;
    }

    public void setTOIEC(int TOIEC) {
        this.TOIEC = TOIEC;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }
}
