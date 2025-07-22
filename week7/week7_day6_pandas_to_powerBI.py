import pandas as pd

df = pd.read_csv("C:\\Users\\Home\\Documents\\data science\\week7\\data\\cleanedNetflix.csv")

print(df.isnull().sum())