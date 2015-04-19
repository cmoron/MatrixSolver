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
    public List<Solution> solve(MatrixGame game) {
        List<Solution> solutions = new ArrayList<Solution>();

        Matrix targetMatrix = game.getTargetMatrix();

        try{
            Thread.sleep(500);
        } catch (Exception e) {
        }
        for (Matrix matrixToSolve : game.getMatrixList()) {
            Solution solution = new Solution();
            solution.addStep(matrixToSolve);
            solution.addStep(targetMatrix);
            solutions.add(solution);
        }

        return solutions;
    }
}
