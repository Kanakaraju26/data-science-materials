# 10 Common Prompts for Data Scientists Using AI
## Copilot
## 1. Data Cleaning
**Prompt:** "Clean the following dataset by removing null values, correcting data types, and standardizing column names."

## 2. Exploratory Data Analysis (EDA)
**Prompt:** "Generate a summary of key statistics and visualizations for this dataset, including histograms, box plots, and correlation heatmaps."

## 3. Feature Engineering
**Prompt:** "Suggest new features that could improve model performance based on the given dataset and target variable."

## 4. Model Selection
**Prompt:** "Recommend the best machine learning models for predicting [target variable] using [dataset description]."

## 5. Hyperparameter Tuning
**Prompt:** "Provide a grid search or randomized search strategy for tuning hyperparameters of a [model name] model."

## 6. Code Explanation
**Prompt:** "Explain what the following Python code does, including its purpose and logic."

## 7. SQL Query Generation
**Prompt:** "Write an SQL query to extract [specific information] from a table with columns [column names]."

## 8. Data Visualization
**Prompt:** "Create a visualization using matplotlib or seaborn to show the distribution of [feature] across different categories."

## 9. Model Evaluation
**Prompt:** "Evaluate the performance of a classification model using precision, recall, F1-score, and ROC-AUC."

## 10. Business Insight Generation
**Prompt:** "Based on the analysis of this dataset, generate actionable business insights for improving customer retention."

## Gemini
## 1. Data Cleaning and Preprocessing

Act as a Python expert for data cleaning. Given the following Pandas DataFrame structure and a sample of the 
'customer_id', 
'purchase_date', 
'price' columns, 
provide Python code to:
 Identify and handle missing values (e.g., fill with median for 'price', drop rows for 'customer_id'). 
 Convert 'purchase_date' to datetime objects.
 Detect and cap outliers in 'price' using the IQR method.
Include comments explaining each step.
DataFrame sample:


## 2. Exploratory Data Analysis (EDA)
I have a dataset on e-commerce transactions with columns like 
'product_category', 
'amount_spent', 
'customer_segment', 
'transaction_date'. 
Propose 5 key exploratory data analysis questions to understand customer purchasing behavior. For each question, suggest relevant columns to analyze and appropriate Python libraries (e.g., Pandas, Matplotlib, Seaborn) and methods to use, along with a brief explanation of what the analysis would reveal. 

## 3. Feature Engineering

Given a dataset containing customer demographic information (age, gender, location) and their online activity (pages visited, time spent on site, number of clicks), suggest 3-5 new features that could be engineered to improve a customer churn prediction model. For each suggested feature, explain its potential relevance and provide a conceptual approach for its calculation.

## 4. Model Selection and Justification

I'm working on a binary classification problem to predict customer churn. I have a dataset with both numerical and categorical features. Explain the pros and cons of using Logistic Regression, Random Forest, and Gradient Boosting (e.g., XGBoost) for this task. Which model would you initially recommend and why, considering interpretability, performance, and handling of different data types?

## 5. Code Generation and Debugging

Write a Python function using Scikit-learn that performs the following steps:

1. Splits a given DataFrame into training and testing sets (80/20 split, stratify by target variable 'churn').

2. Trains a RandomForestClassifier on the training data.

3. Evaluates the model on the test set and prints the classification report and confusion matrix.

Assume the target variable is named 'churn' and the features are all other columns. Include error handling for missing target column.

## 6. Explaining Complex Concepts

Explain the concept of "Regularization" in machine learning, specifically L1 and L2 regularization, to a non-technical audience (e.g., a business stakeholder). Use analogies to make it easy to understand and highlight why it's important for model performance and avoiding overfitting.

## 7. Data Visualization

I have sales data over the past year, with columns 'date', 'product_category', and 'sales_amount'.

1. Suggest the most suitable chart types to visualize:

    a. Monthly sales trends.

    b. Sales distribution across product categories.

    c. How sales of a specific product category change over time.

2. For each, describe what insights can be gained from that visualization.

## 8. Statistical Analysis and Hypothesis Testing

I've conducted an A/B test for a new website design. Group A (control) saw 10% conversion rate, and Group B (new design) saw 12% conversion rate, with 1000 users in each group. Explain how I can perform a hypothesis test to determine if the 2% difference in conversion rates is statistically significant. Outline the steps, including defining null and alternative hypotheses, choosing a significance level, selecting an appropriate test (e.g., chi-squared), and interpreting the p-value.

## 9. Model Deployment and Monitoring

I have a trained machine learning model for predicting fraudulent transactions. Outline the key considerations and steps involved in deploying this model into a production environment. Focus on aspects like API integration, scalability, latency, model versioning, and ongoing monitoring for performance decay and data drift.

## 10. Data Storytelling and Communication

Imagine you are presenting the results of a customer churn analysis to a non-technical executive board. The model shows a significant increase in churn among customers aged 18-25 who use a specific older version of our mobile app. Craft a concise, impactful summary of these findings, highlighting the business implications and suggesting actionable recommendations. Avoid technical jargon.

## Chatgpt

# 10 Common Prompts for Data Scientists Using AI

## 1. Data Cleaning
**Prompt:**
Given this messy dataset (provide schema or sample rows), suggest Python code using pandas to clean and preprocess the data for analysis.

## 2. Exploratory Data Analysis (EDA)
**Prompt:**
Explain how I can perform an initial exploratory data analysis on this dataset. What charts or summaries should I generate?

## 3. Feature Engineering
**Prompt:**
Based on this dataset and the target variable, suggest potential new features I can create to improve model performance.

## 4. Missing Value Imputation
**Prompt:**
What are the best practices for imputing missing values in numerical and categorical columns in a machine learning dataset?

## 5. Model Selection
**Prompt:**
What machine learning models would be appropriate for a binary classification problem with imbalanced classes?

## 6. Hyperparameter Tuning
**Prompt:**
Generate a sample code using GridSearchCV or RandomizedSearchCV for tuning a RandomForestClassifier.

## 7. Model Evaluation
**Prompt:**
How do I evaluate a regression model? Explain the use of metrics like RMSE, MAE, and R².

## 8. Interpretability
**Prompt:**
Explain how I can use SHAP or LIME to interpret the predictions of a black-box model like XGBoost.

## 9. Data Visualization
**Prompt:**
Generate Python code using Seaborn or Plotly to visualize feature relationships and target variable trends.

## 10. Communicating Results
**Prompt:** Help me draft a summary of this machine learning project for a non-technical audience, including the problem, approach, and key findings.