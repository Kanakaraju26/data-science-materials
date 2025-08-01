import pandas as pd

df = pd.read_csv("C:\\Users\\Home\\Documents\\data science\\week8\\data\\e_commerce.csv",encoding='ISO-8859-1')


# print(df.head(10))
# print(df.describe())
# print(df.isnull().sum())
df = df.dropna(subset=['CustomerID']) 
df = df.drop_duplicates()
# print(df.isnull().sum())

df['InvoiceDate'] = pd.to_datetime(df['InvoiceDate'])
df['CustomerID'] = df['CustomerID'].astype(int)
# print(df.info())

df['total_amount'] = df['Quantity'] * df['UnitPrice']
# print(df["total_amount"].head(10))
# print(df.info())

df['invoice_type'] = df['InvoiceNo'].apply(lambda x: 'Return' if str(x).startswith('C') else 'Purchase')
# print(df['invoice_type'].head(10))

df['hour'] = df['InvoiceDate'].dt.hour
df['date'] = df['InvoiceDate'].dt.date
df['day'] = df['InvoiceDate'].dt.day
df['year'] = df['InvoiceDate'].dt.year
df['month'] = df['InvoiceDate'].dt.month


# print(df['hour'].head(1))
# print(df['date'].head(1))
# print(df['day'].head(1))
# print(df['month'].head(1))
# print(df['year'].head(1))

# print(df.info())

top_countries = df['Country'].value_counts().nlargest(5).index
df['country_group'] = df['Country'].apply(lambda x: "yes" if x in top_countries else 'Other')
# print(df['country_group'].head(10))

df.to_csv("C:\\Users\\Home\\Documents\\data science\\week8\\data\\cleaned_ecommerce_data.csv", index=False)
