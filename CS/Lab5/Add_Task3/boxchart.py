import pandas
import matplotlib.pyplot as plt
import seaborn


data = pandas.read_csv('aboba.csv')
seaborn.set(style='whitegrid')
plt.subplots(figsize=(10, 6))
seaborn.boxplot(data=data, width=0.8)
plt.show()
