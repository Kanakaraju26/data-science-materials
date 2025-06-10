# basic_concepts.py

# ----------------------------
# VARIABLES AND DATA TYPES
# ----------------------------

# Variables are used to store data
name = "Alice"             # string
age = 25                   # integer
height = 5.6               # float
is_student = True          # boolean

print("Name:", name)
print("Age:", age)
print("Height:", height)
print("Is student?", is_student)

# ----------------------------
# BASIC INPUT/OUTPUT
# ----------------------------

user_input = input("Enter your favorite color: ")
print("You entered:", user_input)

# ----------------------------
# OPERATORS
# ----------------------------

a = 10
b = 3
print("Addition:", a + b)
print("Division:", a / b)
print("Floor Division:", a // b)
print("Modulus:", a % b)
print("Exponent:", a ** b)
print("Comparison (a > b):", a > b)
print("Logical (a > 5 and b < 5):", a > 5 and b < 5)

# ----------------------------
# IF/ELSE STATEMENTS
# ----------------------------

if age >= 18:
    print("You are an adult.")
else:
    print("You are a minor.")

# elif example
score = 75
if score >= 90:
    print("Grade: A")
elif score >= 80:
    print("Grade: B")
elif score >= 70:
    print("Grade: C")
else:
    print("Grade: F")

# ----------------------------
# LOOPS
# ----------------------------

# For loop
print("Counting from 1 to 5:")
for i in range(1, 6):
    print(i)

# While loop
count = 0
print("While loop example:")
while count < 3:
    print("Count is:", count)
    count += 1

# ----------------------------
# FUNCTIONS
# ----------------------------

def greet(name):
    print("Hello,", name)

greet("Bob")

def add(x, y):
    return x + y

result = add(3, 4)
print("Sum is:", result)

# ----------------------------
# LISTS
# ----------------------------

fruits = ["apple", "banana", "cherry"]
print("First fruit:", fruits[0])
fruits.append("orange")
print("Updated fruits:", fruits)

for fruit in fruits:
    print("Fruit:", fruit)

# ----------------------------
# DICTIONARIES
# ----------------------------

student = {
    "name": "Alice",
    "age": 25,
    "courses": ["Math", "Science"]
}

print("Student name:", student["name"])
student["grade"] = "A"
print("Updated student dict:", student)

# ----------------------------
# TUPLES AND SETS (Bonus Basic Concepts)
# ----------------------------

# Tuples - Immutable sequences
coordinates = (10, 20)
print("X coordinate:", coordinates[0])

# Sets - Unordered collections of unique elements
unique_numbers = {1, 2, 2, 3, 4}
print("Unique numbers:", unique_numbers)

# ----------------------------
# END OF FILE
# ----------------------------
