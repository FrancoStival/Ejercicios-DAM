Este_Curso = 1.5 
Este_Curso_Crudo = 3.5
Curso_Mas_Rapido = 2.5
Curso_Mas_Lento = 7.0
Promedio = 4.0
Promedio_crudo = 5.0
Equivalencia = 10.0
# A
#  Diferencia porcentual entre:
#  A_1 El curso más rapido
A_1 = (Este_Curso / Curso_Mas_Rapido) * 100
print("Este curso es un " + str(A_1) + "% del curso más rapido.")

#  A_2 El curso más lento
A_2 = (Este_Curso / Curso_Mas_Lento) * 100
print("Este curso es un " + str(A_2) + "% del curso más lento.")

#  A_3 El promedio
A_3 = (Este_Curso / Promedio) * 100
print("Este curso es un " + str(A_3) + "% del promedio de cursos.")

# B
#  Porcentaje de material inservervible en
#  B_1 El promedio de otros cursos
B_1 = 100.0 - (Promedio / Promedio_crudo * 100)
print("Del material grabado total en el promedio de cursos, un " + str(B_1) + "% es material inservible")

#  B_2 El curso actual
B_2 = 100.0 - (Este_Curso / Este_Curso_Crudo * 100)
print("Del material grabado total en este curso, un " + str(B_2) + "% es material inservible")

# C
#  C_1 10 horas de este curso a cuantas equivalen en otros cursos
C_1 = (Promedio * Equivalencia / Este_Curso)
print(f"{Equivalencia:.0f} horas en este curso equivalen a {C_1:.2f} en el resto de cursos")