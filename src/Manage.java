import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    public static final Scanner scn = new Scanner(System.in);

    private final ArrayList<GoodStudent> GoodStudentList = new ArrayList<>();
    private final ArrayList<NormalStudent> NormalStudentList = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> excommunicateStudent(int numberOfStudent){
        ArrayList<GoodStudent> currentListGood = new ArrayList<>(GoodStudentList);
        ArrayList<NormalStudent> currentListNor = new ArrayList<>(NormalStudentList);
        ArrayList<Student> studentPass = new ArrayList<>();

        if (numberOfStudent <= currentListGood.size()){
            sortArrayListByGPA(currentListGood);
            for(int i = 0; i < numberOfStudent; i++){
                studentPass.add(currentListGood.get(i));
            }
        } else {
            studentPass.addAll(currentListGood);
            sortArrayListByTOEIC(currentListNor);
            if(numberOfStudent - studentPass.size() >= currentListNor.size()){
                studentPass.addAll(currentListNor);
                return null;
            }
            for (int i = 0; i <= numberOfStudent - studentPass.size(); i++) {
                studentPass.add(currentListNor.get(i));
            }
        }
        return studentPass;
    }

    public void sortArrayListByGPA(ArrayList<GoodStudent> currentList){
        for(int i = 0; i < currentList.size() - 1; i++){
            int studentIndex = i;
            for(int j = i + 1; j < currentList.size(); j++){
                if(currentList.get(studentIndex).getGpa() < currentList.get(j).getGpa()){
                    studentIndex = j;
                }
            }
            GoodStudent currentStudent = currentList.get(studentIndex);
            currentList.set(studentIndex, currentList.get(i));
            currentList.set(i, currentStudent);
        }
    }

    public void sortArrayListByTOEIC(ArrayList<NormalStudent> currentList){
        for(int i = 0; i < currentList.size() - 1; i++){
            int studentIndex = i;
            for(int j = i + 1; j < currentList.size(); j++){
                if(currentList.get(studentIndex).getTOIEC() < currentList.get(j).getTOIEC()){
                    studentIndex = j;
                }
            }
            NormalStudent currentStudent = currentList.get(studentIndex);
            currentList.set(studentIndex, currentList.get(i));
            currentList.set(i, currentStudent);
        }
    }

    public void showStudent(ArrayList<Student> students){
        for (Student student : students) {
            System.out.println();
            if(student instanceof GoodStudent){
                System.out.println((GoodStudent)student);
            }else if(student instanceof NormalStudent){
                System.out.println((NormalStudent)student);
            }
        }
    }

    public void showGoodStudent(ArrayList<GoodStudent> goodStudentList) {
        for (GoodStudent student: goodStudentList) {
            System.out.println();
            System.out.println(student);
        }
    }

    public void showNormalStudent(ArrayList<NormalStudent> normalStudentList) {
        for (NormalStudent student: normalStudentList) {
            System.out.println();
            System.out.println(student);
        }
    }

    public boolean checkNull(ArrayList list){
        if(list.size() == 0){
            return false;
        }
        return true;
    }

    public ArrayList<Student> searchStudentByName(String keyword){
        ArrayList<Student> studentSearched = new ArrayList<>();

        for (Student student : this.students) {
            if(student.getFullName().toString().toLowerCase().contains(keyword.toLowerCase())){
                studentSearched.add(student);
            }
        }
        return studentSearched;
    }

    public Student searchStudentById(String id){
        for (Student student : this.students) {
            if(student instanceof GoodStudent){
                if(((GoodStudent) student).getId().equals(id)){
                    return  student;
                }
            } else if(student instanceof NormalStudent){
                if( ((NormalStudent) student).getId().equals(id)){
                    return student;
                }
            }
        }
        return null;
    }

    public void addStudent(Student student){
        if(student instanceof GoodStudent){
            GoodStudentList.add( (GoodStudent) student);
        }else if(student instanceof NormalStudent){
            NormalStudentList.add( (NormalStudent) student );
        }
        students.add(student);
    }

    public LocalDate createDate(){
        LocalDate dob;

        System.out.print("+ year: ");
        int year = Integer.parseInt(scn.nextLine());

        System.out.print("+ month: ");
        int month = Integer.parseInt(scn.nextLine());

        System.out.print("+ day: ");
        int day = Integer.parseInt(scn.nextLine());

        try{
            dob = LocalDate.of(year, month, day);
        } catch (Exception e){
            System.out.println("*the day is invalid, please try again");
            return createDate();
        }
        return dob;
    }

//    public void inputGender(){
//        System.out.print("gender(1: male, 2: femail, 3: LGBT): ");
//        int gender = Integer.parseInt(scn.nextLine());
//
//        try{
//
//        } catch (Exception e){
//
//        }
//    }

    public FullName createName(){
        System.out.println();
        System.out.println("- full name -");
        System.out.print("+ first name: ");
        String firstName = scn.nextLine();

        System.out.print("+ surname: ");
        String surname = scn.nextLine();

        return new FullName(firstName, surname);
    }

    public Student createStudent(){
        FullName fullName = createName();

        System.out.println();
        System.out.println("- day of birth -");
        LocalDate dob = createDate();
        System.out.println();

        int gender = (int) inputCheckNumber(1, 3, "+ gender(1: male, 2: femail, 3: LGBT)");

        System.out.print("+ phone: ");
        String phone = scn.nextLine();

        System.out.print("+ university: ");
        String uni = scn.nextLine();

        System.out.print("+ grade ( good || normal ) : ");
        String grade = scn.nextLine();

        if(grade.equalsIgnoreCase("good")){
            return createGoodStudent(fullName, dob, gender, phone, uni, grade);
        }
            return createNormalStudent(fullName, dob, gender, phone, uni, grade);
    }

    public GoodStudent createGoodStudent(FullName fullName, LocalDate doB, int gender, String phoneNumber, String universityName, String gradeLevel) {
        System.out.println();
        System.out.println("- good student -");
        double mark = inputCheckNumber(0, 10, "+ GPA");

        System.out.print("+ best reward: ");
        String reward = scn.nextLine();

        return new GoodStudent(fullName, doB, gender, phoneNumber, universityName, gradeLevel, mark, reward);
    }

    public NormalStudent createNormalStudent(FullName fullName, LocalDate doB, int gender, String phoneNumber, String universityName, String gradeLevel) {
        System.out.println();
        System.out.println("- normal student -");
        int toeic = (int) inputCheckNumber(0, 990, "+ TOEIC");

        double entryTestScore = inputCheckNumber(0, 10, "+ test score");

        return new NormalStudent(fullName, doB, gender, phoneNumber, universityName, gradeLevel, toeic, entryTestScore);
    }

    public double inputCheckNumber(double x, double y, String text){
        System.out.print(text + ": ");
        double mark = Double.parseDouble(scn.nextLine());
        try{
            if(mark < x || mark > y){
                throw new Exception("*invalid value, valid value must be between " + x +" and " + y);
            }
        } catch (Exception e){
            System.out.println(e.toString());
            return inputCheckNumber(x, y, text);
        }
        return mark;
    }

    public ArrayList<GoodStudent> getGoodStudentList() {
        return GoodStudentList;
    }

    public ArrayList<NormalStudent> getNormalStudentList() {
        return NormalStudentList;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }


}
