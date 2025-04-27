package com.fernandoyutiz.thymeleaf.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Value("${entorno}")
    String entorno;

    @GetMapping("/hello")
    public String hello(Model model){
        Map<String,String> mapa= new HashMap<>();
        mapa.put("saludo","Buenos dias");
        mapa.put("nombre", "Fernando");
        mapa.put("entorno", entorno);
        model.addAttribute("mapa",mapa);
        return "hello";
    }

    @GetMapping("/archivo")
    public String guardarArchivo(){
        String rutaVolumen = "/data/archivo.txt";
        String texto = "¡Hola desde Railway!";
        File archivo = new File(rutaVolumen);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(texto);
            System.out.println("Archivo guardado exitosamente en: " + rutaVolumen);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
        return "archivo";
    }

    @GetMapping("/leer")
    public String leerArchivo(Model model){
        String rutaVolumen = "/data/archivo.txt";
        File archivo = new File(rutaVolumen);
        String archiTxt="";
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                System.out.println(linea); // Imprimir el contenido del archivo
                archiTxt += linea;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        Map<String,String> mapa= new HashMap<>();
        mapa.put("archivo",archiTxt);
        return "archivoleer";
    }
}
