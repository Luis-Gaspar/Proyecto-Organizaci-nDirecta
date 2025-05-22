//Representa al CRUD de un archivo de texto
package modelo;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ArchivoBinario {

    RandomAccessFile raf;

    final int NUMCONTROL_LEN = 8;
    final int NOMBRE_LEN = 20;
    final int APELLIDOS_LEN = 20;
    final int SEMESTRE_LEN = 2;
    final int GRUPO_LEN = 1;
    final int CARRERA_LEN = 30;
    final int TAMREG = NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN + GRUPO_LEN + CARRERA_LEN;

    PrintWriter pw;
    int totReg;

    public ArchivoBinario() {
        this.raf = null;

        this.pw = null;
        this.totReg = 0;
    }

    public boolean abrirArchivoRAF(String nombreArchivo) {
        try {
            raf = new RandomAccessFile(nombreArchivo, "rw"); //  usa el atributo
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private RandomAccessFile rafTemp = null;

    public boolean abrirArchivoRAFTemporal(String nombreArchivoTemp) {
        try {
            rafTemp = new RandomAccessFile(nombreArchivoTemp, "rw");
            rafTemp.setLength(0);  // Deja el temporal vacío
            rafTemp.seek(0);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static String ajustar(String s, int longitud) {
        if (s.length() > longitud) {
            return s.substring(0, longitud);
        } else {
            StringBuilder sb = new StringBuilder(s);
            while (sb.length() < longitud) {
                sb.append(' ');
            }
            return sb.toString();
        }
    }

    public void escribirRegistro(String numControl, String nombre,
            String apellidos, int semestre,
            char grupo, String carrera) {

        String formato = "00";
        //long pos = (long)(numRegistro - 1) * REGISTRO_BYTES;
        long pos = establecerPosicionByte(numControl);
        try {
            raf.seek(pos);
            raf.write(numControl.getBytes(("ISO-8859-1")));
            raf.write(ajustar(nombre, NOMBRE_LEN).getBytes("ISO-8859-1"));
            raf.write(ajustar(apellidos, APELLIDOS_LEN).getBytes("ISO-8859-1"));
            DecimalFormat df = new DecimalFormat(formato);
            String sem = df.format(semestre);
            //String sem = String.format("%d2", semestre);
            raf.write(sem.getBytes("ISO-8859-1"));
            String gpo = String.valueOf(grupo);
            raf.write(gpo.getBytes("ISO-8859-1"));
            raf.write(ajustar(carrera, CARRERA_LEN).getBytes("ISO-8859-1"));
        } catch (IOException ex) {
            Logger.getLogger(ArchivoBinario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private long establecerPosicionByte(String numeroControl) {
        return ((Long.parseLong(numeroControl.substring(5))) - 1) * TAMREG;
    }

    public void crearLinea(String linea) {
        this.pw.println(linea);
    }

    public void cerrarArchivo() {
        try {
            if (raf != null) {
                raf.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cerrarArchivoRAFTemporal() {
        try {
            if (rafTemp != null) {
                rafTemp.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String[] leerSiguienteRegistro() {
        try {
            if (raf.getFilePointer() >= raf.length()) {
                return null; // Fin del archivo
            }
            byte[] buf = new byte[TAMREG];
            raf.readFully(buf);

            String nc = new String(buf, 0, NUMCONTROL_LEN, "ISO-8859-1").trim();
            String nombre = new String(buf, NUMCONTROL_LEN, NOMBRE_LEN, "ISO-8859-1").trim();
            String apellidos = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN, APELLIDOS_LEN, "ISO-8859-1").trim();
            String semestre = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN, SEMESTRE_LEN, "ISO-8859-1").trim();
            String grupo = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN, GRUPO_LEN, "ISO-8859-1").trim();
            String carrera = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN + GRUPO_LEN, CARRERA_LEN, "ISO-8859-1").trim();

            return new String[]{nc, nombre, apellidos, semestre, grupo, carrera};

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void escribirRegistroTemporal(String[] registro) {
        try {
            rafTemp.write(ajustar(registro[0], NUMCONTROL_LEN).getBytes("ISO-8859-1"));
            rafTemp.write(ajustar(registro[1], NOMBRE_LEN).getBytes("ISO-8859-1"));
            rafTemp.write(ajustar(registro[2], APELLIDOS_LEN).getBytes("ISO-8859-1"));
            rafTemp.write(ajustar(registro[3], SEMESTRE_LEN).getBytes("ISO-8859-1"));
            rafTemp.write(ajustar(registro[4], GRUPO_LEN).getBytes("ISO-8859-1"));
            rafTemp.write(ajustar(registro[5], CARRERA_LEN).getBytes("ISO-8859-1"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String[][] obtenerMatrizRegistros(int numCol) {
        String registros[][] = new String[this.totReg][numCol];

        for (int f = 0; f < this.totReg; f++) {
            for (int c = 0; c < numCol; c++) {
            }
        }
        //System.out.println("Lineas:"+ lineas);
        return registros;
    }

    public String[] buscarRegistro(String numControlBuscado) {
        try {
            this.abrirArchivoRAF("estudiantes.dat");
            long numRegistros = raf.length() / TAMREG;
            for (int i = 0; i < numRegistros; i++) {
                raf.seek(i * TAMREG); // Ir al inicio del registro
                byte[] buf = new byte[TAMREG];
                raf.readFully(buf);
                String numControl = new String(buf, 0, NUMCONTROL_LEN, "ISO-8859-1").trim();

                if (numControl.equals(numControlBuscado)) {
                    String nombre = new String(buf, NUMCONTROL_LEN, NOMBRE_LEN, "ISO-8859-1").trim();
                    String apellidos = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN, APELLIDOS_LEN, "ISO-8859-1").trim();
                    String semestre = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN, SEMESTRE_LEN, "ISO-8859-1").trim();
                    String grupo = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN, GRUPO_LEN, "ISO-8859-1").trim();
                    String carrera = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN + GRUPO_LEN, CARRERA_LEN, "ISO-8859-1").trim();

                    return new String[]{
                        numControl, nombre, apellidos, semestre, grupo, carrera
                    };
                }
            }

        } catch (IOException e) {
            System.err.println("Error leyendo archivo: " + e.getMessage());
        } finally {
            this.cerrarArchivo(); // Cierre garantizado
        }

        return null; // No se encontró el registro
    }

    public boolean validaControl(String numControl) {
        return numControl.matches("^[0-9]{8}$");
    }

    public String[][] obtenerTodosLosRegistros() {
        try {
            long numRegistros = raf.length() / TAMREG;
            String[][] datos = new String[(int) numRegistros][6];

            raf.seek(0); // Volver al inicio

            int registrosValidos = 0;
            for (int i = 0; i < numRegistros; i++) {
                byte[] buf = new byte[TAMREG];
                raf.readFully(buf);

                String nc = new String(buf, 0, NUMCONTROL_LEN, "ISO-8859-1").trim();
                if (nc.isEmpty()) {
                    continue; // Salta registros vacíos
                }
                String nombre = new String(buf, NUMCONTROL_LEN, NOMBRE_LEN, "ISO-8859-1").trim();
                String apellidos = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN, APELLIDOS_LEN, "ISO-8859-1").trim();
                String semestre = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN, SEMESTRE_LEN, "ISO-8859-1").trim();
                String grupo = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN, GRUPO_LEN, "ISO-8859-1").trim();
                String carrera = new String(buf, NUMCONTROL_LEN + NOMBRE_LEN + APELLIDOS_LEN + SEMESTRE_LEN + GRUPO_LEN, CARRERA_LEN, "ISO-8859-1").trim();

                datos[registrosValidos][0] = nc;
                datos[registrosValidos][1] = nombre;
                datos[registrosValidos][2] = apellidos;
                datos[registrosValidos][3] = semestre;
                datos[registrosValidos][4] = grupo;
                datos[registrosValidos][5] = carrera;
                registrosValidos++;
            }

            // Ajustar el tamaño del array para eliminar filas vacías
            String[][] datosLimpios = new String[registrosValidos][6];
            System.arraycopy(datos, 0, datosLimpios, 0, registrosValidos);

            return datosLimpios;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[0][0];
    }

    public RandomAccessFile getRaf() {// clase que nos permite leer y escribir 
        return this.raf;              // en cualquier parte de un archivo, no solo desde 
    }                                 //el principio hasta el final como con un FileReader o BufferedReader.

    public RandomAccessFile getRafTemp() {
        return this.rafTemp;
    }

    public void eliminarArchivo(String nombreArchivo) {
        File f = new File(nombreArchivo);
        if (f.exists()) {
            f.delete();
        }
    }

    public void renombrarArchivo(String archivoViejo, String archivoNuevo) {
        File oldFile = new File(archivoViejo);
        File newFile = new File(archivoNuevo);
        if (oldFile.exists()) {
            oldFile.renameTo(newFile);
        }
    }
}
