package utils;

public class DotTransformer {

    public static <T extends Number> T dotTransform(T num){
        String strNum = num.toString().replace(",",".");
        if (num instanceof Double) {
            return (T) Double.valueOf(strNum);
        } else if (num instanceof Float) {
            return (T) Float.valueOf(strNum);
        } else {
            throw new IllegalArgumentException("Unsupported Number type");
        }
    }
}
