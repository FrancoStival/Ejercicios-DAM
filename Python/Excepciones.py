try:
    numero1 = input("Introduzca un primer número: ")
    numero2 = input("Introduzca un segundo número: ")
    resultado = float(numero1) / float(numero2)
except ZeroDivisionError:
    print("No se puede dividir por cero")
except ValueError:
    print("Introduzca un valor numerico")
else:
    print(f"El resultado de la división es: {resultado}")
finally:
    print("El programa ha terminado")
    
    """
    Tipos de Errores:
        
    FileNotFoundError: No se encontró el archivo
    ZeroDivisionError: Error de división por cero
    TypeError: Error de tipo de datos (ejemplo: sumar dos strings)
    ValueError: Error de valor (usualmente cuando se pasa como parametro a una funcion)
    """