from matematicas import pow_mod, inverso_modular, mcd
import random
import hashlib

def hash_mensaje(mensaje):
    """
    Devuelve el hash SHA-256 del mensaje como entero.
    """
    h = hashlib.sha256(mensaje.encode())
    return int(h.hexdigest(), 16)

def generar_parametros():
    """
    Genera parámetros p, q y g simplificados.
    """

    # Primos pequeños para prueba
    p = 467
    q = 233  # q debe dividir p-1

    # Verificamos que q divide p-1
    if (p - 1) % q != 0:
        raise ValueError("q no divide p-1")

    # Generador g
    h = 2
    g = pow_mod(h, (p - 1) // q, p)

    return p, q, g

def generar_claves():
    p, q, g = generar_parametros()

    # Clave privada
    x = random.randint(1, q - 1)

    # Clave pública
    y = pow_mod(g, x, p)

    clave_publica = (p, q, g, y)
    clave_privada = x

    return clave_publica, clave_privada

def firmar(mensaje, parametros, clave_privada):
    p, q, g = parametros
    x = clave_privada

    H = hash_mensaje(mensaje)

    while True:
        k = random.randint(1, q - 1)

        if mcd(k, q) != 1:
            continue

        r = pow_mod(g, k, p) % q

        if r == 0:
            continue

        k_inv = inverso_modular(k, q)

        s = (k_inv * (H + x * r)) % q

        if s != 0:
            break

    return (r, s)

def verificar(mensaje, firma, clave_publica):
    p, q, g, y = clave_publica
    r, s = firma

    if not (0 < r < q and 0 < s < q):
        return False

    H = hash_mensaje(mensaje)

    w = inverso_modular(s, q)

    u1 = (H * w) % q
    u2 = (r * w) % q

    v = ((pow_mod(g, u1, p) * pow_mod(y, u2, p)) % p) % q

    return v == r