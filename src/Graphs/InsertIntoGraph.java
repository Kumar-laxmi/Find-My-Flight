package Graphs;

import Graphs.Graph;
import java.util.*;

public class InsertIntoGraph {
	public static void main(String args[]) {
		Graph<String> g = new Graph<String>();
		
		// Storing all Airport codes
		String[] code = {"DEL","BOM","BLR","HYD","CCU","MAA","AMD","GOI","PAT",
				"COK","LKO","GAU","PNQ","JAI","SXR","BBI","IXB","VNS",
				"IXC","IXR"};
		
		for(int i=0; i<code.length; i++) {
			for(int j=i; j<code.length; j++) {
				if(i!=j) {
					g.addEdge(code[i], code[j], true);
				}
			}
		}
	}
		
}

/*
 * HashMap<Integer,String> code = new HashMap<Integer,String>();
	    code.put(1, "DEL");
		code.put(2, "BOM");
		code.put(3, "BLR");
		code.put(4, "HYD");
		code.put(5, "CCU");
		code.put(6, "MAA");
		code.put(7, "AMD");
		code.put(8, "GOI");
		code.put(9, "PAT");
		code.put(10, "COK");
		code.put(11, "LKO");
		code.put(12, "GAU");
		code.put(13, "PNQ");
		code.put(14, "JAI");
		code.put(15, "SXR");
		code.put(16, "BBI");
		code.put(17, "IXB");
		code.put(18, "VNS");
		code.put(19, "IXC");
		code.put(20, "IXR");
 */ 
