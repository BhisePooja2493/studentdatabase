import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	private String url="jdbc:mysql://localhost:8080/studentdetails? useSSL=false";
	private String username="root";
	private String password="Pooja@123";
	
	private static final String INSERT_USERS_SQL="INSERT INTO student" + "(name, date_of_birth, date_of_joining) VALUES" + "(?,?,?);";
	
	private static final String SELECT_STUDENT_BY_ID="select id,name,date_of_birth, date_of_joining from student where id=?";
	private static final String SELECT_ALL_STUDENT="select * from student";
	private static final String DELETE_STUDENT_SQL="delete from student where id=?;";
	private static final String UPDATE_STUDENT_SQL="update student set name= ?,date_of_birth= ?,date_of_joining= ? where id= ?; ";
	
	protected Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
		
	}
	
	public void insertStudent(Student student) throws SQLException{
		try(Connection connection=getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(INSERT_USERS_SQL)){
			 preparedStatement.setString(1,student.getName());
			 preparedStatement.setString(2,student.getDate_of_birth());
			 preparedStatement.setString(3,student.getDate_of_joining());
			 preparedStatement.executeUpdate();
			 
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean updateStudent(Student student) throws SQLException{
		boolean rowUpdated;
	
		try(Connection connection=getConnection();
				PreparedStatement statement=connection.prepareStatement(UPDATE_STUDENT_SQL);){
			 statement.setString(1,student.getName());
			 statement.setString(2,student.getDate_of_birth());
			 statement.setString(3,student.getDate_of_joining());
			 statement.setInt(4, student.getId());
			 
			 rowUpdated=statement.executeUpdate() > 0;
			 
		}
		return rowUpdated;

}
	public Student selectStudent(int id) {
		Student student=null;
		try(Connection connection=getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_STUDENT_BY_ID);){
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("name");
				String date_of_birth = rs.getString("date_of_birth");
				String date_of_joining = rs.getString("date_of_joining");
				student=new Student(id,name,date_of_birth,date_of_joining);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
		
	}
	public List<Student> selectAllStudents() {
		List<Student> students=new ArrayList<>();
		
		try(Connection connection=getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(SELECT_ALL_STUDENT);){
			
			System.out.println(preparedStatement);
			
			ResultSet rs=preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String name = rs.getString("name");
				String date_of_birth = rs.getString("date_of_birth");
				String date_of_joining = rs.getString("date_of_joining");
				students.add(new Student(id,name,date_of_birth,date_of_joining));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return students;
		
	}
	
	public boolean deleteUser(int id)throws SQLException {
		boolean rowDeleted;
		try(Connection connection=getConnection();
				PreparedStatement statement=connection.prepareStatement(DELETE_STUDENT_SQL);){
			statement.setInt(1, id);
			rowDeleted=statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
		
	
	
}