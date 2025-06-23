import pymysql

conn = pymysql.connect(
    host="localhost",
    user="root",
    password="root",
    database="employee"
)

cursor = conn.cursor()

# Example SQL query: Create a new table from SELECT
sql_query = """
SELECT LEFT(new_cases, 2)
FROM covid_india_19
WHERE CAST(new_cases AS CHAR) LIKE '99%'
   OR CAST(new_cases AS CHAR) LIKE '88%'
   OR CAST(new_cases AS CHAR) LIKE '77%'
   OR CAST(new_cases AS CHAR) LIKE '66%'
   OR CAST(new_cases AS CHAR) LIKE '55%'
   OR CAST(new_cases AS CHAR) LIKE '44%'
   OR CAST(new_cases AS CHAR) LIKE '33%'
   OR CAST(new_cases AS CHAR) LIKE '22%'
   OR CAST(new_cases AS CHAR) LIKE '11%';
"""

cursor.execute(sql_query)
# Fetch all rows
results = cursor.fetchall()

# Print each row
for row in results:
    print(row)
    
# Commit and close
conn.commit()
cursor.close()
conn.close()
