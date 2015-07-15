package day15;

public class Course {

	int fee;
	String subject;
	public void courseDetails(int fee,String subject)
	{
		this.fee=fee;
		this.subject=subject;
	}
	public static void main(String[] args) {
		Course c=new Course();
		c.courseDetails(10000,"Testing");
		System.out.println(c.fee+"---"+c.subject);

	}

}
