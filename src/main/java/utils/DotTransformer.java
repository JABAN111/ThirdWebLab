package utils;

public class DotTransformer {

    public static Float dotTransform(String num){
        String strNum = num.replace(",",".");
        return Float.parseFloat(strNum);
    }
}
