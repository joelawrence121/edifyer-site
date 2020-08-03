# goodonyou extractor
import csv
import pandas as pd

def get_rating(argument):
    argument = str(argument)
    argument = argument.lower();
    rating_dict = {
        "nan":-1,
        "rated : we avoid":0,
        "rated : not good enough":25,
        "rated : it's a start":50,
        "rated : good":75,
        "rated : great":100
    }
    return rating_dict.get(argument, "null");

# read in csv as pandas.dataframe
raw_table = pd.read_csv('goodonyou.csv', delimiter=',')

# create a new rating as default -1 (rating between 0 and 1)
final_csv = raw_table
final_csv['sd_rating'] = -1

# loop through all rows:
#      get 0-1 rating from rating row using method

for index,row in final_csv.iterrows():
    final_csv.set_value(index, 'sd_rating', get_rating(row['rating']))

# remove unnecessary columns
final_csv = final_csv.drop(['web-scraper-order', 'web-scraper-start-url', 'category_link'],
                axis=1)

# save final_csv
final_csv.to_csv('goodonyou_sd.csv')
