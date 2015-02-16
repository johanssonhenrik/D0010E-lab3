import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class GraphIO implements Graph{

	public static void readFile(Graph g, String filename)throws IOException{
		try{
			File stringFile = new File(filename);
			Scanner scan = new Scanner(stringFile);
			String firstLine = scan.nextLine();	//Number of nodes in the graph. First Line.
			System.out.println("Number of Nodes:"+Integer.parseInt(firstLine));
			int nodeCoordLinesRead = 0;	//Number of lines that have been read. (0->Number of nodes)->(id1,id2,weight)
			
			while(scan.hasNextLine()){
				if(nodeCoordLinesRead >= Integer.parseInt(firstLine)){
					while(scan.hasNextLine()){
						g.addEdge(Integer.parseInt(scan.next()), Integer.parseInt(scan.next()), Integer.parseInt(scan.next()));
					}
				}else{
					while(scan.hasNextLine() && nodeCoordLinesRead < Integer.parseInt(firstLine)){
						g.addNode(Integer.parseInt(scan.next()),Integer.parseInt(scan.next()),Integer.parseInt(scan.next()));
						nodeCoordLinesRead++;
					}
				}
			}
			scan.close();
						
		}catch(NoSuchElementException e){
			//System.out.print(e);
		}
	}
	
	public void addNode(int id, int x, int y){
	}
	public void addEdge(int id1, int id2, int weight) throws NoSuchElementException{
	}
}
