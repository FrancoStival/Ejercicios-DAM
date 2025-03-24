numero = {4, 2, 15, 129, 82}

# Encontrar el numero mas alto
numero_mas_alto = max(numero)
print(numero_mas_alto)
# Encontrar el numero mas bajo
numero_mas_bajo = min(numero)
print(numero_mas_bajo)

# Redondear a 2 decimales
numero = round(12.34532234,2)

# Retorna False -> 0, vacio, False, ninguno \ True -> != 0, True, cadena de texto 
resultado_bool = bool(None)
print(resultado_bool)

# Retorna True si todos són verdaderos
resultado_all = all([123, "True", [234, 576]])
print(resultado_all)

# Suma todos los numeros de un iterable
resultado_sumado = sum(numero)
print(resultado_sumado)