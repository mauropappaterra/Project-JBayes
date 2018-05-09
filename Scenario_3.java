import com.github.vangj.jbayes.inf.exact.graph.Graph;
import com.github.vangj.jbayes.inf.exact.graph.Node;

public class Scenario_3 {

    public static void main (String[] args){

        /* SCENARIO 3: Bayes Network for Authentication Violation Scenario */

        // Create Nodes
        Node un = Node.newBuilder().name("un").value("t").value("f").build(); // User Connects to Untrusted Network
        Node mw = Node.newBuilder().name("mw").value("t").value("f").build(); // User Accesses Malicious Website
        Node im = Node.newBuilder().name("im").value("t").value("f").build(); // User Connects Infected Removable Media to the System
        Node iw = Node.newBuilder().name("iw").value("t").value("f").build(); // User Accesses Website Infected with Malware
        Node spe = Node.newBuilder().name("spe").value("t").value("f").build(); // User Opens Spear Phishing Email
        Node kv = Node.newBuilder().name("kv").value("t").value("f").build(); // Using Components with Known Vulnerabilities
        Node euv = Node.newBuilder().name("euv").value("t").value("f").build(); // Exploitation of unpatched vulnerability
        Node zdv = Node.newBuilder().name("zdv").value("t").value("f").build(); // Exploitation of zero-day vulnerability
        Node bd = Node.newBuilder().name("bd").value("t").value("f").build(); // Attacker installs backdoor on target System
        Node aic = Node.newBuilder().name("aic").value("t").value("f").build(); // Attacker gets access to internal system
        Node av = Node.newBuilder().name("av").value("t").value("f").build(); // Authentification Violation

        // Assign Connections
        kv.addParent(un);
        kv.addParent(mw);
        kv.addParent(im);
        kv.addParent(iw);
        kv.addParent(spe);
        euv.addParent(kv);
        bd.addParent(euv);
        bd.addParent(zdv);
        aic.addParent(bd);
        av.addParent(aic);

        // Populate CPTs
        un.setCpt(new double[][] {{0.5, 0.5}});
        mw.setCpt(new double[][] {{0.5, 0.5}});
        im.setCpt(new double[][] {{0.5, 0.5},{0.5, 0.5}});
        iw.setCpt(new double[][] {{0.5, 0.5}});
        spe.setCpt(new double[][] {{0.5, 0.5}});
        kv.setCpt(new double[][] {{0.5, 0.5}});
        euv.setCpt(new double[][] {{0.5, 0.5}});
        zdv.setCpt(new double[][] {{0.5, 0.5}});
        bd.setCpt(new double[][] {{0.5, 0.5}});
        aic.setCpt(new double[][] {{0.5, 0.5}});
        av.setCpt(new double[][] {{0.5, 0.5}});

        // Create Graphs
        Graph bayesGraph = new Graph();
        bayesGraph.addNode(un);
        bayesGraph.addNode(mw);
        bayesGraph.addNode(im);
        bayesGraph.addNode(iw);
        bayesGraph.addNode(spe);
        bayesGraph.addNode(kv);
        bayesGraph.addNode(euv);
        bayesGraph.addNode(zdv);
        bayesGraph.addNode(bd);
        bayesGraph.addNode(aic);
        bayesGraph.addNode(av);
        bayesGraph.sample(1000);

        // Check Probabilities
        double[] un_prob = un.probs();
        double[] mw_prob = mw.probs();
        double[] im_prob = im.probs();
        double[] iw_prob = iw.probs();
        double[] spe_prob = spe.probs();
        double[] kv_prob = kv.probs();
        double[] euv_prob = euv.probs();
        double[] zdv_prob = zdv.probs();
        double[] bd_prob = bd.probs();
        double[] aic_prob = aic.probs();
        double[] av_prob = av.probs();

        System.out.println("\nUser Connects to Untrusted Network");
        System.out.println("True: " + un_prob[0] + " False: " + un_prob[1]);
        System.out.println("\nUser Accesses Malicious Website");
        System.out.println("True: " + mw_prob[0] + " False: " + mw_prob[1]);
        System.out.println("\nUser Connects Infected Removable Media to the System");
        System.out.println("True: " + im_prob[0] + " False: " + im_prob[1]);
        System.out.println("\nUser Accesses Website Infected with Malware");
        System.out.println("True: " + iw_prob[0] + " False: " + iw_prob[1]);
        System.out.println("\nUser Opens Spear Phishing Email");
        System.out.println("True: " + spe_prob[0] + " False: " + spe_prob[1]);
        System.out.println("\nUsing Components with Known Vulnerabilities");
        System.out.println("True: " + kv_prob[0] + " False: " + kv_prob[1]);
        System.out.println("\nExploitation of unpatched vulnerability");
        System.out.println("True: " + euv_prob[0] + " False: " + euv_prob[1]);
        System.out.println("\nExploitation of zero-day vulnerability");
        System.out.println("True: " + zdv_prob[0] + " False: " + zdv_prob[1]);
        System.out.println("\nAttacker installs backdoor on target System");
        System.out.println("True: " + bd_prob[0] + " False: " + bd_prob[1]);
        System.out.println("\nAttacker gets access to internal system");
        System.out.println("True: " + aic_prob[0] + " False: " + aic_prob[1]);
        System.out.println("\nAuthentification Violation");
        System.out.println("True: " + av_prob[0] + " False: " + av_prob[1]);
    }

}


