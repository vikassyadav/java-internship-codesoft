import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    // JDBC URL, username, and password
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/student_mange";
    static final String USERNAME = "root";
    static final String PASSWORD = "vikas27";



    // Insert a new student into the table
    public static void insertStudent(Connection connection, String name, String grade, String phoneNumber, String address) throws SQLException {
       
        String insertQuery = "INSERT INTO students (name, grade, phone_number, address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, grade);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, address);
            preparedStatement.execute();
            System.out.println("Student inserted successfully.");
            
        }
       
    }

    // Update an existing student's details
    public static void updateStudent(Connection connection, int rollNumber, String name, String grade, String phoneNumber, String address) throws SQLException {
        String updateQuery = "UPDATE students SET name = ?, grade = ?, phone_number = ?, address = ? WHERE roll_number = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, grade);
            preparedStatement.setString(3, phoneNumber);
            preparedStatement.setString(4, address);
            preparedStatement.setInt(5, rollNumber);
            preparedStatement.executeUpdate();
            System.out.println("Student updated successfully.");
            
        }
        System.out.println(" \n \n \n");
    }

    // Delete a student from the table
    public static void deleteStudent(Connection connection, int rollNumber) throws SQLException {
        String deleteQuery = "DELETE FROM students WHERE roll_number = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, rollNumber);
            preparedStatement.executeUpdate();
            System.out.println("Student deleted successfully.");
            
        }
        System.out.println(" \n \n \n");
    }

    // Retrieve and display all students
    public static void selectStudents(Connection connection) throws SQLException {
        String selectQuery = "SELECT * FROM students";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
                while (resultSet.next()) {
                    int rollNumber = resultSet.getInt("roll_number");
                    String name = resultSet.getString("name");
                    String grade = resultSet.getString("grade");
                    String phoneNumber = resultSet.getString("phone_number");
                    String address = resultSet.getString("address");
                    System.out.println("Roll Number: " + rollNumber +
                                       ", Name: " + name +
                                       ", Grade: " + grade +
                                       ", Phone Number: " + phoneNumber +
                                       ", Address: " + address);
                
            }
            System.out.println(" \n \n \n");
        }
    }
        //SEARCHING STUDENT FROM RECORDED DATA
     public static void searchStudents(Connection connection, int rollnumber) throws SQLException {
        String selectQuery = "SELECT * FROM students where roll_number=? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, rollnumber);
            
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("Student Found:");
                    System.out.println("Roll Number: " + resultSet.getInt("roll_number"));
                    System.out.println("Name: " + resultSet.getString("name"));
                    System.out.println("Grade: " + resultSet.getString("grade"));
                    System.out.println("Phone Number: " + resultSet.getString("phone_number"));
                    System.out.println("Address: " + resultSet.getString("address"));
                } else {
                    System.out.println("Student not found with the given roll number.");
                }
            System.out.println(" \n \n \n");
        }
    }
}


    



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("STUDENT MANGEMENT PROGRAM IS STARTED \n CHOOSE YOUR OPERATION WITH PRESSING APPROPIATE NUMBER ");
        
        boolean continueLoop = true;
        
        
        while(continueLoop){
 
          
             
            System.out.println("press 1 for insert student data");
            System.out.println("press 2 update student data ");
            System.out.println("press 3 for delete student data");
            System.out.println("press 4 to show all student data");
            System.out.println("press 5 to search for student");
            System.out.println("PRESS 6 TO EXIT");
            int choice =sc.nextInt();
            sc.nextLine();
            
            switch(choice){

                case 1:
                 try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            
            System.out.println("ENTER THE STUDENT DETAILS");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Grade: ");
            String grade = sc.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
        
            // Perform CRUD operations
            insertStudent(connection, name, grade, phoneNumber, address);
            // String name , grade , phoneNumber,address;
            // name=sc.nextLine();
            // grade=sc.nextLine();
            // phoneNumber=sc.nextLine();
            // address=sc.nextLine();

            // // Perform CRUD operations
            // insertStudent(connection, name, grade , phoneNumber , address);

            //nsertStudent(connection, name, grade , phoneNumber , address);
           // updateStudent(connection, 1, "Jane Smith", "11th", "987-654-3210", "456 Elm St, Townsville");
            //deleteStudent(connection, 2);
           // selectStudents(connection);

            // Close the connection
            connection.close();
        } 
        catch (Exception e)
         {
            e.printStackTrace();
        }
        break;

         

        case 2 :
         try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            
            System.out.println( "ENTER THE STUDENT DETAIL WHICH WHOM YOU WANT TO  UPDATE");
            System.out.println("Roll Number ,Name , garde , phone Number , address");
            int rollNumber=sc.nextInt();
            sc.nextLine();
            String updated_name= sc.nextLine();
            String updated_grade=sc.nextLine();
           String updated_phoneNumber=sc.nextLine();
            String updated_address=sc.nextLine();
            
            // Perform CRUD operations
            
           updateStudent(connection,rollNumber,updated_name, updated_grade , updated_phoneNumber , updated_address  );
            //deleteStudent(connection, 2);
           // selectStudents(connection);

            // Close the connection
            connection.close();
        } 
        catch (Exception e)
         {
            e.printStackTrace();
        }

        break;

        case 3:
         try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            
            System.out.println( "ENTER ROLL NUMBER OF THE STUDENRT WHOM YOU WANT TO DELETE");
            
            int rollNumber=sc.nextInt();

           
            deleteStudent(connection, rollNumber);
           // selectStudents(connection);

            // Close the connection
            connection.close();
        } 
        catch (Exception e)
         {
            e.printStackTrace();
        }
        break;

        case 4:
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("ALL STUDENT DATA ");
            System.out.print("");
            
            selectStudents(connection);

            // Close the connection
            connection.close();
        } 
        catch (Exception e)
         {
            e.printStackTrace();
        }
            break;

             case 5:
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("SEARCH  STUDENT ");
            System.out.println("ENTER ROLL NUMBER OF STUDENT");
            int rollnumber=sc.nextInt();
            sc.nextLine();
            System.out.print("");
            
            searchStudents(connection,rollnumber);

            // Close the connection
            connection.close();
        } 
        catch (Exception e)
         {
            e.printStackTrace();
        }
            break;
            case 6:
                    continueLoop = false;
                    sc.close();
                    System.exit(0);
                    System.out.println("Exiting the loop.");
                    break;

        default:
        System.out.println("ENTER VALID CHOICE");


                
            }
            
        }
        
    }
}

    