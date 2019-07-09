package xpertgroup.technical.accessTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xpertgroup.technical.model.Cube3D;
import xpertgroup.technical.model.Point3D;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccessTestApplicationTests {

	@Test
	public void contextLoads() {
	}
        
        @Test
	public void updateCorrectly() {
            
            Cube3D cube = new Cube3D(3);
            cube.updateCube(new Point3D(1, 1, 1), 4);
            
            assertEquals(4, cube.queryCube(new Point3D(1, 1, 1), new Point3D(1, 1, 1)));    
	
        }

        @Test
	public void queryCorrectly() {
            
            Cube3D cube = new Cube3D(5);
            
            assertEquals(0, cube.queryCube(new Point3D(1, 1, 1), new Point3D(3, 3, 3)));
            
            cube.updateCube(new Point3D(1, 1, 1), 4);
            cube.updateCube(new Point3D(2, 2, 2), 23);
            cube.updateCube(new Point3D(3, 3, 3), 10);
            
            assertEquals(37, cube.queryCube(new Point3D(1, 1, 1), new Point3D(3, 3, 3)));
            
            cube.updateCube(new Point3D(2, 2, 2), 20);
            
            assertEquals(34, cube.queryCube(new Point3D(1, 1, 1), new Point3D(3, 3, 3)));
            
	}
        
}
