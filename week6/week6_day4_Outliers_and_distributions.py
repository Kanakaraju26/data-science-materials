import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

df = pd.read_csv("C:\\Users\\Home\\Documents\\data science\\week6\\data\\day3_engineer.csv")
# print(df.head(10))
# print(df.info())

q1 = df["duration_mins"].quantile(0.25)
q3 = df["duration_mins"].quantile(0.75)
IQR = q3-q1

low_bou = q1 - 1.5 * IQR
up_bou = q3 + 1.5 * IQR

df_no_outliers = df[(df['duration_mins'] >= low_bou) & (df['duration_mins'] <= up_bou)]

sns.histplot(df["duration_mins"],kde=True)
plt.title("With Outlier")
plt.show()

sns.histplot(df_no_outliers['duration_mins'], kde=True)
plt.title("Without Outlier")
plt.show()

sns.boxplot(x=df['duration_mins'])
plt.title("Boxplot With Outliers")
plt.show()

sns.boxplot(x=df_no_outliers['duration_mins'])
plt.title("Boxplot Without Outliers")
plt.show()
