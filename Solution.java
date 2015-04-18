/* file name  : Solution.java
 * authors    : Cyril Moron (cyril@moron.at)
 * created    : Sat 18 Apr 2015 08:59:51 PM CEST
 */
import java.util.List;
import java.util.ArrayList;

/** 
 * Classe Solution: représente une solution au problème de la matrice.
 * @author Cyril Moron (cyril@moron.at)
 */
class Solution {
    
    /** La suite de matrix permettant d'arriver à la solution. */
    List<Matrix> solutions;

    /** 
     * Constructeur par défaut de la classe Solution.
     */
    public Solution() {
        this.solutions = new ArrayList<Matrix>();
    }

    /** 
     * Rajoute une étape à la liste de la solution.
     * @param solution 
     */
    public void addSolution(Matrix etape) {
        this.solutions.add(etape);
    }

}
