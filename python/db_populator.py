import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="edifyer_admin",
  password="apostolidou",
  database="edifyer_db"
)

mycursor = mydb.cursor()

mycursor.execute("SHOW TABLES")

for x in mycursor:
  print(x)
