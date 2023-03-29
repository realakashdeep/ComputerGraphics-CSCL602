package transformation;

public class Matrix {
	static double[][] mul(double[][] a, double[][] b) {
		double[][] c = new double[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				c[i][j] = 0;
				for (int k = 0; k < b.length; k++)
					c[i][j] += a[i][k] * b[k][j];
			}
		}
		return c;
	}
	
	static void display(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + ", ");
			}
			System.out.println();
		}
	}
}
