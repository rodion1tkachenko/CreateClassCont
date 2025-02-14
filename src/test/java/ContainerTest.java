import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class ContainerTest {

    @Test
    public void testAddGet() {
        Container<String> container = new Container<>();
        container.add("Hello");
        container.add("World");

        assertEquals(2, container.size());
        assertEquals("Hello", container.get(0));
        assertEquals("World", container.get(1));
    }

    @Test
    public void testRemove() {
        Container<Integer> container = new Container<>();
        container.add(1);
        container.add(2);
        container.add(3);

        container.remove(1);

        assertEquals(2, container.size());
        assertEquals(3, container.get(1));
    }

    @Test
    public void testIsEmpty() {
        Container<String> container = new Container<>();

        assertTrue(container.isEmpty());

        container.add("data");
        assertFalse(container.isEmpty());
    }

    @Test
    public void testGetOutOfBounds() {
        Container<Boolean> container = new Container<>();
        container.add(true);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            container.get(1);
        });
    }
}