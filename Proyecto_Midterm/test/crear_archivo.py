import random
import sys

ops = 30000

try:
    file_name = sys.argv[1] #Nombre del archivo se pasa como command line arg
except:
    print("No se definió el archivo como parámetro de la CLI")
    sys.exit(1) 

f = open(file_name, "w")
r = open(f"{file_name[:-4]}-resultado.txt", "w")
for i in range(ops):
    a = random.randint(-1000000, 1000001)
    b = random.randint(-1000000, 1000001)
    f.write(f"{a},{b},s\n")
    r.write(f"{a+b}\n")
for i in range(ops):
    a = random.randint(-1000000, 1000001)
    b = random.randint(-1000000, 1000001)
    f.write(f"{a},{b},r\n")
    r.write(f"{a-b}\n")
for i in range(ops):
    a = random.randint(-1000000, 1000001)
    b = random.randint(-1000000, 1000001)
    f.write(f"{a},{b},m\n")
    r.write(f"{a*b}\n")
f.close()
r.close()

    
