package www.n0nexist.gq.utils;

public class Purifica {
    public static String purificaDagliAnsi(String text) {
        return text.replaceAll("\u001B\\[[\\d;]*[^\\d;]", "");
    }

    public static String purificaDalFormatting(String text) {
        return text.replaceAll("§.", "");
    }


}
