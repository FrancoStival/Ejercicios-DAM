import pandas as pd
df = pd.read_csv("Python/Archivos/Archivos_de_Ejemplos/datos.csv")
df2 = pd.read_csv("Python/Archivos/Archivos_de_Ejemplos/datos.csv")

#Todas las filas en la columna "Nombre", las mete en la variable
nombres= df["Nombre"]
print(nombres)

#Slicing, similar al Split de Java. Muestra en base a un inicio y un final (sin incluir)
cadena = "0123456789"
#print(cadena[1:8])

# Ordenando el Dataframe por la edad ascendente
df_ordenado_ascendente = df.sort_values("Edad")
print(df_ordenado_ascendente)
print()
# Ordenando el Dataframe por la edad descendente
df_ordenado_descendente = df.sort_values("Edad", ascending=False)
print(df_ordenado_descendente)
print()

#Concatenar DataFrames
df_concatenado = pd.concat([df,df2])
print(df_concatenado)
print()

#Accediendo a las 3 primeras fila con head()
primeras_filas = df.head(3)
print(primeras_filas)

#Accediendo a las 3 ultimas fila con tail()
ultimas_filas = df.tail(3)
print(ultimas_filas)

# Accediendo a la cantidad de filas y columnas con .shape
filas_totales,columnas_totales = df.shape
print(f"Hay {filas_totales} filas en total")
print(f"Hay {columnas_totales} columnas en total")

# Accediendo a un elemento especifico del df con loc
elemento_especifico_loc = df.loc[2,"Edad"] # Accedemos a la fila de indice 2, a la columna "edad"

# Accediendo a un elemento especifico del df con iloc
elemento_especifico_iloc = df.iloc[2,2] # Accedemos a la fila de indice 2, a la columna de indice 

# Accediendo a todas las filas de una columna
apellidos = df.iloc[:,1] # Los : en Slicing hace referencia a todos los elementos

# Accediendo a las filas con edad mayor que 25
mayor_que_25 = df.loc[df["Edad"]>25,:]

print(mayor_que_25)