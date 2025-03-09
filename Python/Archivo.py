with open("Python/Archivos/notas.txt", "w") as archivo: #Esto crea el archivo si no existe y lo escribe
    
    archivo.write("Matemáticas: 8.5\n")
    archivo.write("Ciencias: 7.0\n")
    archivo.write("Historia: 9.0\n")

with open("Python/Archivos/notas.txt", "r") as archivo: #Hay que abrir el archivo con otros permisos para leerlo
    contenido = archivo.read()
    print
    print(contenido)

with open("Python/Archivos/notas.txt", "a") as archivo: #Esto agrega contenido al final del archivo sin borrar el contenido existente
    archivo.write("Lengua: 8.0\n")

with open("Python/Archivos/notas.txt", "r") as archivo: #Hay que abrir el archivo con otros permisos para leerlo
    contenido = archivo.read()
    print()
    print(contenido)