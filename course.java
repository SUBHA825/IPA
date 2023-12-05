public class course {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Course[] course = new Course[4];
        for(int i=0;i<4;i++){
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextInt();
            String c = sc.nextInt();
            int d = sc.nextInt();sc.nextLine();
            ind e = sc.nextInt();sc.nextLine();
            course[i] = new Course[a,b,c,d,e];
        }
        String admin= sc.nextLine();
        int hand = sc.nextInt();
        int ans1=findavgofquizbyadmin(course, admin);
        if(ans1 != 0){
            System.out.println(ans1);
        }
        else{
            System.out.println("no course found");
        }
        Course[] ans2= sortcoursebyhandson(course, hand);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].getName());
            }

        }
        else{
            System.out.println("no course found");
        }
    }




    public static int findavgofquizbyadmin(Course[] course, String ad){
         int sum=0,count=0;
         for(int i=0;i<course.length;i++){
             if(course[i].getAdmin().equalsIgnoreCase(ad)){
                 sum=sum+ course[i].getQuiz();
                 count++;
             }
         }
         if(count>0){
             int avg=sum/count;
             return avg;
         }
         else{
             return 0;
         }
    }
    public static Course[] sortcoursebyhandson(Course[] course, int h){
        Course[] obj = new Course[0];
        for(int i=0;i<course.length;i++){
            if(course[i].getHandson()<h){
                obj=ArrayscopyOf(obj, obj.length+1);
                obj[obj.length-1]=coures[i];
            }
        }
        Course val;
        for(int i=o;i<obj.length;i++){
            for(int j=0;j<obj.length;j++){
                if(obj[i].getHandson()>obj[j].getHandson()){
                    val=obj[i];
                    obj[i]=obj[j];
                    obj[j]=val;
                }
            }
        }
        if(obj.length>1){
            return obj;
        }
        else{
            return null;
        }
    }

}
class Course{
    private int id;
    private String name;
    private String admin;
    private int quiz;
    private int handson;

    public Course(int id, String name, String admin, int quiz, int handson) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.quiz = quiz;
        this.handson = handson;
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
    public String getAdmin(){
        return admin;
    }
    public void setAdmin(String admin){
        this.admin=admin;
    }
    public int getQuiz(){
        return quiz;
    }
    public void setQuiz(int quiz){
        this.quiz=quiz;
    }
    public int getHandson(){
        return handson;
    }
    public void setHandson(int handson){
        this.handson=handson;
    }
}
