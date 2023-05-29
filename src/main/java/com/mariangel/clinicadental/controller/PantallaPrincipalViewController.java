
package com.mariangel.clinicadental.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jumaikel
 */
public class PantallaPrincipalViewController implements Initializable {
   @FXML
    private Button btnBuscarPaciente;

    @FXML
    private Button btnBuscarRegistrarCita;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnEliminarPaciente;

    @FXML
    private Button btnGuardarPaciente;

    @FXML
    private Button btnRegistrar;

    @FXML
    private DatePicker datePickerFecNacPaciente;

    @FXML
    private DatePicker datePickerFechaRegistrarCita;

    @FXML
    private Tab tapPaneInfoPacientes;

    @FXML
    private Tab tapPanePaciente;

    @FXML
    private Tab tapPaneRegistarCita;

    @FXML
    private TableColumn<?, ?> tblvCedulaInfoPacientes;

    @FXML
    private TableColumn<?, ?> tblvDireccionInfoPacientes;

    @FXML
    private TableColumn<?, ?> tblvEdadInfoPacientes;

    @FXML
    private TableColumn<?, ?> tblvFechaInfoPacientes;

    @FXML
    private TableColumn<?, ?> tblvFechaRegistrarCita;

    @FXML
    private TableColumn<?, ?> tblvHoraRegistrarCita;

    @FXML
    private TableColumn<?, ?> tblvNombreInfoPacientes;

    @FXML
    private TableColumn<?, ?> tblvPrimerApellidoInfoPacientes;

    @FXML
    private TableColumn<?, ?> tblvSegundoApellidoInfoPacientes;

    @FXML
    private TextField txtCedulaPaciente;

    @FXML
    private TextField txtCedulaRegistrarCita;

    @FXML
    private TextArea txtDireccionPaciente;

    @FXML
    private TextField txtHoraRegistrarCita;

    @FXML
    private TextField txtNombrePaciente;

    @FXML
    private Label txtNombreRegistrarCita;

    @FXML
    private TextField txtPrimerApellidoPaciente;

    @FXML
    private Label txtPrimerApellidoRegistrarCita;

    @FXML
    private TextField txtSegundoApellidoPaciente;

    @FXML
    private Label txtSegundoApellidoRegistrarCita;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
