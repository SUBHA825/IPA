import java.util.*;
public class SecondTask {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();sc.nextLine();
        Employee[]emp=new Employee[n];
        for (int i=0;i<n;i++){
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            char d = sc.next().charAt(0);sc.nextLine();
            double e = sc.nextdouble();sc.nextLine();
            emp[i]=new Employee(a,b,c,d,e);
            }
        int age = sc.nextInt();
        Employee[] ans1= getemployeewithsecondlowestsalary(emp);
        if(ans1!=null){
            for(int i=0;i<ans1.length;i++){
                System.out.println(ans1[i].getEmployeeid() + "#" + ans1[i].getEmployeename());
            }
        }
        else{
            System.out.println("null");
        }
        int ans2 = countEmployeesBasedOnAge(emp, age);
        if(ans2!=null){
            System.out.println(ans2);
        }
        else{
            System.out.println("not found");
        }


    }
    public static Employee[] getemployeewithsecondlowestsalary(Employee[] e) {
        Employee[] det = new Employee[0];
        if (e.length > 1) {
            for (int i = 0; i < e.length; i++) {
                for (int j = i; j < e.length; j++) {
                    if (e[i].getSalary() > e[j].getSalary()) {
                        Employee temp = e[i];
                        e[i] = e[j];
                        e[j] = temp;
                    }
                }
            }
            Employee min = e[0];
            for (int i = 0; i < e.length; i ++) {
                if (e[i].getSalary() > e[0].getSalary()) {
                    det = Arrays.copyOf(det, det.length + 1);
                    det[det.length - 1] = e[i];
                    break;
                }
            }
            for (int i = 0; i < e.length; i++) {
                if (det[0].getSalary() == e[i].getSalary() && det[0].getEmployeeid() != e[i].getEmployeeid()) {
                    det[det.length - 1] = e[i];
                }
            }
            return det;
        }
        return null;
    }
    public static int countEmployeesBasedOnAge(Employee[] e, int a){
        int count=0;
        for(int i=o;i<e.length;i++){
            if(e[i].getAge()==a){
                count++;
            }
        }
        return count;
    }
}
class Employee{
    private int employeeid;
    private String employeename;
    private int age;
    private char gender;
    private double salary;

    public Employee(int employeeid, String employeename, int age, char gender, double salary) {
        this.employeeid = employeeid;
        this.employeename = employeename;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }
    public int getEmployeeid(){
        return employeeid;
    }
    public void setEmployeeid(int employeeid){
        this.employeeid=employeeid;
    }
    public String getEmployeename(){
        return employeename;
    }
    public void setEmployeename(String employeename){
        this.employeename=employeename;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public char getGender(){
        this.gender=gender;
    }
    public void setGender(char gender){
        this.gender=gender;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
}