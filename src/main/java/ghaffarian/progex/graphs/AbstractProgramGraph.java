/*** In The Name of Allah ***/
package ghaffarian.progex.graphs;

import ghaffarian.graphs.Digraph;
import java.io.IOException;
import java.util.Properties;

/**
 * Abstract Program Graph is the base class for all graphical program representations.
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public abstract class AbstractProgramGraph<N, E> extends Digraph<N, E>  {
    
    protected final Properties props; // TODO: compare Java's Properties vs Map<String, String>
    
    /**
     * Default constructor.
     */
    public AbstractProgramGraph() {
        super();
        props = new Properties();
    }
    
    /**
     * Copy constructor.
     */
    public AbstractProgramGraph(AbstractProgramGraph g) {
        super(g);
        props = new Properties(g.props); // TODO: make sure this is a copy operation
    }
    
	/**
	 * Export this program graph to specified file format.
     * The file will be saved in current working directory.
	 */
	public void export(String format) throws IOException {
        export(format, System.getProperty("user.dir"));
    }

    /**
	 * Export this program graph to specified file format.
     * The file will be saved in the given directory path.
	 */
	public void export(String format, String outDir) throws IOException {
		switch (format.toLowerCase()) {
            
			case "dot":
				exportDOT(outDir);
				break;
                
			case "gml":
				exportGML(outDir);
				break;
                
			case "json":
				exportJSON(outDir);
				break;
		}
	}
    
    /**
     * Export this program graph to DOT format. 
     * The DOT file will be saved in current working directory. 
     * The DOT format is mainly aimed for visualization purposes.
     */
    public void exportDOT() throws IOException {
        exportDOT(System.getProperty("user.dir"));
    }
    
    /**
     * Export this program graph to DOT format. 
     * The DOT file will be saved inside the given directory. 
     * The DOT format is mainly aimed for visualization purposes.
     */
    public abstract void exportDOT(String outDir) throws IOException;
    
	/**
	 * Export this program graph to GML format.
	 * The JSON file will be saved in current working directory.
	 */
    public void exportGML() throws IOException {
        exportGML(System.getProperty("user.dir"));
    }
	
	/**
	 * Export this program graph to GML format.
	 * The JSON file will be saved inside the given directory path.
	 */
	public abstract void exportGML(String outDir) throws IOException;

    /**
	 * Export this program graph to JSON format.
	 * The JSON file will be saved in current working directory.
	 */
    public void exportJSON() throws IOException {
        exportJSON(System.getProperty("user.dir"));
    }
	
	/**
	 * Export this program graph to JSON format.
	 * The JSON file will be saved inside the given directory path.
	 */
	public abstract void exportJSON(String outDir) throws IOException;
}
