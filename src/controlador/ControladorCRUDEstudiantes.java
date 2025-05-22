package controlador;
import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ArchivoBinario;
import vista.VistaCRUDEstudiantes;

public class ControladorCRUDEstudiantes {

    public VistaCRUDEstudiantes objVistaCRUDEst;
    ArchivoBinario objArchivo;
    DefaultTableModel modelo;

    public ControladorCRUDEstudiantes(VistaCRUDEstudiantes aThis,
            ArchivoBinario objArchivo) {
        this.objVistaCRUDEst = aThis;
        this.objArchivo = objArchivo;
        this.modelo = null;
    }

    public void llenarTabla() {
        String[] columnas = {"Num.Control", "Nombre", "Apellidos",
            "Semestre", "Grupo", "Carrera"};
        this.objArchivo.abrirArchivoRAF("estudiantes.dat");
        String[][] registros = this.objArchivo.obtenerTodosLosRegistros();
        this.objArchivo.cerrarArchivo();

        modelo = new DefaultTableModel(registros, columnas);
        this.objVistaCRUDEst.jtblEstudiantes.setModel(modelo);

        // Complemento para refrescar visualmente y limpiar selección anterior
        modelo.fireTableDataChanged();
        this.objVistaCRUDEst.jtblEstudiantes.clearSelection();
    }

    public void guardarRegistro(String nc, String nom, String ape,
            int sem, char gpo, String carrera) {
        if (buscarRegistro(nc) != null) {
            JOptionPane.showMessageDialog(objVistaCRUDEst,
                    "Ya existe un estudiante con ese número de control.");
            return;
        }
        this.objArchivo.abrirArchivoRAF("estudiantes.dat");
        this.objArchivo.escribirRegistro(nc, nom, ape, sem, gpo, carrera);
        this.llenarTabla();
        this.objArchivo.cerrarArchivo();
    }

    public String[] buscarRegistro(String nc) {
        return this.objArchivo.buscarRegistro(nc);
    }

    public void buscarSeleccionarRegistro(String nc) {
        boolean encontrado = false;
        for (int i = 0; i < this.modelo.getRowCount(); i++) {
            String nControl = this.modelo.getValueAt(i, 0).toString();
            if (nControl.equals(nc)) {
                this.objVistaCRUDEst.jtblEstudiantes.setRowSelectionInterval(i, i);
                this.objVistaCRUDEst.jtblEstudiantes.setSelectionBackground(Color.BLUE);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(objVistaCRUDEst, "No se encontró el registro");
        }
    }

    public boolean validaNumControl(String numControl) {
        return this.objArchivo.validaControl(numControl);
    }

    public boolean eliminarRegistro(String numControl) {
        boolean eliminado = false;

        this.objArchivo.abrirArchivoRAF("estudiantes.dat");
        this.objArchivo.abrirArchivoRAFTemporal("temporal.dat");

        String[] registro;
        while ((registro = this.objArchivo.leerSiguienteRegistro()) != null) {
            if (!registro[0].equals(numControl)) {
                this.objArchivo.escribirRegistroTemporal(registro);
            } else {
                eliminado = true;
            }
        }

        this.objArchivo.cerrarArchivo();
        this.objArchivo.cerrarArchivoRAFTemporal();

        this.objArchivo.eliminarArchivo("estudiantes.dat");
        this.objArchivo.renombrarArchivo("temporal.dat", "estudiantes.dat");

        if (eliminado) {
            llenarTabla();  // solo refresca si realmente eliminó
        }

        return eliminado;
    }

    public boolean editarRegistro(String nc, String nom, String ape, int sem, char grupo, String carrera) {
        boolean eliminado = this.eliminarRegistro(nc);

        if (eliminado) {
            this.guardarRegistro(nc, nom, ape, sem, grupo, carrera); // solo lo llamás, no lo retornás
            return true;
        }

        return false;
    }

    public void agregarRegistro(String nc, String nom, String ape, int sem, char grupo, String carrera) {
        guardarRegistro(nc, nom, ape, sem, grupo, carrera);
    }
}
