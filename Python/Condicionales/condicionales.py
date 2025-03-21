edad = int(input("¿Cuál es tu edad?: "))

if edad < 13:
    print("Eres un niño")
elif 13 <= edad <= 17:
    print("Eres un adolescente")
elif 18 <= edad <= 64:
    print("Eres un adulto")
elif edad >= 65:
    print("Eres un adulto mayor")
else:
    print("No has introducido una edad válida")