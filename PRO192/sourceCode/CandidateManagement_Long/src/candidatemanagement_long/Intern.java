package candidatemanagement_long;
/**
 *
 * @author LongDinh
 */
class Intern extends I_Candidate{
    private String graduationDate, education; private int graduationRank;

    public String getGraduationDate() {
        return graduationDate;
    }
    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }
    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
    public int getGraduationRank() {
        return graduationRank;
    }
    public void setGraduationRank(int graduationRank) {
        this.graduationRank = graduationRank;
    }

    public Intern(int candidate_type, String candidate_Id, String first_Name, String last_Name, String address, String email, String birth_Date, int phone, String graduationDate, String education, int graduationRank) {
        super(candidate_type, candidate_Id, first_Name, last_Name, address, email, birth_Date, phone);
        this.graduationDate = graduationDate;
        this.education = education;
        this.graduationRank = graduationRank;
    }

    @Override
    String showInfo() {
        return super.showInfo()+" - \u001B[31mDate of Graduation\u001B[0m: "+this.graduationDate+" - \u001B[31mRank of Graduation\u001B[0m: "+this.graduationRank+" - \u001B[31mEducation\u001B[0m: "+this.education;
    }
    
    @Override
    String Info() {
        return super.Info()+","+this.graduationDate+","+this.graduationRank+","+this.education;
    }
}
