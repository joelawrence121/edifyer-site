# DATABASE UPDATES
# 19/08

# Add factor and subFactor properties to rating table
ALTER TABLE rating
ADD factor VARCHAR(30) AFTER sd_rate,
ADD sub_factor VARCHAR(50) AFTER factor;

# Insert csrhub as a new source 
INSERT INTO source VALUES ('60', 'csrhub', 'csrhub_extractor.py', 'https://www.csrhub.com/');
