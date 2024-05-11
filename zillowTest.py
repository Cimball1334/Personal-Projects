import matplotlib.pyplot as plt
import numpy as np



x = np.random.uniform(0.5001, 0.9001, size=45)
y = np.random.uniform(0.5, 1.5, size=45)

plt.scatter(x,y)


plt.show()