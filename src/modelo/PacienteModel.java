package modelo;

public class PacienteModel {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private int numero_telefonico;
    private String correo_electronico;
    private String enfermedades;
    private String medicamentos;
    private String alergias;
    private String intervenciones;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getNumero_telefonico() {
        return numero_telefonico;
    }

    public void setNumero_telefonico(int numero_telefonico) {
        this.numero_telefonico = numero_telefonico;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }
    
     public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(String medicamentos) {
        this.medicamentos = medicamentos;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getIntervenciones() {
        return intervenciones;
    }

    public void setIntervenciones(String intervenciones) {
        this.intervenciones = intervenciones;
    }
}
