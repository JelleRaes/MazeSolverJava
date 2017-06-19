package amazed;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Solve {

private char grid[][] = new char[0][0],solution[][];
private Point start=new Point();
private final List<Integer> path = new ArrayList<Integer>();


	public Solve(File x) throws FileNotFoundException{
		convert(x);
		startAndEndPos();
		Search.searchPath(grid,start.x,start.y,path);
		printMaze();
		System.out.println(path);
	}

	public void convert(File x) throws FileNotFoundException{
		File m = x;
		Scanner maze = new Scanner( m );
		int index = 0;
		while(maze.hasNextLine()){
			String line = maze.nextLine();
			StringBuffer chars= new StringBuffer(line);
			if(index==0){
				grid= new char[chars.length()+2][chars.length()+2];
				for(int i=0;i<chars.length();i++){
					grid[i][0]='X';
					grid[i][chars.length()+1]='X';
				}
			}
			for(int i=0;i<chars.length();i++){
				grid[index][i+1]=chars.charAt(i);
			}
			index++;
		}
		maze.close();
	}
	
	public void startAndEndPos(){
		for(int i=0;i<grid.length;i++){
			if(grid[i][1]==' '){
				start.x=1;
				start.y=i;
			}
		}
		for(int i=0;i<grid.length;i++){
			if(grid[i][grid.length-2]==' '){
				grid[i][grid.length-2]='E';
			}
		}
		solution=grid;
	}
	
	public void printMaze(){
		for (int p = 0; p < path.size(); p += 2) {
			 int pathX = path.get(p);
	         int pathY = path.get(p + 1);
	         solution[pathY][pathX]='*';
		}
		
		
		for(int i=0;i<solution.length;i++){
			for(int j=0;j<solution[0].length;j++){
				System.out.print(solution[i][j]);
			}
			System.out.println();
		}
	}
}