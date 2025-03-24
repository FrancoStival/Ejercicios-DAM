animales = ["perro", "gato", "loro", "cocodrilo", "pez"]
numeros = [12, 52, 76, 89, 43]

# Recorriendo la lista de animales
for animal in animales:
    print(animal)
    
# Recorriendo la lista de numeros
for numero in numeros:
    resultado = numero *3
    print(resultado)
    
# Si las listas tienen la misma cantidad de elementos, se pueden recorrer a la vez
for numero, animal in zip(numeros,animales): 
    print(f"Lista 1: {numero}")
    print(f"Lista 2: {animal}")
    
# Recorre desde el primer numero (o 0 si no se da un numero), hasta el segundo numero
for num in range(10, 20):
    print(num)

# Forma no correcta de recorrer una lista
for num in range(len(numeros)):
    print(numeros[num])
    
# Forma correcta de recorrer una lista con su indice
for num in enumerate(numeros):
    indice = num[0] # Los elementos pares son los indices
    valor = num[1] # Los elementos impares son los valores
    print(f"El indice es {indice} y el valor es {valor}")
else:
    print("Fin del bucle") # Los bucles se pueden acabar con un Else