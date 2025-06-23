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
SELECT e.name, d.dept_name 
FROM emp4 e 
LEFT JOIN dep d ON e.dept_id = d.dept_id

UNION

SELECT e.name, d.dept_name 
FROM emp4 e 
RIGHT JOIN dep d ON e.dept_id = d.dept_id;
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
