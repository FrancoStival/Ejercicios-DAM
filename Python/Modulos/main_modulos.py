from Modulos_Calculadora.operaciones import sumar, restar, multiplicar, dividir
from Modulos_Calculadora.avanzadas import * # Podemos importar todo, pero no es recomendable

# Tambien podemos usar nombre_del_modulo as nom. Esto le da otro nombre al modulo
print("Suma: ", sumar(10, 20))
print("Resta: ", restar(10, 20))
print("Multiplicación: ", multiplicar(10, 20))
print("División: ", dividir(10, 20))

print("Raíz cuadrada: ", raiz(16))
print("Potencia: ", potencia(2, 3))