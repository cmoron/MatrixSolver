/* file name  : GameSolverMock.java
 * authors    : Cyril Moron (cyril@moron.at)
 * created    : Sun 19 Apr 2015 10:47:09 AM CEST
 */
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;

/** 
 * Classe GameSolverMock: Bouchon représentant une implémentation de GameSolver.
 * @author Cyril Moron (cyril@moron.at)
 */
class GameSolverMock implements GameSolver {
    
    /** 
     * Implémentation de la méthode solve.
     * @param MatrixSolver le problème à résoudre.
     * @return la liste de solution
     */
    public List<List<Solution>> solve(MatrixGame game) {
        List<List<Solution>> solutions = new ArrayList<List<Solution>>();

        Matrix targetMatrix = game.getTargetMatrix();

        try{
            Thread.sleep(500);
        } catch (Exception e) {
        }

        for (Matrix matrixToSolve : game.getMatrixList()) {
            List<Solution> matrixSolutions = new ArrayList<Solution>();
            Solution solution = new Solution();
            solution.addStep(matrixToSolve);
            solution.addStep(targetMatrix);
            matrixSolutions.add(solution);
            solutions.add(matrixSolutions);
        }

        return solutions;
    }
}
