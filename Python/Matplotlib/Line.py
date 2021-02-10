import matplotlib.pyplot as plt
import numpy as np

xPoints = np.array([0, 6])
yPoints = np.array([0, 250])

# plt.plot(xPoints, yPoints)
plt.plot(xPoints, yPoints, 'o--r', ms=20)
# plt.plot([0, 6], [0, 250])

font1 = {'family': 'serif', 'color': 'blue', 'size': 20}
font2 = {'family': 'serif', 'color': 'darkred', 'size': 15}

plt.title("Sports Watch Data", fontdict=font1, loc='left')
plt.xlabel("Average Pulse", fontdict=font2)
plt.ylabel("Calorie Burnage", fontdict=font2)

plt.grid(axis = 'x')

plt.show()
