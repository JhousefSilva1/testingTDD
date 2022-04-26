import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ElevadorTest {

    private Elevador elevador;
    @Rule
    public ExpectedException exception = ExpectedException.none();

    public ElevadorTest() {
    }

    @Before
    public void before() {
        this.elevador = new Elevador();
    }

    @Test
    public void cuandoSeMueveAscensor() throws Exception {
        Assert.assertEquals(2L, (long)this.elevador.moverElevador());
        Assert.assertEquals(3L, (long)this.elevador.moverElevador());
        Assert.assertEquals(2L, (long)this.elevador.moverElevador());
        Assert.assertEquals(1L, (long)this.elevador.moverElevador());
    }

    @Test
    public void creacionPersona() {
        this.elevador.crearPersona();
        this.elevador.crearPersona();
        this.elevador.crearPersona();
    }

    @Test
    public void controlDeAscensor() {
        Assert.assertEquals("Piso 3", this.elevador.escogerPiso(3));
        Assert.assertEquals("Piso 2", this.elevador.escogerPiso(2));
        Assert.assertEquals("Piso 2", this.elevador.escogerPiso(2));
    }
}
