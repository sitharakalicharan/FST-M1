# import pandas
import pandas as pd

# Create a dictionary to hold our data
data = {
  "Usernames": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}

# Create a new DataFrame using our dictionary
table = pd.DataFrame(data)

table.to_csv("../Resources/sample.csv", index=False)