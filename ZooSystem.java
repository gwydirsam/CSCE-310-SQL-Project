import java.sql.*;

public class ZooSystem {
  static final String _jdbcDriver = "com.mysql.jdbc.Driver";
  static final String _url = "jdbc:mysql://database-new.cs.tamu.edu:3306/glisti-ZooSystem";
  static Connection conn = null;

  public static void main(String[] argv) {
    try {
      conn = connect("glisti", "G5m16l92");

      updateSalary(101010, "Bill Gates", "Fort Worth Zoo");

      conn.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  // ==================================================================================
  // Connection init

  // Returns Connection
  public static Connection connect(String userName, String password) {
    // register driver

    try {
      Class.forName(_jdbcDriver);
    } catch (ClassNotFoundException e) {
      print("MySQL JDBC Driver Error");
      e.printStackTrace();
      return conn;
    }

    // connection details
    try {
      conn = DriverManager.getConnection(_url, userName, password);

    } catch (SQLException e) {
      print("Connection Failed");
      e.printStackTrace();
      return conn;
    }

    // connection verification
    if (conn != null) {
      print("Connection Made");
      return conn;
    } else {
      print("Connection Failed");
    }
    return conn;
  }

  public static void close() {
    try {
      conn.close();
    }
    catch (SQLException e) {
      e.printStackTrace();
    }
  }

  // ==================================================================================
  // JDBC inline sql commands

  // MODIFICATIONS

  public static void updateSalary(int newSalary, String employeeName, String zoo)
    throws SQLException {

    Statement stmt = conn.createStatement();

    String sql = "UPDATE Owners SET salary = " + newSalary +
      " WHERE name LIKE " + qwrap(employeeName) +
      " AND zooName LIKE " + qwrap(zoo);

    stmt.executeUpdate(sql);
  }

  public static void insertAnimal(String animalClass, String animalSpecies, String animalOrigin,
                                  String animalFood, String zoo, String animalArea)
    throws SQLException {

    Statement stmt = conn.createStatement();

    // find the max id
    ResultSet rs = stmt.executeQuery("SELECT MAX(animalID) FROM Animals");
    int maxAnimalID = rs.getInt("animalID") + 1;
    rs.close();

    String sql = "INSERT INTO Animals VALUES (" + maxAnimalID + ", "
      + qwrap(animalClass) + ", "
      + qwrap(animalSpecies) + ", "
      + qwrap(animalOrigin)+ ", "
      + qwrap(animalFood) + ", "
      + qwrap(zoo) + ", "
      + qwrap(animalArea);

    stmt.executeUpdate(sql);
  }

  public static void insertWorker(String employeeName, String employeeJob, String employeeWorkSite,
                                  String employeeShift, String employeeArea)
    throws SQLException {

    Statement stmt = conn.createStatement();

    ResultSet rs = stmt.executeQuery("SELECT MAX(employeeID) FROM Workers");
    int maxEmployeeID = rs.getInt("employeeID") + 1;
    rs.close();

    String sql = "INSERT INTO Workers VALUES (" + maxEmployeeID + ", "
      + qwrap(employeeName) + ", "
      + qwrap(employeeJob) + ", "
      + qwrap(employeeWorkSite) + ", "
      + qwrap(employeeShift) + ", "
      + qwrap(employeeArea);

    stmt.executeUpdate(sql);
  }

  public static void updateWorker(String employeeJob, String employeeWorkSite, String employeeShift,
                                  String employeeArea, String employeeName)
    throws SQLException {

    Statement stmt = conn.createStatement();

    String sql = "UPDATE Workers SET job = " + qwrap(employeeJob) +
      ", workSite = " + qwrap(employeeWorkSite) +
      ", shift = " + qwrap(employeeShift) +
      ", areaWorking " + qwrap(employeeArea) +
      " WHERE name LIKE " + qwrap(employeeName);

    stmt.executeUpdate(sql);
  }

  // changed to only account for instances where both the animal and the worker are gone
  public static void updateIncedent(int employeeID, String employeeName, String animalSpecies)
    throws SQLException {

    Statement stmt = conn.createStatement();

    String sql1 = "DELETE FROM Workers WHERE name LIKE " + qwrap(employeeName) +
      " AND employeeID = " + employeeID;
    String sql2 = "DELETE FROM Animals WHERE species LIKE " + qwrap(animalSpecies);

    stmt.executeUpdate(sql1);
    stmt.executeUpdate(sql2);
  }

  // QUERIES


  // ==================================================================================
  // utils

  public static String qwrap(String s) {
    return "'" + s + "'";
  }

  public static void print(String l) {
    System.out.print(l);
  }

  public static void println(String l) {
    System.out.println(l);
  }
}
