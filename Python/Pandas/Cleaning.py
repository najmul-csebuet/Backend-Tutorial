import pandas as pd

df = pd.read_csv('dirtydata.csv')
print(df.head())
print(df.tail())
print(df.info())

new_df = df.dropna()
print(new_df.info())

# By default, the dropna() method returns a new DataFrame, and will not change the original.
# If you want to change the original DataFrame, use the inplace = True argument:
df.dropna(inplace=True)
print(df.to_string())
print(df.info())

# The fillna() method allows us to replace empty cells with a value:
df.fillna(130, inplace=True)

# Replace NULL values in the "Calories" columns with the number 130:
df['Calories'].fillna(130, inplace=True)

# A common way to replace empty cells, is to calculate the mean, median or mode value of the column.
# Pandas uses the mean() median() and mode() methods to calculate the respective values for a specified column:
x = df['Calories'].mean()
df['Calories'].fillna(x, inplace=True)

x = df["Calories"].median()
df["Calories"].fillna(x, inplace=True)

# Mode = the value that appears most frequently.
mode = df["Calories"].mode()
x = mode[0]
df["Calories"].fillna(x, inplace=True)

df = pd.read_csv('dirtydata.csv')
df['Date'] = pd.to_datetime(df['Date'])
print(df.to_string())

# the date in row 26 where fixed, but the empty date in row 22 got a NaT (Not a Time) value, in other words an empty
# value. One way to deal with empty values is simply removing the entire row.

# Remove rows with a NULL value in the "Date" column:
df.dropna(subset=['Date'], inplace=True)
