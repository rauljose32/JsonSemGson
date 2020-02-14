package paladeans.jsonsemgson.model;

/*
 *Classe Usuarios utilizada para adicionar todos os objetos Usuario em uma Lista e assim
 * manipulalos
 * */

import java.util.List;

public class Usuarios {

    @Override
    public String toString() {
        return "Usuarios{" +
                "usuarios=" + usuarios +
                '}';
    }

    private List<Usuario> usuarios = null;

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
