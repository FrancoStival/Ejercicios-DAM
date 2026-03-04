from matematicas import mcd, inverso_modular, pow_mod
import random

def es_primo(n):
    if n <= 1:
        return False
    if n <= 3:
        return True
    if n % 2 == 0:
        return False

    i = 3
    while i * i <= n:
        if n % i == 0:
            return False
        i += 2

    return True

def generar_primo(inicio=50, fin=200):
    while True:
        num = random.randint(inicio, fin)
        if es_primo(num):
            return num
        
def generar_claves():
    # 1. Elegir p y q
    p = generar_primo()
    q = generar_primo()

    while q == p:
        q = generar_primo()

    # 2. Calcular n
    n = p * q

    # 3. Calcular phi(n)
    phi = (p - 1) * (q - 1)

    # 4. Elegir e coprimo con phi
    e = random.randint(2, phi - 1)
    while mcd(e, phi) != 1:
        e = random.randint(2, phi - 1)

    # 5. Calcular d (inverso modular)
    d = inverso_modular(e, phi)

    clave_publica = (e, n)
    clave_privada = (d, n)

    return clave_publica, clave_privada

def cifrar(mensaje, clave_publica):
    e, n = clave_publica
    return pow_mod(mensaje, e, n)

def descifrar(cifrado, clave_privada):
    d, n = clave_privada
    return pow_mod(cifrado, d, n)