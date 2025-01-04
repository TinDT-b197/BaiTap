public class Patient extends Person {
    private String patientID;
    private String diseaseID;
    private String roomID;
    private String admissionDate;
    private String disChargeDate;
    private boolean isDischarged;
    private String assignedDoctorID;

    public Patient(String name, int yearOfBirth, String address, String patientID, String diseaseID, String roomID, String admissionDate, boolean isDischarged, String assignedDoctorID) {
        super(name, yearOfBirth, address);
        this.patientID = patientID;
        this.diseaseID = diseaseID;
        this.roomID = roomID;
        this.admissionDate = admissionDate;
        this.isDischarged = isDischarged;
        this.assignedDoctorID = assignedDoctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(String diseaseID) {
        this.diseaseID = diseaseID;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getDisChargeDate() {
        return disChargeDate;
    }

    public void setDisChargeDate(String disChargeDate) {
        this.disChargeDate = disChargeDate;
    }

    public boolean isDischarged() {
        return isDischarged;
    }

    public void setDischarged(boolean discharged) {
        isDischarged = discharged;
    }

    public String getAssignedDoctorID() {
        return assignedDoctorID;
    }

    public void setAssignedDoctorID(String assignedDoctorID) {
        this.assignedDoctorID = assignedDoctorID;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("| %-10s | %-10s | %-10s | %-10s | %-10s | %-5b | %-10s",
                patientID, diseaseID, roomID, admissionDate, disChargeDate, isDischarged, assignedDoctorID);
    }

    public void discharge(String disChargeDate) {
        this.disChargeDate = disChargeDate;
        isDischarged = true;
    }

    public void assignDoctor(String assignedDoctorID) {
        this.assignedDoctorID = assignedDoctorID;
    }

    public void changeRoom(String roomID) {
        this.roomID = roomID;
    }
}
