cadena1 = "Hola Soy Franco"
cadena2 = "213456789"
cadena3 = "123123Fran"

mayus = cadena1.upper() # A mayusculas
minus = cadena1.lower() # A minusculas
primera_letra_mayus = cadena1.capitalize() # Solo la primera letra en mayusculas
busqueda_find = cadena1.find("Franco") # Devuelve la posición de otro String. -1 si no lo encuentra.
busqueda_index = cadena1.index("Franco") # Lo mismo que Find, pero si no lo encuentra, da ValueError
es_numerico = cadena2.isnumeric() # Si es numerico da True, sino False
es_alfanumerico = cadena3.isalpha() # Si es Alfa Numerico da True, sino False
contar_coincidencias = cadena1.count("a") # Cantidad de coincidencias de una cadena dentro de otra cadena
contar_longitud = len(cadena1) # Cantidad de caracteres
empieza_con = cadena1.startswith("Hola") # Mira si una cadena empieza con otra cadena, devuelve un Bool
termina_con = cadena1.endswith("Hola") # Mira si una cadena termina con otra cadena, devuelve un Bool
cadenaNueva = cadena1.replace("la", "lu") # Remplaza una parte de la cadena con otra parte
cadenaSeparada = cadena1.split() # Separa una cadena en partes según un parametro. Devuelve una lista

print(es_alfanumerico)