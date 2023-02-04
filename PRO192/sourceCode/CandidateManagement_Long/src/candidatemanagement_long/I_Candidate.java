package candidatemanagement_long;
/**
 *
 * @author LongDinh
 */
class I_Candidate {
    private String candidate_Id, first_Name, last_Name, address, email, birth_Date;
    private int phone,candidate_type;

    public String getCandidate_Id() {
        return candidate_Id;
    }
    public void setCandidate_Id(String candidate_Id) {
        this.candidate_Id = candidate_Id;
    }
    public String getFirst_Name() {
        return first_Name;
    }
    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }
    public String getLast_Name() {
        return last_Name;
    }
    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getBirth_Date() {
        return birth_Date;
    }
    public void setBirth_Date(String birth_Date) {
        this.birth_Date = birth_Date;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    public int getCandidate_type() {
        return candidate_type;
    }
    public void setCandidate_type(int candidate_type) {
        this.candidate_type = candidate_type;
    }
    
    I_Candidate(int candidate_type,String candidate_Id,String first_Name,String last_Name,String address,String email, String birth_Date, int phone) {
        this.candidate_Id = candidate_Id;
        this.first_Name = first_Name;
        this.last_Name = last_Name;
        this.address = address;
        this.email = email;
        this.birth_Date = birth_Date;
        this.phone = phone;
        this.candidate_type = candidate_type;
    }
    String showInfo() {
        return "\u001B[31mType\u001B[0m: "+this.candidate_type+" - \u001B[31mID\u001B[0m: "+this.candidate_Id+" - \u001B[31mFirst name\u001B[0m: "+this.first_Name+" - \u001B[31mLast name\u001B[0m: "+this.last_Name+" - \u001B[31mAddress\u001B[0m: "+this.address+" - \u001B[31mEmail\u001B[0m: "+this.email+" - \u001B[31mDate of birth\u001B[0m: "+this.birth_Date+" - \u001B[31mPhone\u001B[0m: "+this.phone;
    }
    String Info(){
        return this.candidate_type+","+this.candidate_Id+","+this.first_Name+","+this.last_Name+","+this.address+","+this.email+","+this.birth_Date+","+this.phone;
    }
}
