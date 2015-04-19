/* file name  : MatrixGame.java
 * authors    : Cyril Moron (cyril@moron.at)
 * created    : Fri 17 Apr 2015 10:09:34 PM CEST
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/** 
 * The Matrix Game class.
 * @author Cyril Moron (cyril@moron.at)
 */
class MatrixGame {

    /** Le nom du fichier des matrices. */
    private static final String MATRIX_FILE_NAME = "matrix";

    /** Le nom du fichier de la matrice target. */
    private static final String TARGET_MATRIX_FILE_NAME = "target";

    /** Le nom du fichier de sortie receuillant les résultats. */
    private static final String OUTPUT_FILE_NAME_SUFFIXE = "_results";

    /** Liste des matrices à résoudre. */
    private List<Matrix> matrixList;

    /** Matrice cible à retrouver. */
    private Matrix targetMatrix;

    /** 
     * Constructeur de MatrixSolver
     * @param solver le solver.
     * @param matrixFileName le nom de fichier où trouver la liste de matrice.
     * @param targetMatrixFileName le nom de fichier où trouver la matrice cible.
     */
    public MatrixGame(String matrixFileName, String targetMatrixFileName) {
        this.matrixList = MatrixReader.readFile(matrixFileName);
        List<Matrix> targetMatrixList = MatrixReader.readFile(targetMatrixFileName);
        if (targetMatrixList.size() != 1) {
            System.err.println("The target matrix should be uniq.");
        } else {
            this.targetMatrix = targetMatrixList.get(0);
        }
    }

    /** 
     * Getter de l'attribut targetMatrix.
     * @return la matrice cible.
     */
    public Matrix getTargetMatrix() {
        return this.targetMatrix;
    }

    /** 
     * Getter de l'attribut matrixList.
     * @return la liste des matrices à résoudre.
     */
    public List<Matrix> getMatrixList() {
        return this.matrixList;
    }

    /** 
     * Lance la résolution du problème avec le solver passé en paramètre
     * @param matrixGame le prolbème à résoudre.
     * @param solver le solver.
     */
    private static void launchSolvingProblem(MatrixGame matrixGame, GameSolver solver) {
        long startTime = System.currentTimeMillis();
        List<Solution> solutions = solver.solve(matrixGame);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File logFile = new File(timeLog + OUTPUT_FILE_NAME_SUFFIXE);
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(logFile));
            writer.write("==== Execution time: " + executionTime + "\n");
            for (Solution solution : solutions) {
                writer.write(solution.toString());
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    /** 
     * Méthode main: lancement du programme.
     * @param args 
     */
    public static void main (String[] args) {
        MatrixGame matrixGame = new MatrixGame(MATRIX_FILE_NAME, TARGET_MATRIX_FILE_NAME);

        // === Instantiate your solver HERE.

        GameSolver solver = new GameSolverMock();

        // =================================

        launchSolvingProblem(matrixGame, solver);
    }
}
