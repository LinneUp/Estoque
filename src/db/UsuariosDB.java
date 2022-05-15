package src.db;

import src.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuariosDB {
    private List<Usuario> usuariosList = new ArrayList<>();

    public List<Usuario> getUsuariosList() {
        return usuariosList;
    }
    public void addNovoUsuario(Usuario usuario){
        int id = usuariosList.size()+1;
        usuario.setId(id);
        usuariosList.add(usuario);
    }
}
