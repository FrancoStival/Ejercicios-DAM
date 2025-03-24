diccionario = dict(nombre="Lucas",apellido="Dalto") # Creando un diccionario con dict()

diccionario = {frozenset(["Lucas","Python"]): "jajas"} # Usando un conjunto inmutable como clave

diccionario= dict.fromkeys(["nombre", "apellido","suscriptores"]) #Creando un diccionario con claves vacias

diccionario= dict.fromkeys("ABCDE", "VALOR") # El primer valor se itera para crear las claves, el segundo es el valor por defecto

print(diccionario)