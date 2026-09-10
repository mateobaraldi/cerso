package com.example.demo.service;

import com.example.demo.dto.ProductoRequestDTO;
import com.example.demo.dto.ProductoResponseDTO;
import java.util.List;

public interface ProductoService {
    List<ProductoResponseDTO> obtenerTodos();
    ProductoResponseDTO obtenerPorId(Long id);
    ProductoResponseDTO crear(ProductoRequestDTO requestDTO);
    ProductoResponseDTO actualizar(Long id, ProductoRequestDTO requestDTO);
    void eliminar(Long id);
}