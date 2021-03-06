import java.util.*;

class PathChecker{
	
	static int[][] board = new int[][]
	{
		{1,0,0,3},
		{0,3,0,3},
		{0,3,3,3},
		{3,3,0,2}
	};
	static int len = board.length;
	static Point source = null;
	
	public static void main(String s[]){
		
		
		
		for(int i = 0;i<len;i++){
			for(int j = 0;j<len;j++){
				if(board[i][j]==1)
					source = new Point(i,j);	
			}
		}
		if(find(source.x,source.y))
			System.out.println("Path Exists");
		else
			System.out.println("No Path Exists");
		
		
	
	}
	
	public static boolean find(int x , int y){
		
		
		if(isDestination(x,y))
			return true;
		else if(isNotValid(x,y)){
			return false;
		}	
		else{
			System.out.println("\n");
			System.out.println(x+" , "+y);
			output();
			board[x][y] = 5;
			
			if(y-1>=0 && find(x,y-1))
				return true;
			else if(x+1<len && find(x+1,y))
				return true;
			else if(y+1<len && find(x,y+1))
				return true;
			else if(x-1>=0 && find(x-1,y))
				return true;
			else{
				return false;
			}
		}
	}
	
	public static boolean isNotValid(int x,int y){
		return (board[x][y]==3 || board[x][y] == 5);
	}
	
	public static boolean isDestination(int x,int y){
		return board[x][y] == 2;
	}
	
	public static void output(){
		for(int i = 0;i<len;i++){
			for(int j = 0;j<len;j++){
				System.out.print(board[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}


}

class Point{
		
	int x;
	int y;
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}

}
