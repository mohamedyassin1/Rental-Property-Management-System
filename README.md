# Rental-Property-Management-System
Steps to Compile and Run the Application:
  1. Clone The Repository on your local device.
  2. If your local device already has a mysql table that is named "mydb", drop it.
  3. Source the sql file on the MySQL Command Line(make sure to include your full path in the command)
  4. To Compile Run The following command line in your compiler javac -cp .;../lib/mysql-connector-java-8.0.23.jar;. model/*.java controller/*.java GUI/*.java
  5. To Run, java -cp .;../lib/mysql-connector-java-8.0.23.jar;. GUI/MainGUIClass
