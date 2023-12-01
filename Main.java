
//import java.sql.SQLOutput;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the company name :");
        String cn = sc.nextLine();
        System.out.println("no of employees :");
        int num=sc.nextInt();sc.nextLine();
        Employee[]emp=new Employee[num];
        System.out.println("Enter emloyee details :");
        for(int i=0;i< emp.length;i++){
            System.out.println("employee "+(i+1)+":");
            System.out.println("enter id :");
            int id=sc.nextInt();sc.nextLine();
            System.out.println("enter the name :");
            String name= sc.nextLine();
            System.out.println("enter designation :");
            String des=sc.nextLine();
            System.out.println("enter salary :");
            double sal=sc.nextInt();sc.nextLine();
            emp[i]=new Employee(id,name,des,sal);
        }
        Company com = new Company(cn,emp,num);
        System.out.println("Average Salary :"+com.getAverageSalary(emp));
        System.out.println("Max Salary :"+com.getMaxSalary(emp));
        System.out.println("Enter with the designation :");
        String desi=sc.nextLine();
        Employee[] ans = com.getEmployeesByDesignation(emp,desi);
        if(ans!=null){
            for (int i=0;i< ans.length;i++){
                System.out.println("ID :"+ans[i].getId()+",Name :"+ans[i].getName()+",Designation :"+ans[i].getDes()+",Salary:"+ans[i].getSalary());

            }





        }
    }


}

class Employee{
    private int id;
    private String name;
    private String des;
    private double salary;
    public Employee(int id, String name, String des, double salary){
        this.id=id;
        this.name=name;
        this.des=des;
        this.salary=salary;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDes(){
        return des;
    }
    public void setDes(String des){
        this.des=des;
    }
    public double getSalary(){
        return salary;
    }
    public void setSalary(double salary){
        this.salary=salary;
    }
}
class Company{
    private String cn;
    private Employee[] emp;
    private int numEmp;
    public Company(String cn,Employee[] emp, int numEmp){
        this.cn=cn;
        this.emp=emp;
        this.numEmp=numEmp;
    }
    public double getAverageSalary(Employee[] e){
        double sum=0;
        for (int i=0;i<e.length;i++){
            sum+=e[i].getSalary();
        }
        if(sum>0){
            double avg=sum/e.length;
            return avg;
        }
        return 0;
    }
    public double getMaxSalary(Employee[] e){
        double maxsalary = e[0].getSalary();
        for(int i=0;i<e.length;i++){
            if(maxsalary<e[i].getSalary()){
                maxsalary=e[i].getSalary();
            }
        }
        return maxsalary;
    }
    public Employee[] getEmployeesByDesignation(Employee[]e,String d)
    {
        Employee[] emp = new Employee[0];
        for (int i = 0; i < e.length; i++) {
            if(e[i].getDes().equalsIgnoreCase(d))
            {
                emp = Arrays.copyOf(emp,emp.length+1);
                emp[emp.length-1] = e[i];
            }
        }
        if(emp.length>0)
        {
            return emp;
        }
        return null;
    }
}
