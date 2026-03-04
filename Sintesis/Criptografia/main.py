import Cifrado.rsa as rsa
import Cifrado.dsa as dsa
from matematicas import *
from block import Block
from blockchain import Blockchain
from transaccion import Transaction


if __name__ == "__main__":
    debug = input("¿Modo debug? (s/n): ") == "s"
    if debug:
        # Ejemplo de Division Euclidea
        q, r = division_euclidea(23, 5)
        print("Cociente:", q)
        print("Resto:", r)

        # Ejemplo de MCD
        print("MCD(252,198):", mcd(252, 198))

        # Ejemplo de Euclides Extendido
        mcd_val, x, y = euclides_extendido(3, 11)
        print("MCD:", mcd_val)
        print("x:", x)
        print("y:", y)

        # Ejemplo de Inverso Modular
        print("Inverso de 3 mod 11:", inverso_modular(3, 11))

        # Ejemplo de Potencia Modular
        print("4^13 mod 497:", pow_mod(4, 13, 497))


        # Ejemplo de RSA
        pubRSA, privRSA = rsa.generar_claves()

        print("Clave pública:", pubRSA)
        print("Clave privada:", privRSA)

        mensaje = 42
        print("Mensaje original:", mensaje)

        cifrado = rsa.cifrar(mensaje, pubRSA)
        print("Mensaje cifrado:", cifrado)

        descifrado = rsa.descifrar(cifrado, privRSA)
        print("Mensaje descifrado:", descifrado)

        # Ejemplo de DSA
        pubDSA, privDSA = dsa.generar_claves()

        p, q, g, y = pubDSA

        mensaje = "Hola mundo"

        firma = dsa.firmar(mensaje, (p, q, g), privDSA)

        print("Firma:", firma)

        es_valida = dsa.verificar(mensaje, firma, pubDSA)

        print("¿Firma válida?", es_valida)

        print("¿Firma válida si modifico mensaje?",
            dsa.verificar("Hola Mundo", firma, pubDSA)) # Solo cambio la M a mayúscula

print("\n--- Transacciones ---")

pubUser, privUser = dsa.generar_claves()
pubUser2, privUser2 = dsa.generar_claves()

# Inicializar balances
mi_blockchain = Blockchain()
mi_blockchain.create_user(pubUser, 1000)
mi_blockchain.create_user(pubUser2, 500)

# Crear transacción
tx1 = Transaction(pubUser, pubUser2, 200)
tx1.sign_transaction(privUser)

# Añadir bloque con la transacción
bloque = Block(1, [tx1], "")
mi_blockchain.add_block(bloque)

# Comprobar balances
print("Balance Usuario1:", mi_blockchain.balances[pubUser])
print("Balance Usuario2:", mi_blockchain.balances[pubUser2])



print("\n--- Blockchain ---")

mi_blockchain = Blockchain()

mi_blockchain.add_block(Block(1, "Transaccion 1", ""))
mi_blockchain.add_block(Block(2, "Transaccion 2", ""))

for block in mi_blockchain.chain:
    print("Index:", block.index)
    print("Hash:", block.hash)
    print("Previous:", block.previous_hash)
    print()

print("¿Blockchain válida?", mi_blockchain.is_chain_valid())