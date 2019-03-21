import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Dimension;

public class Panel extends JPanel {

    int[][] puntos;
    int n;

    public Panel() {
        super();
        this.setPreferredSize(new Dimension(500, 500));
        int radioInicial = 10, stepSize = 10;
        this.n = 28;
        this.puntos = generaPuntos(n, radioInicial, stepSize, false);
    }

    public void paint(Graphics g) {
        g.drawPolyline(puntos[0], puntos[1], this.n);
    }

    // Generador de puntos espiral
    public static int[][] generaPuntos(int n, int radioInicial, int stepSize, boolean clockWise) {
        // Matriz de 2xn donde se guardan las coordenadas. Ej: [0][5] es la sexta
        // coordenada de x
        int[][] puntos = new int[2][n];
        double angulo = 0;

        for (int i = 0; i < n; i++) {

            // Obtiene coordenadas relativas al centro (250,250)
            puntos[0][i] = (int) (Math.cos(angulo) * radioInicial) + 250;
            puntos[1][i] = (int) (Math.sin(angulo) * radioInicial) + 250;

            radioInicial += stepSize;
            // El angulo aumentara o decrementara en funcion de parametro 'clockWise'
            if (clockWise)
                angulo += Math.toRadians(45);
            else
                angulo -= Math.toRadians(45);
        }
        return puntos;
    }
}