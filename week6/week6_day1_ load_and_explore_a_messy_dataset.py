import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import plotly.express as px

df = pd.read_csv("C:\\Users\\Home\\Documents\\data science\\week6\\data\\netflix_titles.csv")

# print(df.head(10))
# print(df.info())
# print(df.isnull().sum())
# print(df.isnull().mean() * 100 )
# print(df.describe(include='all'))
# print(df.duplicated().sum())
# print(df[df.duplicated()])
# print(df["country"].value_counts(dropna=False))
# print(df["director"].value_counts(dropna=False))
# country_counts = df['country'].value_counts().reset_index()
# country_counts.columns = ['country', 'count']
# fig = px.choropleth(country_counts,
#                     locations='country',
#                     locationmode='country names',
#                     color='count',
#                     color_continuous_scale='Viridis',
#                     title='Country Occurrences on World Map')

# fig.show()
# print(df["country"].value_counts(dropna=False))