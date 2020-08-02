# thegoodshoppingguide extractor
import csv
import pandas as pd

def get_rating(argument):
    return int(argument)

# read in csv as pandas.dataframe
raw_table = pd.read_csv('goodshoppingguide.csv', delimiter=',')

# create a new rating as default -1 (rating between 0 and 1)
final_csv = raw_table
final_csv['sd_rating'] = -1

# loop through all rows:
#      get 0-1 rating from rating row using method

for index,row in final_csv.iterrows():
    final_csv.set_value(index, 'sd_rating', get_rating(row['rating']))

# remove unnecessary columns
final_csv = final_csv.drop(['web-scraper-order', 'web-scraper-start-url', 'category'],
                axis=1)

# save final_csv
final_csv.to_csv('goodshoppingguide_sd.csv')
