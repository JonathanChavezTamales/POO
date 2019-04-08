import sys

try:
    file_1 = sys.argv[1]
    file_2 = sys.argv[2]
except:
    print("No se pasaron los archivos como parametro de CLI correctos")
    sys.exit(1)
f = open("salida_comparacion.txt", "w")
with open(file_1, "r") as a, open(file_2, "r") as b:
    try:
        number_of_ops = 0
        correct = 0
        for x, y in zip(a, b):
            if(x == y):
                f.write("1\n")
                correct += 1
            else:
                f.write("0\n")
            number_of_ops += 1

    except:
        print("Error en IO de archivos")

print("Operaciones en total: ", number_of_ops)
print(f"Correctas: {correct}/{number_of_ops}")
print(f"Precisión: {correct*1.0/number_of_ops}")

f.close()

