import java.io.Serializable;

public class GameObj implements Serializable{
	public boolean isOpenGame = true;
	public boolean isTurn = false;
	public char[][] cells = new char[3][3];
	public String player1 = "";
	public String player2 = "";
	public String winner;
	
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
		isOpenGame  = cloneFrom.isOpenGame;
	}
	
	public boolean isFull(){
		// Check all Rows
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[i].length; j++){
				if(cells[i][j] == ' '){
					return false;
				}
			}
		}
		
		// All cells are filled
		return true;
	}
	
	public boolean isWon(char token){
		// Check all Rows
		for (int i = 0; i < cells.length; i++){
			if(cells[i][0] == token
				&& (cells[i][1] == token)
				&& (cells[i][2] == token)){
				return true;
			}
		}
		
		// Check all Columns
		for (int j = 0; j < cells.length; j++){
			if(cells[0][j] == token
				&& (cells[1][j] == token)
				&& (cells[2][j] == token)){
				return true;
			}
		}
		
		// Check major diagonal
		if(cells[0][0] == token
			&& (cells[1][1] == token)
			&& (cells[2][2] == token)){
			return true;
		}
	
		// Check subdiagonal
		if(cells[0][2] == token
			&& (cells[1][1] == token)
			&& (cells[2][0] == token)){
				return true;
		}
		
		// No Winners
		return false;
	}
	
	public void resetGame(){
		// Set all cells to empty
		for(int i = 0; i < cells.length; i++){
			for(int j = 0; j < cells[i].length; j++){
				cells[i][j] = ' ';
			}
		}
		
		isOpenGame = true;
		winner = null;
		
	}
}
