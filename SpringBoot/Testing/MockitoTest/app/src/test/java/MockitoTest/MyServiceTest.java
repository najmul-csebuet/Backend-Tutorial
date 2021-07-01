package MockitoTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    MyDatabase myDatabase1;

    @Mock
    MyDatabase myDatabase2;

    @Test
    public void testQuery()  {
        assertNotNull(myDatabase1);

        when(myDatabase1.isAvailable()).thenReturn(true);
        when(myDatabase2.isAvailable()).thenReturn(false);

        boolean available = myDatabase1.isAvailable();
        boolean available1 = myDatabase2.isAvailable();

        MyService t  = new MyService(myDatabase1);
        boolean check = t.query("* from t");
        assertTrue(check);

        MyService t2  = new MyService(myDatabase2);
        boolean check2 = t2.query("* from t");
        assertFalse(check2);
    }
}
