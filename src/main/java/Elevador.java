import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class Elevador {

    private Character[] ubiPersona = new Character[]{'0', '0', '0'};
    private Character[] ubiElevador = new Character[]{'x', '0', '0'};
    private final int LIM_INF = 1;
    private final int LIM_SUP = 3;
    private final int Pisos;
    private boolean subida;

    public Elevador() {
        this.Pisos = this.ubiElevador.length;
        this.subida = true;
    }

    public String escogerPiso(int piso) {
        int posPersona = 0;
        int pisoActual = 0;

        int p;
        for(p = this.crearPersona(); piso == p; p = this.crearPersona()) {
        }

        System.out.println(p);
        this.ubiPersona[p - 1] = 'x';
        if (piso >= 1 && piso <= 3) {
            for(int i = 0; i < this.Pisos; ++i) {
                if (this.ubiPersona[i] == 'x') {
                    posPersona = i + 1;
                }
            }

            while(this.ubiElevador[posPersona - 1] != 'x') {
                pisoActual = this.moverElevador();
                System.out.println("piso " + pisoActual);
            }

            while(this.ubiElevador[piso - 1] != 'x') {
                pisoActual = this.moverElevador();
                System.out.println("piso " + pisoActual);
            }

            return "Piso " + pisoActual;
        } else {
            throw new RuntimeException("Fuera del rango");
        }
    }

    public int crearPersona() {
        SecureRandom sr = null;

        try {
            sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        } catch (NoSuchAlgorithmException var3) {
            var3.printStackTrace();
        } catch (NoSuchProviderException var4) {
            var4.printStackTrace();
        }

        int rand = sr.nextInt(3) + 1;
        return rand;
    }

    public int moverElevador() {
        int pos = 0;

        for(int i = 0; i < this.Pisos; ++i) {
            if (this.ubiElevador[i] == 'x') {
                pos = i;
                this.ubiElevador[i] = '0';
            }
        }

        if (pos == this.Pisos - 1) {
            this.subida = false;
        }

        if (pos == 0) {
            this.subida = true;
        }

        if (this.subida) {
            ++pos;
        } else {
            --pos;
        }

        this.ubiElevador[pos] = 'x';
        return pos + 1;
    }
}
