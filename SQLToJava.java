// **** 1. update salaries ****
ResultSet rs1 = Stmt.executeQuery("SELECT name, zooName FROM Owners");
Array workersNames = rs1.getArray(1);
Array workersZoos = rs1.getArray(2);
    // display data to gui submenu in dropdown lists
// int newSalary = zooWindow....
// String employeeName = zooWindow....
// String zoo1 = zooWindow....
rs1 = Stmt.executeQuery("UPDATE Owners SET salary=" + newSalary + "WHERE name LIKE " 
    + employeeName + "AND zooName LIKE " + zoo1);

// **** 2. insert animal ****
    // what about species??
rs1 = Stmt.executeQuery("SELECT class, origin, zooAt, inArea FROM Animals");
Array classes = rs1.getArray(1);
Array origins = rs1.getArray(2);
Array zoos = rs1.getArray(3);
Array areas = rs1.getArray(4);
    // display data to gui submenu in dropdown lists
ResultSet rs2 = Stmt.executeQuery("SELECT MAX(animalID) FROM Animals");
    // read into maxAnimalID and increment by one, either now or later
    // shouldn't need to display, transparent to user
int maxAnimalID = rs2.getInt(1) + 1;
// String animalClass = zooWindow....
// String animalSpecies = zooWindow....
// String animalOrigin = zooWindow....
// int animalFood = zooWindow....
// zoo1 = zooWindow....
// int enclosureSize = zooWindow....
ResultSet rs3 = Stmt.executeQuery("INSERT INTO Animals VALUES (" + maxAnimalID + ", " + animalClass + 
    ", " + animalSpecies + ", " + animalOrigin + ", " + animalFood + ", " + zoo1 + ", " + animalArea);
    // Enclosures only adds one other attribute - enclosureSize
ResultSet rs4 = Stmt.executeQuery("INSERT INTO Enclosures VALUES (" + enclosureSize + ", " + 
    animalSpecies + ", " maxAnimalID);

// **** 3. insert worker ****
rs1 = Stmt.executeQuery("SELECT job, workSite, shift, areaWorking FROM Workers");
    // display data to gui submenu in dropdown lists
Array jobs = rs1.getArray(1);
Array workSites = rs1.getArray(2);
Array shifts = rs1.getArray(3);
areas = rs1.getArray(4);
rs2 = Stmt.executeQuery("SELECT MAX(employeeID) FROM Workers");
    // read into maxEmployeeID and increment by one 
    // shouldn't need to display, transparent to user
int maxEmployeeID = rs2.getInt(1) + 1;
// employeeName = zooWindow....
// String employeeJob = zooWindow....
// String employeeWorkSite = zooWindow....
// String employeeShift = zooWindow....
// String employeeArea = zooWindow....
rs3 = Stmt.executeQuery("INSERT INTO Workers VALUES (" + maxEmployeeID + ", " + employeeName + ", " + 
    employeeJob + ", " + employeeWorkSite + ", " + employeeShift + ", " + employeeArea);

// **** 4. incidents ****
  // ** 4A. animal kills or seriously injures worker **
rs1 = Stmt.executeQuery("SELECT name, employeeID FROM Workers");
workersNames = rs1.getArray(1);
Array workerIDs = rs1.getArray(2);
    // display data to gui submenu in dropdown lists
// employeeName = zooWindow....
// int employeeID = zooWindow....
rs4 = Stmt.executeQuery("DELETE FROM Workers WHERE name LIKE " + employeeName + " AND employeeID=" + employeeID);
  // ** 4B. animal dies or escapes **
rs2 = Stmt.executeQuery("SELECT species FROM Animals");
Array species = rs2.getArray(1);
    // display data to gui submenu in dropdown lists
// animalSpecies = zooWindow....
rs4 = Stmt.executeQuery("DELETE FROM Animals WHERE species LIKE " + animalSpecies);
  // ** 4C. zoo closes **
rs3 = Stmt.executeQuery("SELECT zooName FROM Zoos");
zoos = rs3.getArray(1);
    // display zoos 2x
    // check that zoo1 != zoo2, if not ..
// zoo1 = zooWindow....
// String zoo2 = zooWindow....
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
Date dateWithoutTime = sdf.parse(sdf.format(new Date()));
rs4 = Stmt.executeQuery("UPDATE Workers SET workSite=" + zoo2 + "WHERE workSite LIKE " + zoo1);
ResultSet rs5 = Stmt.executeQuery("UPDATE Animals SET zooAt=" + zoo2 + " WHERE zooAt LIKE " + zoo1);
ResultSet rs6 = Stmt.executeQuery("DELETE FROM Zoos WHERE zooName LIKE " + zoo1);
ResultSet rs7 = Stmt.executeQuery("UPDATE Owners SET endDate=" + todaysDate + " WHERE zooName LIKE " + zoo1);

// **** 5. update worker ****
rs1 = Stmt.executeQuery("SELECT name, employeeID FROM Workers");
workersNames = rs1.getArray(1);
workerIDs = rs1.getArray(2);
    // display data to gui submenu in dropdown lists
// String employeeName = zooWindow....
// employeeJob = zooWindow....
// employeeWorkSite = zooWindow....
// employeeShift = zooWindow....
// employeeArea = zooWindow....
rs2 = Stmt.executeQuery("UPDATE Workers SET job=" + employeeJob + ", workSite=" + employeeWorkSite + 
        ", shift=" + employeeShift + ", areaWorking=" + employeeArea + "WHERE name LIKE " + employeeName);
