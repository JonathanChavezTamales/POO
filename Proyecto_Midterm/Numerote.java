
/*
PROYECTO DE MEDIO TERMINO POO
Metodos Numerote:
Jonathan de Jesus Chavez Tabares A01636160
GUI:
Jose Miguel Perez Gonzalez A01636355
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Numerote {

    byte[] numerote;
    boolean signo;

    public Numerote() {
        numerote = new byte[] { 0 };
        signo = true;
    }

    public Numerote(String a) {
        this.numerote = convertirString(a);
    }

    public byte[] convertirString(String a) {
        String sNumero = "";
        byte[] cadenaByte;
        if (a.charAt(0) == '-') {
            this.signo = false;
            a = a.substring(1);
        } else {
            this.signo = true;
        }
        for (int i = 0; i < a.length(); i++) {
            sNumero += a.charAt((a.length() - 1) - i);
        }
        cadenaByte = new byte[sNumero.length()];
        for (int i = 0; i < sNumero.length(); i++) {
            cadenaByte[i] = Byte.parseByte(sNumero.substring(i, i + 1));
        }
        return cadenaByte;
    }

    /*
     * 
     * CASOS: A+B = A.SUMA(B) signo + (-A)+B = B.RESTA(A) A+(-B) = A.RESTA(B)
     * (-A)+(-B) = A.SUMA(B) signo -
     * 
     * 
     */

    public Numerote suma(Numerote b) {
        if (this.toString().equals("0") && b.toString().equals("0")) {
            return new Numerote("0");
        }

        Numerote a = this.trimZeros();
        b = b.trimZeros();
        Numerote r = new Numerote();

        // Se obtiene el length mayor de los dos numeros y el menor

        Numerote maxNumerote, minNumerote;
        if (a.esMayorOIgual(b)) {
            maxNumerote = a;
            minNumerote = b;
        } else {
            maxNumerote = b;
            minNumerote = a;
        }

        // Se inicializa el arreglo con una casilla extra por si hay carry out.
        r.numerote = new byte[maxNumerote.numerote.length + 1];

        /*
         * 
         * CASOS: A+B = A.SUMA(B) signo + (-A)+B = B.RESTA(A) A+(-B) = A.RESTA(B)
         * (-A)+(-B) = A.SUMA(B) signo -
         * 
         */

        if (!a.signo && !b.signo) {
            r.signo = false;
        } else if (!a.signo && b.signo) {
            a.signo = true;
            return b.resta(a);
        } else if (a.signo && !b.signo) {
            b.signo = true;
            return a.resta(b);
        }

        int i = 0;
        while (i < minNumerote.numerote.length) {
            byte res = (byte) (maxNumerote.numerote[i] + minNumerote.numerote[i] + r.numerote[i]);
            r.numerote[i] = (byte) (res % 10);
            if (res >= 10)
                r.numerote[i + 1]++;
            i++;
        }
        while (i < maxNumerote.numerote.length) {
            byte res = (byte) (maxNumerote.numerote[i] + r.numerote[i]);
            r.numerote[i] = (byte) (res % 10);
            if (res >= 10)
                r.numerote[i + 1]++;
            i++;
        }
        if (r.trimZeros().toString().equals("")) {
            return new Numerote("0");
        }
        return r.trimZeros();
    }

    public Numerote resta(Numerote b) {

        if (this.toString().equals("0") && b.toString().equals("0")) {
            return new Numerote("0");
        }

        /*
         * A-B = A-B done (-A)-B = -(A+B) done A-(-B) = A+B (-A)-(-B) = -A+B = B-A done
         */

        Numerote a = this.trimZeros();
        b = b.trimZeros();

        Numerote r = new Numerote();

        if (!a.signo && !b.signo) {
            b.signo = true;
            a.signo = true;
            r = b.resta(a);
            if (r.trimZeros().toString().equals("")) {
                return new Numerote("0");
            }
            return r.trimZeros();
        } else if (!a.signo && b.signo) {
            b.signo = true;
            a.signo = true;
            r = a.suma(b);
            r.signo = false;
            if (r.trimZeros().toString().equals("")) {
                return new Numerote("0");
            }
            return r.trimZeros();
        } else if (a.signo && !b.signo) {
            b.signo = true;
            a.signo = true;
            r = a.suma(b);
            r.signo = true;
            if (r.trimZeros().toString().equals("")) {
                return new Numerote("0");
            }
            return r.trimZeros();
        }

        Numerote maxNumerote, minNumerote;
        if (a.esMayorOIgual(b)) {
            maxNumerote = a;
            minNumerote = b;
            r.signo = true;
        } else {
            maxNumerote = b;
            minNumerote = a;
            r.signo = false;
        }

        // Se inicializa el arreglo con una casilla extra por si hay carry out.
        r.numerote = new byte[maxNumerote.numerote.length + 1];

        int i = 0;
        while (i < minNumerote.numerote.length) {
            byte res = (byte) (maxNumerote.numerote[i] - minNumerote.numerote[i] + r.numerote[i]);
            r.numerote[i] = (byte) ((10 + res) % 10);
            if (res < 0)
                r.numerote[i + 1]--;
            i++;
        }
        // Cuando hay ceros se pasa el numero directo.
        while (i < maxNumerote.numerote.length) {
            byte res = (byte) (maxNumerote.numerote[i] + r.numerote[i]);
            r.numerote[i] = (byte) ((10 + res) % 10);
            if (res < 0)
                r.numerote[i + 1]--;
            i++;
        }

        if (r.trimZeros().toString().equals("")) {
            return new Numerote("0");
        }
        return r.trimZeros();
    }

    public Numerote trimZeros() {
        int trailingZeros = 0;
        for (int i = this.numerote.length - 1; i >= 0; i--) {
            if (this.numerote[i] == 0) {
                trailingZeros++;
            } else {
                break;
            }
        }
        Numerote r = new Numerote();
        r.signo = this.signo;
        r.numerote = new byte[this.numerote.length - trailingZeros];
        for (int i = this.numerote.length - trailingZeros - 1; i >= 0; i--) {
            r.numerote[i] = this.numerote[i];
        }
        return r;
    }

    public boolean esMayorOIgual(Numerote b) {
        Numerote a = this.trimZeros();
        b = b.trimZeros();

        if (a.numerote.length > b.numerote.length) {
            return true;
        } else if (a.numerote.length < b.numerote.length) {
            return false;
        } else if (a.numerote.length == b.numerote.length) {
            for (int i = a.numerote.length - 1; i >= 0; i--) {
                if (a.numerote[i] > b.numerote[i]) {
                    return true;
                } else if (a.numerote[i] < b.numerote[i]) {
                    return false;
                }
            }
            // Cuando son iguales
            return false;
        }

        return false;
    }

    public Numerote multiplica(Numerote b) {

        if (this.toString().equals("0") || b.toString().equals("0")) {
            return new Numerote();
        }

        Numerote r = new Numerote();

        Numerote a = this.trimZeros();
        b = b.trimZeros();

        r.numerote = new byte[a.numerote.length + b.numerote.length];
        String multiplicador = "";
        Numerote p = new Numerote();
        int res;

        for (int i = 0; i < a.numerote.length; i++) {
            p.numerote = new byte[a.numerote.length + b.numerote.length];

            for (int j = 0; j < b.numerote.length; j++) {
                res = ((a.numerote[i] * b.numerote[j] + p.numerote[j]));
                p.numerote[j] = (byte) ((a.numerote[i] * b.numerote[j] + p.numerote[j]) % 10);
                p.numerote[j + 1] = (byte) (res / 10);
            }
            Numerote nlocal = new Numerote(p.toString() + multiplicador);
            r = r.suma(nlocal);
            multiplicador += "0";
        }

        if (a.signo ^ b.signo)
            r.signo = false;
        else
            r.signo = true;

        return r.trimZeros();
    }

    public String toString() {
        String str = "";

        if (this.signo == false) {
            str += "-";
        }

        for (int i = 0; i < this.numerote.length; i++) {
            // Los inserta al reves
            str += this.numerote[this.numerote.length - i - 1];
        }

        return str;
    }

    public void ejecutaArchivo(String entrada, String salida) throws IOException {
        String linea, lineaArch[];
        Numerote numTemp;
        BufferedReader bR = new BufferedReader(new FileReader(entrada));
        PrintWriter fR = new PrintWriter(new FileWriter(salida));

        while ((linea = bR.readLine()) != null) {
            lineaArch = linea.split(",");
            if (lineaArch.length != 3) {
                throw new RuntimeException("Mas de 3 argumentos");
            }
            this.numerote = this.convertirString(lineaArch[0]);
            numTemp = new Numerote(lineaArch[1]);
            if (lineaArch[2].equals("s")) {
                numTemp = this.suma(numTemp);
            } else if (lineaArch[2].equals("r")) {
                numTemp = this.resta(numTemp);
            } else if (lineaArch[2].equals("m")) {
                numTemp = this.multiplica(numTemp);
            } else {
                throw new RuntimeException("Error en el contenido del Archivo");
            }
            fR.println(numTemp);
        }
        bR.close();
        fR.close();
    }

    public static void main(String[] args) {
    }
}