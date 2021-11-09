package Categoriser;

public class StringCategoriser implements Categoriser<String, String>  {
    
    public String getCategory(String value) {

        return value.substring(0, 1);
    }
}
