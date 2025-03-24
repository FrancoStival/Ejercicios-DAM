def saludar(nombre,sexo):
    sexo = sexo.lower()
    if (sexo == "mujer"):
        adjetivo = "reina"
    elif (sexo == "hombre"):
        adjetivo == "capo"
    else:
        adjetivo == "crack"
    print(f"Hola! {nombre}. Sos un {adjetivo}")
    
saludar("Fran", "hombre")
