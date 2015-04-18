/* file name  : Matrix.java
 * authors    : Cyril Moron (cyril@moron.at)
 * created    : Sat 18 Apr 2015 07:01:02 PM CEST
 */

/** 
 * Classe Matrix: représente une matrice col*row.
 * @author Cyril Moron (cyril@moron.at)
 */
class Matrix {

    /** Attribut columns: nombre de colonne de la matrice. */
    int columns;

    /** Attribut rows: nombre de lignes de la matrice. */
    int rows;

    /** Attribut matrix: valeurs de la matrice. */
    int[][] matrix;

    /** 
     * Constructeur de la classe Matrix.
     * @param columns Nombre de colonnes.
     * @param rows Nombre de lignes.
     */
    public Matrix(int rows, int columns, int[][] matrix) {
        this.columns = columns;
        this.rows = rows;
        this.matrix = new int[rows][columns];

        try {
            for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
                for (int colIndex = 0; colIndex < columns; colIndex++) {
                    this.matrix[rowIndex][colIndex] = matrix[rowIndex][colIndex];
                }
            }
        } catch (ArrayIndexOutOfBoundsException arrayIndexException) {
            System.err.println("Cannot initialize matrix: constructor argument has wrong size.");
            this.matrix = new int[rows][columns];
        }
    }

    /** 
     * Décale une ligne sur la gauche.
     * @param row le numéro de ligne.
     */
    public void leftRow(int row) {
        if (row >= 0 && row < rows) {
            int firstColValue = this.matrix[row][0];
            for (int colIndex = 0; colIndex < columns - 1; colIndex++) {
                this.matrix[row][colIndex] = this.matrix[row][colIndex+1];
            }
            this.matrix[row][columns - 1] = firstColValue;
        } else {
            System.err.println("Cannot move row. No row " + row + " in this matrix.");
        }
    }

    /** 
     * Décale une ligne sur la droite.
     * @param row le numéro de ligne.
     */
    public void rightRow(int row) {
        if (row >= 0 && row < rows) {
            int lastColValue = this.matrix[row][columns - 1];
            for (int colIndex = columns - 1; colIndex > 0; colIndex--) {
                this.matrix[row][colIndex] = this.matrix[row][colIndex - 1];
            }
            this.matrix[row][0] = lastColValue;
        } else {
            System.err.println("Cannot move row. No row " + row + " in this matrix.");
        }
    }

    /** 
     * Décale une colonne vers le bas.
     * @param col le numéro de la colonne.
     */
    public void downCol(int col) {
        if (col >= 0 && col < columns) {
            int lastRowValue = this.matrix[rows - 1][col];
            for (int rowIndex = rows - 1; rowIndex > 0; rowIndex--) {
                this.matrix[rowIndex][col] = this.matrix[rowIndex - 1][col];
            }
            this.matrix[0][col] = lastRowValue;
        } else {
            System.err.println("Cannot move column. No column " + col + " in this matrix.");
        }
    }

    /** 
     * Décale une colonne vers le haut.
     * @param col le numéro de la colonne.
     */
    public void upCol(int col) {
        if (col >= 0 && col < columns) {
            int firstRowvalue = this.matrix[0][col];
            for (int rowIndex = 0; rowIndex < rows -1; rowIndex++) {
                this.matrix[rowIndex][col] = this.matrix[rowIndex + 1][col];
            }
            this.matrix[rows - 1][col] = firstRowvalue;
        } else {
            System.err.println("Cannot move column. No column " + col + " in this matrix.");
        }
    }

    /** 
     * Récupère la valeur à la position rowIndex, colIndex.
     * @param rowIndex 
     * @param colIndex 
     * @return la valeur.
     */
    public int getValueAt(int rowIndex, int colIndex) {
        int value = -1;
        if (this.matrix.length > rowIndex && this.matrix[rowIndex].length > colIndex) {
            value = this.matrix[rowIndex][colIndex];
        }
        return value;
    }

    /** 
     * Getter de l'attribut rows.
     * @return la valeur de rows.
     */
    public int getRows() {
        return this.rows;
    }

    /** 
     * Getter de l'attribut columns.
     * @return la valeur de columns.
     */
    public int getColumns() {
        return this.columns;
    }

    /** 
     * Méthode equals: vérifie l'égalité de deux matrices.
     * @param matrix la matrice à comparer.
     * @return true si les deux matrices sont égales.
     */
    public boolean equals(Matrix matrix) {
        boolean result = true;

        if (null != matrix && this.rows == matrix.getRows() && this.columns == matrix.getColumns()) {
            boolean found = false;
            for (int rowIndex = 0; rowIndex < this.rows && !found; rowIndex++) {
                for (int colIndex = 0; colIndex < this.columns && !found; colIndex++) {
                    if (getValueAt(rowIndex, colIndex) != matrix.getValueAt(rowIndex, colIndex)) {
                        result = false;
                        found = true;
                    }
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    /** 
     * Transforme la matrice en String pour l'affichage.
     * @return la matrice sous forme de String.
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("\n");
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            sb.append("| ");
            for (int colIndex = 0; colIndex < columns; colIndex++) {
                sb.append(this.matrix[rowIndex][colIndex] + " ");
            }
            sb.append("|\n");
        } 

        return sb.toString();
    }
}
