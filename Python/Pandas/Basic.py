import pandas as pd

df = pd.read_csv('data.csv', header=None)
print(df.to_string())

myDataSet = {
    'passing': ['A', 'B', 'C'],
    'cars': ['A', 'B', 'C']
}
myvar = pd.DataFrame(myDataSet)
print(myvar)

print(pd.__version__)

a = [1, 7, 2]
m = pd.Series(a)
print(m)
print(m[0])

a = [1, 7, 2]
myvar = pd.Series(a, index=["x", "y", "z"])
print(myvar)
print(myvar["y"])

calories = {"day1": 420, "day2": 380, "day3": 390}
myvar = pd.Series(calories)
print(myvar)

calories = {"day1": 420, "day2": 380, "day3": 390}
myvar = pd.Series(calories, index=["day1", "day2"])
print(myvar)

data = {
    "calories": [420, 380, 390],
    "duration": [50, 40, 45]
}
# load data into a DataFrame object:
df = pd.DataFrame(data)
print(df)
print(df.loc[0])

# use a list of indexes:
print(df.loc[[0, 2]])

data = {
    "calories": [420, 380, 390],
    "duration": [50, 40, 45]
}
df = pd.DataFrame(data, index=["day1", "day2", "day3"])
print(df)
print(df.loc["day2"])

df = pd.read_json('data.json')
print(df.to_string())

data = {
    "Duration": {
        "0": 60,
        "1": 60,
        "2": 60,
        "3": 45,
        "4": 45,
        "5": 60
    },
    "Pulse": {
        "0": 110,
        "1": 117,
        "2": 103,
        "3": 109,
        "4": 117,
        "5": 102
    },
    "Maxpulse": {
        "0": 130,
        "1": 145,
        "2": 135,
        "3": 175,
        "4": 148,
        "5": 127
    },
    "Calories": {
        "0": 409,
        "1": 479,
        "2": 340,
        "3": 282,
        "4": 406,
        "5": 300
    }
}

df = pd.DataFrame(data)

print(df)

print('Tail')
print(df.tail())


print('Info')
print(df.info())
