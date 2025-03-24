import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# Leemos el CSV
df = pd.read_csv("Python\Graficos\Grafico_Lineal\panes.csv")

#Creamos el grafico Lineal, en el eje X ponemos la Fecha y en el eje Y ponemos los panes. Como datos usamos DF
sns.lineplot(x="Fecha",y="Panes",data=df)

# Creamos un punto en una coordenadas, Y que sea un "o"
plt.plot("03-08", 18, "o")

# Mostramos el grafico
plt.show()

