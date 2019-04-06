/*
    METODOS DE LA CLASE NUMEROTE
    PROYECTO DE MEDIO TERMINO POO
    Metodos Numerote:
    Jonathan de Jesus Chavez Tabares
    GUI:
    Jose Miguel
*/

//FIXME: Multiplicar

public class Numerote {

    byte[] numerote;
    boolean signo;

    public Numerote() {
        numerote = new byte[] { 0 };
        signo = true;
    }

    // Este metodo no valida vacios ni otros caracteres
    public Numerote(String n) {

        // Crea array con puros ceros
        if (n.charAt(0) == '-') {
            numerote = new byte[n.length() - 1];

            signo = false;
            for (int i = 1; i < n.length(); i++) {
                this.numerote[i - 1] = (byte) (n.charAt(n.length() - i) - '0');
            }
        } else {
            numerote = new byte[n.length()];

            signo = true;
            for (int i = 0; i < n.length(); i++) {
                this.numerote[i] = (byte) (n.charAt(n.length() - 1 - i) - '0');
            }

        }

    }

    /*
     * CASOS: A+B = A.SUMA(B) signo + (-A)+B = B.RESTA(A) A+(-B) = A.RESTA(B)
     * (-A)+(-B) = A.SUMA(B) signo -
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
            byte res = (byte) (a.numerote[i] + b.numerote[i] + r.numerote[i]);
            r.numerote[i] = (byte) (res % 10);
            if (res >= 10)
                r.numerote[i + 1]++;
            i++;
        }
        while (i < maxNumerote.numerote.length) {
            r.numerote[i] += maxNumerote.numerote[i];
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
            r.numerote[i] += maxNumerote.numerote[i];
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
                if (a.numerote[i] >= b.numerote[i]) {
                    return true;
                } else {
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

    public static void main(String[] args) {
        Numerote a = new Numerote("5001");
        Numerote b = new Numerote("499");
        Numerote suma = (a.suma(b).suma(new Numerote("1"))).suma(a).trimZeros();
        System.out.println(suma.toString());
        Numerote c = new Numerote("4999");
        System.out.println(c.esMayorOIgual(b) ? "mayor" : "menor");
        System.out.println(new Numerote("-440").resta(new Numerote("-59")));
        System.out.println(new Numerote("-440").resta(new Numerote("59")));
        System.out.println(new Numerote("440").resta(new Numerote("-59")));
        System.out.println(new Numerote("440").resta(new Numerote("59")));
        // Bugs
        // FIXME: multiplicacion de numeros grandes, suma y resta de 0s
        System.out.println("BUGS");
        System.out.println(new Numerote("0").resta(new Numerote("0")));
        System.out.println(new Numerote("0").suma(new Numerote("0")));

        System.out.println(new Numerote("987654321").multiplica(new Numerote("123456789")));

    }
}
