// HOSPITAL MANAGEMENT SYSTEM - DECLARING PACKAGE
package hms;

// HOSPITAL MANAGEMENT SYSTEM - DECLARING IMPORTS
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.io.*;

// CUSTOM EXCEPTIONS
class PatientNotFoundException extends Exception 
{
    public PatientNotFoundException(String message) 
    {
        super(message);
    }
}
class InvalidDataException extends Exception 
{
    public InvalidDataException(String message) 
    {
        super(message);
    }
}

// INTERFACES
interface IMedicalOperations 
{
    void performMedicalTask() throws InvalidDataException;
    String getMedicalInfo();
}
interface IAdministrativeOperations 
{
    void manageRecords();
}

// ABSTRACT CLASS FOR HOSPITAL STAFF
abstract class HospitalStaff implements Serializable 
{
    // COMMON ATTRIBUTES FOR ALL STAFF MEMBERS
    private String id;
    private String name;
    private String password;
    private double salary;
    // CONSTRUCTOR TO INITIALIZE COMMON ATTRIBUTES FOR ALL STAFF MEMBERS
    HospitalStaff(String id, String name, String password, double salary) 
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salary = salary;
    }
    // GETTERS AND SETTERS FOR COMMON ATTRIBUTES
    // FOR ID
    public String getId() 
    { 
        return id; 
    }
    public void setId(String id) 
    { 
        this.id = id; 
    }
    // FOR NAME
    public String getName() 
    { 
        return name; 
    }
    public void setName(String name) 
    { 
        this.name = name; 
    }
    // FOR PASSWORD
    public String getPassword() 
    { 
        return password; 
    }
    public void setPassword(String password) 
    { 
        this.password = password; 
    }
    // FOR SALARY
    public double getSalary() 
    { 
        return salary; 
    }
    public void setSalary(double salary) 
    { 
        this.salary = salary; 
    }
    // ABSTRACT METHOD TO DISPLAY ROLE-SPECIFIC DETAILS
    abstract void displayRoleSpecificDetails();
    // METHOD TO DISPLAY BASIC INFO COMMON TO ALL STAFF MEMBERS
    void displayBasicInfo() {
        System.out.println("ID      : " + id);
        System.out.println("Name    : " + name);
        System.out.println("Salary  : Rs." + salary);
    }
}

// PATIENT CLASS
class Patient implements Serializable 
{
    // ATTRIBUTES FOR PATIENTS
    private String id, name, birthdate, phone;
    private String type, category, status;
    private String appointmentDate, followUp, medicines;
    private double bill;
    private String doctorId, doctorName;
    // ADDITIONAL ATTRIBUTES FOR MEDICAL HISTORY, PROCEDURES
    private List<String> medicalRecords = new ArrayList<>();
    private List<String> procedures = new ArrayList<>();
    // ADDITIONAL ATTRIBUTES FOR OUTPATIENTS AND INPATIENTS
    private String lastVisit;
    private String token;
    private String ward;
    private String admissionDate;
    // CONSTRUCTOR TO INITIALIZE PATIENT OBJECTS
    Patient(String id, String name, String birthdate, String phone, String type, String category, String status, String appointmentDate, String followUp, 
            String medicines, double bill, String doctorId, String doctorName) 
    {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.phone = phone;
        this.type = type;
        this.category = category;
        this.status = status;
        this.appointmentDate = appointmentDate;
        this.followUp = followUp;
        this.medicines = medicines;
        this.bill = bill;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
    }
    // GETTERS AND SETTERS FOR ALL ATTRIBUTES
    // FOR ID
    public String getId() 
    { 
        return id; 
    }
    public void setId(String id) 
    { 
        this.id = id; 
    }
    // FOR NAME
    public String getName() 
    { 
        return name; 
    }
    public void setName(String name) 
    { 
        this.name = name; 
    }
    // FOR BIRTHDATE
    public String getBirthdate() 
    { 
        return birthdate; 
    }
    public void setBirthdate(String birthdate) 
    { 
        this.birthdate = birthdate; 
    }
    // FOR PHONE
    public String getPhone() 
    { 
        return phone; 
    }
    public void setPhone(String phone) 
    { 
        this.phone = phone; 
    }
    // FOR TYPE
    public String getType() 
    { 
        return type; 
    }
    public void setType(String type) 
    { 
        this.type = type; 
    }
    // FOR CATEGORY
    public String getCategory() 
    { 
        return category; 
    }
    public void setCategory(String category) 
    { 
        this.category = category; 
    }
    // FOR STATUS
    public String getStatus() 
    { 
        return status; 
    }
    public void setStatus(String status) 
    { 
        this.status = status; 
    }
    // FOR APPOINTMENT DATE
    public String getAppointmentDate() 
    { 
        return appointmentDate; 
    }
    public void setAppointmentDate(String appointmentDate) 
    { 
        this.appointmentDate = appointmentDate; 
    }
    // FOR FOLLOW UP
    public String getFollowUp() 
    { 
        return followUp; 
    }
    public void setFollowUp(String followUp) 
    { 
        this.followUp = followUp; 
    }
    // FOR MEDICINES
    public String getMedicines() 
    { 
        return medicines; 
    }
    public void setMedicines(String medicines) 
    { 
        this.medicines = medicines; 
    }
    // FOR BILL
    public double getBill() 
    { 
        return bill; 
    }
    public void setBill(double bill) 
    { 
        this.bill = bill; 
    }
    // FOR DOCTOR ID
    public String getDoctorId() 
    { 
        return doctorId; 
    }
    public void setDoctorId(String doctorId) 
    { 
        this.doctorId = doctorId; 
    }
    // FOR DOCTOR NAME
    public String getDoctorName() 
    { 
        return doctorName; 
    }
    public void setDoctorName(String doctorName) 
    { 
        this.doctorName = doctorName; 
    }
    // FOR MEDICAL RECORDS AND PROCEDURES
    public List<String> getMedicalRecords() 
    { 
        return medicalRecords; 
    }
    public List<String> getProcedures() 
    { 
        return procedures; 
    }
    // LAST VISIT FOR OCCASIONAL OUTPATIENTS
    public String getLastVisit() 
    { 
        return lastVisit; 
    }   
    public void setLastVisit(String lastVisit) 
    { 
        this.lastVisit = lastVisit; 
    }
    // TOKENS FOR OUTPATIENTS
    public String getToken() 
    { 
        return token; 
    }
    public void setToken(String token) 
    { 
        this.token = token; 
    }
    // FOR WARD - INPATIENTS
    public String getWard() 
    { 
        return ward; 
    }
    public void setWard(String ward) 
    { 
        this.ward = ward; 
    }
    // FOR ADMISSION DATE - INPATIENTS
    public String getAdmissionDate() 
    { 
        return admissionDate; 
    }
    public void setAdmissionDate(String admissionDate) 
    { 
        this.admissionDate = admissionDate; 
    }
}

// DOCTOR CLASS
class Doctor extends HospitalStaff implements IMedicalOperations, IAdministrativeOperations 
{
    // ATTRIBUTES FOR DOCTORS
    private String specialization;
    private String phone;
    private String dateOfJoining;
    private int experience;
    // CONSTRUCTOR TO INITIALIZE DOCTOR OBJECTS
    Doctor(String id, String name, String password, String specialization, double salary, String phone, String dateOfJoining) 
    {
        super(id, name, password, salary);
        this.specialization = specialization;
        this.phone = phone;
        this.dateOfJoining = dateOfJoining;
        this.experience = calculateExperience(dateOfJoining);
    }
    // METHOD TO CALCULATE EXPERIENCE BASED ON DATE OF JOINING
    private int calculateExperience(String doj) 
    {
        try 
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate joinDate = LocalDate.parse(doj, formatter);
            LocalDate currentDate = LocalDate.now();
            return Period.between(joinDate, currentDate).getYears();
        } 
        catch (DateTimeParseException e) 
        {
            return 0;
        } 
        finally 
        {
            // Cleanup
        }
    }
    // IMPLEMENTATION OF INTERFACE METHODS
    @Override
    public void performMedicalTask() throws InvalidDataException
    {
        if (specialization == null || specialization.isEmpty()) 
        {
            throw new InvalidDataException("Doctor specialization cannot be empty");
        }
    }
    // METHOD TO GET DOCTOR'S MEDICAL INFO
    @Override
    public String getMedicalInfo() 
    {
        StringBuilder info = new StringBuilder();
        info.append("Dr. ").append(getName())
            .append(" (").append(specialization).append(")")
            .append(" - ").append(experience).append(" years experience");
        return info.toString();
    }    
    // METHOD TO MANAGE RECORDS (ADMINISTRATIVE TASK)
    @Override
    public void manageRecords() 
    {
        // Implementation
    }    
    // METHOD TO DISPLAY DOCTOR-SPECIFIC DETAILS
    @Override
    void displayRoleSpecificDetails() 
    {
        System.out.println("ROLE: DOCTOR");
        System.out.println("Specialization  : " + specialization);
        System.out.println("Experience      : " + experience + " years");
        System.out.println("Phone           : " + phone);
        System.out.println("Date of Joining : " + dateOfJoining);
    }
    // GETTER AND SETTER METHODS FOR DOCTOR'S ATTRIBUTES
    // FOR SPECIALIZATION
    public String getSpecialization() 
    { 
        return specialization; 
    }
    public void setSpecialization(String specialization) 
    { 
        this.specialization = specialization; 
    }
    // FOR PHONE
    public String getPhone() 
    { 
        return phone; 
    }
    public void setPhone(String phone) 
    { 
        this.phone = phone; 
    }
    // FOR DATE OF JOINING
    public String getDateOfJoining() 
    { 
        return dateOfJoining; 
    }
    public void setDateOfJoining(String dateOfJoining) 
    { 
        this.dateOfJoining = dateOfJoining; 
        this.experience = calculateExperience(dateOfJoining); // Recalculate experience if date changes
    }
    // FOR EXPERIENCE
    public int getExperience() 
    { 
        return experience;
    } 
    public int setExperience(int experience) 
    { 
        this.experience = experience; 
        return experience;
    }   
}

// NURSE CLASS
class Nurse extends HospitalStaff 
{
    // DECLARE ATTRIBUTES FOR NURSE
    private String assistingDoctorId;
    // CONSTRUCTOR TO INITIALIZE NURSE OBJECTS
    Nurse(String id, String name, String password, String assistingDoctorId, double salary) 
    {
        super(id, name, password, salary);
        this.assistingDoctorId = assistingDoctorId;
    }
    // METHOD TO DISPLAY NURSE-SPECIFIC DETAILS
    @Override
    void displayRoleSpecificDetails() 
    {
        System.out.println("ROLE: NURSE");
        System.out.println("Assisting Doctor: " + assistingDoctorId);
    }
    // GETTER AND SETTER FOR ASSISTING DOCTOR ID
    public String getAssistingDoctorId() 
    { 
        return assistingDoctorId; 
    }
    public void setAssistingDoctorId(String assistingDoctorId) 
    { 
        this.assistingDoctorId = assistingDoctorId; 
    }
}

// RECEPTIONIST CLASS
class Receptionist extends HospitalStaff 
{
    // CONSTRUCTOR FOR RECEPTIONIST CLASS INHERITS FROM HOSPITALSTAFF
    Receptionist(String id, String name, String password, double salary) 
    {
        super(id, name, password, salary);
    }
    // METHOD TO DISPLAY RECEPTIONIST-SPECIFIC DETAILS
    @Override
    void displayRoleSpecificDetails() 
    {
        System.out.println("ROLE: RECEPTIONIST");
    }
}

// PHARMACIST CLASS
class Pharmacist extends HospitalStaff 
{
    // CONSTRUCTOR FOR PHARMACIST CLASS INHERITS FROM HOSPITALSTAFF
    Pharmacist(String id, String name, String password) 
    {
        super(id, name, password, 0);
    }
    // METHOD TO DISPLAY PHARMACIST-SPECIFIC DETAILS
    @Override
    void displayRoleSpecificDetails() 
    {
        System.out.println("ROLE: PHARMACIST");
    }
}

// APPOINTMENT CLASS
class Appointment implements Serializable 
{
    // ATTRIBUTES FOR APPOINTMENTS
    private String patientId, doctorId, date, time, status;
    // CONSTRUCTOR TO INITIALIZE APPOINTMENT OBJECTS
    Appointment(String patientId, String doctorId, String date, String time, String status) 
    {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.status = status;
    }
    // GETTERS AND SETTERS FOR APPOINTMENT ATTRIBUTES
    //  FOR PATIENT ID
    public String getPatientId() 
    { 
        return patientId; 
    }
    public void setPatientId(String patientId) 
    { 
        this.patientId = patientId; 
    }
    // FOR DOCTOR ID
    public String getDoctorId() 
    { 
        return doctorId; 
    }
    public void setDoctorId(String doctorId) 
    { 
        this.doctorId = doctorId; 
    }
    // FOR DATE
    public String getDate() 
    { 
        return date; 
    }
    public void setDate(String date) 
    { 
        this.date = date; 
    }
    // FOR TIME
    public String getTime() 
    { 
        return time; 
    }
    public void setTime(String time) 
    { 
        this.time = time; 
    }
    // FOR STATUS
    public String getStatus() 
    { 
        return status; 
    }
    public void setStatus(String status) 
    { 
        this.status = status; 
    }
}

// MAIN CLASS
public class HospitalManagementSystem
{
    // BUFFERED READER FOR USER INPUT
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    // COLLECTIONS FOR DATA STORAGE - USING ARRAYLISTS AND HASHMAPS FOR PATIENTS, STAFF, NURSE, RECEPTIONISTS, PHARMACISTS, APPOINTMENTS, BLOOD BANK,MEDICINE STOCK
    private static List<Patient> patients = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Nurse> nurses = new ArrayList<>();
    private static List<Receptionist> receptionists = new ArrayList<>();
    private static List<Pharmacist> pharmacists = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();
    private static Map<String,Integer> bloodBank = new LinkedHashMap<>();
    private static Map<String,Integer> medicineStock = new LinkedHashMap<>();
    // FILE FOR DATA PERSISTENCE - WORD DOCUMENT FORMAT
    private static final String DATA_FILE = "Hospital_Management_System_Data.txt";
    
    public static void main(String[] args)
    {
        // LOAD DATA AND START APPLICATION
        try
        {
            File file = new File(DATA_FILE);
            if (!file.exists()) 
            {
                System.out.println("No saved data file found. Loading sample data...");
                loadSampleData();
            }   
            else
            {
                System.out.println("Found data file: " + DATA_FILE);
                System.out.println("Loading sample data for now...");
                loadSampleData();
            }
            // SAVE DATA ON SHUTDOWN USING A SHUTDOWN HOOK
            Runtime.getRuntime().addShutdownHook(new Thread(() -> 
            {
                try
                { 
                    saveData();
                }
                catch (Exception e)
                {
                    System.err.println("Error saving data: " + e.getMessage());
                }
            }));
            mainMenu();
        }
        finally
        {
            try
            {
                if (reader != null)
                    reader.close();
            }
            catch (IOException e)
            {
                System.err.println("Error closing resources: " + e.getMessage());
            }
        }   
    }

    // LOAD DATA FROM FILE - FOR ADMIN MENU OPTION 27
    private static boolean loadData() 
    {
        File file = new File(DATA_FILE);
        if (!file.exists()) 
        {
            System.out.println("\nNo data file found: " + DATA_FILE);
            System.out.println("Press Enter to continue...");
            try 
            {
                reader.readLine();
            } 
            catch (IOException e) 
            {
                // Ignore   
            }   
            return false;
        }

        System.out.println("\nData file found: " + DATA_FILE);
        System.out.println("Displaying file contents...\n");
    
        try (BufferedReader fileReader = new BufferedReader(new FileReader(DATA_FILE)))
        {
            String line;
            while ((line = fileReader.readLine()) != null)
            {
                System.out.println(line);
            }
            System.out.println("\nEnd of file reached.");
            System.out.println("\nPress Enter to continue...");
            reader.readLine();
        
            return true;
        }
        catch (IOException e)
        {
            System.err.println("\nError loading data: " + e.getMessage());
            System.out.println("\nPress Enter to continue...");
            try 
            {
                reader.readLine();
            } 
            catch (IOException ex) 
            {   
                // Ignore
            }
            return false;
        }
    }
    // SAVE DATA TO READABLE WORD DOCUMENT FORMAT    
    private static void saveData() 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) 
        {
            writer.write("================================================================================");
            writer.newLine();
            writer.write("                    HOSPITAL MANAGEMENT SYSTEM - COMPLETE DATA");
            writer.newLine();
            writer.write("================================================================================");
            writer.newLine();
            writer.newLine();
            // PATIENT MASTER TABLE
            writer.write("PATIENT MASTER TABLE");
            writer.newLine();
            writer.write("---------------------------------------------------------------------------------------");
            writer.newLine();
            writer.write(String.format("%-10s | %-15s | %-12s | %-15s | %-15s",  "ID", "Name", "Birthdate", "Credential", "Type"));
            writer.newLine();
            writer.write("---------------------------------------------------------------------------------------");
            writer.newLine();
            // WRITING PATIENT DATA TO THE FILE IN A FORMATTED MANNER
            for (Patient p : patients) 
            {
                writer.write(String.format("%-10s | %-15s | %-12s | %-15s | %-15s", p.getId(), p.getName(), p.getBirthdate(), p.getBirthdate(), p.getType() + " " + p.getCategory()));
                writer.newLine();
            }
            writer.newLine();
            writer.newLine();
            // MEDICAL HISTORY TABLE
            writer.write("MEDICAL HISTORY TABLE");
            writer.newLine();
            writer.write("----------------------------------------------------------");
            writer.newLine();
            writer.write(String.format("%-15s | %-50s", "Patient ID", "Medical History Details"));
            writer.newLine();
            writer.write("----------------------------------------------------------");
            writer.newLine();
            // WRITING MEDICAL HISTORY DATA TO THE FILE IN A FORMATTED MANNER
            for (Patient p : patients)
            {
                if (!p.getMedicalRecords().isEmpty()) 
                {
                    for (String record : p.getMedicalRecords()) 
                    {
                        writer.write(String.format("%-15s | %-50s", p.getId(), record));
                        writer.newLine();
                    }
                } 
                else 
                {
                    writer.write(String.format("%-15s | %-50s", p.getId(), "No medical records"));
                    writer.newLine();
                }
            }
            writer.newLine();
            writer.newLine();
            // DOCTOR ASSIGNMENT TABLE
            writer.write("DOCTOR ASSIGNMENT TABLE");
            writer.newLine();
            writer.write("-------------------------------");
            writer.newLine();
            writer.write(String.format("%-15s | %-15s", "Patient ID", "Doctor Code"));
            writer.newLine();
            writer.write("-------------------------------");
            writer.newLine();
            // WRITING DOCTOR ASSIGNMENT DATA TO THE FILE IN A FORMATTED MANNER
            for (Patient p : patients) 
            {
                writer.write(String.format("%-15s | %-15s", p.getId(), p.getDoctorId()));
                writer.newLine();
            }
            writer.newLine();
            writer.newLine();
            // OUTPATIENT DETAILS TABLE
            writer.write("OUTPATIENT DETAILS TABLE");
            writer.newLine();
            writer.write("Regular Outpatients");
            writer.newLine();
            writer.write("--------------------------------------------------------------------");
            writer.newLine();
            writer.write(String.format("%-10s | %-15s | %-15s | %-15s", "Patient ID", "Appointment Date", "Doctor Name", "Follow Up (Days)"));
            writer.newLine();
            writer.write("--------------------------------------------------------------------");
            writer.newLine();
            // WRITING REGULAR OUTPATIENT DETAILS DATA TO THE FILE IN A FORMATTED MANNER
            for (Patient p : patients) 
            {
                if (p.getCategory().equalsIgnoreCase("Outpatient") && p.getType().equalsIgnoreCase("Regular")) 
                {
                    writer.write(String.format("%-10s | %-16s | %-15s | %-15s", p.getId(), p.getAppointmentDate(), p.getDoctorName(), p.getFollowUp()));
                    writer.newLine();
                }
            }
            writer.newLine();
            writer.write("Occasional Outpatients");
            writer.newLine();
            writer.write("-------------------------------------------------------------------------");
            writer.newLine();
            writer.write(String.format("%-10s | %-16s | %-15s | %-12s | %-8s",  "Patient ID", "Appointment Date", "Doctor Name", "Last Visit", "Token"));
            writer.newLine();
            writer.write("-------------------------------------------------------------------------");
            writer.newLine();
            // WRITING OCCASIONAL OUTPATIENT DETAILS DATA TO THE FILE IN A FORMATTED MANNER
            for (Patient p : patients) 
            {
                if (p.getCategory().equalsIgnoreCase("Outpatient") && p.getType().equalsIgnoreCase("Occasional")) 
                {
                    writer.write(String.format("%-10s | %-16s | %-15s | %-12s | %-8s", p.getId(), p.getAppointmentDate(), p.getDoctorName(), 
                        p.getLastVisit() != null ? p.getLastVisit() : "-", p.getToken() != null ? p.getToken() : "1"));
                    writer.newLine();
                }
            }
            writer.newLine();
            writer.newLine();
            // INPATIENT DETAILS TABLE
            writer.write("INPATIENT DETAILS TABLE");
            writer.newLine();
            writer.write("-------------------------------------------------");
            writer.newLine();
            writer.write(String.format("%-15s | %-15s | %-10s", "Patient ID", "Admission Date", "Ward"));
            writer.newLine();
            writer.write("-------------------------------------------------");
            writer.newLine();
            // WRITING INPATIENT DETAILS DATA TO THE FILE IN A FORMATTED MANNER
            for (Patient p : patients) 
                {
                if (p.getCategory().equalsIgnoreCase("Inpatient")) {
                    writer.write(String.format("%-15s | %-15s | %-10s", p.getId(), p.getAdmissionDate() != null ? p.getAdmissionDate() : p.getAppointmentDate(),
                        p.getWard() != null ? p.getWard() : "-"));
                    writer.newLine();
                }
            }
            writer.newLine();
            writer.newLine();
            // MEDICATION TABLE
            writer.write("MEDICATION TABLE");
            writer.newLine();
            writer.write("----------------------------------");
            writer.newLine();
            writer.write(String.format("%-12s | %-18s", "Patient ID", "Medication"));
            writer.newLine();
            writer.write("----------------------------------");
            writer.newLine();
            // WRITING MEDICATION DATA TO THE FILE IN A FORMATTED MANNER
            for (Patient p : patients) 
            {
                if (p.getMedicines() != null && !p.getMedicines().equals("-")) 
                {
                    String[] meds = p.getMedicines().split(", ");
                    for (String med : meds) 
                    {
                        writer.write(String.format("%-12s | %-18s", p.getId(), med));
                        writer.newLine();
                    }
                }
            }
            writer.newLine();
            writer.newLine();
            // PROCEDURES TABLE
            writer.write("PROCEDURES TABLE (Inpatients Only)");
            writer.newLine();
            writer.write("-----------------------------");
            writer.newLine();
            writer.write(String.format("%-15s | %-18s", "Patient ID", "Procedure"));
            writer.newLine();
            writer.write("-----------------------------");
            writer.newLine();
            for (Patient p : patients) 
            {
                if (p.getCategory().equalsIgnoreCase("Inpatient") && !p.getProcedures().isEmpty()) 
                {
                    for (String procedure : p.getProcedures()) 
                    {
                        writer.write(String.format("%-15s | %-18s", p.getId(), procedure));
                        writer.newLine();
                    }
                }
            }
            writer.newLine();
            writer.newLine();
            // BLOOD BANK STATUS
            writer.write("BLOOD BANK STATUS");
            writer.newLine();
            writer.write("=========================");
            writer.newLine();
            writer.write(String.format("%-12s | %-6s", "Blood Group", "Units"));
            writer.newLine();
            writer.write("=========================");
            writer.newLine();
            // WRITING BLOOD BANK DATA TO THE FILE IN A FORMATTED MANNER
            for (Map.Entry<String, Integer> entry : bloodBank.entrySet()) 
            {
                writer.write(String.format("%-12s | %-6d", entry.getKey(), entry.getValue()));
                writer.newLine();
            }
            writer.newLine();
            writer.newLine();
            // MEDICINE STOCK
            writer.write("MEDICINE STOCK");
            writer.newLine();
            writer.write("=============================");
            writer.newLine();
            writer.write(String.format("%-16s | %-8s", "Medicine Name", "Quantity"));
            writer.newLine();
            writer.write("=============================");
            writer.newLine();
            // WRITING MEDICINE STOCK DATA TO THE FILE IN A FORMATTED MANNER
            for (Map.Entry<String, Integer> entry : medicineStock.entrySet()) 
            {
                writer.write(String.format("%-16s | %-8d", entry.getKey(), entry.getValue()));
                writer.newLine();
            }   
            writer.newLine();
            writer.write("======================================");            
            writer.newLine();
            writer.write("Generated on: " + getCurrentDateTime());
            writer.newLine();
            writer.write("======================================");            
            System.out.println("\nData saved successfully to: " + DATA_FILE);
        } 
        catch (IOException e) 
        {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }
    
    // LOAD SAMPLE DATA
    static void loadSampleData() 
    {
        // DOCTORS
        doctors.add(new Doctor("D1", "Dr.Shanthi", "Sha@16D1", "Gynaecologist", 90000, "934534530", "2020-12-14"));
        doctors.add(new Doctor("D2", "Dr.Tharu", "Tha@16D2", "General Physician", 85000, "9876543210", "2021-01-15"));
        doctors.add(new Doctor("D3", "Dr.Kumar", "Kum@16D3", "Cardiologist", 95000, "9876543211", "2019-03-10"));
        doctors.add(new Doctor("D4", "Dr.Krithika", "Kri@16D4", "Pediatrician", 88000, "9876543212", "2022-05-20"));
        doctors.add(new Doctor("D5", "Dr.Tharun", "Tha@16D5", "Orthopedic", 92000, "9876543213", "2020-08-15"));
        
        // NURSES
        nurses.add(new Nurse("N1", "Mimi", "Nu#456", "D1", 15000));
        nurses.add(new Nurse("N2", "John", "Nu#789", "D2", 15000));
        nurses.add(new Nurse("N3", "Sarah", "Nu#123", "D3", 16000));
        
        // RECEPTIONISTS
        receptionists.add(new Receptionist("R1", "Meena", "Re!789", 20000));
        receptionists.add(new Receptionist("R2", "Raj", "Re!456", 20000));
        
        // PHARMACISTS
        pharmacists.add(new Pharmacist("Ph1", "Reena", "Ph@321"));
        pharmacists.add(new Pharmacist("Ph2", "Kumar", "Ph@654"));
        
        // PATIENTS WITH DETAILED DATA
        // PATIENT1
        Patient p1 = new Patient("101", "Sharu", "2006-11-21", "9876543210", "Regular", "Outpatient", 
                                "Treatment - 7 months pregnant", "2025-03-11", "10", "Paracetamol, Vitamin C", 1500, "D1", "Dr.Shanthi");
        p1.getMedicalRecords().add("Initial consultation with Dr. Shanthi");
        p1.getMedicalRecords().add("Biopsy");
        p1.getProcedures().add("Biopsy");
        patients.add(p1);
        // PATIENT 2
        Patient p2 = new Patient("102", "Anto", "2006-10-21", "9123456789", "Occasional", "Outpatient", 
                                "At delivery", "2025-03-21", "Last visit: 2025-01-21", "Ibuprofen", 5000, "D2", "Dr.Tharu");
        p2.getMedicalRecords().add("Check-up with Dr. Tharun");
        p2.setLastVisit("2025-01-21");
        p2.setToken("1");
        patients.add(p2);
        // PATIENT 3
        Patient p3 = new Patient("103", "Krithika", "2006-09-21", "9012345678", "Regular", "Inpatient", 
                                "Delivered a baby girl", "2025-03-31", "Stayed: 5 days", "Calcium, Multivitamin", 25000, "D1", "Dr.Shanthi");
        p3.getMedicalRecords().add("Admitted to ward 30");
        p3.getMedicalRecords().add("Biopsy");
        p3.getProcedures().add("Appendectomy");
        p3.getProcedures().add("Biopsy");
        p3.setAdmissionDate("2025-03-31");
        p3.setWard("30");
        patients.add(p3);
        // PATIENT 4
        Patient p4 = new Patient("104", "Nithya", "2006-08-21", "9988776655", "Regular", "Outpatient", 
                                "General consultation", "2025-03-11", "12", "Insulin", 700, "D1", "Dr.Krithika");
        p4.getMedicalRecords().add("Initial registration");
        p4.getMedicalRecords().add("Initial consultation with Dr. Krithika");
        patients.add(p4);
        // PATIENT 5
        Patient p5 = new Patient("105", "Sri", "2006-07-21", "9988776644", "Occasional", "Outpatient", 
                                "General consultation", "2025-04-15", "Last visit: 2025-03-03", "Lisinopril", 800, "D1", "Dr.Shanthi");
        p5.getMedicalRecords().add("Initial registration");
        p5.getMedicalRecords().add("Check-up with Dr. Shanthi");
        p5.setLastVisit("2025-03-03");
        p5.setToken("1");
        patients.add(p5);
        // PATIENT 6
        Patient p6 = new Patient("106", "Shiva", "2002-06-21", "9988776633", "Regular", "Inpatient", 
                                "Surgery scheduled", "2025-04-27", "Stayed: 10 days", "Painkillers, Antibiotics", 45000, "D2", "Dr.Tharu");
        p6.getMedicalRecords().add("Initial registration");
        p6.getMedicalRecords().add("Admitted to ward 234");
        p6.getProcedures().add("Hysterectomy");
        p6.setAdmissionDate("2025-04-27");
        p6.setWard("234");
        patients.add(p6);
        // APPOINTMENTS
        appointments.add(new Appointment("101", "D1", "2025-03-11", "10:00", "Scheduled"));
        appointments.add(new Appointment("102", "D2", "2025-03-21", "11:30", "Scheduled"));
        appointments.add(new Appointment("103", "D1", "2025-03-31", "09:00", "Admitted"));
        appointments.add(new Appointment("104", "D1", "2025-03-11", "14:00", "Completed"));
        appointments.add(new Appointment("105", "D1", "2025-04-15", "15:30", "Scheduled"));
        appointments.add(new Appointment("106", "D2", "2025-04-27", "08:00", "Admitted"));
        // BLOOD BANK
        bloodBank.put("A+", 10);
        bloodBank.put("A-", 5);
        bloodBank.put("B+", 8);
        bloodBank.put("B-", 3);
        bloodBank.put("O+", 12);
        bloodBank.put("O-", 4);
        bloodBank.put("AB+", 6);
        bloodBank.put("AB-", 2);
        // MEDICINE STOCK
        medicineStock.put("Paracetamol", 100);
        medicineStock.put("Ibuprofen", 50);
        medicineStock.put("Vitamin C", 75);
        medicineStock.put("Iron Tablets", 40);
        medicineStock.put("Calcium", 60);
        medicineStock.put("Multivitamin", 45);
        medicineStock.put("Insulin", 30);
        medicineStock.put("Lisinopril", 25);
        medicineStock.put("Antibiotics", 80);
        medicineStock.put("Painkillers", 65);
    }
    // UTILITY METHOD TO READ USER INPUT WITH ERROR HANDLING
    private static String readLine() 
    {
        try 
        {
            return reader.readLine();
        } 
        catch (IOException e) 
        {
            System.err.println("Input error: " + e.getMessage());
            return "";
        }
    }
    // UTILITY METHOD TO GET CURRENT DATE AND TIME IN A FORMATTED MANNER
    private static String getCurrentDateTime() 
    {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    // MAIN MENU
    static void mainMenu() 
    {
        // DISPLAY MAIN MENU AND HANDLE USER CHOICES IN A LOOP UNTIL EXIT
        while(true) 
        {
            System.out.println("\n======================================");
            System.out.println("       HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Patient Login");
            System.out.println("2. Doctor Login");
            System.out.println("3. Nurse Login");
            System.out.println("4. Receptionist Login");
            System.out.println("5. Pharmacist Login");
            System.out.println("6. Admin Login");
            System.out.println("7. Exit");
            System.out.println("======================================");
            
            System.out.print("Enter choice: ");
            String choice = readLine();
            
            switch(choice) 
            {
                case "1" -> patientLogin();
                case "2" -> doctorLogin();
                case "3" -> nurseLogin();
                case "4" -> receptionistLogin();
                case "5" -> pharmacistLogin();
                case "6" -> {
                    try 
                    {
                        adminLogin();
                    } 
                    catch (IOException e) 
                    {
                        System.err.println("Admin login error: " + e.getMessage());
                    }
                }
                case "7" -> {
                    System.out.println("\nSaving data...");
                    saveData();
                    System.out.println("Goodbye!");
                    System.out.println("Thank You!!");
                    return;
                }
                default -> System.out.println("Invalid Choice!");
            }
        }
    }

    // ADMIN LOGIN WITH PASSWORD PROTECTION AND ACCESS TO ADMIN DASHBOARD WITH FILE SAVE/LOAD OPTIONS
    static void adminLogin() throws IOException 
    {
        System.out.print("\nEnter Admin Password: ");
        String pass = readLine();
        if (!pass.equals("Ad$999")) 
        {
            System.out.println("Invalid Password!");
            return;
        }
        System.out.println("WELCOME ADMIN!");
        
        while (true) 
        {
            System.out.println("\n------------------------------");
            System.out.println("        ADMIN DASHBOARD");
            System.out.println(" 1. View Patients");
            System.out.println(" 2. Create Patient");
            System.out.println(" 3. Edit Patient");
            System.out.println(" 4. Delete Patient");
            System.out.println(" 5. View Doctors");
            System.out.println(" 6. Add Doctor");
            System.out.println(" 7. Edit Doctor");
            System.out.println(" 8. Delete Doctor");
            System.out.println(" 9. View Nurses");
            System.out.println("10. Add Nurse");
            System.out.println("11. Edit Nurse");
            System.out.println("12. Delete Nurse");
            System.out.println("13. View Receptionists");
            System.out.println("14. Add Receptionist");
            System.out.println("15. Edit Receptionist");
            System.out.println("16. Delete Receptionist");
            System.out.println("17. View Pharmacists");
            System.out.println("18. Add Pharmacist");
            System.out.println("19. Edit Pharmacist");
            System.out.println("20. Delete Pharmacist");
            System.out.println("21. View Blood Bank");
            System.out.println("22. Manage Blood Bank");
            System.out.println("23. View Appointments");
            System.out.println("24. View Detailed Reports");
            System.out.println("25. New Features");
            System.out.println("26. Save Data to File");
            System.out.println("27. Load Data from File");
            System.out.println("28. Back to Main Menu");
            System.out.println("------------------------------");
            
            System.out.print("Enter your choice (1-28): ");
            String ch = readLine();
            
            try 
            {
                switch (ch) 
                {
                    case "1" -> viewPatients();
                    case "2" -> createPatient();
                    case "3" -> editPatient();
                    case "4" -> deletePatient();
                    case "5" -> viewDoctors();
                    case "6" -> addDoctor();
                    case "7" -> editDoctor();
                    case "8" -> deleteDoctor();
                    case "9" -> viewNurses();
                    case "10" -> addNurse();
                    case "11" -> editNurse();
                    case "12" -> deleteNurse();
                    case "13" -> viewReceptionists();
                    case "14" -> addReceptionist();
                    case "15" -> editReceptionist();
                    case "16" -> deleteReceptionist();
                    case "17" -> viewPharmacists();
                    case "18" -> addPharmacist();
                    case "19" -> editPharmacist();
                    case "20" -> deletePharmacist();
                    case "21" -> printBloodBank();
                    case "22" -> bloodBankSection();
                    case "23" -> viewAllAppointments();
                    case "24" -> viewDetailedReports();
                    case "25" -> newFeaturesSection();
                    case "26" -> {
                        saveData();
                    }
                    case "27" -> {
                        if (loadData()) 
                        {
                            System.out.println("Data loaded successfully!");
                        } 
                        else 
                        {
                            System.out.println("No saved data found or using sample data.");
                        }
                    }
                    case "28" -> { 
                        return; 
                    }
                    default -> System.out.println("Invalid Choice!");
                }
            } 
            catch (NumberFormatException e) 
            {
                System.err.println("Number format error: " + e.getMessage());
            } 
            catch (Exception e) 
            {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    
    // PATIENT LOGIN
    static void patientLogin() 
    {
        System.out.print("\nEnter Patient ID: ");
        String id = readLine();
        
        System.out.print("Enter Birthdate (YYYY-MM-DD): ");
        String dob = readLine();
        
        // CHECKING CREDENTIALS AGAINST THE LIST OF PATIENTS AND GRANTING ACCESS TO DASHBOARD IF VALID, OTHERWISE THROWING CUSTOM EXCEPTION
        try 
        {
            Patient patient = findPatientById(id);
            if (patient != null && patient.getBirthdate().equals(dob)) 
            {
                System.out.println("\nWELCOME " + patient.getName().toUpperCase() + "!");
                patientDashboard(patient);
            } 
            else 
            {
                throw new PatientNotFoundException("Patient not found with ID: " + id);
            }
        } 
        catch (PatientNotFoundException e) 
        {
            System.out.println("Invalid Credentials! " + e.getMessage());
        }
    }
    
    // DOCTOR LOGIN
    static void doctorLogin() 
    {
        System.out.print("\nEnter Doctor ID: ");
        String id = readLine();
        
        System.out.print("Enter Password: ");
        String pass = readLine();

        // CHECKING CREDENTIALS AGAINST THE LIST OF DOCTORS AND GRANTING ACCESS TO DASHBOARD IF VALID
        for(Doctor d: doctors) 
        {
            if(d.getId().equals(id) && d.getPassword().equals(pass)) 
            {
                System.out.println("\nWELCOME " + d.getName().toUpperCase() + "!");
                doctorDashboard(d);
                return;
            }
        }
        System.out.println("Invalid Credentials!");
    }
    
    // NURSE LOGIN
    static void nurseLogin() 
    {
        System.out.print("\nEnter Nurse ID: ");
        String id = readLine();
        
        System.out.print("Enter Password: ");
        String pass = readLine();
        
        // CHECKING CREDENTIALS AGAINST THE LIST OF NURSES AND GRANTING ACCESS TO DASHBOARD IF VALID
        for(Nurse n: nurses) 
        {
            if(n.getId().equals(id) && n.getPassword().equals(pass)) 
            {
                System.out.println("\nWELCOME NURSE " + n.getName().toUpperCase() + "!");
                nurseDashboard(n);
                return;
            }
        }
        System.out.println("Invalid Credentials!");
    }
    
    // RECEPTIONIST LOGIN
    static void receptionistLogin()
    {
        System.out.print("\nEnter Receptionist ID: ");
        String id = readLine();
        
        System.out.print("Enter Password: ");
        String pass = readLine();
        
        // CHECKING CREDENTIALS AGAINST THE LIST OF RECEPTIONISTS AND GRANTING ACCESS TO DASHBOARD IF VALID
        for(Receptionist r: receptionists) 
        {
            if(r.getId().equals(id) && r.getPassword().equals(pass)) 
            {
                System.out.println("\nWELCOME RECEPTIONIST " + r.getName().toUpperCase() + "!");
                receptionistDashboard(r);
                return;
            }
        }
        System.out.println("Invalid Credentials!");
    }
    
    // PHARMACIST LOGIN
    static void pharmacistLogin() 
    {
        System.out.print("\nEnter Pharmacist ID: ");
        String id = readLine();
        
        System.out.print("Enter Password: ");
        String pass = readLine();
        
        // CHECKING CREDENTIALS AGAINST THE LIST OF PHARMACISTS AND GRANTING ACCESS TO DASHBOARD IF VALID
        for(Pharmacist p: pharmacists) 
        {
            if(p.getId().equals(id) && p.getPassword().equals(pass)) 
            {
                System.out.println("\nWELCOME PHARMACIST " + p.getName().toUpperCase() + "!");
                pharmacistDashboard(p);
                return;
            }
        }
        System.out.println("Invalid Credentials!");
    }
    
    // PATIENT DASHBOARD
    static void patientDashboard(Patient patient) 
    {
        while(true) 
        {
            System.out.println("\n--------------------------");
            System.out.println("      PATIENT DASHBOARD");
            System.out.println("1. View My Details");
            System.out.println("2. View Appointments");
            System.out.println("3. View Medical Records");
            System.out.println("4. View Bill");
            System.out.println("5. Logout");
            System.out.println("----------------------------");
            
            System.out.print("Enter choice: ");
            String choice = readLine();
            
            switch(choice) 
            {
                case "1":
                    displayPatientDetails(patient);
                    break;
                case "2":
                    viewPatientAppointments(patient.getId());
                    break;
                case "3":
                    viewMedicalRecords(patient);
                    break;
                case "4":
                    System.out.println("\nCurrent Bill: Rs." + patient.getBill());
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
    
    // DOCTOR DASHBOARD
    static void doctorDashboard(Doctor doctor) 
    {
        while(true) 
        {
            System.out.println("\n--------------------------");
            System.out.println("      DOCTOR DASHBOARD");
            System.out.println("1. View My Patients");
            System.out.println("2. View Appointments");
            System.out.println("3. Prescribe Medicine");
            System.out.println("4. Update Patient Status");
            System.out.println("5. View My Details");
            System.out.println("6. Logout");
            System.out.println("--------------------------");
            
            System.out.print("Enter choice: ");
            String choice = readLine();
            
            switch(choice) 
            {
                case "1":
                    viewDoctorPatients(doctor.getId());
                    break;
                case "2":
                    viewDoctorAppointments(doctor.getId());
                    break;
                case "3":
                    try 
                    {
                        prescribeMedicine(doctor.getId());
                    } 
                    catch (PatientNotFoundException e) 
                    {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "4":
                    try 
                    {
                        updatePatientStatus(doctor.getId());
                    } 
                    catch (PatientNotFoundException e) 
                    {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "5":
                    displayDoctorDetails(doctor);
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
    
    // NURSE DASHBOARD
    static void nurseDashboard(Nurse nurse) 
    {
        while(true) 
        {
            System.out.println("\n------------------------------------");
            System.out.println("           NURSE DASHBOARD");
            System.out.println("1. View Assigned Doctor's Patients");
            System.out.println("2. Update Vitals");
            System.out.println("3. View My Details");
            System.out.println("4. Logout");
            System.out.println("--------------------------------------");
           
            System.out.print("Enter choice: ");
            String choice = readLine();
           
            switch(choice) 
            {
                case "1":
                    viewDoctorPatients(nurse.getAssistingDoctorId());
                    break;
                case "2":
                    updatePatientVitals();
                    break;
                case "3":
                    displayNurseDetails(nurse);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
    
    // RECEPTIONIST DASHBOARD
    static void receptionistDashboard(Receptionist receptionist) 
    {
        while(true) 
        {
            System.out.println("\n------------------------------------");
            System.out.println("           RECEPTIONIST DASHBOARD");
            System.out.println("1. Register New Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View All Patients");
            System.out.println("4. View Appointments");
            System.out.println("5. Process Payment");
            System.out.println("6. View My Details");
            System.out.println("7. Logout");
            System.out.println("--------------------------------------");
           
            System.out.print("Enter choice: ");
            String choice = readLine();
           
            switch(choice) 
            {
                case "1":
                    registerPatient();
                    break;
                case "2":
                    scheduleAppointment();
                    break;
                case "3":
                    viewPatients();
                    break;
                case "4":
                    viewAllAppointments();
                    break;
                case "5":
                    processPayment();
                    break;
                case "6":
                    displayReceptionistDetails(receptionist);
                    break;
                case "7":
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
    
    // PHARMACIST DASHBOARD
    static void pharmacistDashboard(Pharmacist pharmacist) 
    {
        while(true) 
        {
            System.out.println("\n------------------------------");
            System.out.println("      PHARMACIST DASHBOARD");
            System.out.println("1. View Medicine Stock");
            System.out.println("2. Add Medicine Stock");
            System.out.println("3. View Prescriptions");
            System.out.println("4. Dispense Medicine");
            System.out.println("5. View My Details");
            System.out.println("6. Logout");
            System.out.println("--------------------------------");
            
            System.out.print("Enter choice: ");
            String choice = readLine();
            
            switch(choice) 
            {
                case "1":
                    viewMedicineStock();
                    break;
                case "2":
                    addMedicineStock();
                    break;
                case "3":
                    viewPrescriptions();
                    break;
                case "4":
                    dispenseMedicine();
                    break;
                case "5":
                    displayPharmacistDetails(pharmacist);
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
    
    // VIEWING DOCTOR'S PATIENTS IN A FORMATTED TABLE WITH ALL DETAILS
    static void viewDoctorPatients(String doctorId) 
    {
        System.out.println("\n======================================= MY PATIENTS ===============================================");
        System.out.println("| Patient ID | Name       | Phone      | Status                    | Appointment Date| Bill (Rs.) |");
        System.out.println("===================================================================================================");
        
        boolean found = false;
        
        for(Patient p : patients) 
        {
            if(p.getDoctorId().equals(doctorId)) 
            {
                System.out.printf("| %-10s | %-10s | %-10s | %-25s | %-15s | %-10.0f |\n", 
                    p.getId(), p.getName(), p.getPhone(), truncate(p.getStatus(), 25), 
                    p.getAppointmentDate(), p.getBill());
                found = true;
            }
        }
        
        if(!found) 
        {
            System.out.println("|                                   No patients assigned.                                   |");
        }
        System.out.println("===================================================================================================");
    }
    
    // VIEW DOCTOR'S APPOINTMENTS IN A FORMATTED TABLE WITH PATIENT NAME, DATE, TIME AND STATUS
    static void viewDoctorAppointments(String doctorId) {
        System.out.println("\n==================== APPOINTMENTS ======================");
        System.out.println("| Patient Name    | Date       | Time    | Status      |");
        System.out.println("========================================================");
        boolean found = false;

        // ITERATING THROUGH APPOINTMENTS AND DISPLAYING THOSE THAT BELONG TO THE DOCTOR IN A FORMATTED MANNER
        for(Appointment a : appointments) 
        {
            if(a.getDoctorId().equals(doctorId)) 
            {
                Patient p = findPatientById(a.getPatientId());
                System.out.printf("| %-15s | %-10s | %-7s | %-11s |\n", (p != null ? p.getName() : a.getPatientId()), a.getDate(), a.getTime(), a.getStatus());
                found = true;
            }
        }
        if(!found) 
        {
            System.out.println("|                No appointments scheduled             |");
        }
        System.out.println("========================================================");
    }
    
    // PRESCRIBE MEDICINE TO A PATIENT, UPDATING THE PATIENT'S RECORD AND DECREASING THE STOCK OF THE MEDICINE, WITH ERROR HANDLING FOR INVALID PATIENT ID OR UNASSIGNED PATIENTS
    static void prescribeMedicine(String doctorId) throws PatientNotFoundException 
    {
        System.out.print("\nEnter Patient ID: ");
        String patientId = readLine();
        Patient patient = findPatientById(patientId);
        if(patient == null || !patient.getDoctorId().equals(doctorId)) 
        {
            throw new PatientNotFoundException("Patient not found or not assigned to you!");
        }
        
        System.out.print("Enter Medicine: ");
        String medicine = readLine();
        
        // UPDATING THE PATIENT'S MEDICINE RECORD IN A FORMATTED MANNER, HANDLING CASES WHERE THERE ARE NO PREVIOUS MEDICINES OR MULTIPLE MEDICINES
        StringBuffer medBuffer = new StringBuffer();
        if(patient.getMedicines().equals("-") || patient.getMedicines().isEmpty()) 
        {
            medBuffer.append(medicine);
        } 
        else 
        {
            medBuffer.append(patient.getMedicines()).append(", ").append(medicine);
        }
        patient.setMedicines(medBuffer.toString());
        
        // DECREASING THE STOCK OF THE PRESCRIBED MEDICINE AND HANDLING CASES WHERE THE MEDICINE IS NOT IN STOCK
        if(medicineStock.containsKey(medicine)) 
        {
            int currentStock = medicineStock.get(medicine);
            if(currentStock > 0) 
            {
                medicineStock.put(medicine, currentStock - 1);
            } 
            else 
            {
                System.out.println("Medicine is out of stock!");
            }
        }
        
        System.out.println("Medicine prescribed successfully!");
    }
    
    // UPDATE MEDICINE STATUS
    static void updatePatientStatus(String doctorId) throws PatientNotFoundException 
    {
        System.out.print("\nEnter Patient ID: ");
        String patientId = readLine();    
        Patient patient = findPatientById(patientId);
        if(patient == null || !patient.getDoctorId().equals(doctorId)) 
        {
            throw new PatientNotFoundException("Patient not found or not assigned to you!");
        }
        
        System.out.print("Enter new status: ");
        patient.setStatus(readLine());
        
        System.out.println("Status updated successfully!");
    }
    
    // UPDATE PATIENT VITALS
    static void updatePatientVitals() 
    {
        System.out.print("\nEnter Patient ID: ");
        String patientId = readLine();    
        Patient patient = findPatientById(patientId);
        if(patient == null) 
        {
            System.out.println("Patient not found!");
            return;
        }
        
        System.out.print("Enter Blood Pressure: ");
        String bp = readLine();
        
        System.out.print("Enter Temperature: ");
        String temp = readLine();
        
        System.out.print("Enter Heart Rate: ");
        String hr = readLine();
        
        StringBuilder vitalsBuilder = new StringBuilder();
        vitalsBuilder.append("BP: ").append(bp)
                    .append(", Temp: ").append(temp)
                    .append(", HR: ").append(hr)
                    .append(" | Date: ").append(getCurrentDateTime());
        
        String vitals = vitalsBuilder.toString();
        patient.getMedicalRecords().add(vitals);
        
        System.out.println("Vitals updated successfully!");
    }
    
    // REGISTER PATIENT
    static void registerPatient() 
    {
        System.out.println("\n-------- REGISTER NEW PATIENT --------");    
        System.out.print("Patient ID: ");
        String id = readLine();
        
        System.out.print("Name: ");
        String name = readLine();
        
        System.out.print("Birthdate (YYYY-MM-DD): ");
        String birth = readLine();
        
        System.out.print("Phone: ");
        String phone = readLine();
        
        System.out.print("Type (Regular/Occasional): ");
        String type = readLine();
        
        System.out.print("Category (Inpatient/Outpatient): ");
        String category = readLine();
        
        System.out.print("Doctor ID: ");
        String did = readLine();
        Doctor doctor = findDoctorById(did);
        String doctorName = (doctor != null) ? doctor.getName() : "Unknown";
        
        Patient newPatient = new Patient(id, name, birth, phone, type, category,  "New Patient", getCurrentDate(), "None", "-", 0, did, doctorName);
        patients.add(newPatient);
        
        System.out.println("Patient registered successfully!");
        displayPatientDetails(newPatient);
    }
    
    // SCHEDULE APPOINTMENT WITH ERROR HANDLING FOR INVALID PATIENT OR DOCTOR IDS, AND DISPLAYING THE SCHEDULED APPOINTMENT DETAILS IN A FORMATTED MANNER
    static void scheduleAppointment() 
    {
        System.out.println("\n-------- SCHEDULE APPOINTMENT --------");    
        System.out.print("Patient ID: ");
        String patientId = readLine();
        Patient patient = findPatientById(patientId);
        if(patient == null) 
        {
            System.out.println("Patient not found!");
            return;
        }
       
        System.out.print("Doctor ID: ");
        String doctorId = readLine();
        Doctor doctor = findDoctorById(doctorId);
        if(doctor == null) 
        {
            System.out.println("Doctor not found!");
            return;
        }
        
        System.out.print("Date (YYYY-MM-DD): ");
        String date = readLine();
        
        System.out.print("Time (HH:MM): ");
        String time = readLine();
        
        Appointment appointment = new Appointment(patientId, doctorId, date, time, "Scheduled");
        appointments.add(appointment);
        patient.setAppointmentDate(date);
        
        System.out.println("Appointment scheduled successfully!\n");
        
        System.out.println("Patient: " + patient.getName() + " | Doctor: " + doctor.getName() + " | Date: " + date + " | Time: " + time);
    }
    
    // VIEW ALL APPOINTMENTS
    static void viewAllAppointments() 
    {
        System.out.println("\n=============================== ALL APPOINTMENTS =========================");
        System.out.println("| Patient Name    | Doctor Name     | Date       | Time    | Status      |");
        System.out.println("==========================================================================");
        if(appointments.isEmpty()) 
        {
            System.out.println("|                      No appointments scheduled.                        |");
        } 
        else 
        {
            // ITERATING THROUGH ALL APPOINTMENTS AND DISPLAYING THEM IN A FORMATTED MANNER WITH PATIENT NAME, DOCTOR NAME, DATE, TIME AND STATUS
            for(Appointment a : appointments) 
            {
                Patient p = findPatientById(a.getPatientId());
                Doctor d = findDoctorById(a.getDoctorId());
                System.out.printf("| %-15s | %-15s | %-10s | %-7s | %-11s |\n", (p != null ? p.getName() : a.getPatientId()), (d != null ? d.getName() : a.getDoctorId()), 
                    a.getDate(), a.getTime(), a.getStatus());
            }
        }
        System.out.println("==========================================================================");
    }
    
    // PROCESS PAYMENT
    static void processPayment() 
    {
        System.out.print("\nEnter Patient ID: ");
        String patientId = readLine();    
        Patient patient = findPatientById(patientId);
        if(patient == null) 
        {
            System.out.println("Patient not found!");
            return;
        }
        
        try
        {
            System.out.println("Current Bill: Rs." + patient.getBill());
            System.out.print("Enter amount to pay: Rs.");
            double payment = Double.parseDouble(readLine());
            if(payment > patient.getBill()) 
            {
                System.out.println("Payment exceeds bill amount!");
                return;
            }
            patient.setBill(patient.getBill() - payment);
            
            System.out.println("Payment successful! Remaining bill: Rs." + patient.getBill());
        } 
        catch (NumberFormatException e) 
        {
            System.err.println("Invalid payment amount! " + e.getMessage());
        }
    }
    
    // ADD MEDICINE STOCK
    static void addMedicineStock() 
    {
        System.out.print("\nEnter Medicine Name: ");
        String med = readLine();    
        
        try 
        {
            System.out.print("Enter Quantity to Add: ");
            int qty = Integer.parseInt(readLine());
            if(medicineStock.containsKey(med)) 
            {
                medicineStock.put(med, medicineStock.get(med) + qty);
            } 
            else 
            {
                medicineStock.put(med, qty);
            }
            
            System.out.println("Stock updated successfully!");
            viewMedicineStock();
        } 
        catch (NumberFormatException e) 
        {
            System.err.println("Invalid quantity! " + e.getMessage());
        }
    }
    
    // VIEWING PRESCRIPTIONS IN A FORMATTED TABLE WITH PATIENT NAME, DOCTOR NAME, MEDICINES AND DATE, HANDLING CASES WHERE THERE ARE NO PRESCRIPTIONS
    static void viewPrescriptions() 
    {
        System.out.println("\n=============================== PRESCRIPTIONS ====================================");
        System.out.println("| Patient Name    | Doctor Name     | Medicines                     | Date       |");
        System.out.println("==================================================================================");
        
        boolean found = false;
        
        for(Patient p : patients)
        {
            if(p.getMedicines() != null && !p.getMedicines().equals("-") && !p.getMedicines().isEmpty()) 
            {
                System.out.printf("| %-15s | %-15s | %-29s | %-10s |\n", p.getName(), p.getDoctorName(), truncate(p.getMedicines(), 29), p.getAppointmentDate());
                found = true;
            }
        }
        
        if(!found) 
        {
            System.out.println("|                              No prescriptions found.                              |");
        }
        System.out.println("==================================================================================");
    }
    
    // DISPENSE MEDICINE TO A PATIENT AND UPDATE STOCK, WITH ERROR HANDLING FOR INVALID PATIENT ID, UNASSIGNED PATIENTS OR CASES WHERE THERE ARE NO PRESCRIBED MEDICINES
    static void dispenseMedicine() 
    {
        System.out.print("\nEnter Patient ID: ");
        String patientId = readLine();    
        Patient patient = findPatientById(patientId);
        if(patient == null) 
        {
            System.out.println("Patient not found!");
            return;
        }
        if(patient.getMedicines() == null || patient.getMedicines().equals("-") || patient.getMedicines().isEmpty()) 
        {
            System.out.println("No medicines prescribed for this patient.");
            return;
        }
        
        System.out.println("Prescribed Medicines: " + patient.getMedicines());
        
        System.out.print("Dispense all medicines? (yes/no): ");
        if(readLine().equalsIgnoreCase("yes")) 
        {
            String[] meds = patient.getMedicines().split(", ");
            for(String med : meds) 
            {
                if(medicineStock.containsKey(med)) 
                {
                    medicineStock.put(med, medicineStock.get(med) - 1);
                }
            }
            
            System.out.println("Medicines dispensed successfully!");
        }
    }
    
    // VIEWING PATIENTS IN A FORMATTED TABLE WITH ALL DETAILS INCLUDING APPOINTMENT DATE, FOLLOW-UP/ STAY INFO, WARD NUMBER FOR INPATIENTS, MEDICINES, BILL AMOUNT AND DOCTOR DETAILS, HANDLING CASES WHERE THERE ARE NO PATIENTS OR CERTAIN FIELDS ARE NOT APPLICABLE
    static void viewPatients() 
    {
        System.out.println("\n=====================================================================================================================================================================================================================================");
        System.out.println("| Patient ID | Name       | Phone        | Type       | Category    | Status                   | Appointment Date  | Follow-up/Stay         | Ward No         | Medicines                 | Payment (Rs.) | Doctor ID | Doctor Name |");
        System.out.println("=====================================================================================================================================================================================================================================");
        
        if(patients.isEmpty())
        {
            System.out.println("| No patients available.                                                                                                                                           |");
        }
        for (Patient p : patients) 
        {
            String wardNo = p.getWard() != null ? p.getWard() : "-";
            String followUpStay = p.getFollowUp();
            String medicines = p.getMedicines();
            
            System.out.printf("| %-10s | %-10s | %-12s | %-10s | %-10s | %-25s | %-17s | %-22s | %-15s | %-25s | %-13.0f | %-9s | %-11s |\n",
                    p.getId(), p.getName(), p.getPhone(), p.getType(), p.getCategory(), truncate(p.getStatus(), 25), p.getAppointmentDate(),
                    truncate(followUpStay, 22), wardNo, truncate(medicines, 25), p.getBill(), p.getDoctorId(), truncate(p.getDoctorName(), 11));
        }
        System.out.println("=====================================================================================================================================================================================================================================");
    }
    
    // CREATE PATIENT
    static void createPatient() 
    {
        System.out.println("\n-------- CREATE NEW PATIENT --------");
        System.out.print("Patient ID: ");
        String id = readLine();
        
        System.out.print("Name: ");
        String name = readLine();
        
        System.out.print("Birthdate (YYYY-MM-DD): ");
        String birth = readLine();
        
        System.out.print("Phone: ");
        String phone = readLine();
        
        System.out.print("Type (Regular/Occasional): ");
        String type = readLine();
        
        System.out.print("Category (Inpatient/Outpatient): ");
        String category = readLine();
        
        System.out.print("Status: ");
        String status = readLine();
        
        System.out.print("Appointment Date (YYYY-MM-DD): ");
        String appDate = readLine();
        
        System.out.print("Follow-up/Stay Info: ");
        String followUp = readLine();
        
        System.out.print("Medicines: ");
        String medicines = readLine();
        
        try 
        {
            System.out.print("Bill Amount (Rs.): ");
            double bill = Double.parseDouble(readLine());
            
            System.out.print("Doctor ID: ");
            String did = readLine();
            Doctor doctor = findDoctorById(did);
            String doctorName = (doctor != null) ? doctor.getName() : "Unknown";
            
            Patient newPatient = new Patient(id, name, birth, phone, type, category, status, appDate, followUp, medicines, bill, did, doctorName);
            
            // ADDIONAL FIELDS FOR INPATIENTS
            if (category.equalsIgnoreCase("Inpatient")) 
            {
                System.out.print("Ward Number: ");
                newPatient.setWard(readLine());
                System.out.print("Admission Date (YYYY-MM-DD): ");
                newPatient.setAdmissionDate(readLine());
            }
            
            // FOR OCCASSIONAL OUTPATIENTS
            if (type.equalsIgnoreCase("Occasional")) 
            {
                System.out.print("Last Visit Date (YYYY-MM-DD): ");
                newPatient.setLastVisit(readLine());
                System.out.print("Token Number: ");
                newPatient.setToken(readLine());
            }
            
            patients.add(newPatient);
            
            System.out.println("Patient Added Successfully!");
            displayPatientDetails(newPatient);
        } 
        catch (NumberFormatException e) 
        {
            System.err.println("Invalid bill amount! " + e.getMessage());
        }
    }
    
    // EDIT PATIENT
    static void editPatient() 
    {
        System.out.print("Enter Patient ID to edit: ");
        String id = readLine();
        for (Patient p : patients) 
        {
            if (p.getId().equals(id)) 
            {
                System.out.println("\nEditing Patient: " + p.getName());
                System.out.println("(Press Enter to keep current value)");    
                
                System.out.print("New Name [" + p.getName() + "]: ");
                String name = readLine();
                if(!name.isEmpty()) 
                    p.setName(name);
                
                System.out.print("New Birthdate [" + p.getBirthdate() + "]: ");
                String birth = readLine();
                if(!birth.isEmpty()) 
                    p.setBirthdate(birth);
                
                System.out.print("New Phone [" + p.getPhone() + "]: ");
                String phone = readLine();
                if(!phone.isEmpty()) 
                    p.setPhone(phone);
                
                System.out.print("New Status [" + p.getStatus() + "]: ");
                String status = readLine();
                if(!status.isEmpty()) 
                    p.setStatus(status);
                
                System.out.print("New Medicines [" + p.getMedicines() + "]: ");
                String medicines = readLine();
                if(!medicines.isEmpty()) 
                    p.setMedicines(medicines);
                
                System.out.print("New Bill Amount [" + p.getBill() + "]: Rs.");
                String billStr = readLine();
                if(!billStr.isEmpty()) 
                {
                    try 
                    {
                        p.setBill(Double.parseDouble(billStr));
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.err.println("Invalid bill amount!");
                    }
                }
                
                // EDIT CATEGORY-SPECIFIC FIELDS
                if (p.getCategory().equalsIgnoreCase("Inpatient"))
                {
                    System.out.print("New Ward [" + (p.getWard() != null ? p.getWard() : "-") + "]: ");
                    String ward = readLine();
                    if(!ward.isEmpty()) 
                        p.setWard(ward);
                    
                    System.out.print("New Admission Date [" + (p.getAdmissionDate() != null ? p.getAdmissionDate() : "-") + "]: ");
                    String admDate = readLine();
                    if(!admDate.isEmpty()) 
                        p.setAdmissionDate(admDate);
                }
                
                if (p.getType().equalsIgnoreCase("Occasional")) 
                {
                    System.out.print("New Last Visit [" + (p.getLastVisit() != null ? p.getLastVisit() : "-") + "]: ");
                    String lastVisit = readLine();
                    if(!lastVisit.isEmpty()) 
                        p.setLastVisit(lastVisit);
                    
                    System.out.print("New Token [" + (p.getToken() != null ? p.getToken() : "1") + "]: ");
                    String token = readLine();
                    if(!token.isEmpty()) 
                        p.setToken(token);
                }
                
                System.out.println("Patient Updated Successfully!");
                displayPatientDetails(p);
                return;
            }
        }
        System.out.println("Patient Not Found!");
    }
    
    // DELETE PATIENT
    static void deletePatient() 
    {
        System.out.print("Enter Patient ID to delete: ");
        String id = readLine();
        Patient patient = findPatientById(id);
        if(patient != null) 
        {
            System.out.print("Are you sure you want to delete " + patient.getName() + "? (yes/no): ");
            if(readLine().equalsIgnoreCase("yes")) 
            {
                patients.remove(patient);
                System.out.println("Patient Deleted Successfully!");
            } 
            else 
            {
                System.out.println("Deletion cancelled.");
            }
        } 
        else 
        {
            System.out.println("Patient Not Found!");
        }
    }
    
    // VIEW DOCTORS
    static void viewDoctors() 
    {
        System.out.println("\n==============================================================================");
        System.out.println("| Doctor ID | Name           | Specialization    | Experience | Salary (Rs.) |");
        System.out.println("==============================================================================");
        for (Doctor d : doctors) 
        {
            System.out.printf("| %-9s | %-14s | %-17s | %-10d | Rs.%-9.0f |\n", d.getId(), d.getName(), d.getSpecialization(), d.getExperience(), d.getSalary());
        }
        System.out.println("==============================================================================");
    }
    
    // ADD DOCTOR
    static void addDoctor() 
    {
        System.out.println("\n-------- ADD NEW DOCTOR --------");
        System.out.print("Doctor ID: ");
        String id = readLine();
        
        System.out.print("Name: ");
        String name = readLine();
        
        System.out.print("Password: ");
        String pass = readLine();
        
        System.out.print("Specialization: ");
        String spec = readLine();
        
        try 
        {
            System.out.print("Salary (Rs.): ");
            double salary = Double.parseDouble(readLine());
            
            System.out.print("Phone: ");
            String phone = readLine();
            
            System.out.print("Date of Joining (YYYY-MM-DD): ");
            String doj = readLine();
            
            doctors.add(new Doctor(id, name, pass, spec, salary, phone, doj));
            System.out.println("Doctor Added Successfully!");
        } 
        catch (NumberFormatException e) 
        {
            System.err.println("Invalid salary! " + e.getMessage());
        }
    }
    
    // EDIT DOCTOR
    static void editDoctor() 
    {
        System.out.print("Enter Doctor ID to edit: ");
        String id = readLine();
        for (Doctor d : doctors) 
        {
            if (d.getId().equals(id)) 
            {
                System.out.println("\nEditing Doctor: " + d.getName());
                System.out.println("(Press Enter to keep current value)");
                
                System.out.print("New Name [" + d.getName() + "]: ");
                String name = readLine();
                if(!name.isEmpty()) 
                    d.setName(name);
                
                System.out.print("New Specialization [" + d.getSpecialization() + "]: ");
                String spec = readLine();
                if(!spec.isEmpty()) 
                    d.setSpecialization(spec);
                
                System.out.print("New Salary [" + d.getSalary() + "]: Rs.");
                String salary = readLine();
                if(!salary.isEmpty()) 
                {
                    try 
                    {
                        d.setSalary(Double.parseDouble(salary));
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.err.println("Invalid salary!");
                    }
                }
                
                System.out.print("New Phone [" + d.getPhone() + "]: ");
                String phone = readLine();
                if(!phone.isEmpty()) 
                    d.setPhone(phone);
                
                System.out.println("Doctor Updated Successfully!");
                return;
            }
        }
        System.out.println("Doctor Not Found!");
    }
    
    // DELETE DOCTOR
    static void deleteDoctor() 
    {
        System.out.print("Enter Doctor ID to delete: ");
        String id = readLine();
        Doctor doctor = findDoctorById(id);
        if(doctor != null) 
        {
            System.out.print("Are you sure you want to delete Dr. " + doctor.getName() + "? (yes/no): ");
            if(readLine().equalsIgnoreCase("yes")) 
            {
                doctors.remove(doctor);
                System.out.println("Doctor Deleted Successfully!");
            }
        } 
        else 
        {
            System.out.println("Doctor Not Found!");
        }
    }
    
    // VIEW NURSES
    static void viewNurses() 
    {
        System.out.println("\n==============================================================");
        System.out.println("| Nurse ID | Name       | Assisting Doctor ID | Salary (Rs.) |");
        System.out.println("==============================================================");
        for (Nurse n : nurses) 
        {
            System.out.printf("| %-8s | %-10s | %-19s | Rs.%-9.0f |\n", n.getId(), n.getName(), n.getAssistingDoctorId(), n.getSalary());
        }
        System.out.println("==============================================================");
    }
    
    // ADD NURSE
    static void addNurse() 
    {
        System.out.println("\n-------- ADD NEW NURSE --------");
        System.out.print("Nurse ID: ");
        String id = readLine();
        
        System.out.print("Name: ");
        String name = readLine();
        
        System.out.print("Password: ");
        String pass = readLine();
        
        System.out.print("Assisting Doctor ID: ");
        String docId = readLine();
        
        try 
        {
            System.out.print("Salary (Rs.): ");
            double salary = Double.parseDouble(readLine());
            nurses.add(new Nurse(id, name, pass, docId, salary));
            System.out.println("Nurse Added Successfully!");
        } 
        catch (NumberFormatException e) 
        {
            System.err.println("Invalid salary! " + e.getMessage());
        }
    }
    
    // EDIT NURSE
    static void editNurse() 
    {
        System.out.print("Enter Nurse ID to edit: ");
        String id = readLine();
        for (Nurse n : nurses) 
        {
            if (n.getId().equals(id)) 
            {
                System.out.println("\nEditing Nurse: " + n.getName());
                System.out.println("(Press Enter to keep current value)");    
                
                System.out.print("New Name [" + n.getName() + "]: ");
                String name = readLine();
                if(!name.isEmpty()) 
                    n.setName(name);
                
                System.out.print("New Assisting Doctor ID [" + n.getAssistingDoctorId() + "]: ");
                String docId = readLine();
                if(!docId.isEmpty()) 
                    n.setAssistingDoctorId(docId);
                
                System.out.print("New Salary [" + n.getSalary() + "]: Rs.");
                String salary = readLine();
                if(!salary.isEmpty()) 
                {
                    try 
                    {
                        n.setSalary(Double.parseDouble(salary));
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.err.println("Invalid salary!");
                    }
                }
                
                System.out.println("Nurse Updated Successfully!");
                return;
            }
        }
        System.out.println("Nurse Not Found!");
    }
    
    // DELETE NURSE
    static void deleteNurse() 
    {
        System.out.print("Enter Nurse ID to delete: ");
        String id = readLine();
        Nurse nurse = findNurseById(id);
        if(nurse != null) 
        { 
            System.out.print("Are you sure you want to delete Nurse " + nurse.getName() + "? (yes/no): ");
            if(readLine().equalsIgnoreCase("yes")) 
            {
                nurses.remove(nurse);
                System.out.println("Nurse Deleted Successfully!");
            }
        } 
        else 
        {
            System.out.println("Nurse Not Found!");
        }
    }
    
    // VIEW RECEPTIONISTS
    static void viewReceptionists() 
    {
        System.out.println("\n===============================================");
        System.out.println("| Receptionist ID | Name       | Salary (Rs.) |");
        System.out.println("===============================================");
        for (Receptionist r : receptionists) 
        {
            System.out.printf("| %-15s | %-10s | Rs.%-9.0f |\n", r.getId(), r.getName(), r.getSalary());
        }
        System.out.println("===============================================");
    }
    
    // ADD RECEPTIONIST
    static void addReceptionist() 
    {
        System.out.println("\n-------- ADD NEW RECEPTIONIST --------");
        
        System.out.print("Receptionist ID: ");
        String id = readLine();
        
        System.out.print("Name: ");
        String name = readLine();
        
        System.out.print("Password: ");
        String pass = readLine();
        
        try 
        {
            System.out.print("Salary (Rs.): ");
            double salary = Double.parseDouble(readLine());
            receptionists.add(new Receptionist(id, name, pass, salary));
            System.out.println("Receptionist Added Successfully!");
        } 
        catch (NumberFormatException e) 
        {
            System.err.println("Invalid salary! " + e.getMessage());
        }
    }
    
    // EDIT RECEPTIONIST
    static void editReceptionist() 
    {
        System.out.print("Enter Receptionist ID to edit: ");
        String id = readLine();
        for (Receptionist r : receptionists) 
        {
            if (r.getId().equals(id)) 
            {
                System.out.println("\nEditing Receptionist: " + r.getName());
                System.out.println("(Press Enter to keep current value)");    
                
                System.out.print("New Name [" + r.getName() + "]: ");
                String name = readLine();
                if(!name.isEmpty()) 
                    r.setName(name);
                
                System.out.print("New Salary [" + r.getSalary() + "]: Rs.");
                String salary = readLine();
                if(!salary.isEmpty()) 
                {
                    try 
                    {
                        r.setSalary(Double.parseDouble(salary));
                    } 
                    catch (NumberFormatException e) 
                    {
                        System.err.println("Invalid salary!");
                    }
                }
                System.out.println("Receptionist Updated Successfully!");
                return;
            }
        }
        System.out.println("Receptionist Not Found!");
    }
    
    // DELETE RECEPTIONIST
    static void deleteReceptionist() 
    {
        System.out.print("Enter Receptionist ID to delete: ");
        String id = readLine();
        Receptionist receptionist = findReceptionistById(id);
        if(receptionist != null) 
        {
            System.out.print("Are you sure you want to delete Receptionist " + receptionist.getName() + "? (yes/no): ");
            if(readLine().equalsIgnoreCase("yes")) 
            {
                receptionists.remove(receptionist);
                System.out.println("Receptionist Deleted Successfully!");
            }
        } 
        else 
        {
            System.out.println("Receptionist Not Found!");
        }
    }
    
    // VIEW PHARMACIST
    static void viewPharmacists() 
    {
        System.out.println("\n=============================");
        System.out.println("| Pharmacist ID | Name      |");
        System.out.println("=============================");
        for (Pharmacist p : pharmacists) 
        {
            System.out.printf("| %-13s | %-9s |\n", p.getId(), p.getName());
        }
        System.out.println("=============================");
    }
    
    // ADD PHARMACIST
    static void addPharmacist() 
    {
        System.out.println("\n-------- ADD NEW PHARMACIST --------");
        System.out.print("Pharmacist ID: ");
        String id = readLine();
        
        System.out.print("Name: ");
        String name = readLine();
        
        System.out.print("Password: ");
        String pass = readLine();
        pharmacists.add(new Pharmacist(id, name, pass));
        
        System.out.println("Pharmacist Added Successfully!");
    }
    
    // EDIT PHARMACIST
    static void editPharmacist() 
    {
        System.out.print("Enter Pharmacist ID to edit: ");
        String id = readLine();
        for (Pharmacist p : pharmacists) 
        {
            if (p.getId().equals(id))
            {
                System.out.println("\nEditing Pharmacist: " + p.getName());
                System.out.println("(Press Enter to keep current value)");
                
                System.out.print("New Name [" + p.getName() + "]: ");
                String name = readLine();
                if(!name.isEmpty()) 
                    p.setName(name);
                
                System.out.println("Pharmacist Updated Successfully!");
                return;
            }
        }
        System.out.println("Pharmacist Not Found!");
    }
    
    // DELETE PHARMACIST
    static void deletePharmacist() 
    {
        System.out.print("Enter Pharmacist ID to delete: ");
        String id = readLine();
        Pharmacist pharmacist = findPharmacistById(id);
        if(pharmacist != null) 
        {
            System.out.print("Are you sure you want to delete Pharmacist " + pharmacist.getName() + "? (yes/no): ");
            if(readLine().equalsIgnoreCase("yes")) 
            {
                pharmacists.remove(pharmacist);
                System.out.println("Pharmacist Deleted Successfully!");
            }
        } else {
            System.out.println("Pharmacist Not Found!");
        }
    }
    
    // BLOOD BANK SECTION
    static void bloodBankSection() 
    {
        printBloodBank();
        System.out.println("\n-------- MANAGE BLOOD BANK --------");
        System.out.println("1. Add Blood Units");
        System.out.println("2. Remove Blood Units");
        System.out.println("3. Update Blood Units");
        
        System.out.print("Enter choice: ");
        String choice = readLine();
        
        System.out.print("Enter Blood Group: ");
        String group = readLine().toUpperCase();
        
        try 
        {
            switch(choice) 
            {
                case "1":
                    System.out.print("Enter Units to Add: ");
                    int addUnits = Integer.parseInt(readLine());
                    bloodBank.put(group, bloodBank.getOrDefault(group, 0) + addUnits);
                    System.out.println("Blood units added successfully!");
                    break;        
                case "2":
                    System.out.print("Enter Units to Remove: ");
                    int removeUnits = Integer.parseInt(readLine());
                    if(bloodBank.containsKey(group) && bloodBank.get(group) >= removeUnits) 
                    { 
                        bloodBank.put(group, bloodBank.get(group) - removeUnits);
                        System.out.println("Blood units removed successfully!");
                    } 
                    else 
                    {
                        System.out.println("Insufficient units!");
                    }
                    break;
                case "3":
                    System.out.print("Enter New Units: ");
                    int newUnits = Integer.parseInt(readLine());
                    bloodBank.put(group, newUnits);
                    System.out.println("Blood bank updated successfully!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } 
        catch (NumberFormatException e)
        {
            System.err.println("Invalid number format! " + e.getMessage());
        }
        printBloodBank();
    }
    
    // PRINT BLOOD BANK
    static void printBloodBank() 
    {
        System.out.println("\n=======================");
        System.out.println("| Blood Group | Units |");
        System.out.println("=======================");
        for (Map.Entry<String,Integer> entry : bloodBank.entrySet()) 
        {
            System.out.printf("| %-11s | %-5d |\n", entry.getKey(), entry.getValue());
        }
        System.out.println("=======================");
    }
    
    // VIEW MEDICINE STOCK
    static void viewMedicineStock() 
    {
        System.out.println("\n============================");
        System.out.println("| Medicine Name    | Stock |");
        System.out.println("============================");
        for (Map.Entry<String,Integer> entry : medicineStock.entrySet()) 
        {
            System.out.printf("| %-16s | %-5d |\n", entry.getKey(), entry.getValue());
        }
        System.out.println("============================");
    }
    
    // VIEW DETAILED REPORTS
    static void viewDetailedReports() 
    {
        StringBuilder report = new StringBuilder();
        
        report.append("\n========== DETAILED REPORTS ==========\n");
        report.append("\n--- Patient Statistics ---\n");
        report.append("Total Patients: ").append(patients.size()).append("\n");
        
        int inpatients = 0, outpatients = 0, regular = 0, occasional = 0;
        for(Patient p : patients) 
        {
            if(p.getCategory().equalsIgnoreCase("Inpatient")) 
                inpatients++;
            else 
                outpatients++;
            
            if(p.getType().equalsIgnoreCase("Regular"))
                regular++;
            else 
                occasional++;
        }
        report.append("Inpatients: ").append(inpatients).append("\n");
        report.append("Outpatients: ").append(outpatients).append("\n");
        report.append("Regular Patients: ").append(regular).append("\n");
        report.append("Occasional Patients: ").append(occasional).append("\n");
        
        double totalRevenue = 0;
        for(Patient p : patients) 
        {
            totalRevenue += p.getBill();
        }
        
        report.append("\n--- Revenue Statistics ---\n");
        report.append("Total Revenue: Rs.").append(totalRevenue).append("\n");
        
        report.append("\n--- Appointment Statistics ---\n");
        report.append("Total Appointments: ").append(appointments.size()).append("\n");
        
        System.out.print(report.toString());
        
        System.out.println("\n--- Blood Bank Status ---");
        printBloodBank();
        System.out.println("\n--- Medicine Stock Status ---");
        viewMedicineStock();
        
        StringBuilder staffReport = new StringBuilder();
        staffReport.append("\n--- Staff Statistics ---\n");
        staffReport.append("Total Doctors: ").append(doctors.size()).append("\n");
        staffReport.append("Total Nurses: ").append(nurses.size()).append("\n");
        staffReport.append("Total Receptionists: ").append(receptionists.size()).append("\n");
        staffReport.append("Total Pharmacists: ").append(pharmacists.size()).append("\n");
        staffReport.append("Total Staff: ").append(doctors.size() + nurses.size() + receptionists.size() + pharmacists.size()).append("\n");
        
        System.out.print(staffReport.toString());
    }
    
    // NEW FEATURES SECTION - COMPREHENSIVE PATIENT JOURNEY TRACKER, MEDICINE STOCK STATUS AND APPOINTMENT SUMMARY
    static void newFeaturesSection() 
    {
        StringBuilder report = new StringBuilder();
        
        report.append("\n=========== PATIENT JOURNEY TRACKER ===========\n");
        
        for (Patient p : patients) 
        {
            report.append("\n-----------------------------------------------\n");
            report.append("Patient ID      : ").append(p.getId()).append("\n");
            report.append("Patient Name    : ").append(p.getName()).append("\n");
            report.append("Doctor Consulted: ").append(p.getDoctorName()).append("\n");
            report.append("Appointment Date: ").append(p.getAppointmentDate()).append("\n");
            report.append("Follow Up       : ").append(p.getFollowUp()).append("\n");
            report.append("Medicines Issued: ").append(p.getMedicines()).append("\n");
            report.append("Bill Paid       : Rs.").append(p.getBill()).append("\n");
            
            if(p.getCategory().equalsIgnoreCase("Inpatient")) 
            {
                report.append("Ward Number     : ").append(p.getWard() != null ? p.getWard() : "-").append("\n");
                report.append("Admission Date  : ").append(p.getAdmissionDate() != null ? p.getAdmissionDate() : "-").append("\n");
            }
            
            if(p.getType().equalsIgnoreCase("Occasional")) 
            {
                report.append("Last Visit      : ").append(p.getLastVisit() != null ? p.getLastVisit() : "-").append("\n");
                report.append("Token Number    : ").append(p.getToken() != null ? p.getToken() : "1").append("\n");
            }
            
            if(!p.getMedicalRecords().isEmpty()) 
            {
                report.append("Medical Records :\n");
                for(String record : p.getMedicalRecords()) 
                {
                    report.append("  - ").append(record).append("\n");
                }
            }
            
            if(!p.getProcedures().isEmpty()) 
            {
                report.append("Procedures      :\n");
                for(String procedure : p.getProcedures()) 
                {
                    report.append("  - ").append(procedure).append("\n");
                }
            }
            report.append("-----------------------------------------------\n");
        }
        
        System.out.print(report.toString());
        
        System.out.println("\n=========== MEDICINE STOCK STATUS ===========");
        viewMedicineStock();
        System.out.println("\n=========== APPOINTMENT SUMMARY ===========");
        viewAllAppointments();
    }
    
    // FIND PATIENT BY ID
    static Patient findPatientById(String id) 
    {
        for(Patient p : patients) 
        {
            if(p.getId().equals(id)) 
                return p;
        }
        return null;
    }
    
    // FIND DOCTOR BY ID
    static Doctor findDoctorById(String id) 
    {
        for(Doctor d : doctors) 
        {
            if(d.getId().equals(id)) 
                return d;
        }
        return null;
    }
    
    // FIND NURSE BY ID 
    static Nurse findNurseById(String id) 
    {
        for(Nurse n : nurses) 
        {
            if(n.getId().equals(id)) 
                return n;
        }
        return null;
    }
    
    // FIND RECEPTIONIST BY ID
    static Receptionist findReceptionistById(String id) 
    {
        for(Receptionist r : receptionists) 
        {
            if(r.getId().equals(id)) 
                return r;
        }
        return null;
    }
    
    // FIND PHARMACIST BY ID
    static Pharmacist findPharmacistById(String id) 
    {
        for(Pharmacist p : pharmacists) 
        {
            if(p.getId().equals(id)) 
                return p;
        }
        return null;
    }
    
    // VIEW PATIENT APPOINTMENTS
    static void viewPatientAppointments(String patientId) 
    {
        System.out.println("\n--- My Appointments ---");
        boolean found = false;
        for(Appointment a : appointments) 
        {
            if(a.getPatientId().equals(patientId)) 
            {
                Doctor d = findDoctorById(a.getDoctorId());
                System.out.println("Date: " + a.getDate() + " | Time: " + a.getTime() + " | Doctor: " + (d != null ? d.getName() : a.getDoctorId()) + " | Status: " + a.getStatus());
                found = true;
            }
        }
        if(!found) 
        {
            System.out.println("No appointments found.");
        }
    }
    
    // VIEW MEDICAL RECORDS
    static void viewMedicalRecords(Patient patient) 
    {
        System.out.println("\n--- Medical Records ---");
        if(patient.getMedicalRecords().isEmpty()) 
        {
            System.out.println("No medical records available.");
        } 
        else 
        {
            for(String record : patient.getMedicalRecords()) 
            {
                System.out.println("- " + record);
            }
        }
        if(!patient.getProcedures().isEmpty()) 
        {
            System.out.println("\n--- Procedures ---");
            for(String procedure : patient.getProcedures()) 
            {
                System.out.println("- " + procedure);
            }
        }
    }
    
    // DISPLAY PATIENT DETAILS
    static void displayPatientDetails(Patient p) 
    {
        System.out.println("\nPATIENT DETAILS");
        System.out.println("Patient ID        : " + p.getId());
        System.out.println("Name              : " + p.getName());
        System.out.println("Birthdate         : " + p.getBirthdate());
        System.out.println("Phone             : " + p.getPhone());
        System.out.println("Type              : " + p.getType());
        System.out.println("Category          : " + p.getCategory());
        System.out.println("Status            : " + p.getStatus());
        System.out.println("Appointment Date  : " + p.getAppointmentDate());
        System.out.println("Follow-up         : " + p.getFollowUp());
        System.out.println("Medicines         : " + p.getMedicines());
        System.out.println("Bill              : Rs." + p.getBill());
        System.out.println("Doctor            : " + p.getDoctorName());
        
        if(p.getCategory().equalsIgnoreCase("Inpatient")) 
        {
            System.out.println("Ward              : " + (p.getWard() != null ? p.getWard() : "-"));
            System.out.println("Admission Date    : " + (p.getAdmissionDate() != null ? p.getAdmissionDate() : "-"));
        }
        
        if(p.getType().equalsIgnoreCase("Occasional")) 
        {
            System.out.println("Last Visit        : " + (p.getLastVisit() != null ? p.getLastVisit() : "-"));
            System.out.println("Token             : " + (p.getToken() != null ? p.getToken() : "1"));
        }
    }
    
    // DISPLAY DOCTOR DETAILS
    static void displayDoctorDetails(Doctor d) 
    {
        System.out.println("\nDOCTOR DETAILS");
        System.out.println("Doctor ID       : " + d.getId());
        System.out.println("Name            : Dr. " + d.getName());
        System.out.println("Specialization  : " + d.getSpecialization());
        System.out.println("Experience      : " + d.getExperience() + " years");
        System.out.println("Phone           : " + d.getPhone());
        System.out.println("Date of Joining : " + d.getDateOfJoining());
        System.out.println("Salary          : Rs." + d.getSalary());
    }
    
    // DISPLAY NURSE DETAILS
    static void displayNurseDetails(Nurse n) 
    {
        System.out.println("\nNURSE DETAILS");
        System.out.println("Nurse ID        : " + n.getId());
        System.out.println("Name            : " + n.getName());
        System.out.println("Assisting Doctor: " + n.getAssistingDoctorId());
        System.out.println("Salary          : Rs." + n.getSalary());
    }
    
    // DISPLAY RECEPTIONIST DETAILS
    static void displayReceptionistDetails(Receptionist r) 
    {
        System.out.println("\nRECEPTIONIST DETAILS");
        System.out.println("Receptionist ID : " + r.getId());
        System.out.println("Name            : " + r.getName());
        System.out.println("Salary          : Rs." + r.getSalary());
    }
    
    // DISPLAY PHARMACIST DETAILS
    static void displayPharmacistDetails(Pharmacist p) 
    {
        System.out.println("\nPHARMACIST DETAILS");
        System.out.println("Pharmacist ID   : " + p.getId());
        System.out.println("Name            : " + p.getName());
    }
    
    // TRUNCATE STRING FOR TABLE DISPLAY
    static String truncate(String str, int length) 
    {
        if(str == null) 
            return "-";
        if(str.length() <= length) 
            return str;
        return str.substring(0, length - 3) + "...";
    }
    
    // GET CURRENT DATE
    static String getCurrentDate() 
    {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}