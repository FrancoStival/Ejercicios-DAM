diccionario = {"nombre": "Ana", "edad": 22, "ciudad": "Barcelona"}
diccionario["profesion"] = "Estudiante" # Si la clave ya existe, se sobreescribe el valor, sino se agrega la clave y el valor
diccionario["edad"] = 23 # Si la clave ya existe, se sobreescribe el valor, sino se agrega la clave y el valor
del diccionario["ciudad"]
print(diccionario)

if "profesion" in diccionario:
    print("La clave 'profesion' existe")