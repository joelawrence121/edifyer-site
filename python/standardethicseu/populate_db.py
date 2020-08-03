
# connect with mysql

# go through the sd ratings of corporate critic

# insert into company(name, null)

# insert into rating INSERT INTO bar (description, foo_id) VALUES
#    ( 'testing',     (SELECT id from foo WHERE type='blue') ),
#    ( 'another row', (SELECT id from foo WHERE type='red' ) );

import mysql.connector
import csv
import pandas as pd

csv = 'standardethicseu_sd.csv'
source_id = 30;
link="http://standardethicsrating.eu/"

mydb = mysql.connector.connect(
  host="localhost",
  user="edifyer_admin",
  password="apostolidou",
  database="edifyer_db"
)

mycursor = mydb.cursor()

# read in sd_csv as pandas.dataframe
sd_table = pd.read_csv(csv, delimiter=',')

# loop through all rows:
#      insert company
#      insert rating
for index,row in sd_table.iterrows():
    print(row['company'])
    mycursor.execute("INSERT IGNORE INTO company (name) VALUES (%s)", (row['company'],))
    mycursor.execute("INSERT IGNORE INTO rating (company_id, source_id, sd_rate, uncertainty, date, source_link) VALUES ((SELECT id from company WHERE name=%s), %s, %s, %s, NOW(), %s)", (row['company'], source_id, row['sd_rating'], 0, link))
    mydb.commit()
