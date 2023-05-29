package com.mariangel.clinicadental.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.mariangel.clinicadental.model.CitasDto;
import com.mariangel.clinicadental.model.PacientesDto;
import com.mariangel.clinicadental.service.CitasService;
import com.mariangel.clinicadental.service.PacientesService;
import com.mariangel.clinicadental.util.Formato;
import com.mariangel.clinicadental.util.Mensaje;
import com.mariangel.clinicadental.util.Respuesta;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import static javafx.scene.control.Alert.AlertType.ERROR;
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
 * @author Mariangel
 */
public class PantallaPrincipalViewController extends Controller implements Initializable {

    private CitasService citasService = new CitasService();
    private PacientesService pacientesService = new PacientesService();

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
    private TextField txtId;
    @FXML
    private TextField txtSegundoApellidoPaciente;

    @FXML
    private Label txtSegundoApellidoRegistrarCita;

    /**
     * Initializes the controller class.
     */
    CitasDto cita;
    PacientesDto paciente;
    List<Node> requeridos = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        txtId.setTextFormatter(Formato.getInstance().integerFormat());
        txtNombrePaciente.setTextFormatter(Formato.getInstance().letrasFormat(30));
        txtPrimerApellidoPaciente.setTextFormatter(Formato.getInstance().letrasFormat(30));
        txtSegundoApellidoPaciente.setTextFormatter(Formato.getInstance().letrasFormat(30));
        txtCedulaPaciente.setTextFormatter(Formato.getInstance().cedulaFormat(30));
        txtDireccionPaciente.setTextFormatter(Formato.getInstance().letrasFormat(150));
      //  txtHoraRegistrarCita.setTextFormatter(Formato.getInstance().integerFormat());
        paciente = new PacientesDto();
        nuevoPaciente();
        indicarRequeridos();
    }

    public void indicarRequeridos() {
        requeridos.clear();
        requeridos.addAll(Arrays.asList(txtNombrePaciente, txtPrimerApellidoPaciente, txtSegundoApellidoPaciente, txtCedulaPaciente, txtDireccionPaciente, txtHoraRegistrarCita));
    }

    private void bindPaciente(Boolean nuevo) {
        if (!nuevo) {
                txtId.textProperty().bind(paciente.pacId);
        }
        txtCedulaPaciente.textProperty().bindBidirectional(paciente.pacCedula);
        txtNombrePaciente.textProperty().bindBidirectional(paciente.pacNombre);
        txtPrimerApellidoPaciente.textProperty().bindBidirectional(paciente.pacPapellido);
        txtSegundoApellidoPaciente.textProperty().bindBidirectional(paciente.pacSapellido);
        txtDireccionPaciente.textProperty().bindBidirectional(paciente.pacDirec);
       // txtHoraRegistrarCita.textProperty().bindBidirectional(cita.citaHora);
       // datePickerFechaRegistrarCita.valueProperty().bindBidirectional(cita.citaDia);
        datePickerFecNacPaciente.valueProperty().bindBidirectional(paciente.pacFecnac);
    }

    private void unbindPaciente() {
        //  txtId.textProperty().unbind();
        txtCedulaPaciente.textProperty().unbindBidirectional(paciente.pacCedula);
        txtNombrePaciente.textProperty().unbindBidirectional(paciente.pacNombre);
        txtPrimerApellidoPaciente.textProperty().unbindBidirectional(paciente.pacPapellido);
        txtSegundoApellidoPaciente.textProperty().unbindBidirectional(paciente.pacSapellido);
        txtDireccionPaciente.textProperty().bindBidirectional(paciente.pacDirec);
//        datePickerFechaRegistrarCita.valueProperty().unbindBidirectional(cita.citaDia);
    //    txtHoraRegistrarCita.textProperty().bindBidirectional(cita.citaHora);
        datePickerFecNacPaciente.valueProperty().unbindBidirectional(paciente.pacFecnac);
    }

    private void nuevoPaciente() {
        unbindPaciente();
        paciente = new PacientesDto();
        bindPaciente(true);
        txtId.clear();
        txtId.requestFocus();
    }
    
    @FXML
    void btnBuscarVerificarPaciente(ActionEvent event) {
        if (txtCedulaPaciente.getText() == null || txtCedulaPaciente.getText().isBlank()) {
            new Mensaje().showModal(ERROR, "Valida paciente", getStage(), "Ingrese un paciente");

        } else {

            Long cedula = Long.parseLong(txtCedulaPaciente.getText());
            Respuesta respuesta = pacientesService.getPaciente(cedula);
            if (respuesta.getEstado()) {
//                 Paciente existe
                PacientesDto paciente = (PacientesDto) respuesta.getResultado("Paciente");

            //     Aquí puedes actualizar los campos de texto con los datos del paciente
            } else {
            //     Paciente no existe
             //    Aquí puedes proceder a crear un nuevo paciente
            }
        }
    }

    public String validarRequeridos() {
        Boolean validos = true;
        String invalidos = "";
        for (Node node : requeridos) {
            if (node instanceof JFXTextField && !((JFXTextField) node).validate()) {
                if (validos) {
                    invalidos += ((JFXTextField) node).getPromptText();
                } else {
                    invalidos += "," + ((JFXTextField) node).getPromptText();
                }
                validos = false;
            } else if (node instanceof JFXPasswordField && !((JFXPasswordField) node).validate()) {
                if (validos) {
                    invalidos += ((JFXPasswordField) node).getPromptText();
                } else {
                    invalidos += "," + ((JFXPasswordField) node).getPromptText();
                }
                validos = false;
            } else if (node instanceof JFXDatePicker && ((JFXDatePicker) node).getValue() == null) {
                if (validos) {
                    invalidos += ((JFXDatePicker) node).getAccessibleText();
                } else {
                    invalidos += "," + ((JFXDatePicker) node).getAccessibleText();
                }
                validos = false;
            } else if (node instanceof JFXComboBox && ((JFXComboBox) node).getSelectionModel().getSelectedIndex() < 0) {
                if (validos) {
                    invalidos += ((JFXComboBox) node).getPromptText();
                } else {
                    invalidos += "," + ((JFXComboBox) node).getPromptText();
                }
                validos = false;
            }
        }
        if (validos) {
            return "";
        } else {
            return "Campos requeridos o con problemas de formato [" + invalidos + "].";
        }
    }

    private void cargarEmpleado(Long id) {
        PacientesService service = new PacientesService();
        Respuesta respuesta = service.getPaciente(id);

        if (respuesta.getEstado()) {
            unbindPaciente();
            paciente = (PacientesDto) respuesta.getResultado("Paciente");
            bindPaciente(false);
            validarRequeridos();
        } else {
            new Mensaje().showModal(Alert.AlertType.ERROR, "Cargar paciente", getStage(), respuesta.getMensaje());
        }
    }

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
