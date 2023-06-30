/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExcelManager;

import App.App;
import ArbolesBinarios.Arbol;
import ArbolesBinarios.Nodo;
import Bedroom.Bedroom;
import HashTable.HashTable;
import Lista.Lista;

import Reservation.Reservation;
import User.User;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Daniel
 */
public class ExcelManager {
    
    public void leerExcel() {
        // ---------------------------------------------------------------------
        XSSFWorkbook libro = null;
        // ---------------------------------------------------------------------
        try {
            //abrimos el XSSFWorkbook
            FileInputStream f = new FileInputStream("C:\\Users\\User\\Desktop\\Trabajo.xlsx");
            libro = new XSSFWorkbook(f);
        } catch (Exception e) {
        }
        // ---------------------------------------------------------------------
        Bedroom[] habs = null;
        Lista reservas = null;
        HashTable statusHabs = null;
        int maximoIndice = libro.getNumberOfSheets();
        for (int i = 0; i < maximoIndice; i++) {
            XSSFSheet hoja = libro.getSheetAt(i);
            String nombreHoja = hoja.getSheetName();
            switch (nombreHoja) {
                case "Reservas":
                    
                    reservas = reservas(hoja);
                    reservas.sort();
//                    Lista p = reservas.copyList();
//                    p.show();
//                    Reservation d = (Reservation) reservas.seachBina(111335, p);
//                    d.show();
                    break;
                case "Habitaciones":
                    
                    habs = Habitaciones(hoja);
                    break;
//
                case "Estado":
                    if (habs == null) {
                        throw new Error("Error");
                    }
                    statusHabs = status(hoja, habs);
                    break;
                case "Historico":
                    if (habs == null) {
                        throw new Error("Error");
                    }
                    historico(hoja, habs);
                    break;
            }
        }
        App app = new App();
//        app.searchBedroomHistorial(habs);
//        app.searchReservation(reservas);
        app.searchHosted(statusHabs);
    }
    
    public Lista reservas(XSSFSheet hoja) {
        Lista ord = new Lista();
        int n = 0;
        int rowIndex = 0; // Índice de la primera fila

        Row row = hoja.getRow(rowIndex); // Obtiene la primera fila

        if (row != null) {
            int cellIndexStart = row.getFirstCellNum(); // Índice de la primera celda
            int cellIndexEnd = row.getLastCellNum(); // Índice de la última celda

            for (int cellIndex = cellIndexStart; cellIndex < 9; cellIndex++) {
                Cell cell = row.getCell(cellIndex);
                n++;
                String[] posicion = new String[2];
                
                if (cell != null) {
                    
                    if ("ci".equals(cell.getStringCellValue())) {
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        posicion[0] = "ci";
                        
                        ord.addLast(posicion);
                    } else if ("primer_nombre".equals(cell.getStringCellValue())) {
                        posicion[0] = "primer_nombre";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        
                        ord.addLast(posicion);
                    } else if ("segundo_nombre".equals(cell.getStringCellValue())) {
                        posicion[0] = "segundo_nombre";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("email".equals(cell.getStringCellValue())) {
                        posicion[0] = "email";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("genero".equals(cell.getStringCellValue())) {
                        posicion[0] = "genero";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("tipo_hab".equals(cell.getStringCellValue())) {
                        posicion[0] = "tipo_hab";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("celular".equals(cell.getStringCellValue())) {
                        posicion[0] = "celular";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("llegada".equals(cell.getStringCellValue())) {
                        posicion[0] = "llegada";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("salida".equals(cell.getStringCellValue())) {
                        posicion[0] = "salida";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else {
                        
                    }
                    
                }
                
            }
        }
        
        Cell columna;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        //recorremos las filas
        Lista reservaciones = new Lista();
        // Índice de la segunda fila

        int rowIndexEnd = hoja.getLastRowNum();
        
        for (int p = 1; p <= rowIndexEnd; p++) {
            row = hoja.getRow(p); // Obtiene la fila por índice
            n = 0;
            if (row != null) {
                int cellIndexStart = row.getFirstCellNum(); // Índice de la primera celda
                int cellIndexEnd = row.getLastCellNum();
                int dni = 0;
                String name = "";
                String last_name = "";
                String gener = "";
                String email = "";
                String phone = "";
                String ride = "";
                String departure = "";
                String type = "";
                for (int cellIndex = cellIndexStart; cellIndex < cellIndexEnd; cellIndex++) {
                    columna = row.getCell(cellIndex); // Obtiene la celda por índice

//                Cogemos la siguiente fila
//
//                Cogemos todas las celdas de esa fila
//                REcorremos todas las celdas
                    n++;
//                    Cogemos la siguiente fila

                    String[] orden = (String[]) ord.search2(n);
                    
                    switch (orden[0]) {
                        case "ci":
                            double i = columna.getNumericCellValue();
                            String value = String.valueOf(i);
                            value = value.replace(".", "");
                            value = value.replace("E7", "");
                            dni = Integer.parseInt(value);
//                            System.out.println(dni);
                            break;
                        case "primer_nombre":
                            name = columna.getStringCellValue();
//                            System.out.println(columna.getStringCellValue());
                            break;
                        
                        case "segundo_nombre":
                            last_name = columna.getStringCellValue();
//                            System.out.println(columna.getStringCellValue());
                            break;
                        case "email":
                            email = columna.getStringCellValue();
//                            System.out.println(columna.getStringCellValue());
                            break;
                        case "genero":
                            gener = columna.getStringCellValue();
//                            System.out.println(columna.getStringCellValue());
                            break;
                        case "tipo_hab":
                            type = columna.getStringCellValue();
//                            System.out.println(columna.getStringCellValue());
                            break;
                        case "celular":
                            phone = columna.getStringCellValue();
//                            System.out.println(columna.getStringCellValue());
                            break;
                        case "llegada":
                            Date a = columna.getDateCellValue();
                            ride = sdf.format(a);

//                            System.out.println("Fecha: " + a);
                            break;
                        case "salida":
                            Date b = columna.getDateCellValue();
                            departure = sdf.format(b);
//                            System.out.println("Fecha: " + b);
                            break;
                        
                    }
                    if (!"".equals(type) && !"".equals(ride) && !"".equals(departure) && !"".equals(last_name)
                            && !"".equals(name) && !"".equals(gener) && !"".equals(email) && !"".equals(phone) && dni != 0) {
                        User u = new User(dni, name, last_name, gener, email, phone);
                        u.setRide(ride);
                        u.setDeparture(departure);
                        Reservation r = new Reservation(u, type);
                        reservaciones.addLast(r);
                    }
                    
                }
            }
        }
        return reservaciones;
    }
    
    public Bedroom[] Habitaciones(XSSFSheet hoja) {
        Lista ord = new Lista();
        int n = 0;
        int rowIndex = 0; // Índice de la primera fila

        Row row = hoja.getRow(rowIndex); // Obtiene la primera fila

        if (row != null) {
            int cellIndexStart = row.getFirstCellNum(); // Índice de la primera celda
            int cellIndexEnd = row.getLastCellNum(); // Índice de la última celda

            for (int cellIndex = cellIndexStart; cellIndex < 3; cellIndex++) {
                Cell cell = row.getCell(cellIndex);
                n++;
                String[] posicion = new String[2];
                
                if (cell != null) {
                    if ("num_hab".equals(cell.getStringCellValue())) {
                        posicion[0] = "num_hab";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("tipo_hab".equals(cell.getStringCellValue())) {
                        posicion[0] = "tipo_hab";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("piso".equals(cell.getStringCellValue())) {
                        posicion[0] = "piso";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else {
                        
                    }
                    
                }
                
            }
        }

        //Cogemos todas las filas de esa hoja
        Row fila;
        Cell columna;
        Lista habitaciones = new Lista();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            recorremos las filas
        Lista reservaciones = new Lista();
        // Índice de la segunda fila

        int rowIndexEnd = hoja.getLastRowNum();
        
        for (int p = 1; p <= rowIndexEnd; p++) {
            row = hoja.getRow(p); // Obtiene la fila por índice
            n = 0;
            if (row != null) {
                int cellIndexStart = row.getFirstCellNum(); // Índice de la primera celda
                int cellIndexEnd = row.getLastCellNum();
                String type = "";
                int piso = 0;
                String x = "";
                for (int cellIndex = cellIndexStart; cellIndex < cellIndexEnd; cellIndex++) {
                    columna = row.getCell(cellIndex); // Obtiene la celda por índice

                    //Cogemos la siguiente fila
                    //Cogemos todas las celdas de esa fila
                    //REcorremos todas las celdas
                    n++;
                    //Cogemos la siguiente fila

                    String[] orden = (String[]) ord.search2(n);
                    
                    switch (orden[0]) {
                        case "tipo_hab":
                            type = columna.getStringCellValue();
//                            System.out.println(type);

                            break;
                        case "piso":
                            double i = columna.getNumericCellValue();
                            piso = (int) i;
//                            System.out.println(piso);
                            break;
                        default:
                            break;
                        
                    }
                    //Segun el tipo de celda, usaremos uno u otra funcion
////                if (o != 0) {
////                    if (n == 2) {
////                        type = columna.getStringCellValue();
////                        System.out.println(columna.getStringCellValue());
////                    } else if ((columna.getCellType() == CellType.NUMERIC) && (n == 3)) {
////                        double i = columna.getNumericCellValue();
////                        piso = (int) i;
////                        System.out.println(piso);
////
////                    } else {
////                        continue;
////                    }
////                }
////            }
////            if (o != 0) {
                    if (!"".equals(type) && piso != 0) {
                        Bedroom b = new Bedroom(type, piso);
                        habitaciones.addLast(b);
                        
                    }
                    
                }
                
            }
            
        }
        Bedroom habs[] = new Bedroom[(int) habitaciones.size()];
        
        for (int i = 0; i < habitaciones.size(); i++) {
            
            habs[i] = (Bedroom) habitaciones.getValuePosition(i);
//            habs[i].show();
//            System.out.println(i);
        }
        return habs;
        
    }
    
    public HashTable status(XSSFSheet hoja, Bedroom habs[]) {
        Lista ord = new Lista();
        int n = 0;
        int rowIndex = 0; // Índice de la primera fila
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Row row = hoja.getRow(rowIndex); // Obtiene la primera fila

        if (row != null) {
            int cellIndexStart = row.getFirstCellNum(); // Índice de la primera celda
            int cellIndexEnd = row.getLastCellNum(); // Índice de la última celda

            for (int cellIndex = cellIndexStart; cellIndex < 10; cellIndex++) {
                Cell cell = row.getCell(cellIndex);
                n++;
                String[] posicion = new String[2];
                
                if (cell != null) {
                    if ("num_hab".equals(cell.getStringCellValue())) {
                        posicion[0] = "num_hab";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("primer_nombre".equals(cell.getStringCellValue())) {
                        posicion[0] = "primer_nombre";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("apellido".equals(cell.getStringCellValue())) {
                        posicion[0] = "apellido";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("email".equals(cell.getStringCellValue())) {
                        posicion[0] = "email";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("genero".equals(cell.getStringCellValue())) {
                        posicion[0] = "genero";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("llegada".equals(cell.getStringCellValue())) {
                        
                        posicion[0] = "llegada";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("celular".equals(cell.getStringCellValue())) {
                        posicion[0] = "celular";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else {
                        
                    }
                }
            }
        }
        HashTable b = new HashTable(habs.length);
        //Cogemos todas las filas de esa hoja
        int rowIndexEnd = hoja.getLastRowNum();
        Cell columna;
        for (int p = 1; p <= rowIndexEnd; p++) {
            row = hoja.getRow(p); // Obtiene la fila por índice
            n = 0;
            if (row != null) {
                int cellIndexStart = row.getFirstCellNum(); // Índice de la primera celda
                int cellIndexEnd = row.getLastCellNum();
                String name = "";
                String last_name = "";
                String gener = "";
                String email = "";
                String phone = "";
                String ride = "";
                int num = 0;
                for (int cellIndex = cellIndexStart; cellIndex < cellIndexEnd; cellIndex++) {
                    columna = row.getCell(cellIndex); // Obtiene la celda por índice

                    //REcorremos todas las celdas
                    n++;
//                    System.out.println(n);
                    //Cogemos la siguiente fila
                    //Segun el tipo de celda, usaremos uno u otra funcion
                    String[] orden = (String[]) ord.search2(n);
//                    System.out.println(orden[0]);
                    switch (orden[0]) {
                        case "num_hab":
                            num = (int) columna.getNumericCellValue();
//                            System.out.println(num);
                            break;
                        case "primer_nombre":
                            name = columna.getStringCellValue();
//                            System.out.println(columna.getStringCellValue());
                            break;
                        
                        case "apellido":
                            last_name = columna.getStringCellValue();
//                            System.out.println(columna.getStringCellValue());
                            break;
                        case "email":
                            email = columna.getStringCellValue();
//                            System.out.println(columna.getStringCellValue());
                            break;
                        case "genero":
                            gener = columna.getStringCellValue();
//                            System.out.println(columna.getStringCellValue());
                            break;
                        case "celular":
                            phone = columna.getStringCellValue();
                            break;
                        case "llegada":
                            Date a = columna.getDateCellValue();
                            ride = sdf.format(a);
//                            System.out.println("Fecha: " + a);
                            break;
                    }
                    
                    if (!"".equals(last_name) && !"".equals(name) && !"".equals(gener) && !"".equals(email) && !"".equals(phone) && num != 0 && !"".equals(ride)) {
                        User u = new User(name, last_name, gener, email, phone);
                        u.setRide(ride);
                        u.setNum(num);
                        habs[num - 1].setOccupied(true);
                        b.insert(u);
                    }
                    
                }

//                if (o != 0) {
//
//                    if (n == 1) {
//                        num = (int) columna.getNumericCellValue();
//                        System.out.println(num);
//
//                    } else if (n == 2) {
//                        name = columna.getStringCellValue();
////                        System.out.println(columna.getStringCellValue());
//
//                    } else if (n == 3) {
//                        last_name = columna.getStringCellValue();
////                        System.out.println(columna.getStringCellValue());
//                    } else if (n == 4) {
//                        email = columna.getStringCellValue();
////                        System.out.println(columna.getStringCellValue());
//                    } else if (n == 5) {
//                        gener = columna.getStringCellValue();
////                        System.out.println(columna.getStringCellValue());
//                    } else if (n == 6) {
//                        phone = columna.getStringCellValue();
////                        System.out.println(columna.getStringCellValue());
//                    } else if (n == 7) {
//                        String a = String.valueOf(columna.getDateCellValue());
//                        ride = a;
//
////                        System.out.println("Fecha: " + a);
//                    }
//                }
//            }
//            if (o != 0) {
//
//                User u = new User(name, last_name, gener, email, phone);
//                u.setRide(ride);
//                u.setNum(num);
//
//                habs[num - 1].setOccupied(true);
//                b.insert(u);
//
//            }
//            o++;}
            }
        }
        return b;
    }
    
    public void historico(XSSFSheet hoja, Bedroom habs[]) {
        Lista ord = new Lista();
        int n = 0;
        int rowIndex = 0; // Índice de la primera fila

        Row row = hoja.getRow(rowIndex); // Obtiene la primera fila

        if (row != null) {
            int cellIndexStart = row.getFirstCellNum(); // Índice de la primera celda
            int cellIndexEnd = row.getLastCellNum(); // Índice de la última celda

            for (int cellIndex = cellIndexStart; cellIndex < 10; cellIndex++) {
                Cell cell = row.getCell(cellIndex);
                n++;
                String[] posicion = new String[2];
                
                if (cell != null) {
                    if ("ci".equals(cell.getStringCellValue())) {
                        posicion[0] = "ci";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("primer_nombre".equals(cell.getStringCellValue())) {
                        posicion[0] = "primer_nombre";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("apellido".equals(cell.getStringCellValue())) {
                        posicion[0] = "apellido";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("email".equals(cell.getStringCellValue())) {
                        posicion[0] = "email";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("genero".equals(cell.getStringCellValue())) {
                        posicion[0] = "genero";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                        
                    } else if ("llegada".equals(cell.getStringCellValue())) {
                        posicion[0] = "llegada";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else if ("num_hab".equals(cell.getStringCellValue())) {
                        posicion[0] = "num_hab";
                        String p = String.valueOf(n);
                        posicion[1] = p;
                        ord.addLast(posicion);
                    } else {
                        
                    }
                    
                }
                
            }
        }
        Iterator<Row> filas = hoja.iterator();
        Iterator<Cell> columnas;
        
        Row fila;
        Cell columna;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            recorremos las filas
        Lista reservaciones = new Lista();
        int rowIndexEnd = hoja.getLastRowNum();
        
        for (int p = 1; p <= rowIndexEnd; p++) {
            row = hoja.getRow(p); // Obtiene la fila por índice
            int dni = 0;
            String name = "";
            String last_name = "";
            String gener = "";
            String email = "";
            String ride = "";
            int num = 0;
            String phone = "";
            n = 0;
            if (row != null) {
                int cellIndexStart = row.getFirstCellNum(); // Índice de la primera celda
                int cellIndexEnd = row.getLastCellNum();
                
                for (int cellIndex = cellIndexStart; cellIndex < cellIndexEnd; cellIndex++) {
                    columna = row.getCell(cellIndex); // Obtiene la celda por índice

//                REcorremos todas las celdas
                    n++;
//                    Cogemos la siguiente fila

                    String[] orden = (String[]) ord.search2(n);
                    switch (orden[0]) {
                        case "ci":
                            double i = columna.getNumericCellValue();
                            String value = String.valueOf(i);
                            value = value.replace(".", "");
                            value = value.replace("E7", "");
                            dni = Integer.parseInt(value);
                            //     System.out.println(dni);
                            break;
                        case "primer_nombre":
                            name = columna.getStringCellValue();
                            //     System.out.println(name);
                            break;
                        
                        case "apellido":
                            last_name = columna.getStringCellValue();
                            //      System.out.println(last_name);
                            break;
                        case "email":
                            email = columna.getStringCellValue();
                            //                     System.out.println(email);
                            break;
                        case "genero":
                            gener = columna.getStringCellValue();
                            //                            System.out.println(gener);
                            break;
                        case "llegada":
                            Date a = columna.getDateCellValue();
                            ride = sdf.format(a);
//
//                            System.out.println("Fecha: " + ride);
                            break;
                        case "num_hab":
                            num = (int) columna.getNumericCellValue();
                            //    System.out.println(num);
                            break;
                        
                    }
                    
                    if (dni != 0 && !"".equals(last_name) && !"".equals(name) && !"".equals(gener) && !"".equals(email) && num != 0 && !"".equals(ride)) {
                        User u = new User(dni, name, last_name, gener, email, phone);
                        u.setRide(ride);
                        u.setNum(num);
                        Nodo aux = new Nodo(u);
                        habs[num - 1].getTree().insert(habs[num - 1].getTree().getpRoot(), aux);
//                        habs[num].getTree().preOrder(root.getpRoot());
                    }
                    
                }
//                if (dni != 0 && num != 0 && !"".equals(last_name) && !"".equals(name) && !"".equals(gener) && !"".equals(email) && !"".equals(ride) && !"".equals(phone)) {
//
////                        
//                }
//            try {

//            } catch (Exception e) {
//            }
//        }}
//        return reservaciones;
            }
        }
        
    }
}

/*
    
//            //seleccionamos la primera hoja
//            XSSFSheet hoja = libro.getSheetAt(0);
//
//            //Cogemos todas las filas de esa hoja
//            Iterator<Row> filas = hoja.iterator();
//            Iterator<Cell> columnas;
//
//            Row fila;
//            Cell columna;
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            //recorremos las filas
//            Lista reservaciones = new Lista();
//            fila = filas.next();
//
//            while (filas.hasNext()) {
//                int n = 0;
//                //Cogemos la siguiente fila
//                fila = filas.next();
//
//                //Cogemos todas las celdas de esa fila
//                columnas = fila.cellIterator();
//                int dni = 0;
//                String name = "";
//                String last_name = "";
//                String gener = "";
//                String email = "";
//                String phone = "";
//                String ride = "";
//                String departure = "";
//                String type="";
//
//                //REcorremos todas las celdas
//                while (columnas.hasNext()) {
//                    n++;
//                    //Cogemos la siguiente fila
//                    columna = columnas.next();
//
//                    //Segun el tipo de celda, usaremos uno u otra funcion
//                    if (n == 1) {
//                        double i = columna.getNumericCellValue();
//                        String value = String.valueOf(i);
//                        value = value.replace(".", "");
//                        value = value.replace("E7", "");
//                        dni = Integer.parseInt(value);
//                        System.out.println(value);
//                    } else if (n == 2) {
//                        name = columna.getStringCellValue();
//                        System.out.println(columna.getStringCellValue());
//
//                    } else if (n == 3) {
//                        last_name = columna.getStringCellValue();
//                        System.out.println(columna.getStringCellValue());
//                    } else if (n == 4) {
//                        email = columna.getStringCellValue();
//                        System.out.println(columna.getStringCellValue());
//                    } else if (n == 5) {
//                        gener = columna.getStringCellValue();
//                        System.out.println(columna.getStringCellValue());
//                    } else if (n == 6) {
//                        type=columna.getStringCellValue();
//                        System.out.println(columna.getStringCellValue());
//                    } else if (n == 7) {
//                        phone = columna.getStringCellValue();
//                        System.out.println(columna.getStringCellValue());
//                    } else if (n == 8) {
//                        String a = String.valueOf(columna.getDateCellValue());
//                        ride = a;
//
//                        System.out.println("Fecha: " + a);
//                    } else {
//                        String a = String.valueOf(columna.getDateCellValue());
//                        departure = a;
//                        System.out.println("Fecha: " + a);
//                    }
//
//                }
//                User u= new User(dni,  name,  last_name,  gener,  email,  phone);
//                u.setRide(ride);
//                u.setDeparture(departure);
//                Reservation r= new Reservation (u,type);
//                reservaciones.addLast(r);
//            }
//            HashTable statusHabs = status(libro, habs);
//            this.b = statusHabs;
//           System.out.println(u.getNum());
        //cerramos el libro
//        } catch (Exception e) {
//            System.out.print("Error");
//
 */
