import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
/**
 * A classe de teste Teste.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class Teste
{
    /**
     * Construtor default para a classe de teste Teste
     */
    public Teste()
    {
    }

    private Parque p;
    
    /**
     * Define a .
     *
     * Chamado antes de cada método de caso de teste.
     */
    @Before
    public void setUp(){
        Map<String,Lugar> lugares = new HashMap<>();
        Lugar l1 = new Lugar();
        l1.setMatricula("aaa");
        lugares.put("aaa", l1);
        Lugar l2 = new Lugar();
        l2.setMatricula("bbb");
        lugares.put("bbb", l2);
        p = new Parque("nome", lugares);
    }

    /**
     * Tears down the test fixture.
     *
     * Chamado após cada método de teste de caso.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void testKeySet(){
        Set<String> ms = p.todasMatriculas();
        ms.clear();
        assertEquals(p.todasMatriculas().size(), 2);
    }
    
    @Test
    public void testSize(){
        assertEquals(p.lugares(), 2);
    }
}
