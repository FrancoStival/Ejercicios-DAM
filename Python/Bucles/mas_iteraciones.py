frutas = ["banana", "manzana", "ciruela", "pera", "naranja","granada", "durazno"]
texto = "Hola Soy Franco"
numeros = [2,4,8,10,12]
#Omitiendo una iteración
for fruta in frutas:
    if fruta == 'granada':
        continue # Omite esta iteración
    print(f"Me voy a comer una {fruta}")
    
# Rompiendo el bucle
for fruta in frutas:
    if fruta == "pera":
        print("Me comí una pera y me duele el estomago")
        break
    print(f"Me voy a comer una {fruta}")
else:
    print("Bucle terminado") # El break omite este Else

# Recorriendo una cadena de texto
for letra in texto:
    print(letra)

#Esta es una forma ineficiente
numeros_doblados = list(),
""" for numero in numeros:
        .append(numero*2)
    print(numeros_doblados)
"""
# Así se hace en una linea
numeros_duplicados = [x*2 for x in numeros]
print(numeros_duplicados)

