package utils;

public class DotTransformer {
    public static Double dotTransform(Double num){
        String strNum = num.toString().replace(",", ".");
        return Double.parseDouble(strNum);
    }
}
