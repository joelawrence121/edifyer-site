# ethicalorgau extractor
import csv
import pandas as pd

def get_rating(argument):
    argument = str(argument)
    argument = argument.lower();
    rating_dict = {
        "https://guide.ethical.org.au/images/icons-small/icon_grey.png":-1,
        "https://guide.ethical.org.au/images/icons-small/icon_red.png":0,
        "https://guide.ethical.org.au/images/icons-small/icon_orange.png":25,
        "https://guide.ethical.org.au/images/icons-small/icon_yellow.png":50,
        "https://guide.ethical.org.au/images/icons-small/icon_ltgreen.png":75,
        "https://guide.ethical.org.au/images/icons-small/icon_green.png":100
    }
    return rating_dict.get(argument, -1);

# read in csv as pandas.dataframe
raw_table = pd.read_csv('ethicalorgau.csv', delimiter=',')

# create a new rating as default -1 (rating between 0 and 1)
final_csv = raw_table
final_csv['sd_rating'] = -1

# loop through all rows:
#      get 0-1 rating from rating row using method

for index,row in final_csv.iterrows():
    final_csv.set_value(index, 'sd_rating', get_rating(row['rating-src']))

# remove unnecessary columns
final_csv = final_csv.drop(['web-scraper-order', 'brand', 'brand-href', 'name', 'brand_link', 'brand_link-href', 'company_link-href', 'web-scraper-start-url', 'company_link'],
                axis=1)

# save final_csv
final_csv.to_csv('ethicalorgau_sd.csv')
