import java.io.Serializable;

public class GameObj implements Serializable{
	public boolean isOpen = true;
	public char[][] cells = new char[3][3];
	public String player1;
	public String player2;
	
	public GameObj(){		
	}
	
	public GameObj(String player1){
		this.player1 = player1;
		// Set all cells to empty
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[i].length; j++){
				cells[i][j] = ' ';
			}
		}
	}
	
	public String getPlayer1(){
		return player1;
	}
	
	public String getPlayer2(){
		return player2;
	}
	
	public void setPlayer1(String player1){
		this.player1 = player1;
	}
	
	public void setPlayer2(String player2){
		this.player2 = player2;
	}
		
	public void setCell(int row, int col, char mark){
		cells[row][col] = mark;
	}
	
	public void cloneProps(GameObj cloneFrom){
		player1 = cloneFrom.getPlayer1();
		player2 = cloneFrom.getPlayer2();
		isOpen  = cloneFrom.isOpen;
	}
	
}
