import com.github.vangj.jbayes.inf.exact.graph.Graph;
import com.github.vangj.jbayes.inf.exact.graph.Node;

public class Scenario_2 {

    public static void main (String[] args){

        /* SCENARIO 2: Bayes Network for SQL Injection Attack */

        // Create Nodes
        Node uid = Node.newBuilder().name("uid").value("t").value("f").build(); // Unsanitized Input Data
        Node qpm = Node.newBuilder().name("qpm").value("t").value("f").build(); // Query Parameterization Misconfiguration
        Node nldc = Node.newBuilder().name("nldc").value("t").value("f").build(); // No Limitations to Database Calls
        Node dmm = Node.newBuilder().name("dmm").value("t").value("f").build(); // Defense Mechanism Misconfiguration
        Node sm = Node.newBuilder().name("sm").value("t").value("f").build(); // Security Misconfiguration
        Node sia = Node.newBuilder().name("sia").value("t").value("f").build(); // SQL Injection Attack

        // Assign Connections
        sm.addParent(uid);
        sm.addParent(qpm);
        sm.addParent(nldc);
        sm.addParent(dmm);
        sia.addParent(sm);

        // Populate CPTs
        uid.setCpt(new double[][] {{0.5, 0.5}});
        qpm.setCpt(new double[][] {{0.5, 0.5}});
        nldc.setCpt(new double[][] {{0.5, 0.5},{0.5, 0.5}});
        dmm.setCpt(new double[][] {{0.5, 0.5}});
        sm.setCpt(new double[][] {{0.5, 0.5}});
        sia.setCpt(new double[][] {{0.5, 0.5}});

        // Create Graphs
        Graph bayesGraph = new Graph();
        bayesGraph.addNode(uid);
        bayesGraph.addNode(qpm);
        bayesGraph.addNode(nldc);
        bayesGraph.addNode(dmm);
        bayesGraph.addNode(sm);
        bayesGraph.addNode(sia);
        bayesGraph.sample(1000);

        // Check Probabilities
        double[] uid_prob = uid.probs();
        double[] qpm_prob = qpm.probs();
        double[] nldc_prob = nldc.probs();
        double[] dmm_prob = dmm.probs();
        double[] sm_prob = sm.probs();
        double[] sia_prob = sia.probs();

        System.out.println("\nUnsanitized Input Data");
        System.out.println("True: " + uid_prob[0] + " False: " + uid_prob[1]);
        System.out.println("\nQuery Parameterization Misconfiguration");
        System.out.println("True: " + qpm_prob[0] + " False: " + qpm_prob[1]);
        System.out.println("\nNo Limitations to Database Calls");
        System.out.println("True: " + nldc_prob[0] + " False: " + nldc_prob[1]);
        System.out.println("\nDefense Mechanism Misconfiguration");
        System.out.println("True: " + dmm_prob[0] + " False: " + dmm_prob[1]);
        System.out.println("\nSecurity Misconfiguration");
        System.out.println("True: " + sm_prob[0] + " False: " + sm_prob[1]);
        System.out.println("\nSQL Injection Attack");
        System.out.println("True: " + sia_prob[0] + " False: " + sia_prob[1]);

    }

}


