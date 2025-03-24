def calcular_area_rectangulo(base, altura):
    return base * altura

numero1 = float(input("Dime un numero: "))
numero2 = float(input("Dime otro numero: "))

area = calcular_area_rectangulo(numero1, numero2)
print("Con esos dos numeros puedes hacer un rectangulo de: " + str(area))
