public class Main {
    Manage ctrl = new Manage();

    public void menu(){
        System.out.println();
        System.out.println("""
                1: add student
                2: show all
                3: show good students
                4: show normal students
                5: choice students for company
                6: sort by GPA ( for good student )
                7: sort by TOEIC ( for normal student )
                8: search student by first name
                9: search student by ID ( "G_x" or "N_x" )
                10: exit\040
                """);
        System.out.print("input your choice: ");
        switch (Integer.parseInt(Manage.scn.nextLine())){
            case 1 -> {
                this.addStudent();
            }
            case 2 -> {
                this.showAll();
            }
            case 3 -> {
                this.showGoodStudent();
            }
            case 4 -> {
                this.showNormalStudent();
            }
            case 5 -> {
                this.choiceStudentForCompany();
            }
            case 6 -> {
                this.sortByGPA();
            }
            case 7 -> {
                this.sortByTOEIC();
            }
            case 8 -> {
                this.searchByFirstName();
            }
            case 9 -> {
                this.searchById();
            }
            case 10 -> {
                return;
            }
        }
        System.out.println();
        menu();
    }

    public void addStudent(){
        System.out.println();
        System.out.print("- number of students: ");
        int number = Integer.parseInt(Manage.scn.nextLine());

        for (int i = 1; i <= number; i++) {
            System.out.println();
            System.out.println("student " + i);
            ctrl.addStudent(ctrl.createStudent());
        }
    }

    public void showAll(){
        System.out.println();
        var current = ctrl.getStudents();
        if(ctrl.checkNull(current)){
            ctrl.showStudent(current);
            return;
        }
        System.out.println("***there are no any students");
    }

    public void showGoodStudent(){
        System.out.println();
        var current = ctrl.getGoodStudentList();
        if(ctrl.checkNull(current)){
            ctrl.showGoodStudent(current);
            return;
        }
        System.out.println("***there are no any students");
    }

    public void showNormalStudent(){
        System.out.println();
        var current = ctrl.getNormalStudentList();
        if(ctrl.checkNull(current)){
            ctrl.showNormalStudent(current);
            return;
        }
        System.out.println("***there are no any students");
    }

    public void choiceStudentForCompany(){
        System.out.println();
        System.out.print("- number of students you want to choice: ");
        int number = Integer.parseInt(Manage.scn.nextLine());

        var current = ctrl.excommunicateStudent(number);
        if(ctrl.checkNull(current)){
            ctrl.showStudent(current);
            return;
        }
        System.out.println("***there are no any students");
    }

    public void sortByGPA(){
        System.out.println();
        var current = ctrl.getGoodStudentList();
        if(ctrl.checkNull(current)){
            ctrl.sortArrayListByGPA(current);
            ctrl.showGoodStudent(current);
            return;
        }
        System.out.println("***there are no any students");
    }

    public void sortByTOEIC(){
        System.out.println();
        var current = ctrl.getNormalStudentList();
        if(ctrl.checkNull(current)){
            ctrl.sortArrayListByTOEIC(current);
            ctrl.showNormalStudent(current);
            return;
        }
        System.out.println("***there are no any students");
    }

    public void searchByFirstName(){
        System.out.println();
        System.out.print("- enter a first name: ");
        String firstName = Manage.scn.nextLine();

        var current = ctrl.searchStudentByName(firstName);
        if(ctrl.checkNull(current)){
            ctrl.showStudent(current);
            return;
        }
        System.out.println("***there are no any students");
    }

    public void searchById(){
        System.out.println();
        System.out.print("- enter an id ( \"G_x\" or \"N_x\" ): ");
        String id = Manage.scn.nextLine();

        var current = ctrl.searchStudentById(id);
        if(current != null){
            System.out.println(current);
            return;
        }
        System.out.println("***there are no any students");
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.menu();
    }

}
