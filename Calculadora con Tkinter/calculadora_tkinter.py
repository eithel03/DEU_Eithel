#importamos la libreria
from tkinter import*

expresion = " " #Variable global que guardara el dato que ingreso el usuario

def limpiar():
    global expresion
    expresion = " "
    equacion.set(expresion)
    return

def apretar(num):
    global expresion
    expresion = expresion + str(num)
    equacion.set(expresion)
    return

def calcular(gui):
    global expresion
    total = str(eval(expresion))
    equacion.set(total)
    expresion = total #Para poder calcular sobre el ultimo resultado
    return

def agregar_botones(gui):
    #Fila 1
    boton_limpiar = Button(gui, text=" AC ", foreground="black", background="orange", command=lambda: limpiar(), height=2, width=4) #Formato del boton limpiar
    boton_limpiar.grid(row=3, column=0) #Ubicación del boton de limpiar
    
    boton_division = Button(gui, text=" / ", foreground= "black", background="orange", command=lambda: apretar("/"), height=2, width=4) #Formato del boton dividir
    boton_division.grid(row=3, column=3) #Ubicación del boton de dividir
    
    #Fila 2
    boton_7 = Button(gui, text=" 7 ", foreground="black", background="light grey", command=lambda: apretar("7"), height=2, width=4)
    boton_7.grid(row=4, column=0)
    
    boton_8 = Button(gui, text=" 8 ", foreground="black", background="light grey", command=lambda: apretar("8"), height=2, width=4)
    boton_8.grid(row=4, column=1)
    
    boton_9 = Button(gui, text=" 9 ", foreground="black", background="light grey", command=lambda: apretar("9"), height=2, width=4)
    boton_9.grid(row=4, column=2)
    
    boton_multiplicar = Button(gui, text=" * ", foreground= "black", background="orange", command=lambda: apretar("*"), height=2, width=4) #Formato del boton multiplicar
    boton_multiplicar.grid(row=4, column=3) #Ubicación del boton de multiplicar
    
    #Fila 3
    boton_4 = Button(gui, text=" 4 ", foreground="black", background="light grey", command=lambda: apretar("4"), height=2, width=4)
    boton_4.grid(row=5, column=0)
    
    boton_5 = Button(gui, text=" 5 ", foreground="black", background="light grey", command=lambda: apretar("5"), height=2, width=4)
    boton_5.grid(row=5, column=1)
    
    boton_6 = Button(gui, text=" 6 ", foreground="black", background="light grey", command=lambda: apretar("6"), height=2, width=4)
    boton_6.grid(row=5, column=2)
    
    boton_menos = Button(gui, text=" - ", foreground= "black", background="orange", command=lambda: apretar("-"), height=2, width=4) #Formato del boton multiplicar
    boton_menos.grid(row=5, column=3) #Ubicación del boton de multiplicar
    
    #Fila 4
    boton_1 = Button(gui, text=" 1 ", foreground="black", background="light grey", command=lambda: apretar("1"), height=2, width=4)
    boton_1.grid(row=6, column=0)
    
    boton_2 = Button(gui, text=" 2 ", foreground="black", background="light grey", command=lambda: apretar("2"), height=2, width=4)
    boton_2.grid(row=6, column=1)
    
    boton_3 = Button(gui, text=" 3 ", foreground="black", background="light grey", command=lambda: apretar("3"), height=2, width=4)
    boton_3.grid(row=6, column=2)
    
    boton_mas = Button(gui, text=" + ", foreground="black", background="orange", command=lambda: apretar("+"), height=2, width=4) #Formato del boton mas
    boton_mas.grid(row=6, column=3)
    
    #Fila 5
    boton_0 = Button(gui, text=" 0 ", foreground="black", background="light grey", command=lambda: apretar("0"), height=2, width=8)
    boton_0.grid(row=7, column=0, columnspan=2)
    
    boton_punto = Button(gui, text=" . ", foreground="black", background="light grey", command=lambda: apretar("."), height=2, width=4)
    boton_punto.grid(row=7, column=2)
    
    boton_igual = Button(gui, text=" = ", foreground="black", background="orange", command=lambda: calcular("+"), height=2, width=4)
    boton_igual.grid(row=7, column=3)
        
#Código principal
gui = Tk() #Se crea la ventana principal (GUI)
gui.configure(background = "gray")
gui.title("Calculadora")
gui.geometry("180x260")

equacion = StringVar() #Dato que el usuario ve 

campo_txt = Entry(gui, textvariable=equacion) #Se crea el campo de texto donde se veran los resultados
campo_txt.grid(columnspan=3) #Se crea la cantidad de columnas deseadas


#Para que se ejecute
agregar_botones(gui)
gui.mainloop()
