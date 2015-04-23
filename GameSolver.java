/* file name  : GameSolver.java
 * authors    : Cyril Moron (cyril@moron.at)
 * created    : Sat 18 Apr 2015 08:58:27 PM CEST
 */
import java.util.List;

/** 
 * Interface GameSolver. 
 * @author Cyril Moron (cyril@moron.at)
 */
interface GameSolver {
    
    /** 
     * Méthode solve: résolution du problème de matrice.
     * @param game le problème à résoudre.
     * @return la liste des solutions.
     */
    public List<List<Solution>> solve(MatrixGame game);
}
