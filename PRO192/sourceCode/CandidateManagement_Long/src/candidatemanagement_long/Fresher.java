package candidatemanagement_long;
/**
 *
 * @author LongDinh
 */
class Fresher extends I_Candidate{
    private String majors, semester, uniname;

    public String getMajors() {
        return majors;
    }
    public void setMajors(String majors) {
        this.majors = majors;
    }
    public String getSemester() {
        return semester;
    }
    public void setSemester(String semester) {
        this.semester = semester;
    }
    public String getUniname() {
        return uniname;
    }
    public void setUniname(String uniname) {
        this.uniname = uniname;
    }

    public Fresher(int candidate_type, String candidate_Id, String first_Name, String last_Name, String address, String email, String birth_Date, int phone, String majors, String semester, String uniname) {
        super(candidate_type, candidate_Id, first_Name, last_Name, address, email, birth_Date, phone);
        this.majors = majors;
        this.semester = semester;
        this.uniname = uniname;
    }


    @Override
    String showInfo() {
        return super.showInfo()+" - \u001B[31mMajor\u001B[0m: "+this.majors+" - \u001B[31mSemester\u001B[0m: "+this.semester+" - \u001B[31mUniversity name\u001B[0m: "+this.uniname;
    }
    @Override
    String Info() {
        return super.Info()+","+this.majors+","+this.semester+","+this.uniname;
    } 
}
