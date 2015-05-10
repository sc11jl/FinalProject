import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class CreateEN {
	public static void main(String[] args){
		
		try {
			File file = new File(args[0]);
			BufferedWriter edgeswriter = new BufferedWriter(new FileWriter("edges.txt"));
			BufferedWriter nodeswriter = new BufferedWriter(new FileWriter("nodes.txt"));
			FileReader fileReader;
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			String edgeline = null;
			List<Integer> nodes = new ArrayList<Integer>();
			int elines = 0;
			while ((line = bufferedReader.readLine()) != null) {
				
				String[] node = line.split("\\s+");
				
				//System.out.println(line);
				edgeline = node[0] + "," +node[1];
				//System.out.println(edgeline);
				nodes.add(Integer.parseInt(node[0]));
				nodes.add(Integer.parseInt(node[1]));
				edgeswriter.write(edgeline);
				edgeswriter.newLine();
				elines++;
			}
			
			LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
			lhs.addAll(nodes);
			nodes.clear();
			nodes.addAll(lhs);
			Collections.sort(nodes);
			
			int nlines = 0;
			for(int i = 0; i< nodes.size();i++){
				nodeswriter.write(Integer.toString(nodes.get(i)));
				nodeswriter.newLine();
				nlines++;
			}
			
			System.out.println(nodes.size());
			System.out.println(elines);
			System.out.println(nlines);
			fileReader.close();
			edgeswriter.close();
			nodeswriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
