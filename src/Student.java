import java.time.LocalDate;

public abstract class Student {
    protected FullName fullName;
    protected LocalDate doB;
    protected String gender;
    protected final String[] genderList = {"male", "female", "LGBT"};
    protected String phoneNumber;
    protected String universityName;
    protected String gradeLevel;

    public Student(FullName fullName, LocalDate doB, int gender, String phoneNumber, String universityName, String gradeLevel) {
        this.fullName = fullName;
        this.doB = doB;
        this.gender = this.genderList[gender - 1];
        this.phoneNumber = phoneNumber;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return fullName.equals(student.fullName) && doB.equals(student.doB) && gender.equals(student.gender) && phoneNumber.equals(student.phoneNumber) && universityName.equals(student.universityName) && gradeLevel.equals(student.gradeLevel);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(fullName, doB, gender, phoneNumber, universityName, gradeLevel);
//    }

    @Override
    public String toString() {
        return "Student{" +
                "fullName=" + fullName +
                ", doB=" + doB.toString() +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", universityName='" + universityName + '\'' +
                ", gradeLevel='" + gradeLevel + '\'' +
                '}';
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDoB() {
        return doB;
    }

    public void setDoB(LocalDate doB) {
        this.doB = doB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = genderList[gender];
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }
}
