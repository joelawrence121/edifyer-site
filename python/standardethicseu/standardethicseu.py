# standardethicseu extractor
import csv
import pandas as pd

def get_rating(argument):
    argument = str(argument)
    rating_dict = {
        "F":0,
        "E-":12.5,
        "E":25,
        "E+":37.5,
        "EE-":50,
        "EE":62.5,
        "EE+":75,
        "EEE-":87.5,
        "EEE":100
    }
    return rating_dict.get(argument, -1);

# read in csv as pandas.dataframe
raw_table = pd.read_csv('standardethicseu.csv', delimiter=',',
                        float_precision=None)

# create a new rating as default -1 (rating between 0 and 1)
final_csv = raw_table
final_csv['sd_rating'] = -1

# loop through all rows:
#      get 0-1 rating from rating row using method

for index,row in final_csv.iterrows():
    # if corporate rating, pass rating in next column
    if(row['Rating to']=="Corporate Rating"):
        final_csv.set_value(index, 'sd_rating', get_rating(row['Outlook']))
        final_csv.set_value(index, 'Rating to', row['Outlook'])
    else:
        final_csv.set_value(index, 'sd_rating', get_rating(row['Rating to']))


# remove unnecessary columns
final_csv = final_csv.rename(columns={"Description":"company", "Rating to":"rating"})
final_csv = final_csv.drop(['Outlook', 'Outlook2', 'Rating From', 'Rating Type',
                            'Industry', 'ISIN', 'Date', 'Unnamed: 9'], axis=1)

# save final_csv
final_csv.to_csv('standardethicseu_sd.csv')
