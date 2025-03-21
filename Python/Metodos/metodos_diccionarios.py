diccionario = {
    "nombre" : 'Franco',
    "apellido" : 'Stival',
    "edad" : 20
}

claves = diccionario.keys() # Devuelve las claves de un diccionario
valor = diccionario.get("nombre") # Devuelve el valor de una clave
diccionario.clear() # Vacia el diccionario
diccionario.pop("nombre") # Elimina una clave y su valor

print(claves)