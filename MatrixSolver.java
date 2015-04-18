/* file name  : MatrixGame.java
 * authors    : Cyril Moron (cyril@moron.at)
 * created    : Fri 17 Apr 2015 10:09:34 PM CEST
 */
import java.util.List;

/** 
 * The Matrix Game class.
 * @author Cyril Moron (cyril@moron.at)
 */
class MatrixSolver {

    /** Le nom du fichier des matrices. */
    private static final String MATRIX_FILE_NAME = "matrix";

    /** Le nom du fichier de la matrice target. */
    private static final String TARGET_MATRIX_FILE_NAME = "target";

    /** 
     * Méthode main: lancement du programme.
     * @param args 
     */
    public static void main (String[] args) {
        List<Matrix> matrixList = MatrixReader.readFile(MATRIX_FILE_NAME);
        List<Matrix> targetMatrixList = MatrixReader.readFile(TARGET_MATRIX_FILE_NAME);
        Matrix targetMatrix = null;

        if (targetMatrixList.size() != 1) {
            System.err.println("The target matrix should be uniq.");
        } else {
            targetMatrix = targetMatrixList.get(0);
        }
        System.out.println("== Target Matrix ==");
        System.out.println(targetMatrix);
        System.out.println("===================");

        for (Matrix matrix : matrixList) {
            System.out.println(matrix);
            System.out.println("Equality ==> " + matrix.equals(targetMatrix));
        }
    }
}
