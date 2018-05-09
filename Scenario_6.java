import com.github.vangj.jbayes.inf.exact.graph.Graph;
import com.github.vangj.jbayes.inf.exact.graph.Node;

public class Scenario_6 {

    public static void main (String[] args){

        /* SCENARIO 6: Bayes Network for Authentication Violation Scenario */

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

        Node uid = Node.newBuilder().name("uid").value("t").value("f").build(); // Unsanitized Input Data
        Node qpm = Node.newBuilder().name("qpm").value("t").value("f").build(); // Query Parameterization Misconfiguration
        Node nldc = Node.newBuilder().name("nldc").value("t").value("f").build(); // No Limitations to Database Calls
        Node dmm = Node.newBuilder().name("dmm").value("t").value("f").build(); // Defense Mechanism Misconfiguration
        Node sm = Node.newBuilder().name("sm").value("t").value("f").build(); // Security Misconfiguration
        Node sia = Node.newBuilder().name("sia").value("t").value("f").build(); // SQL Injection Attack

        Node ili = Node.newBuilder().name("ili").value("t").value("f").build(); // Intercepting Login Information

        Node ba = Node.newBuilder().name("ba").value("t").value("f").build(); // Blind Attack
        Node ps = Node.newBuilder().name("ps").value("t").value("f").build(); // Packet Sniffing
        Node sas = Node.newBuilder().name("sas").value("t").value("f").build(); // Sniffing Authenticated Sessions
        Node ips = Node.newBuilder().name("ips").value("t").value("f").build(); // IP Spoofing
        Node xss = Node.newBuilder().name("xss").value("t").value("f").build(); // Cross Site Scripting Attack
        Node asid = Node.newBuilder().name("asid").value("t").value("f").build(); // Access to Stored Session ID
        Node sh = Node.newBuilder().name("sh").value("t").value("f").build(); // Session Hijacking

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

        sm.addParent(uid);
        sm.addParent(qpm);
        sm.addParent(nldc);
        sm.addParent(dmm);
        sia.addParent(sm);

        ili.addParent(sia);
        ili.addParent(oup);

        sas.addParent(ps);
        ips.addParent(sas);
        ips.addParent(ba);
        asid.addParent(xss);

        sh.addParent(ips);
        sh.addParent(asid);

        av.addParent(sh);
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

        uid.setCpt(new double[][] {{0.5, 0.5}});
        qpm.setCpt(new double[][] {{0.5, 0.5}});
        nldc.setCpt(new double[][] {{0.5, 0.5},{0.5, 0.5}});
        dmm.setCpt(new double[][] {{0.5, 0.5}});
        sm.setCpt(new double[][] {{0.5, 0.5}});
        sia.setCpt(new double[][] {{0.5, 0.5}});

        ba.setCpt(new double[][] {{0.5, 0.5}});
        ps.setCpt(new double[][] {{0.5, 0.5}});
        sas.setCpt(new double[][] {{0.5, 0.5}});
        ips.setCpt(new double[][] {{0.5, 0.5}});
        xss.setCpt(new double[][] {{0.5, 0.5}});
        asid.setCpt(new double[][] {{0.5, 0.5}});
        sh.setCpt(new double[][] {{0.5, 0.5}});

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

        bayesGraph.addNode(uid);
        bayesGraph.addNode(qpm);
        bayesGraph.addNode(nldc);
        bayesGraph.addNode(dmm);
        bayesGraph.addNode(sm);
        bayesGraph.addNode(sia);

        bayesGraph.addNode(ba);
        bayesGraph.addNode(ps);
        bayesGraph.addNode(sas);
        bayesGraph.addNode(ips);
        bayesGraph.addNode(xss);
        bayesGraph.addNode(asid);
        bayesGraph.addNode(sh);

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
        double[] uid_prob = uid.probs();
        double[] qpm_prob = qpm.probs();
        double[] nldc_prob = nldc.probs();
        double[] dmm_prob = dmm.probs();
        double[] sm_prob = sm.probs();
        double[] sia_prob = sia.probs();
        double[] ba_prob = ba.probs();
        double[] ps_prob = ps.probs();
        double[] sas_prob = sas.probs();
        double[] ips_prob = ips.probs();
        double[] xss_prob = xss.probs();
        double[] asid_prob = asid.probs();
        double[] sh_prob = sh.probs();

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
        System.out.println("\nBlind Attack");
        System.out.println("True: " + ba_prob[0] + " False: " + ba_prob[1]);
        System.out.println("\nPacket Sniffing");//
        System.out.println("True: " + ps_prob[0] + " False: " + ps_prob[1]);
        System.out.println("\nSniffing Authenticated Sessions");
        System.out.println("True: " + sas_prob[0] + " False: " + sas_prob[1]);
        System.out.println("\nIP Spoofing");
        System.out.println("True: " + ips_prob[0] + " False: " + ips_prob[1]);
        System.out.println("\nCross Site Scripting Attack");
        System.out.println("True: " + xss_prob[0] + " False: " + xss_prob[1]);
        System.out.println("\nAccess to Stored Session ID");
        System.out.println("True: " + asid_prob[0] + " False: " + asid_prob[1]);
        System.out.println("\nSession Hijacking");
        System.out.println("True: " + sh_prob[0] + " False: " + sh_prob[1]);
    }

}


