
public class Student {
    
    private int id;
    private String name;
    private String date_of_birth;
    private String date_of_joining;
    
    
    
    
	public Student(int id, String name, String date_of_birth, String date_of_joining) {
		super();
		this.id = id;
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.date_of_joining = date_of_joining;
	}
	
	
	public Student(String name, String date_of_birth, String date_of_joining) {
		super();
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.date_of_joining = date_of_joining;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getDate_of_joining() {
		return date_of_joining;
	}
	public void setDate_of_joining(String date_of_joining) {
		this.date_of_joining = date_of_joining;
	}
    
}