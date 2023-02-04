package candidatemanagement_long;
/**
 *
 * @author LongDinh
 */
class Experience extends I_Candidate{
    private int expInYear; private String proSkill;

    public Experience(int candidate_type, String candidate_Id, String first_Name, String last_Name, String address, String email, String birth_Date, int phone, int expInYear, String proSkill) {
        super(candidate_type, candidate_Id, first_Name, last_Name, address, email, birth_Date, phone);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }
    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }
    public String getProSkill() {
        return proSkill;
    }
    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    String showInfo() {
        return super.showInfo()+" - \u001B[31mYear of experience\u001B[0m: "+this.expInYear+" - \u001B[31mProfessional Skill\u001B[0m: "+this.proSkill;
    }
    
    @Override
    String Info(){
        return super.Info()+","+this.expInYear+","+this.proSkill;
    }
}
