class Animal:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
    
    def describirse(self):
        print(f"Soy un animal llamado {self.nombre} y tengo {self.edad}")
    
class Perro(Animal):
    def __init__(self, nombre, edad, raza):
        super().__init__(nombre, edad) # El super llama al método de la clase padre
        self.raza = raza
    
    def describirse(self): # Esto ya sobreescribe el metodo sin necesidad de nada extra
        super().describirse()# El super llama al método de la clase padre
        print(f"Y soy un perro de la raza {self.raza}\n")
        
    def ladrar(self):
        print("Guau guau \n")
        
try:
    mi_animal = Animal("Twist", 13)
    mi_perro = Perro("Berta", 12, "Negra")

    mi_animal.describirse()
    print("")
    mi_perro.describirse()
    mi_perro.ladrar()

except Exception as e: # Esto es para capturar cualquier error que pueda ocurrir 
    print(f"Error: {e}")

finally:
    print("Fin del programa")