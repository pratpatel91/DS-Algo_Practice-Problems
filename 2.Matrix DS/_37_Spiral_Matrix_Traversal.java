
public class _37_Spiral_Matrix_Traversal
{
	//Variations: Number of turns, create spiral matrix, finding the sum by direction
	public static void main(String[] args)
	{
		int[][] matrix = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 }, 
				{ 9, 10, 11, 12 }, 
				{ 13, 14, 15, 16 },
				{17,18,19, 20},
				{21,22,23,24},
		};

		spiralMatrixPrinting(matrix);
	}

	public static void spiralMatrixPrinting(int matrix[][])
	{
		// generic way to get the size of the matrix
		// bottom = rows = matrix.length
		// right = columns = matrix[0].length because a row is a 1d array
		// we are subtracting -1 from right & bottom so that they reflect indicies
		int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
		System.out.print("Matrix Rows: " + bottom);
		System.out.print("\nMatrix Columns: " + right);
		
		System.out.print("\n");
		// counts the number of directions traveled while iterating the matrix
		int dir = 0;
		int numTurns=0;
		

		// logic for spiraling the matrix
		// while loop is used (for loop is more complex due to updating multiple
		// variables)
		while (left <= right && top <= bottom)
		{
			// 1st, we travel from left to right
			if (dir == 0)
			{
				// printing elements from left to right
				for (int i = left; i <= right; i++)
				{
					System.out.print(matrix[top][i] + " ");
				}
				// after the top row is printed we update the top row var
				top++; // prevents elements from being printed 1+ for rows or columns
			}
			// update the direction var
			dir++;
			numTurns++;
			// -------------------------------------------------------------//

			// 2nd, we travel from top to bottom
			if (dir == 1)
			{
				// printing elements from top to bottom
				for (int i = top; i <= bottom; i++)
				{
					System.out.print(matrix[i][right] + " ");
				}
				// after the right most column is printed we update the right var
				right--; // prevents elements from being printed 1+ for rows or columns
			}
			// update the direction var
			dir++;
			numTurns++;
			// -------------------------------------------------------------//

			// 3rd, we travel from right to left
			if (dir == 2)
			{
				// printing elements from right to left
				// right > left so i>=left makes sense
				for (int i = right; i >= left; i--)
				{
					System.out.print(matrix[bottom][i] + " ");
				}
				// after the right most column is printed we update the bottom var
				bottom--; // prevents elements from being printed 1+ for rows or columns
			}
			// update the direction var
			dir++;
			numTurns++;
			// -------------------------------------------------------------//

			// 4th, we travel from bottom to top
			if (dir == 3)
			{
				// printing elements from bottom to top
				// bottom > top so i>=top makes sense
				for (int i = bottom; i >= top; i--)
				{
					System.out.print(matrix[i][left] + " ");
				}
				// after the right most column is printed we update the bottom var
				left++; // prevents elements from being printed 1+ for rows or columns
			}
			// update the direction var
			dir++;
			//System.out.println("\ndir: " + dir);
			dir = dir%4; //resets values so that its always in the range of 0-3 (4-1)
			numTurns++;
		}
		System.out.println("\nNumber of turns: " + numTurns);

	}

}
