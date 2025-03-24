# Crear el archivo y escribir notas
with open("Python/Archivos/Archivos_de_Ejemplos/notas.txt", "w") as archivo:  # Esto crea el archivo si no existe
    archivo.write("Matemáticas: 8.5\n")
    archivo.write("Ciencias: 7.0\n")
    archivo.write("Historia: 9.0\n")

# Leer el archivo para mostrar su contenido
with open("Python/Archivos/Archivos_de_Ejemplos/notas.txt", "r") as archivo:  # Abrir en modo lectura
    contenido = archivo.read()
    print(contenido)  # Mostrar contenido del archivo

# Agregar nueva nota al final del archivo
with open("Python/Archivos/Archivos_de_Ejemplos/notas.txt", "a") as archivo:  # Abrir en modo anexar
    archivo.write("Lengua: 8.0\n")

# Leer el archivo nuevamente para mostrar el contenido actualizado
with open("Python/Archivos/Archivos_de_Ejemplos/notas.txt", "r") as archivo:  # Abrir en modo lectura
    contenido = archivo.read()
    print()  # Salto de línea para separación visual
    print(contenido)  # Mostrar contenido actualizado

"""
Los modos para abrir un archivo en Python son los siguientes:

1. 'r'  - Modo de lectura (Read)
   - Abre el archivo para leerlo. 
   - Si el archivo no existe, se genera un error `FileNotFoundError`.
   - El archivo debe existir previamente.

2. 'w'  - Modo de escritura (Write)
   - Abre el archivo para escribir. 
   - Si el archivo ya existe, su contenido se borra y se sobrescribe con lo nuevo.
   - Si el archivo no existe, se crea uno nuevo.

3. 'a'  - Modo de anexado (Append)
   - Abre el archivo para agregar contenido al final sin borrar el contenido existente.
   - Si el archivo no existe, se crea uno nuevo.

4. 'x'  - Modo exclusivo (Exclusive creation)
   - Abre el archivo para escritura, pero solo si el archivo no existe. 
   - Si el archivo ya existe, se genera un error `FileExistsError`.

5. 'b'  - Modo binario (Binary)
   - Abre el archivo en modo binario (en lugar de texto).
   - Se utiliza junto con otros modos para trabajar con archivos binarios (por ejemplo, imágenes, audios, etc.).

6. 't'  - Modo texto (Text)
   - Abre el archivo en modo texto (por defecto). 
   - No es necesario especificarlo ya que es el modo predeterminado si no se indica lo contrario.

7. 'r+' - Modo de lectura y escritura (Read/Write)
   - Abre el archivo para leer y escribir.
   - Si el archivo no existe, se genera un error `FileNotFoundError`.

8. 'w+' - Modo de escritura y lectura (Write/Read)
   - Abre el archivo para leer y escribir.
   - Si el archivo ya existe, su contenido se borra y se sobrescribe con lo nuevo.
   - Si el archivo no existe, se crea uno nuevo.

9. 'a+' - Modo de anexado y lectura (Append/Read)
   - Abre el archivo para leer y agregar contenido al final del archivo.
   - Si el archivo no existe, se crea uno nuevo.

10. 'rb' - Modo binario de solo lectura (Read Binary)
    - Abre el archivo en modo binario solo para lectura.

11. 'wb' - Modo binario de escritura (Write Binary)
    - Abre el archivo en modo binario solo para escritura.

12. 'ab' - Modo binario de anexado (Append Binary)
    - Abre el archivo en modo binario solo para agregar contenido al final sin sobrescribir el contenido existente.

13. 'r+b' - Modo binario de lectura y escritura (Read/Write Binary)
    - Abre el archivo en modo binario para leer y escribir.

14. 'w+b' - Modo binario de escritura y lectura (Write/Read Binary)
    - Abre el archivo en modo binario para leer y escribir, pero sobrescribe el contenido si ya existe.

15. 'a+b' - Modo binario de anexado y lectura (Append/Read Binary)
    - Abre el archivo en modo binario para agregar contenido al final sin sobrescribir el contenido existente.
"""
