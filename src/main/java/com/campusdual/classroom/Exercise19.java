package com.campusdual.classroom;

public class Exercise19 {

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {

        int rows = intArrayTri[0].length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.delete(sb.length()-1, sb.length());
        return sb.toString();

    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length-1; i++){
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            sb.append("   ");
        }
        sb.append(getUnidimensionalString(intArrayTri[intArrayTri.length-1][row]));

        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    // recibe un array tridimensional de tipo int y devolverá un array bidimensional de tipo int
    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int rows = intArrayTri[0].length;
        int columns = intArrayTri[0][0].length;

        int [][] arrayTridimensional = new int[rows][columns];

        for (int i = 0; i < intArrayTri.length; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    arrayTridimensional[j][k] += intArrayTri[i][j][k];
                }
            }
        }
        return arrayTridimensional;

    }

    // recibe un array bidimensional e invoca a stringFlatMatrixRow(), pasándole dicho array bidimensional y un entero correspondiente a cada uno de los elementos de su primera dimensión
    public static String getBidimensionalString(int[][] intArrayBi) {
        StringBuilder arrayBidimensional = new StringBuilder();

        for (int i = 0; i < intArrayBi.length; i++) {
            arrayBidimensional.append(stringFlatMatrixRow(intArrayBi, i)); //para que las filas sean un string

            if (i < intArrayBi.length -1) {
                arrayBidimensional.append("\n");
            }
        }
        return arrayBidimensional.toString();
    }


    // recorrer el array unidimensional de tipo entero y devolver un String único compuesto por los elementos del array de tipo int
    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder arrayUnidimensional = new StringBuilder();


        for (int i = 0; i < uniArray.length; i++) {
            arrayUnidimensional.append(uniArray[i]);

            if (i < uniArray.length - 1) {
                arrayUnidimensional.append(" ");
            }
        }
        return arrayUnidimensional.toString();
    }

    // Array unidimensional de tipo entero e inicializarlo
    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int [] uniArray = new int[columns];

        for (int i = 0; i < columns; i++) {
            uniArray[i] = i + 1;
        }
        return uniArray;

    }

    // Array bidimensional de tipo entero e inicializarlo
    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int [][] intArrayBi = new int[rows][columns];

        int contador = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                intArrayBi[i][j] = contador++;
            }
        }
        return intArrayBi;
    }

    // Array tridimensional de tipo entero e inicializarlo
    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int [][][] intArrayTri = new int[depth][rows][columns];

        int contador = 1;

        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    intArrayTri[i][j][k] = contador++;
                }
            }
        }
        return intArrayTri;
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(5, 5);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(3, 3, 3);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
