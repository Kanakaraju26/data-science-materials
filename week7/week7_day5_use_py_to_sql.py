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
SELECT * from dep8;
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
