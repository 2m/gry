from pandas import read_csv
from matplotlib import pyplot

measured = read_csv("clean_log.txt", header=0, index_col=0)
calculated = read_csv("clean_dump.txt", header=0, index_col=0)

pyplot.plot(measured)
pyplot.plot(calculated)
pyplot.show()
