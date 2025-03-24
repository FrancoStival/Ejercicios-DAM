import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# Leemos el CSV
df = pd.read_csv("Python\Graficos\Grafico_Barras\ingresos.csv")

#Creamos el grafico de Barras, en el eje X ponemos las fuentes y en el eje Y ponemos los Ingresos. Como datos usamos DF
sns.barplot(x="Fuentes",y="Ingresos",data=df)

total_ingresos = df['Ingresos'].sum()

# Mostrando el total
print(f"El Total de Ingresos es de: ${total_ingresos}")
# Mostramos el grafico
plt.show()

