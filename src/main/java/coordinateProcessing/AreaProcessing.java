package coordinateProcessing;

public class AreaProcessing implements CartesianAreas {

    @Override
    public boolean firstRotation(Integer x, Double y, Float R) {
        if(x >= 0 && y >= 0){
            return x <= R / 2 && y <= R;
        }
        return false;
    }

    @Override
    public boolean secondRotation(Integer x, Double y, Float R) {
        if(x<=0 && y>=0){
            double line = (float) x + 0.5;
            return line>=R && x<=-R/2 && y<=R/2;
        }
        return false;
    }

    @Override
    public boolean thirdRotation(Integer x, Double y, Float R) {
        if(x <= 0 && y <= 0){
            double circle = x*x+y*y;
            return circle <= Math.sqrt(R) && x<=-R && y<=-R;
        }
        return false;
    }

    @Override
    public boolean fourthRotation(Integer x, Double y, Float R) {
        return false;
    }

    @Override
    public boolean areaCheck(Integer x, Double y, Float R) {
        return firstRotation(x,y,R) || secondRotation(x,y,R) || thirdRotation(x,y,R) || fourthRotation(x,y,R);
    }
}
