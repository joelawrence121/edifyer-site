from __future__ import print_function
import mysql.connector
import csv
import pandas as pd
import math


csv = 'csrhub.csv'
source_id = 60;

mydb = mysql.connector.connect(
  host="localhost",
  user="edifyer_admin",
  password="apostolidou",
  database="edifyer_db"
)

def progressBar(current, total, barLength = 20):
    percent = float(current) * 100 / total
    arrow   = '-' * int(percent/100 * barLength - 1) + '>'
    spaces  = ' ' * (barLength - len(arrow))

    print('Progress: [%s%s] %d %%' % (arrow, spaces, percent), end='\r')

mycursor = mydb.cursor()

# read in sd_csv as pandas.dataframe
sd_table = pd.read_csv(csv, delimiter=',')

columns = len(sd_table.index)
proc = 0

for index,row in sd_table.iterrows():
    progressBar(proc, columns)
    proc = proc + 1
    # no point inserting NA rated companies
    if(math.isnan(row['sd_rating']) == False):
        mycursor.execute("INSERT IGNORE INTO company (name) VALUES (%s)", (row['company_name'],))
        mycursor.execute("INSERT IGNORE INTO rating (company_id, source_id, sd_rate, factor, sub_factor, uncertainty, date, source_link) VALUES ((SELECT id from company WHERE name=%s), %s, %s, %s, %s, %s, NOW(), %s)", (row['company_name'], source_id, row['sd_rating'], "NA", "NA", 0, row['company_link-href']))
        mydb.commit()
