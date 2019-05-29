package model;

import control.DBAccess;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Doctor {
    
    private int id;
    private String name;
    private String spec;
    private int branchId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public Doctor(int id, String name, String spec, int branchId) {
        this.id = id;
        this.name = name;
        this.spec = spec;
        this.branchId = branchId;
    }
    
    
    
    public Doctor(String name, String spec, int branchId) {
        this.id = id;
        this.name = name;
        this.spec = spec;
        this.branchId = branchId;
    }

    public Doctor() {
    }

    public String getBranch() {
        DBAccess db = new DBAccess();
        return db.getDoctorBranch(this.getBranchId());
    }

    public boolean update(String name, String spec, String branch) {
        DBAccess db = new DBAccess();
        int branchId = db.getBranchIdByName(branch);
        String sql = "Update doctor SET name='" + name + "', spec='" + spec + "', branch_id=" + branchId + " where id =" + this.id;
        
        
        try {
            db.connect();
            int rs = db.stmt.executeUpdate(sql);

            System.out.println(rs);

            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }
       
}
