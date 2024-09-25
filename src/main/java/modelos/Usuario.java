package modelos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private int edad;
    private double salary;
    private String department;
}
