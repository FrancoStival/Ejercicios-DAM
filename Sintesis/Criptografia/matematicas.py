def division_euclidea(a, b):
    """
    Devuelve el cociente y el resto de la división euclídea.
    a = b*q + r
    """
    if b == 0:
        raise ValueError("El divisor no puede ser 0")

    q = a // b
    r = a % b

    return q, r

def mcd(a, b):
    """
    Calcula el máximo común divisor usando el algoritmo de Euclides.
    """
    while b != 0:
        a, b = b, a % b
    return a

def inverso_modular(a, n):
    """
    Devuelve el inverso modular de a mod n.
    """
    mcd_val, x, y = euclides_extendido(a, n)

    if mcd_val != 1:
        raise ValueError("No existe inverso modular")

    return x % n

def euclides_extendido(a, b):
    """
    Devuelve (mcd, x, y) tal que:
    ax + by = mcd
    """
    if b == 0:
        return a, 1, 0

    mcd_val, x1, y1 = euclides_extendido(b, a % b)

    x = y1
    y = x1 - (a // b) * y1

    return mcd_val, x, y

def pow_mod(base, exponente, modulo):
    """
    Calcula (base^exponente) mod modulo
    usando Square and Multiply.
    """
    resultado = 1
    base = base % modulo

    while exponente > 0:
        if exponente % 2 == 1:
            resultado = (resultado * base) % modulo

        base = (base * base) % modulo
        exponente = exponente // 2

    return resultado