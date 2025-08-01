
# 📊 E-Commerce Data Analysis (AI Tool Day)

This notebook is designed for exploring the use of AI tools (Claude, Gemini, ChatGPT, etc.) to assist in understanding EDA and visualizations.

---

## 🔹 Step 1: Load the Data

```python
import pandas as pd

df = pd.read_csv("e_commerce.csv", encoding="ISO-8859-1")
df.info()
df.head()
```

---

## 🔹 Step 2: Basic Data Cleaning

```python
# Convert InvoiceDate to datetime
df["InvoiceDate"] = pd.to_datetime(df["InvoiceDate"])

# Check for nulls
df.isnull().sum()

# Fill missing descriptions with "Unknown"
df["Description"].fillna("Unknown", inplace=True)
```

---

## 🔹 Step 3: Summary Statistics

```python
# Summary of numerical data
df.describe()

# Unique values in categorical columns
df["Country"].value_counts().head()
```

---

## 🔹 Step 4: Visualizations

```python
import matplotlib.pyplot as plt
import seaborn as sns

# Top 10 selling products
top_products = df["Description"].value_counts().head(10)
plt.figure(figsize=(10, 5))
sns.barplot(x=top_products.values, y=top_products.index)
plt.title("Top 10 Selling Products")
plt.xlabel("Count")
plt.ylabel("Product")
plt.tight_layout()
plt.show()
```

---

## 🔹 Step 5: Revenue Analysis

```python
df["Revenue"] = df["Quantity"] * df["UnitPrice"]

# Monthly revenue trend
df.set_index("InvoiceDate", inplace=True)
monthly_revenue = df["Revenue"].resample("M").sum()

plt.figure(figsize=(12, 6))
monthly_revenue.plot()
plt.title("Monthly Revenue Over Time")
plt.xlabel("Date")
plt.ylabel("Revenue")
plt.grid(True)
plt.tight_layout()
plt.show()
```

---

## 🤖 Step 6: Ask AI to Help You

### 🟢 Claude / Gemini / ChatGPT Prompt Ideas

**1. Describe the dataset:**
> “Given the dataset summary from `df.describe()` and `df.info()`, what kind of business is this? What could be the goal of the analysis?”

**2. Suggest insights:**
> “Here are the top 10 products by count — what can you infer about customer behavior?”

**3. Ask to create more plots:**
> “Can you suggest a visualization to analyze country-wise revenue and provide seaborn/matplotlib code for it?”

---

## ✅ Summary & Next Steps

Use AI tools to:
- Interpret correlation matrices
- Explain revenue trends
- Draft a 2-slide summary of findings
