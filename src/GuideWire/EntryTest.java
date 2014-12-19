package GuideWire;

import org.junit.*;
public class EntryTest {

    MyHashMap hashmap;
    @Before
    public void setUp() throws Exception {
        hashmap = new MyHashMap();
    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void testGetMethodInMap(){
        Assert.assertNull (hashmap.get("a") == null);
        System.out.println("pass testcase1");
    }

    @Test
    public void test2(){
        Assert.assertNotSame ("it should be null", null, hashmap.get("a") );
    }
}