diccionario = {"nombre": "Ana", "edad": 22, "ciudad": "Barcelona"}
diccionario["profesion"] = "Estudiante"
diccionario["edad"] = 23
del diccionario["ciudad"]
print(diccionario)

if "profesion" in diccionario:
    print("La clave 'profesion' existe")