lista = list(["Hola", "Franco", "Stival"]) # Lista crea una lista

cantidad_elementos = len(lista) # Devuelve la cantidad de elementos de la lista
lista.append("Como estas") # Agrega un elemento al final de la lista
lista.insert(1, "Soy") # Agrega un elemento en un indice especifico
lista.extend([False, 2025]) # Agrega varios elementos a la lista en formato lista

lista.pop(1) # Elimina un elemento segun un indice especifico
lista.pop(-1) # Elimina empezando por el final
lista.remove(False) # Elimina un elemento según un valor
lista.clear() # Vacia la lista

lista.sort() # Ordena por valor ascendente
lista.sort(reverse=True) # Ordena y luego invierte
lista.reverse() # Invierte los elementos de una lista

elemento_encontrado = lista.index("Hola") # Devuelve el indice de un valor que le pasemos

