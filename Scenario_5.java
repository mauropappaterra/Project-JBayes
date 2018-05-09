import com.github.vangj.jbayes.inf.exact.graph.Graph;
import com.github.vangj.jbayes.inf.exact.graph.Node;

public class Scenario_5 {

    public static void main (String[] args){

        /* SCENARIO 5: Bayes Network for Authentication Violation Scenario */

        // Create Nodes
        Node ptf = Node.newBuilder().name("ptf").value("t").value("f").build(); // Plain Text File
        Node ef = Node.newBuilder().name("ef").value("t").value("f").build(); // Encrypted File
        Node df = Node.newBuilder().name("df").value("t").value("f").build(); // File is Decrypted
        Node fs = Node.newBuilder().name("fs").value("t").value("f").build(); // From System
        Node cs = Node.newBuilder().name("cs").value("t").value("f").build(); // Credential Stuffing
        Node ga = Node.newBuilder().name("ga").value("t").value("f").build(); // Guessing Attack
        Node bfa = Node.newBuilder().name("bfa").value("t").value("f").build(); // Brute Force Attack
        Node si = Node.newBuilder().name("si").value("t").value("f").build(); // Stolen Information
        Node cf = Node.newBuilder().name("cf").value("t").value("f").build(); // Coersive Force
        Node xsf = Node.newBuilder().name("xsf").value("t").value("f").build(); // Cross-Site Request Forgery
        Node kl = Node.newBuilder().name("kl").value("t").value("f").build(); // Key Logger
        Node se = Node.newBuilder().name("se").value("t").value("f").build(); // Social Engineering
        Node fu = Node.newBuilder().name("fu").value("t").value("f").build(); // From User
        Node oup = Node.newBuilder().name("oup").value("t").value("f").build(); // Obtaining Username & Passwords
        Node av = Node.newBuilder().name("av").value("t").value("f").build(); // Authentification Violation

        // Assign Connections
        df.addParent(ef);
        fs.addParent(df);
        fs.addParent(ptf);

        fu.addParent(si);
        fu.addParent(cf);
        fu.addParent(xsf);
        fu.addParent(kl);
        fu.addParent(se);

        oup.addParent(fs);
        oup.addParent(cs);
        oup.addParent(ga);
        oup.addParent(bfa);
        oup.addParent(fu);
        av.addParent(oup);

        // Populate CPTs
        ptf.setCpt(new double[][] {{0.5, 0.5}});
        ef.setCpt(new double[][] {{0.5, 0.5}});
        df.setCpt(new double[][] {{0.5, 0.5},{0.5, 0.5}});
        fs.setCpt(new double[][] {{0.5, 0.5}});
        cs.setCpt(new double[][] {{0.5, 0.5}});
        ga.setCpt(new double[][] {{0.5, 0.5}});
        bfa.setCpt(new double[][] {{0.5, 0.5}});
        si.setCpt(new double[][] {{0.5, 0.5}});
        cf.setCpt(new double[][] {{0.5, 0.5},{0.5, 0.5}});
        xsf.setCpt(new double[][] {{0.5, 0.5}});
        kl.setCpt(new double[][] {{0.5, 0.5}});
        se.setCpt(new double[][] {{0.5, 0.5}});
        fu.setCpt(new double[][] {{0.5, 0.5}});
        oup.setCpt(new double[][] {{0.5, 0.5}});
        av.setCpt(new double[][] {{0.5, 0.5}});


        // Create Graphs
        Graph bayesGraph = new Graph();
        bayesGraph.addNode(ptf);
        bayesGraph.addNode(ef);
        bayesGraph.addNode(df);
        bayesGraph.addNode(fs);
        bayesGraph.addNode(cs);
        bayesGraph.addNode(ga);
        bayesGraph.addNode(bfa);
        bayesGraph.addNode(si);
        bayesGraph.addNode(cf);
        bayesGraph.addNode(xsf);
        bayesGraph.addNode(kl);
        bayesGraph.addNode(se);
        bayesGraph.addNode(fu);
        bayesGraph.addNode(oup);
        bayesGraph.addNode(av);


        bayesGraph.sample(1000);

        // Check Probabilities
        double[] ptf_prob = ptf.probs();
        double[] ef_prob = ef.probs();
        double[] df_prob = df.probs();
        double[] fs_prob = fs.probs();
        double[] cs_prob = cs.probs();
        double[] ga_prob = ga.probs();
        double[] bfa_prob = bfa.probs();
        double[] si_prob = si.probs();
        double[] cf_prob = cf.probs();
        double[] xsf_prob = xsf.probs();
        double[] kl_prob = kl.probs();
        double[] se_prob = se.probs();
        double[] fu_prob = fu.probs();
        double[] oup_prob = oup.probs();
        double[] av_prob = av.probs();

        System.out.println("\nPlain Text File");
        System.out.println("True: " + ptf_prob[0] + " False: " + ptf_prob[1]);
        System.out.println("\nEncrypted File");
        System.out.println("True: " + ef_prob[0] + " False: " + ef_prob[1]);
        System.out.println("\nEncrypted File");
        System.out.println("True: " + ef_prob[0] + " False: " + ef_prob[1]);
        System.out.println("\nFile is Decrypted");
        System.out.println("True: " + df_prob[0] + " False: " + df_prob[1]);
        System.out.println("\nFrom System");
        System.out.println("True: " + fs_prob[0] + " False: " + fs_prob[1]);
        System.out.println("\nCredential Stuffing");
        System.out.println("True: " + cs_prob[0] + " False: " + cs_prob[1]);
        System.out.println("\nGuessing Attack");
        System.out.println("True: " + ga_prob[0] + " False: " + ga_prob[1]);
        System.out.println("\nBrute Force Attack");
        System.out.println("True: " + bfa_prob[0] + " False: " + bfa_prob[1]);
        System.out.println("\nStolen Information");
        System.out.println("True: " + si_prob[0] + " False: " + si_prob[1]);
        System.out.println("\nCoersive Force");
        System.out.println("True: " + cf_prob[0] + " False: " + cf_prob[1]);
        System.out.println("\nCross-Site Request Forgery");
        System.out.println("True: " + xsf_prob[0] + " False: " + xsf_prob[1]);
        System.out.println("\nKey Logger");
        System.out.println("True: " + kl_prob[0] + " False: " + kl_prob[1]);
        System.out.println("\nSocial Engineering");
        System.out.println("True: " + se_prob[0] + " False: " + se_prob[1]);
        System.out.println("\nFrom User");
        System.out.println("True: " + fu_prob[0] + " False: " + fu_prob[1]);
        System.out.println("\nObtaining Username & Passwords");
        System.out.println("True: " + oup_prob[0] + " False: " + oup_prob[1]);
        System.out.println("\nAuthentification Violation");
        System.out.println("True: " + av_prob[0] + " False: " + av_prob[1]);

    }

}


