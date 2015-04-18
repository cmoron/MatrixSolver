/* file name  : MatrixReader.java
 * authors    : Cyril Moron (cyril@moron.at)
 * created    : Sat 18 Apr 2015 10:37:36 PM CEST
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** 
 * Class MatrixReader qui permet de lire un fichier de problèmes.
 * @author Cyril Moron (cyril@moron.at)
 */
class MatrixReader {

    /** Pattern REGEXP d'une matrice. */
    private static final String MATRIX_PATTERN = "\\[(([1-9]\\s*,\\s*)*[1-9]\\s*:\\s*)*([1-9]\\s*,\\s*)*[1-9]\\s*\\]";

    /** The text matrix start char. */
    private static final String MATRIX_START_CHAR = "[";

    /** The text matrix end char. */
    private static final String MATRIX_END_CHAR = "]";

    /** The text matrix line separator. */
    private static final String MATRIX_LINE_SEPARATOR = ":";

    /** The text matrix value separator. */
    private static final String MATRIX_VALUE_SEPARATOR = ",";

    /** The empty string. */
    private static final String EMPTY_STRING = "";

    /** 
     * Lit le fichier passé en paramètre et récupère les matrices initiales.
     * @param fileName le nom du fichier
     * @return L'ensemble des matrices initiales.
     */
    public static List<Matrix> readFile(String fileName) {
        return convertStringMatrixToMatrix(getMatrixStringFromFile(fileName));
    }

    /** 
     * Récupère les matrices depuis le fichier sous forme de list de String.
     * @param fileName le nom du fichier.
     * @return La liste de matrices sous forme de String.
     */
    private static List<String> getMatrixStringFromFile(String fileName) {
        List<String> textMatrixList = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (null != line) {
                textMatrixList.add(line);
                line = br.readLine();
            }
        } catch (Exception exc) {
            System.err.println("Error while reader file: " + fileName);
            exc.printStackTrace();
        }

        return textMatrixList;
    }

    /** 
     * Convertit une liste de String en Matrix.
     * @param stringMatrix la liste de String.
     * @return la liste de Matrix.
     */
    private static List<Matrix> convertStringMatrixToMatrix(List<String> stringMatrix) {
        List<Matrix> initialMatrix = new ArrayList<Matrix>();
        Pattern pattern = Pattern.compile(MATRIX_PATTERN);

        for (String mat : stringMatrix) {
            System.out.println(mat);
            Matcher matcher = pattern.matcher(mat);
            if (matcher.matches()) {
                try {
                    mat = mat.replace(MATRIX_START_CHAR, EMPTY_STRING);
                    mat = mat.replace(MATRIX_END_CHAR, EMPTY_STRING);
                    String[] matrixLines = mat.split(MATRIX_LINE_SEPARATOR);
                    int nbLines = matrixLines.length;
                    int nbCols = getMatrixColNumber(matrixLines[0]);
                    int[][] matrixArray = new int[nbLines][nbCols];

                    int row = 0;
                    for (String matrixLine : matrixLines) {
                        String[] values = matrixLine.split(MATRIX_VALUE_SEPARATOR);
                        int col = 0;
                        nbCols = values.length;
                        for (String matrixColumn : values) {
                            matrixArray[row][col] = Integer.parseInt(matrixColumn);
                            col++;
                        }
                        row++;
                    }
                    initialMatrix.add(new Matrix(nbLines, nbCols, matrixArray));

                } catch (Exception exc) {
                    System.err.println("Cannot convert " + mat + " to matrix.\n");
                    exc.printStackTrace();
                }
            } else {
                System.err.println("Cannot convert " + mat + " to matrix.");
            }
        }
        return initialMatrix;
    }

    /** 
     * Get the number of columns from a String matrix line.
     * @param matrixLine the String matrix line.
     * @return The number of columns.
     */
    private static int getMatrixColNumber(String matrixLine) {
        return matrixLine.split(MATRIX_VALUE_SEPARATOR).length;
    }
}
