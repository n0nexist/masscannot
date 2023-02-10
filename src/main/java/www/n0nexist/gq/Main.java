package www.n0nexist.gq;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\033[3;33m" +
                "8b    d8    db    .dP\"Y8 .dP\"Y8  dP\"\"b8    db    88b 88 88b 88  dP\"Yb  888888 \n" +
                "88b  d88   dPYb   `Ybo.\" `Ybo.\" dP   `\"   dPYb   88Yb88 88Yb88 dP   Yb   88   \n" +
                "88YbdP88  dP__Yb  o.`Y8b o.`Y8b Yb       dP__Yb  88 Y88 88 Y88 Yb   dP   88   \n" +
                "88 YY 88 dP\"\"\"\"Yb 8bodP' 8bodP'  YboodP dP\"\"\"\"Yb 88  Y8 88  Y8  YbodP    88   \n\033[0m");

        System.out.println("a masscan minecraft server checker by www.n0nexist.gq");

        try {
            String tocheck = args[0];
            int thrs = Integer.parseInt(args[1]);
            OutputFile.init(args[2]);
            OutputFile.write("MASSCANNOT BY WWW.N0NEXIST.GQ");
            System.out.println("* parsing xml file..");
            XMLParser.parseXML(tocheck,thrs);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("usage => java -jar masscannot.jar [masscan xml file] [threads] [output file]");
        }

    }
}