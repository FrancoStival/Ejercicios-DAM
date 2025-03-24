# Esta es una forma de leer csv con el modulo csv
import csv
with open("Python/Archivos/Archivos_de_Ejemplos/datos.csv") as ArchivoCsv:
    reader = csv.reader(ArchivoCsv)
    for row in reader:
        print(row)