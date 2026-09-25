package samplearrays;

public class CourseNumbersArray {
    public static int[] updateCourse(int courseNum, int[] registeredCourses){
        int n = registeredCourses.length + 1;
        int[] updatedCourses = new int[n];
        for( int i = 0 ; i < registeredCourses.length ; i ++){
            updatedCourses[i] = registeredCourses[i];
        }
        updatedCourses[n-1] = courseNum;
        return updatedCourses;
    }
    public static void printArray(int[] arr ,String arr_name){
        System.out.print("The elements of the array "+ arr_name +" are : ");
        for( int i = 0 ; i < arr.length ; i ++){
            if (i != arr.length -1) {
                System.out.print(arr[i] + ", ");
            }
            else{
                System.out.print(arr[i]);
            }
        }
        System.out.println("");
    }
    public static boolean checkInclusion(int[] arr, int num){
        for( int i = 0 ; i < arr.length ; i ++){
            if (arr[i] == num){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        printArray(registeredCourses,"registeredCourses");
        System.out.println("Adding 2000 to updatedCourses .........");
        int[] updatedCourses = updateCourse(2000,registeredCourses);
        printArray(updatedCourses,"updatedCourses");
        System.out.println("Does updatedCourses include 2000? : " + checkInclusion(updatedCourses,2080));
        System.out.println("Does updatedCourses include 2111? : " + checkInclusion(updatedCourses,2111));
    }
}
