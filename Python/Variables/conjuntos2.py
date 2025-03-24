conjunto = set(["Dato1", "Dato2"]) # Creando un conjunto con un set()

# Metiendo un conjunto dentro de otro conjunto
conjunto1 = frozenset(["Dato1", "Dato2"]) # Frozenset hace un conjunto inmutable
conjunto2= {conjunto1, "Dato3"}
print(conjunto2)

# Teoria de conjuntos

conjuntoSuper = {1,2,3,4,5}
conjuntoPeque = {1,2,3}

# Comprobar si es SubConjunto
resultado = conjuntoPeque.issubset(conjuntoSuper)
resultado = conjuntoPeque <= conjuntoSuper

# Comprobar si es un SuperConjunto
resultado = conjuntoSuper.issuperset(conjuntoPeque)
resultado = conjuntoSuper > conjuntoPeque

# Comprobar si hay elemento en común
resultado = conjuntoSuper.isdisjoint(conjuntoPeque)

print(resultado)