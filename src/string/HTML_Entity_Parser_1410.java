package string;

public class HTML_Entity_Parser_1410 {
    public String entityParser(String text) {
        return text.replace("&quot;","\"").replace("&apos;","'").replace("&amp;","&").replace("&gt;",">").replace("&lt;","<").replace("&frasl;","/");
    }
}
