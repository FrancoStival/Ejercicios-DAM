import math
def potencia(num1, potencia):
    return num1 ** potencia

def raiz(num1):
    if num1 < 0:
        return "No se puede calcular la raiz de un número negativo"
    return math.sqrt(num1)
