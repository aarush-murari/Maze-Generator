package mazePackage;

public class MazeTree {
	public static void main(String[] agrs) {
		
		MazeNode[][] maze = generateMaze(10,10);
		printMaze(maze);
		
		
	}
	
	public static MazeNode[][] generateMaze(int length, int height) {
		
		MazeNode[][] maze = new MazeNode[height][length];
		
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				maze[i][j] = new MazeNode();
			}
			
		}
		//for
		
		//so we have our array
		//let's create a simple perfect maze as follows
		for (int i = 0; i < maze.length; i++) {
			
			MazeNode[] line = maze[i];
			for (int j = 0; j < line.length; j++) {
				
				if (j != (line.length - 1)) {
					maze[i][j].addChild(maze[i][j+1]);
					/*if (i < (maze.length - 1)) {
					maze[i][j].addChild(maze[i+1][j]);
					}*/
					
				}
				else if (j == (line.length - 1)) {
					if (i < (maze.length - 1)) {
						maze[i][j].addChild(maze[i+1][j]);
					}
				}
				
			}
			
		}
		return maze;
	}
	public static void printMaze(MazeNode[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			String downLines = "";
			for (int j = 0; j < maze[i].length; j++) {
				
				MazeNode node = maze[i][j];
				MazeNode node1 = null;
				MazeNode node2 = null;
				
				
				
				if ((j+1) < maze[i].length) {
					node1 = maze[i][j + 1];
				}
				
				if ((i+1) < maze.length) {
					node2 = maze[i+1][j];
				}
				
				
				System.out.print("+");
				
				if (node.hasChild(node1)) {
					System.out.print('-');
					
				}
				else {
					System.out.print(' ');
				}
				
				if (node.hasChild(node2)) {
					downLines += "| ";
				}
				else {
					downLines += "  ";
				}
					
			}
			
			System.out.println();
			
			System.out.println(downLines);
		}
	}
}
