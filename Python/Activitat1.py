def añadir():
    nombre = input("Ingrese el nombre del cliente: ")
    habitación = int(input("Ingrese el numero de habitación: "))
    noches = int(input("Ingrese el numero de noches que se alojará: "))
    precio = int(input("Ingrese el precio de la habitación: "))
    reservas[nombre] = {"habitación": habitación, "noches": noches, "precio": precio}
    print("Reserva agregada con éxito")

def ver():
    if not reservas:
        print("No hay reservas")
    else:
        print("Reservas:")
        for nombre, datos in reservas.items():
            print(f"Nombre: {nombre}, Habitación: {datos['habitación']}, Noches : {datos['noches']}, Precio: {datos['precio']}")
            print("\n")

def buscar():
    nombre = input("Ingrese el nombre del cliente: ")
    if nombre in reservas:
        print(f"Nombre: {nombre}, Habitación: {reservas[nombre]['habitación']} , Noches: {reservas[nombre]['noches']} , Precio: {reservas[nombre]['precio']}")
    else:
        print("No hay reservas para ese cliente")
              
def cancelar():
    nombre = input("Ingrese el nombre del cliente: ")
    if nombre in reservas:
        del reservas[nombre]
        print("Reserva eliminada con éxito")
    else:
        print("No se encontró la reserva")

reservas = {}
while True:
    print("1. Añadir una reserva")
    print("2. Ver todas las reservas")
    print("3. Buscar una reserva por el nombre del cliente")
    print("4. Cancelar una reserva")
    print("5. Salir")
    opcion = input("Ingrese una opción: ")

    match opcion:
        case "1":
            añadir()
        case "2":
            ver()
        case "3":
            buscar()
        case "4":
            cancelar()
        case "5":
            print("Hasta luego")
        case _:
            print("Opción no válida. Por favor, intente de nuevo.")