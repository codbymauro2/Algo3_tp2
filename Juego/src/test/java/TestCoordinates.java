import MainObjects.Coordinates;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestCoordinates {

    @Test
    public void Test01CDistanceBetweenCoordinates()  {
        Coordinates coordinates = new Coordinates(-54.807222,-68.304444); //Ushuaia
        Coordinates otherCoordinates = new Coordinates(-53.783333,-67.7); // Rio Grande

        Assert.assertEquals(coordinates.distance(otherCoordinates),120);
    }
}
