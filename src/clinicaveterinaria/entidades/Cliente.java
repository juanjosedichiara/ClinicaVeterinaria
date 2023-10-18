package clinicaveterinaria.entidades;

public class Cliente {

    int idCliente;
    int documento;
    String apellido;
    String nombre;
    String direccion;
    int telefono;
    String contacto;
    Mascota mascota;
    Boolean estadoCliente;

    public Cliente() {
    }

    public Cliente(int idCliente, int documento, String apellido, String nombre, String direccion, int telefono, String contacto, Boolean estadoCliente) {
        this.idCliente = idCliente;
        this.documento = documento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contacto = contacto;
        this.estadoCliente = estadoCliente;
    }

    
    public Cliente(int documento, String apellido, String nombre, String direccion, int telefono, String contacto, Boolean estadoCliente) {
        this.documento = documento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contacto = contacto;
        this.estadoCliente = estadoCliente;
    }

    public Cliente(int documento, String apellido, String nombre, String direccion, int telefono, String contacto, Mascota mascota, Boolean estadoCliente) {
        this.documento = documento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contacto = contacto;
        this.mascota = mascota;
        this.estadoCliente = estadoCliente;
    }

    public Cliente(int idCliente, int documento, String apellido, String nombre, String direccion, int telefono, String contacto, Mascota mascota, Boolean estadoCliente) {
        this.idCliente = idCliente;
        this.documento = documento;
        this.apellido = apellido;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contacto = contacto;
        this.mascota = mascota;
        this.estadoCliente = estadoCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Boolean getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(Boolean estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "idCliente=" + idCliente + ", documento=" + documento + ", apellido=" + apellido + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", contacto=" + contacto + ", mascota=" + mascota + ", estadoCliente=" + estadoCliente + '}';
    }

}
