/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio_progra2;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Ordonez
 */
public class Laboratorio_progra2 {

    static String[][] matri = new String[13][13];
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int x = 0, y = 0;
        matri = matriz();
        print(x, y);
        movimiento();
    }

    public static String[][] matriz() {
        String[][] matri = {{" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
        {" ", "-", "-", "-", "X", "X", "X", "X", "X", "-", "-", "-", "|1"},
        {" ", "-", "-", "-", "-", "-", "O", "-", "-", "-", "-", "-", "|2"},
        {" ", "-", "-", "-", "-", "-", "O", "-", "-", "-", "-", "-", "|3"},
        {" ", "X", "-", "-", "-", "-", "O", "-", "-", "-", "-", "X", "|4"},
        {" ", "X", "-", "-", "-", "-", "O", "-", "-", "-", "-", "X", "|5"},
        {" ", "X", "O", "O", "O", "O", "K", "O", "O", "O", "O", "X", "|6"},
        {" ", "X", "-", "-", "-", "-", "O", "-", "-", "-", "-", "X", "|7"},
        {" ", "X", "-", "-", "-", "-", "O", "-", "-", "-", "-", "X", "|8"},
        {" ", "-", "-", "-", "-", "-", "O", "-", "-", "-", "-", "-", "|9"},
        {" ", "-", "-", "-", "-", "-", "O", "-", "-", "-", "-", "-", "|10"},
        {" ", "-", "-", "-", "X", "X", "X", "X", "X", "-", "-", "-", "|11"},
        {" ", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "   "}};
        return matri;
    }

    public static void print(int x, int y) {
        if (x == matri.length - 1 && y == matri.length - 1) {
            System.out.print(matri[x][y] + "\t");
        } else {
            if (y == matri.length - 1) {
                System.out.println(matri[x][y]);
                if (x == 11) {
                    System.out.println("        ---------------------------------------------------------------------------------------");
                }
                print(x + 1, 0);
            } else {
                System.out.print(matri[x][y] + "\t");
                print(x, y + 1);
            }
        }
    }
    static boolean j = true;

    public static void movimiento() {
        boolean juego = false;
        while (juego == false) {
            System.out.println("");
            if (j == false) {
                System.out.println("**turno O**");
            } else {
                System.out.println("**turno X**");
            }
            int ux = 0, uy = 0;
            System.out.println("Ingrese su movimiento de la siguiente manera:");
            System.out.println("Ingrese la fila de la pieza que desea mover:");
            try {
                ux = sc.nextInt();
            } catch (Exception e) {
                ux = -1;
                sc.next();
            }
            while (ux > 11 || ux < 1) {
                System.out.println("no existe la fila " );
                System.out.println("Ingrese la fila de la pieza que desea mover:");
                try {
                    ux = sc.nextInt();
                } catch (Exception e) {
                    ux = -1;
                    sc.next();
                }
            }
            System.out.println("Ingrese la columna de la pieza que desea mover:");
            try {
                uy = sc.nextInt();
            } catch (Exception e) {
                uy = -1;
                sc.next();
            }
            while (uy > 11 || uy < 1) {
                System.out.println("no existe la columna ");
                System.out.println("Ingrese la columna de la pieza que desea mover:");
                try {
                    uy = sc.nextInt();
                } catch (Exception e) {
                    uy = -1;
                    sc.next();
                }
            }
            if (j == true) {
                while (matri[ux][uy] != "X" || (matri[ux + 1][uy] != "-" && matri[ux - 1][uy] != "-" && matri[ux][uy + 1] != "-" && matri[ux][uy - 1] != "-")) {
                    System.out.println("no ha seleccionado una pieza valida");
                    System.out.println("Ingrese la fila de la pieza que desea mover:");
                    ux = sc.nextInt();
                    while (ux > 11 || ux < 1) {
                        System.out.println("no existe la fila ");
                        System.out.println("Ingrese la fila de la pieza que desea mover:");
                        try {
                            ux = sc.nextInt();
                        } catch (Exception e) {
                            ux = -1;
                            sc.next();
                        }
                    }
                    System.out.println("Ingrese la columna que desea mover:");
                    uy = sc.nextInt();
                    while (uy > 11 || uy < 1) {
                        System.out.println("no existe la columna ");
                        System.out.println("Ingrese la columna de la pieza que desea mover:");
                        try {
                            uy = sc.nextInt();
                        } catch (Exception e) {
                            uy = -1;
                            sc.next();
                        }
                    }
                }
            } else {
                while (matri[ux][uy] != "O" && matri[ux][uy] != "K") {
                    System.out.println("no ha seleccionado uan pieza valida");
                    System.out.println(matri[ux][uy]);
                    System.out.println("Ingrese la fila de la pieza que desea mover:");
                    ux = sc.nextInt();
                    while (ux > 11 || ux < 1) {
                        System.out.println("no existe la fila ");
                        System.out.println("Ingrese la fila de la pieza que desea mover:");
                        try {
                            ux = sc.nextInt();
                        } catch (Exception e) {
                            ux = -1;
                            sc.next();
                        }
                    }
                    System.out.println("Ingrese la columna que desea mover:");
                    try {
                        uy = sc.nextInt();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Numero no valido");
                        uy = -1;
                        sc.next();
                    }
                    while (uy > 11 || uy < 1) {
                        System.out.println("no existe la columna ");
                        System.out.println("Ingrese la columna de la pieza que desea mover:");
                        try {
                            uy = sc.nextInt();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Numero no valido");
                            uy = -1;
                            sc.next();
                        }
                    }
                }

            }
            int px;
            System.out.println("Ingrese la fila de la casilla a la que desea mover");
            try {
                px = sc.nextInt();
            } catch (Exception e) {
                px = -1;
                sc.next();
            }
            while (px > 11 || px < 1) {
                System.out.println("no existe la fila ");
                System.out.println("Ingrese la fila de la casilla que desea mover:");
                try {
                    px = sc.nextInt();
                } catch (Exception e) {
                    px = -1;
                    sc.next();
                }
            }
            int py;
            System.out.println("Ingrese la columna de la casilla a la que desea mover");
            try {
                py = sc.nextInt();
            } catch (Exception e) {
                py = -1;
                sc.next();
            }
            while (py > 11 || py < 1) {
                System.out.println("no existe la columna ");
                System.out.println("Ingrese la columna de la casilla que desea mover:");
                try {
                    py = sc.nextInt();
                } catch (Exception e) {
                    py = -1;
                    sc.next();
                }
            }
            while ((matri[px][py] != "-" && (px == ux || py == uy)) || (piezasintermedias(ux, uy, px, py) != true)) {
                System.out.println("su movimiento no se puede hacer");
                System.out.println("Ingrese la fila de la casilla que desea mover:");
                try {
                    px = sc.nextInt();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Numero no valido");
                    px = -1;
                    sc.next();
                }
                while (px > 11 || px < 1) {
                    System.out.println("no existe la fila " + px);
                    System.out.println("Ingrese la fila de la casilla que desea mover:");
                    try {
                        px = sc.nextInt();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Numero no valido");
                        px = -1;
                        sc.next();
                    }
                }
                System.out.println("Ingrese la columna que desea mover:");
                try {
                    py = sc.nextInt();
                } catch (Exception e) {
                    py = -1;
                    sc.next();
                }
                while (py > 11 || py < 1) {
                    System.out.println("no existe la columna ");
                    System.out.println("Ingrese la columna de la casilla que desea mover:");
                    try {
                        py = sc.nextInt();
                    } catch (Exception e) {
                        py = -1;
                        sc.next();
                    }
                }
            }
            matri[px][py] = matri[ux][uy];
            matri[ux][uy] = "-";
            boolean q = false;
            if (matri[px][py] == "K" && (px == 1 || px == 11 || py == 1 || py == 11)) {
                juego = true;
                q = true;
            } else {
                if ((j == true && (matri[px + 1][py] == "O" || matri[px + 1][py] == "K") && (matri[px - 1][py] == "O" || matri[px - 1][py] == "K")) || (j == false && matri[px + 1][py] == "X" && matri[px - 1][py] == "X")
                        || (j == true && (matri[px][py + 1] == "O" || matri[px][py + 1] == "K") && (matri[px][py - 1] == "O" || matri[px][py - 1] == "K")) || (j == false && matri[px][py + 1] == "X" && matri[px][py - 1] == "X")) {
                    matri[px][py] = "-";
                }
            }
            if (px + 1 < matri.length) {
                if ((j == true && (matri[px + 1][py] == "O" || matri[px + 1][py] == "K") && matri[px + 2][py] == "X") || (j == false && matri[px + 1][py] == "X" && (matri[px + 2][py] == "O" || matri[px + 2][py] == "K"))) {
                    matri[px + 1][py] = "-";
                }
            }
            if (py + 1 < matri.length) {
                if ((j == true && (matri[px][py + 1] == "O" || matri[px][py + 1] == "K") && matri[px][py + 2] == "X") || (j == false && matri[px][py + 1] == "X" && (matri[px][py + 2] == "O" || matri[px][py + 2] == "K"))) {
                    matri[px][py + 1] = "-";
                }
            }
            if (px - 1 > 0) {
                if ((j == true && (matri[px - 1][py] == "O" || matri[px - 1][py] == "K") && matri[px - 2][py] == "X") || (j == false && matri[px - 1][py] == "X" && (matri[px - 2][py] == "O" || matri[px - 2][py] == "K"))) {
                    matri[px - 1][py] = "-";
                }
            }
            if (py - 1 > 0) {
                if ((j == true && (matri[px][py - 1] == "O" || matri[px][py - 1] == "K") && matri[px][py - 2] == "X") || (j == false && matri[px][py - 1] == "X" && (matri[px][py - 2] == "O" || matri[px][py - 2] == "K"))) {
                    matri[px][py - 1] = "-";
                }
            }
            if (px + 1 < matri.length && px + 2 < matri.length) {
                if ((j == true && (matri[px + 1][py] == "O" || matri[px + 1][py] == "K") && (matri[px + 2][py] == "O" || matri[px + 2][py] == "K") && matri[px + 3][py] == "X") || (j == false && matri[px + 1][py] == "X" && matri[px + 2][py] == "X" && (matri[px + 3][py] == "O" || matri[px + 3][py] == "K"))) {
                    matri[px + 1][py] = "-";
                    matri[px + 2][py] = "-";
                }
            }
            if (py + 1 < matri.length && py + 2 < matri.length) {
                if ((j == true && (matri[px][py + 1] == "O" || matri[px][py + 1] == "K") && (matri[px][py + 2] == "O" || matri[px][py + 2] == "K") && matri[px][py + 3] == "X") || (j == false && matri[px][py + 1] == "X" && matri[px][py + 2] == "X" && (matri[px][py + 3] == "O" || matri[px][py + 3] == "K"))) {
                    matri[px][py + 1] = "-";
                    matri[px][py + 2] = "-";
                }
            }
            if (px - 1 > 0 && px - 2 > 0) {
                if ((j == true && (matri[px - 1][py] == "O" || matri[px - 1][py] == "K") && (matri[px - 2][py] == "O" || matri[px - 2][py] == "K") && matri[px - 3][py] == "X") || (j == false && matri[px - 1][py] == "X" && matri[px - 2][py] == "X" && (matri[px - 3][py] == "O" || matri[px - 3][py] == "K"))) {
                    matri[px - 1][py] = "-";
                    matri[px - 2][py] = "-";
                }
            }
            if (py - 1 > 0 && py - 2 > 0) {
                if ((j == true && (matri[px][py - 1] == "O" || matri[px][py - 1] == "K") && (matri[px][py - 2] == "O" || matri[px][py - 2] == "K") && matri[px][py - 3] == "X") || (j == false && matri[px][py - 1] == "X" && matri[px][py - 2] == "X" && (matri[px][py - 3] == "O" || matri[px][py - 3] == "K"))) {
                    matri[px][py - 1] = "-";
                    matri[px][py - 2] = "-";
                }
            }
            if (px + 1 < matri.length && px + 2 < matri.length && px + 3 < matri.length) {
                if ((j == true && (matri[px + 1][py] == "O" || matri[px + 1][py] == "K") && (matri[px + 2][py] == "O" || matri[px + 2][py] == "K") && (matri[px + 3][py] == "O" || matri[px + 3][py] == "K") && matri[px + 4][py] == "X") || (j == false && matri[px + 1][py] == "X" && matri[px + 2][py] == "X" && matri[px + 3][py] == "X" && (matri[px + 4][py] == "O" || matri[px + 4][py] == "K"))) {
                    matri[px + 1][py] = "-";
                    matri[px + 2][py] = "-";
                    matri[px + 3][py] = "-";
                }
            }
            if (py + 1 < matri.length && py + 2 < matri.length && py + 3 < matri.length) {
                if ((j == true && (matri[px][py + 1] == "O" || matri[px][py + 1] == "K") && (matri[px][py + 2] == "O" || matri[px][py + 2] == "K") && (matri[px][py + 3] == "O" || matri[px][py + 3] == "K") && matri[px][py + 4] == "X") || (j == false && matri[px][py + 1] == "X" && matri[px + 2][py] == "X" && matri[px][py + 3] == "X" && (matri[px][py + 4] == "O" || matri[px][py + 4] == "K"))) {
                    matri[px][py + 1] = "-";
                    matri[px][py + 2] = "-";
                    matri[px][py + 3] = "-";
                }
            }
            if (px - 1 > 0 && px - 2 > 0 && px - 3 > 0) {
                if ((j == true && (matri[px - 1][py] == "O" || matri[px - 1][py] == "K") && (matri[px - 2][py] == "O" || matri[px - 2][py] == "K") && (matri[px - 3][py] == "O" || matri[px - 3][py] == "K") && matri[px - 4][py] == "X") || (j == false && matri[px - 1][py] == "X" && matri[px - 2][py] == "X" && matri[px - 3][py] == "X" && (matri[px - 4][py] == "O" || matri[px - 4][py] == "K"))) {
                    matri[px - 1][py] = "-";
                    matri[px - 2][py] = "-";
                    matri[px - 3][py] = "-";
                }
            }
            if (py - 1 > 0 && py - 2 > 0 && py - 3 > 0) {
                if ((j == true && (matri[px][py - 1] == "O" || matri[px][py - 1] == "K") && (matri[px][py - 2] == "O" || matri[px][py - 2] == "K") && (matri[px][py - 3] == "O" || matri[px][py - 3] == "K") && matri[px][py - 4] == "X") || (j == false && matri[px][py - 1] == "X" && matri[px][py - 2] == "X" && matri[px][py - 3] == "X" && (matri[px][py - 4] == "O" || matri[px][py - 4] == "K"))) {
                    matri[px][py - 1] = "-";
                    matri[px][py - 2] = "-";
                    matri[px][py - 3] = "-";
                }
            }
            print(0, 0);
            if (q == true) {
                juego = true;
                System.out.println("Han ganado los defensores O");
            } else {
                boolean g = true;
                for (int i = 0; i < 10; i++) {
                    for (int k = 0; k < 10; k++) {
                        if (matri[i][k] == "K") {
                            g = false;
                            juego = false;
                            break;
                        } else {
                            juego = true;
                        }
                    }
                    if (g == false) {
                        break;
                    }
                }
                if (juego == true) {
                    System.out.println("Han ganado los Atacantes X");
                }
            }
            if (j == true) {
                j = false;
            } else {
                j = true;
            }
        }
    }
    static boolean u = false;

    public static boolean piezasintermedias(int ux, int uy, int px, int py) {
        boolean o = true;
        int a = px - ux;
        int b = py - uy, c = a, cx, cy;
        if (a == 0) {
            c = b;
            cx = 0;
        } else {
            if (a < 0) {
                cx = -1;
            } else {
                cx = 1;
            }
        }
        if (b == 0) {
            cy = 0;
        } else {
            if (b < 0) {
                cy = -1;
            } else {
                cy = 1;
            }
        }
        for (int i = 0; i < Math.abs(c) - 1; i++) {
            if (matri[ux + cx][uy + cy] != "-") {
                o = false;
            } else {
                if (cx < 0) {
                    cx--;
                } else {
                    if (cx == 0) {

                    } else {
                        cx++;
                    }
                }
                if (cy < 0) {
                    cy--;
                } else {
                    if (cy == 0) {

                    } else {
                        cy++;
                    }
                }
            }
        }
        return o;
    }
}
