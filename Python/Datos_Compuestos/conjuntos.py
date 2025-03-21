conjunto = {1, 2, 3, 4, 5} #Llista desordenada, pero invariable como las tuplas, e irepetible.
                            #Como está desordenada, no se puede acceder por Indice.
try:
    print(conjunto[3]) #Dará Error
except TypeError: 
    print(TypeError)