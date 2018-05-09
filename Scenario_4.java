import com.github.vangj.jbayes.inf.exact.graph.Graph;
import com.github.vangj.jbayes.inf.exact.graph.Node;

public class Scenario_4 {

    public static void main (String[] args){

        /* SCENARIO 4: Bayes Network for Sensitive Data Exposure Scenario */

        // Create Nodes
        Node uid = Node.newBuilder().name("uid").value("t").value("f").build(); // Unsanitized Input Data
        Node qpm = Node.newBuilder().name("qpm").value("t").value("f").build(); // Query Parameterization Misconfiguration
        Node nldc = Node.newBuilder().name("nldc").value("t").value("f").build(); // No Limitations to Database Calls
        Node dmm = Node.newBuilder().name("dmm").value("t").value("f").build(); // Defense Mechanism Misconfiguration
        Node sm = Node.newBuilder().name("sm").value("t").value("f").build(); // Security Misconfiguration
        Node sia = Node.newBuilder().name("sia").value("t").value("f").build(); // SQL Injection Attack

        Node dm = Node.newBuilder().name("dm").value("t").value("f").build(); // Device Misconfiguration
        Node fpm = Node.newBuilder().name("fpm").value("t").value("f").build(); // File Permissions Misconfiguration
        /* REPEATED */ Node sm = Node.newBuilder().name("sm").value("t").value("f").build(); // Security Misconfiguration
        Node bac = Node.newBuilder().name("bac").value("t").value("f").build(); // Broken Access Control

        Node ia = Node.newBuilder().name("ia").value("t").value("f").build(); // Internal Attack
        Node edb = Node.newBuilder().name("edb").value("t").value("f").build(); // Encrypted Data is Breached

        Node ddb = Node.newBuilder().name("ddb").value("t").value("f").build(); // Data is decrypted by the attacker
        Node sde = Node.newBuilder().name("sde").value("t").value("f").build(); // Sensitive Data Exposure

        // Assign Connections
        sm.addParent(uid);
        sm.addParent(qpm);
        sm.addParent(nldc);
        sm.addParent(dmm);
        sia.addParent(sm);
        sm.addParent(dm);
        sm.addParent(fpm);
        bac.addParent(sm);

        edb.addParent(bac);
        edb.addParent(ia);
        edb.addParent(sia);

        ddb.addParent(edb);
        sde.addParent(ddb);


        // Populate CPTs
        uid.setCpt(new double[][] {{0.5, 0.5}});
        qpm.setCpt(new double[][] {{0.5, 0.5}});
        nldc.setCpt(new double[][] {{0.5, 0.5},{0.5, 0.5}});
        dmm.setCpt(new double[][] {{0.5, 0.5}});
        sm.setCpt(new double[][] {{0.5, 0.5}});
        sia.setCpt(new double[][] {{0.5, 0.5}});

        dm.setCpt(new double[][] {{0.5, 0.5}});
        fpm.setCpt(new double[][] {{0.5, 0.5}});
        /* REPEATED */ sm.setCpt(new double[][] {{0.5, 0.5},{0.5, 0.5}});
        bac.setCpt(new double[][] {{0.5, 0.5}});

        edb.setCpt(new double[][] {{0.5, 0.5}});
        ddb.setCpt(new double[][] {{0.5, 0.5}});
        sde.setCpt(new double[][] {{0.5, 0.5}});

        // Create Graphs
        Graph bayesGraph = new Graph();
        bayesGraph.addNode(uid);
        bayesGraph.addNode(qpm);
        bayesGraph.addNode(nldc);
        bayesGraph.addNode(dmm);
        bayesGraph.addNode(sm);
        bayesGraph.addNode(sia);

        bayesGraph.addNode(dm);
        bayesGraph.addNode(fpm);
        /* REPEATED */bayesGraph.addNode(sm);
        bayesGraph.addNode(bac);

        bayesGraph.addNode(ia);
        bayesGraph.addNode(edb);
        bayesGraph.addNode(ddb);
        bayesGraph.addNode(sde);

        bayesGraph.sample(1000);

        // Check Probabilities
        double[] uid_prob = uid.probs();
        double[] qpm_prob = qpm.probs();
        double[] nldc_prob = nldc.probs();
        double[] dmm_prob = dmm.probs();
        double[] sm_prob = sm.probs();
        double[] sia_prob = sia.probs();

        double[] dm_prob = dm.probs();
        double[] fpm_prob = fpm.probs();
        /* REPEATED */ double[] sm_prob = sm.probs();
        double[] bac_prob = bac.probs();

        double[] ia_prob = ia.probs();
        double[] edb_prob = edb.probs();
        double[] ddb_prob = ddb.probs();
        double[] sde_prob = sde.probs();

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

        System.out.println("\nDevice Misconfiguration Probabilities");
        System.out.println("True: " + dm_prob[0] + " False: " + dm_prob[1]);
        System.out.println("\nFile Permissions Misconfiguration Probabilities");
        System.out.println("True: " + fpm_prob[0] + " False: " + fpm_prob[1]);
        /* REPEATED */ System.out.println("\nSecurity Misconfiguration Probabilities");
        System.out.println("True: " + sm_prob[0] + " False: " + sm_prob[1]);
        System.out.println("\nBroken Access Control Probabilities");
        System.out.println("True: " + bac_prob[0] + " False: " + bac_prob[1]);

        System.out.println("\nInternal Attack");
        System.out.println("True: " + ia_prob[0] + " False: " + ia_prob[1]);
        System.out.println("\nEncrypted Data is Breached");
        System.out.println("True: " + edb_prob[0] + " False: " + edb_prob[1]);
        System.out.println("\nData is decrypted by the attacker");
        System.out.println("True: " + ddb_prob[0] + " False: " + ddb_prob[1]);
        System.out.println("\nSensitive Data Exposure");
        System.out.println("True: " + sde_prob[0] + " False: " + sde_prob[1]);
    }

}


