diccionario = {
    "nombre": "Franco",
    "apellido": "Stival",
    "edad": "20"
}
# Recorriendo un diccionario para obtener las claves
for keys in diccionario:
    print(keys)
    
# Recorriendo un diccionario con items() para obtener las claves y el valor
for keys in diccionario.items:
    clave = keys[0] # Los elementos pares son las claves
    valor = keys[1] # Los elementos impares son los valores
    print(f"La clave es {clave} y el valor es {valor}")