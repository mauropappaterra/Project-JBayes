import com.github.vangj.jbayes.inf.exact.graph.Graph;
import com.github.vangj.jbayes.inf.exact.graph.Node;

public class Scenario_1 {

    public static void main (String[] args){

        /* SCENARIO 1: Bayes Network for Broken Access Control Scenario */

        // Create Nodes
        Node dm = Node.newBuilder().name("dm").value("t").value("f").build(); // Device Misconfiguration
        Node fpm = Node.newBuilder().name("fpm").value("t").value("f").build(); // File Permissions Misconfiguration
        Node sm = Node.newBuilder().name("sm").value("t").value("f").build(); // Security Misconfiguration
        Node bac = Node.newBuilder().name("bac").value("t").value("f").build(); // Broken Access Control

        // Assign Connections
        sm.addParent(dm);
        sm.addParent(fpm);
        bac.addParent(sm);

        // Populate CPTs
        dm.setCpt(new double[][] {{0.5, 0.5}});
        fpm.setCpt(new double[][] {{0.5, 0.5}});
        sm.setCpt(new double[][] {{0.5, 0.5},{0.5, 0.5}});
        bac.setCpt(new double[][] {{0.5, 0.5}});

        // Create Graphs
        Graph bayesGraph = new Graph();
        bayesGraph.addNode(dm);
        bayesGraph.addNode(fpm);
        bayesGraph.addNode(sm);
        bayesGraph.addNode(bac);
        bayesGraph.sample(1000);

        // Check Probabilities
        double[] dm_prob = dm.probs();
        double[] fpm_prob = fpm.probs();
        double[] sm_prob = sm.probs();
        double[] bac_prob = bac.probs();

        System.out.println("\nDevice Misconfiguration Probabilities");
        System.out.println("True: " + dm_prob[0] + " False: " + dm_prob[1]);
        System.out.println("\nFile Permissions Misconfiguration Probabilities");
        System.out.println("True: " + fpm_prob[0] + " False: " + fpm_prob[1]);
        System.out.println("\nSecurity Misconfiguration Probabilities");
        System.out.println("True: " + sm_prob[0] + " False: " + sm_prob[1]);
        System.out.println("\nBroken Access Control Probabilities");
        System.out.println("True: " + bac_prob[0] + " False: " + bac_prob[1]);

    }

}


