import matplotlib.pyplot as plt
import numpy as np

x = np.array(['A', 'B', 'C', 'D'])
y = np.random.randint(10, size=4)

plt.bar(x, y)
plt.show()

x = np.array(["A", "B", "C", "D"])
y = np.array([3, 8, 1, 10])

plt.barh(x, y)
plt.show()
