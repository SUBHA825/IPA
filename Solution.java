import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Medicine[] m=new Medicine[4];
        for(int i=0;i<m.length;i++){
            String a=sc.nextLine();
            String b= sc.nextLine();
            String c= sc.nextLine();
            int d=sc.nextInt();sc.nextLine();
            m[i]=new Medicine(a, b, c, d);
        }
        String dis=sc.nextLine();
        int[] ans = getPricebydiesease(m, dis);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i]);
            }
        }
        else{
            System.out.println("no medicne found");
        }

    }


public static int[] getPricebydiesease(Medicine[] m, String dis){
    int[] p = new int[0];
    for(int i=0;i<m.length;i++){
        if(m[i].getDiesease().equalsIgnoreCase(dis))
        {
            p= Arrays.copyOf(p, p.length+1);
            p[p.length-1]=m[i].getPrice();
            Arrays.sort(p);
        }
    }
    if(p.length>0){
        return p;
    }
    else{
        return null;
    }
}
}
class Medicine{
    String medname;
    String batch;
    String diesease;
    int price;
    public Medicine(String medname, String batch, String diesease, int price){
        this.medname=medname;
        this.batch=batch;
        this.diesease=diesease;
        this.price=price;
    }

    public String getMedname() {
        return medname;
    }

    public String getBatch() {
        return batch;
    }

    public String getDiesease() {
        return diesease;
    }

    public int getPrice() {
        return price;
    }

    public void setMedname(String medname) {
        this.medname = medname;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public void setDiesease(String diesease) {
        this.diesease = diesease;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
