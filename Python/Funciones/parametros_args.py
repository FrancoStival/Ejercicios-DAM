def suma(nombre,*numeros):
    return f"{nombre} la suma de tus numeros es: {sum(numeros)}" 
    

resultado = suma("Franco",5,3,9,125)
print(resultado)