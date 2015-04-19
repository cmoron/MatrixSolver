/* file name  : Solution.java
 * authors    : Cyril Moron (cyril@moron.at)
 * created    : Sat 18 Apr 2015 08:59:51 PM CEST
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** 
 * Classe Solution: représente un ensemble de solutions au problème de la matrice.
 * @author Cyril Moron (cyril@moron.at)
 */
class Solution {
    
    /** La suite de matrix permettant d'arriver à la solution. */
    List<Matrix> steps;

    /** 
     * Constructeur par défaut de la classe Solution.
     */
    public Solution() {
        this.steps = new ArrayList<Matrix>();
    }

    /** 
     * Rajoute une étape à la liste de la solution.
     * @param solution 
     */
    public void addStep(Matrix step) {
        this.steps.add(step);
    }

    /** 
     * Vérifie si la solution est valide selon la règle du jeu.
     * @return true si la solution est valide.
     */
    public boolean isValid() {
        boolean result = true;

        Iterator<Matrix> iterator = this.steps.iterator();
        Matrix firstStep = iterator.next();

        while(iterator.hasNext() && result) {
            Matrix stepToTest = iterator.next();
            result = isStepValid(firstStep, stepToTest);
            firstStep = stepToTest;
        }

        return result;
    }

    /** 
     * Nombre de steps de la solution.
     * @return le nombre de steps.
     */
    public int steps() {
        return this.steps.size();
    }

    /** 
     * Vérifie si un step entre deux matrices est valide.
     * @param start La matrice de départ.
     * @param finish La matrice d'arrivée.
     * @return true si le step est valide.
     */
    private boolean isStepValid(Matrix start, Matrix finish) {
        boolean result = false;

        if (!start.equals(finish) 
                && start.getRows() == finish.getRows() 
                && start.getColumns() == finish.getColumns()) {
            // Test every combination on start matrix to retrieve the final matrix.
            for (int rowIndex = 0; rowIndex < start.getRows(); rowIndex++) {
                // TODO : test steps on copy of start and finish matrix.
            }
        }

        return result;
    }

    /** 
     * Méthode toString de la classe Solution.
     * @return une Solution sous forme de String.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("\n==== Solution (steps : " + this.steps() + ") \n");
        sb.append(this.steps);
        sb.append("\n==================\n");

        return sb.toString();
    }
}
