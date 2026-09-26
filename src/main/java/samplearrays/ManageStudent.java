package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {


    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if ( students == null || students.length == 0){
            return null;
        }
        Student oldest = students[0];
        for(Student s : students){
            if (s.getAge() > oldest.getAge()){
                oldest = s;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for(Student s : students){
            if(s.getAge() >= 18){
                count ++;
            }
        }
        return count;

    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students == null || students.length == 0 ){
            return 0.0;
        }
        double sum = 0;
        for(Student s:students){
            sum += s.getGrade();
        }
        return  sum/(students.length);
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(Student s : students){
            if (s.getName() == name){
                return s;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        if ( students == null || students.length == 0){
            return;
        }
        for(int i = 0 ; i <= students.length - 2  ; i ++){
            for(int j = 0; j <= students.length - i - 2; j++) {
                if (students[j].getGrade() < students[j+1].getGrade()) {
                    Student temp = students[j+1];
                    students[j+1] = students[j];
                    students[j] = temp;
                }
            }
        }

    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(Student s : students){
            if(s.getGrade() >= 15){
                System.out.print(s.getName() +" ");
            }
        }
        System.out.println();
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(Student s : students) {
            if (s.getId() == id) {
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        if ( students == null || students.length == 0){
            return false;
        }
        for(int i = 0; i < students.length ; i ++) {
            String name_i = students[i].getName();
            for (int j = 0; j < students.length; j++) {
                if(name_i == students[j].getName() && i != j){
                    System.out.println("Duplicates found");
                    return true;
                }
            }
        }
        return  false;

    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        if ( students == null || students.length == 0){
            return new Student[] {newStudent};
        }
        Student[] new_arr = new Student[students.length + 1 ];
        for(int i = 0 ; i < students.length ; i ++ ){
            new_arr[i] = students[i];
        }
        new_arr[students.length] = newStudent;
        return  new_arr;

    }
    // 11) 2D School array

    public static Student[][] school_matrix(Student[] students, int numClasses,int numStudents){
        if ( students == null || students.length < numClasses*numStudents){
            return null;
        }
        Student[][] school = new Student[numClasses][numStudents];
        for(int i = 0 ; i < numClasses ; i ++){
            System.out.print("The students of class " + (i+1) + " are : ");
            for(int j = 0 ; j < numStudents ; j++){
                school[i][j] = students[numStudents*(i)+j];
                System.out.print(school[i][j].getName() + " ");
            }
            System.out.println();
        }
        return school;

    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student r1 = new Student(1,"Amine");
        r1.setAge(17);
        r1.setGrade(18);
        Student r2 = new Student(2,"Omar",21);
        r2.setGrade(12);
        Student r3 = new Student(3,"Yasser",19,15);
        Student r4 = new Student(4,"Ahmed",17);
        r4.setGrade(13);
        Student r5 = new Student(5,"Saad");
        r5.setAge(16);
        r5.setGrade(18);

        Student[] arr = new Student[5];
        arr[0] = r1;
        arr[1] = r2;
        arr[2] = r3;
        arr[3] = r4;
        arr[4] = r5;
        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("\nThe oldest student : " + findOldest(arr));

        // 3) Count adults
        System.out.println("\nThe number of adults is : " + countAdults(arr));

        // 4) Average grade
        System.out.println("\nThe average grade is : " + averageGrade(arr));

        // 5) Find by name
        System.out.println("\nThe student with name Amine is : " + findStudentByName(arr,"Amine"));

        // 6) Sort by grade desc
        // sort function
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        // function
        System.out.println("\nUpdated id=4? " + updateGrade(arr,4,13));
        System.out.println("\nDoes the array contain a student names Dina ? " + findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println();
        System.out.println("Does the array contain duplicate names? " + hasDuplicateNames(arr));

        // 10) Append new student

        Student r6 = new Student(6,"Adam",19,14);
        Student[] updatedArray = appendStudent(arr,r6);
        System.out.println("\n== All Students ==");
        for (Student s : updatedArray) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 11) School matrix
        System.out.println();
        Student[][] school = school_matrix(updatedArray, 2,3);

    }
}

