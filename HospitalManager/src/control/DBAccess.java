package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Assigned;
import model.Blood;
import model.Branch;
import model.Doctor;
import model.Patient;

public class DBAccess {

    public Connection con;
    public Statement stmt;

    public void connect() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java?serverTimezone=UTC", "root",
                "");
        stmt = con.createStatement();
    }

    public void close() throws SQLException {
        stmt.close();
        con.close();
    }

    // doctor
    public void addDoctor(Doctor doctor) {
        String query = "insert into doctor (`name`, `spec`, `branch_id`) values('"
                + doctor.getName() + "','" + doctor.getSpec() + "',"
                + doctor.getBranchId() + ");";

        try {
            connect();
            stmt.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Integer> getAllDoctorId() {
        String query = "Select id from doctor ORDER BY id";
        ArrayList<Integer> idList = new ArrayList<>();

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                idList.add(rs.getInt("id"));
            }

            close();

        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idList;
    }

    public Doctor getDoctorByName(String name) {

        String query = "select * from doctor where name='" + name + "'";
        Doctor doctor = null;

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                doctor = new Doctor();
                doctor.setName(rs.getString("name"));
                doctor.setSpec(rs.getString("spec"));
                doctor.setId(rs.getInt("id"));
                doctor.setBranchId(rs.getInt("branch_id"));
            }

            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doctor;
    }

    public Doctor getDoctorById(int id) {

        String query = "select * from doctor where id=" + id;
        Doctor doctor = null;

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                doctor = new Doctor();
                doctor.setName(rs.getString("name"));
                doctor.setSpec(rs.getString("spec"));
                doctor.setId(rs.getInt("id"));
                doctor.setBranchId(rs.getInt("branch_id"));
            }

            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return doctor;
    }

    public ArrayList<Doctor> getDoctorByBranch(int id) {
        String query = "Select * from doctor where branch_id =" + id;
        ArrayList<Doctor> doctors = new ArrayList<>();

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                doctors.add(new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("spec"), rs.getInt("branch_id")));
            }

            close();

        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctors;
    }

    public String getDoctorBranch(int id) {

        String query = "select * from branch where id=" + id;
        String branch = null;

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                branch = rs.getString("name");
            }

            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return branch;
    }

    public boolean updateDoctor(Doctor doctor) {

        String query = "UPDATE `doctor` SET `name`=" + doctor.getName() + ",`spec`=" + doctor.getSpec() + ",`branch_id`=" + doctor.getBranchId() + " where id=" + doctor.getId();

        try {
            connect();
            stmt.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public void deleteDoctorById(int id) {
        String query = "delete from doctor where id=" + id;
        try {
            connect();
            stmt.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Doctor> getAllDoctors() {
        String query = "Select * from doctor";
        ArrayList<Doctor> doctors = new ArrayList<>();

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                doctors.add(new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("spec"), rs.getInt("branch_id")));
            }

            close();

        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return doctors;
    }

    // patient
    public void addPatient(Patient patient) {
        String query = "insert into patient (`name`, `phone`, `blood_id`) values('"
                + patient.getName() + "','" + patient.getPhone() + "', " + patient.getBlood().getId() + ");";

        try {
            connect();
            stmt.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Integer> getAllPatientId() {
        String query = "Select id from patient ORDER BY id";
        ArrayList<Integer> idList = new ArrayList<>();

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                idList.add(rs.getInt("id"));
            }

            close();

        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idList;
    }

    public Patient getPatientById(int id) {

        String query = "select patient.*, blood.* from patient, blood where patient.id=" + id + " and blood.id = patient.blood_id";
        Patient patient = null;

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                patient = new Patient();
                patient.setName(rs.getString("patient.name"));
                patient.setPhone(rs.getString("patient.phone"));
                patient.setId(rs.getInt("patient.id"));
                patient.setBranchId(rs.getInt("patient.branch_id"));
                patient.setBlood(new Blood(rs.getInt("blood.id"), rs.getString("blood.name"), rs.getInt("blood.qty")));
            }

            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return patient;
    }

    public Patient getPatientByName(String name) {

        String query = "Select patient.*, blood.* from patient, blood where  patient.name='" + name + "' AND blood.id = patient.blood_id";
        Patient patient = null;
        Blood blood;
        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                patient = new Patient();
                blood = new Blood(rs.getInt("blood.id"), rs.getString("blood.name"), rs.getInt("blood.qty"));
                patient.setName(rs.getString("patient.name"));
                patient.setPhone(rs.getString("patient.phone"));
                patient.setId(rs.getInt("patient.id"));
                patient.setBranchId(rs.getInt("patient.branch_id"));
                patient.setBlood(blood);
            }

            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return patient;
    }

    public boolean updatePatient(Patient patient) {

        String query = "UPDATE `patient` SET `name`='" + patient.getName() + "',`phone`='" + patient.getPhone() + "',`blood_id`=" + patient.getBlood().getId() + " where id=" + patient.getId();

        try {
            connect();
            stmt.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public void deletePatientById(int id) {
        String query = "delete from patient where id=" + id;
        try {
            connect();
            stmt.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Patient> getAllPatients() {
        String query = "Select patient.*, blood.* from patient, blood where blood.id = patient.blood_id";
        ArrayList<Patient> Patients = new ArrayList<>();
        Blood blood;
        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                blood = new Blood(rs.getInt("blood.id"), rs.getString("blood.name"), rs.getInt("blood.qty"));
                Patients.add(new Patient(rs.getInt("patient.id"), rs.getString("patient.name"), rs.getString("patient.phone"), rs.getInt("patient.branch_id"), blood));
            }

            close();

        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Patients;
    }

    // assign
    public boolean assignDoctorToPatient(Doctor doctor, Patient patient) {
        String query = "insert into doctor_patient (`doctor_id`, `patient_id`) values('"
                + doctor.getId() + "','" + patient.getId() + "');";

        try {
            connect();
            stmt.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

    public boolean updateDoctorPatient(int doctorPatientId, int doctorId, int patientId) {

        String query = "UPDATE `doctor_patient` SET `doctor_id`=" + doctorId + ",`patient_id`=" + patientId + " where id=" + doctorPatientId;

        try {
            connect();
            stmt.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }
    
    public ArrayList<Assigned> getAllAssigned() {
        String query = "SELECT doctor.*, patient.* FROM doctor, patient, doctor_patient "
                + "WHERE doctor.id = doctor_patient.doctor_id AND patient.id = doctor_patient.patient_id"
                + " ORDER BY doctor_patient.id";
        ArrayList<Assigned> data = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<Branch> branches = new ArrayList<>();
        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);
            Doctor doctor;
            Patient patient;
            while (rs.next()) {
                doctor = new Doctor(rs.getInt("doctor.id"), rs.getString("doctor.name"), rs.getString("doctor.spec"), rs.getInt("doctor.branch_id"));
                patient = new Patient(rs.getInt("patient.id"), rs.getString("patient.name"), rs.getString("patient.phone"), rs.getInt("patient.branch_id"));
                data.add(new Assigned(doctor, patient));
            }
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    // branches
    public ArrayList<String> getAllBranches() {
        String query = "Select name from branch";
        ArrayList<String> branchList = new ArrayList<>();

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                branchList.add(rs.getString("name"));
            }

            close();

        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return branchList;
    }

    public int getBranchIdByName(String name) {
        String query = "SELECT `id` FROM `branch` WHERE `name`='" + name + "'";
        int id = 0;

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                id = rs.getInt("id");
            }

            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return id;
    }

    

    //blood
    public Blood getBloodByName(String name) {
        String query = "SELECT * from blood WHERE `name`='" + name + "'";
        Blood blood = null;

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                blood = new Blood(rs.getInt("id"), rs.getString("name"), rs.getInt("qty"));
            }

            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return blood;
    }

    public Blood getPatientBlood(int id) {

        String query = "select * from blood where id=" + id;
        Blood blood = null;

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                blood = new Blood(rs.getInt("id"), rs.getString("name"), rs.getInt("qty"));
            }

            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }

        return blood;
    }

    public ArrayList<Blood> getAllBlood() {
        String query = "Select * from blood";
        ArrayList<Blood> bloods = new ArrayList<>();

        try {
            connect();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                bloods.add(new Blood(rs.getInt("id"), rs.getString("name"), rs.getInt("qty")));
            }

            close();

        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bloods;
    }

}
