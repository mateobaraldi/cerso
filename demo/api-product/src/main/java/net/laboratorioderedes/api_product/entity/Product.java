package net.laboratorioderedes.api_product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // Lombok: Genera el constructor vacío sin argumentos
@AllArgsConstructor // Lombok: Genera el constructor con todos los argumentos
@Data // Lombok: Genera automáticamente getters, setters, toString, equals y hashCode
@Entity // JPA: Especifica que la clase es una entidad que mapea a una tabla
@Table(name = "products") // JPA: Define el nombre exacto de la tabla en la base de datos
public class Product {

    @Id // JPA: Define este atributo como la clave primaria (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA: Configura el ID como autoincrementable
    private Long id;

    private String name;

    private double price;

    private int quantity;
}