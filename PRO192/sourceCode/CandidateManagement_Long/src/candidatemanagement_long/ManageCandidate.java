package candidatemanagement_long;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

/**
 *
 * @author LongDinh
 */
public class ManageCandidate extends ArrayList<I_Candidate> implements I_ManageCandidate {

    Scanner sc = new Scanner(System.in);

    public boolean check_Same_ID(String id) {
        for (I_Candidate mem : this) {
            if (id.toLowerCase().equals(mem.getCandidate_Id().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void takeInfofromFile1() {
        try {
            File x = new File("Experience.txt");
            Scanner chuyenx = new Scanner(x);
            while (chuyenx.hasNext()) {
                String a = chuyenx.nextLine();
                String[] s = a.split(",");
                I_Candidate create = new Experience(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4], s[5], s[6], Integer.parseInt(s[7]), Integer.parseInt(s[8]), s[9]);
                this.add(create);
            }
            System.out.println("Load1..........");
            chuyenx.close();
        } catch (Exception e) {
            System.out.println("File1 no data!");
        }
    }
    @Override
    public void takeInfofromFile2() {
        try {
            File y = new File("Intern.txt");
            Scanner chuyeny = new Scanner(y);
            while (chuyeny.hasNext()) {
                String a = chuyeny.nextLine();
                String[] s = a.split(",");
                I_Candidate create = new Intern(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4], s[5], s[6], Integer.parseInt(s[7]), s[8], s[9], Integer.parseInt(s[10]));
                this.add(create);
            }
            System.out.println("Load2..........");
            chuyeny.close();
        }catch (Exception e) {
            System.out.println("File2 no data!");
        }
    }
    @Override
    public void takeInfofromFile3() {
        try {
            File z = new File("Fresher.txt");
            Scanner chuyenz = new Scanner(z);
            while (chuyenz.hasNext()) {
                String a = chuyenz.nextLine();
                String[] s = a.split(",");
                I_Candidate create = new Fresher(Integer.parseInt(s[0]), s[1], s[2], s[3], s[4], s[5], s[6], Integer.parseInt(s[7]), s[8], s[9], s[10]);
                this.add(create);
            }
            System.out.println("Load3..........");
            chuyenz.close();
        }catch (Exception e) {
            System.out.println("File3 no data!");
        }
    }

    void showList() {
        this.forEach((i) -> System.out.println(i.Info()));
    }

    @Override
    public void addCan() {
        boolean alwaysAdd = true;
        System.out.println("\u001B[35m** Insert New Candidate **\u001B[0m");
        while (alwaysAdd == true) {
            /*ID*/
            System.out.print("\u001B[35mID (\"STOP\" to stop)\u001B[0m: ");
            String candidate_Id = sc.nextLine();
            while (candidate_Id != null) {
                if (check_Same_ID(candidate_Id) == true) {
                    System.out.print("\u001B[31m**Invalid id!Try again\u001B[0m: ");
                    candidate_Id = sc.nextLine();
                } else {
                    break;
                }
            }
            if (candidate_Id.toLowerCase().equals("stop")) {
                System.out.println("\u001B[31mStop inserting!\u001B[0m");
                alwaysAdd = false;
            } else {
                /*First name*/
                System.out.print("\u001B[35mFirst name (\"STOP\" to stop)\u001B[0m: ");
                String first_Name = sc.nextLine();
                while (true) {
                    if (CheckError.Check_Name(first_Name) == true) {
                        break;
                    } else {
                        System.out.print("\u001B[31m**Invalid fisrt name!Try again\u001B[0m: ");
                        first_Name = sc.nextLine();
                    }
                }
                if (first_Name.toLowerCase().equals("stop")) {
                    System.out.println("\u001B[31mStop inserting!\u001B[0m");
                    alwaysAdd = false;
                } else {
                    /*Last name*/
                    System.out.print("\u001B[35mLast name (\"STOP\" to stop)\u001B[0m: ");
                    String last_Name = sc.nextLine();
                    while (true) {
                        if (CheckError.Check_Name(last_Name) == true) {
                            break;
                        } else {
                            System.out.print("\u001B[31m**Invalid last name!Try again\u001B[0m: ");
                            last_Name = sc.nextLine();
                        }
                    }
                    if (last_Name.toLowerCase().equals("stop")) {
                        System.out.println("\u001B[31mStop inserting!\u001B[0m");
                        alwaysAdd = false;
                    } else {
                        /*Address*/
                        System.out.print("\u001B[35mAddress (\"STOP\" to stop)\u001B[0m: ");
                        String address = sc.nextLine();
                        if (address.toLowerCase().equals("stop")) {
                            System.out.println("\u001B[31mStop inserting!\u001B[0m");
                            alwaysAdd = false;
                        } else {
                            /*Email*/
                            System.out.print("\u001B[35mEmail\u001B[0m: ");
                            String email = sc.nextLine();
                            while (email != null) {
                                if (CheckError.validMail(email) == false) {
                                    System.out.print("\u001B[31m**Invalid email!Try again\u001B[0m: ");
                                    email = sc.nextLine();
                                } else {
                                    break;
                                }
                            }
                            /*Date of birth*/
                            System.out.print("\u001B[35mDate of birth (dd/mm/yyyy)\u001B[m: ");
                            String birth_Date = sc.nextLine();
                            while (birth_Date != null) {
                                if (CheckError.Check_Date(birth_Date) == false || CheckError.Check_Month_Valid(birth_Date) == false || CheckError.isValidFutureDate(birth_Date)==true) {
                                    System.out.print("\u001B[31m**Invalid date!Try again\u001B[0m: ");
                                    birth_Date = sc.nextLine();
                                } else {
                                    break;
                                }
                            }
                            /*Phone*/
                            int phone = 0;
                            System.out.print("\u001B[35mPhone\u001B[0m: ");
                            String phone_ = sc.nextLine();
                            while (phone_ != null) {
                                if (CheckError.Check_Valid_Num(phone_) == false || phone_.length() >10) {
                                    System.out.print("\u001B[31m**Invalid input! Try again\u001B[0m: ");
                                    phone_ = sc.nextLine();
                                } else {
                                    phone = Integer.parseInt(phone_);
                                    break;
                                }
                            }
                            /*Type*/
                            System.out.print("\u001B[35mType of candidate (1. Experience - 2. Intern  - 3. Fresher)\u001B[0m: ");
                            String candidate_type_ = sc.nextLine();
                            int candidate_type = 0;
                            while (candidate_type_ != null) {
                                if (CheckError.Check_Valid_Num(candidate_type_) == false) {
                                    System.out.print("\u001B[31m**Invalid input! Try again\u001B[0m: ");
                                    candidate_type_ = sc.nextLine();
                                } else if (Integer.parseInt(candidate_type_) < 1 || Integer.parseInt(candidate_type_) > 3) {
                                    System.out.print("\u001B[31m**Out of this operator! Try again\u001B[0m: ");
                                    candidate_type_ = sc.nextLine();
                                } else {
                                    candidate_type = Integer.parseInt(candidate_type_);
                                    break;
                                }
                            }
                            switch (candidate_type) {
                                case 1:  //Experience
                /*Experience years*/
                                    int expInYear = 0;
                                    System.out.print("\u001B[35mYears of experience\u001B[0m: ");
                                    String expInYear_ = sc.nextLine();
                                    while (expInYear_ != null) {
                                        if (CheckError.Check_Valid_Num(expInYear_) == false) {
                                            System.out.print("\u001B[31m**Invalid input! Try again\u001B[0m: ");
                                            expInYear_ = sc.nextLine();
                                        } else {
                                            expInYear = Integer.parseInt(expInYear_);
                                            break;
                                        }
                                    }
                                    /*Professional skill*/
                                    System.out.print("\u001B[35mProfessional skill (\"STOP\" to stop)\u001B[0m: ");
                                    String proSkill = sc.nextLine();
                                    if (proSkill.toLowerCase().equals("stop")) {
                                        System.out.println("\u001B[31mStop inserting!\u001B[0m");
                                        alwaysAdd = false;
                                    } else {
                                        I_Candidate create_exp = new Experience(candidate_type, candidate_Id, first_Name, last_Name, address, email, birth_Date, phone, expInYear, proSkill);
                                        this.add(create_exp);
                                        System.out.println("\u001B[31mDone!\u001B[0m");
                                    }
                                    break;
                                case 2:  //Intern
                /*Graduated time*/
                                    System.out.print("\u001B[35mGraduated time\u001B[0m: ");
                                    String graduationDate = sc.nextLine();
                                    while (graduationDate != null) {
                                        if (CheckError.Check_Date(graduationDate) == false || CheckError.Check_Month_Valid(graduationDate) == false || CheckError.isValidFutureDate(birth_Date)==true) {
                                            System.out.print("\u001B[31m**Invalid date!Try again\u001B[0m: ");
                                            graduationDate = sc.nextLine();
                                        } else {
                                            break;
                                        }
                                    }
                                    /*Rank of graduation*/
                                    System.out.print("\u001B[35mRank of graduation\u001B[0m: ");
                                    int graduationRank = 0;
                                    String graduationRank_ = sc.nextLine();
                                    while (graduationRank_ != null) {
                                        if (CheckError.Check_Valid_Num(graduationRank_) == false) {
                                            System.out.print("\u001B[31m**Invalid value! Try again\u001B[0m: ");
                                            graduationRank_ = sc.nextLine();
                                        } else {
                                            graduationRank = Integer.parseInt(graduationRank_);
                                            break;
                                        }
                                    }
                                    /*University where graduated*/
                                    System.out.print("\u001B[35mUniversity where graduated (\"STOP\" to stop)\u001B[0m: ");
                                    String education = sc.nextLine();
                                    if (education.toLowerCase().equals("stop")) {
                                        System.out.println("\u001B[31mStop inserting!\u001B[0m");
                                        alwaysAdd = false;
                                    } else {
                                        I_Candidate create_intern = new Intern(candidate_type, candidate_Id, first_Name, last_Name, address, email, birth_Date, phone, graduationDate, education, graduationRank);
                                        this.add(create_intern);
                                        System.out.println("\u001B[31mDone!\u001B[0m");
                                    }
                                    break;
                                case 3:  //Fresher
                /*Major*/
                                    System.out.print("\u001B[35mMajor (\"STOP\" to stop)\u001B[0m: ");
                                    String majors = sc.nextLine();
                                    if (majors.toLowerCase().equals("stop")) {
                                        System.out.println("\u001B[31mStop inserting!\u001B[0m");
                                        alwaysAdd = false;
                                    } else {
                                        /*Semester*/
                                        System.out.print("\u001B[35mSemester (\"STOP\" to stop)\u001B[0m: ");
                                        String semester = sc.nextLine();
                                        if (semester.toLowerCase().equals("stop")) {
                                            System.out.println("\u001B[31mStop inserting!\u001B[0m");
                                            alwaysAdd = false;
                                        } else {
                                            /*University name*/
                                            System.out.print("\u001B[35mUniversity name (\"STOP\" to stop)\u001B[0m: ");
                                            String uniname = sc.nextLine();
                                            if (uniname.toLowerCase().equals("stop")) {
                                                System.out.println("\u001B[31mStop inserting!\u001B[0m");
                                                alwaysAdd = false;
                                            } else {
                                                I_Candidate create_fresher = new Fresher(candidate_type, candidate_Id, first_Name, last_Name, address, email, birth_Date, phone, majors, semester, uniname);
                                                this.add(create_fresher);
                                                System.out.println("\u001B[31mDone!\u001B[0m");
                                            }
                                        }
                                    }
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    ArrayList<I_Candidate> findByFName(String nameFind) {
        ArrayList<I_Candidate> found = new ArrayList<>();
        for (I_Candidate candidate : this) {
            if (candidate.getFirst_Name().toLowerCase().contains(nameFind.toLowerCase())) {
                found.add(candidate);
            }
        }
        return found;
    }

    void findByName() {
        System.out.print("\u001B[36m-*Find by name*-\u001B[0m\n\u001B[36m1) First name\u001B[0m\n\u001B[36m2) Last name\u001B[0m\n\u001B[36mChoice\u001B[0m: ");
        int choice = 0;
        String choice_ = sc.nextLine();
        while (choice_ != null) {
            if (CheckError.Check_Valid_Num(choice_) == false) {
                System.out.print("\u001B[31m**Invalid input! Try again! Choice\u001B[0m: ");
                choice_ = sc.nextLine();
            } else if (Integer.parseInt(choice_) < 1 || Integer.parseInt(choice_) > 2) {
                System.out.print("\u001B[31m**Out of this operator! Try again! Choice\u001B[0m: ");
                choice_ = sc.nextLine();
            } else {
                choice = Integer.parseInt(choice_);
                break;
            }
        }
        switch (choice) {
            case 1:
                System.out.print("\u001B[36mFirst name you want to find: \u001B[0m");
                String nameFind = sc.nextLine();
                ArrayList<I_Candidate> fname = findByFName(nameFind);
                if (fname.size() < 1) {
                    System.out.println("\u001B[31mNo result!\u001B[0m");
                } else {
                    fname.forEach((i) -> System.out.println(i.showInfo()));
                }
                break;
            case 2:
                System.out.print("\u001B[36mLast name you want to find\u001B[0m: ");
                String nameFin = sc.nextLine();
                ArrayList<I_Candidate> lname = findByLName(nameFin);
                if (lname.size() < 1) {
                    System.out.println("\u001B[31mNo result!\u001B[0m");
                } else {
                    lname.forEach((i) -> System.out.println(i.showInfo()));
                }
                break;
        }
    }

    ArrayList<I_Candidate> findByLName(String nameFind) {
        ArrayList<I_Candidate> found = new ArrayList<>();
        for (I_Candidate candidate : this) {
            if (candidate.getLast_Name().toLowerCase().contains(nameFind.toLowerCase())) {
                found.add(candidate);
            }
        }
        return found;
    }

    I_Candidate findByID(String id_find) {
        for (I_Candidate id : this) {
            if (id.getCandidate_Id().toLowerCase().equals(id_find.toLowerCase())) {
                return id;
            }
        }
        return null;
    }

    @Override
    public void findCan() {
        System.out.print("\u001B[36m**Find Candidate**\u001B[0m\n\u001B[36mFind by name  (1)\u001B[0m\n\u001B[36mFind by ID  (2)\u001B[0m\n\u001B[36mChoice\u001B[0m: ");
        int choice = 0;
        String choice_ = sc.nextLine();
        while (choice_ != null) {
            if (CheckError.Check_Valid_Num(choice_) == false) {
                System.out.print("\u001B[31m**Invalid input! Try again! Choice\u001B[0m: ");
                choice_ = sc.nextLine();
            } else if (Integer.parseInt(choice_) < 1 || Integer.parseInt(choice_) > 2) {
                System.out.print("\u001B[31m**Out of this operator! Try again! Choice\u001B[0m: ");
                choice_ = sc.nextLine();
            } else {
                choice = Integer.parseInt(choice_);
                break;
            }
        }
        switch (choice) {
            case 1: //Find by name
                findByName();
                break;
            case 2: //Find by ID
                System.out.print("\u001B[36mID you want to find\u001B[0m: ");
                String id_find = sc.nextLine();
                I_Candidate idf = findByID(id_find);
                if (idf == null) {
                    System.out.println("\u001B[31mNo result!\u001B[0m");
                } else {
                    System.out.println(idf.showInfo());
                }
                break;
        }
    }

    int returnIndex(I_Candidate can) {
        return this.indexOf(can);
    }

    @Override
    public void deleteCan() {
        System.out.print("\u001B[32m**Delete Candidate**\u001B[0m\n\u001B[32mID of candidate to delete: ");
        String id_del = sc.nextLine();
        I_Candidate check = findByID(id_del);
        int check_ = returnIndex(check);
        if (check == null) {
            System.out.println("\u001B[31mDelete failed\u001B[0m");
        } else {
            this.remove(check_);
            System.out.println("\u001B[31mDelete successfully!\u001B[0m");
        }
    }

    void changeType1(Experience canUpdate) {
        boolean loop1 = true;
        while (loop1 == true) {
            System.out.print("1/ Experience in year\n2/ Professional Skill\n3/ Exit\nChoice: ");
            int choice1 = 0;
            String choice1_ = sc.nextLine();
            while (choice1_ != null) {
                if (CheckError.Check_Valid_Num(choice1_) == false) {
                    System.out.print("\u001B[31m**Invalid input! Try again! Choice\u001B[0m: ");
                    choice1_ = sc.nextLine();
                } else if (Integer.parseInt(choice1_) < 1 || Integer.parseInt(choice1_) > 3) {
                    System.out.print("\u001B[31m**Out of this operator! Try again! Choice\u001B[0m: ");
                    choice1_ = sc.nextLine();
                } else {
                    choice1 = Integer.parseInt(choice1_);
                    break;
                }
            }
            switch (choice1) {
                case 1:
                    System.out.print("Experience in year: ");
                    String expInYear_ = sc.nextLine();
                    int expInYear = 0;
                    while (expInYear_ != null) {
                        if (CheckError.Check_Valid_Num(expInYear_) == false) {
                            System.out.print("\u001B[31m**Invalid input! Try again\u001B[0m: ");
                            expInYear_ = sc.nextLine();
                        } else {
                            expInYear = Integer.parseInt(expInYear_);
                            System.out.println("\u001B[31mDone!\u001B[0m");
                            break;
                        }
                    }
                    canUpdate.setExpInYear(expInYear);
                    break;
                case 2:
                    System.out.print("Professional Skill: ");
                    String proSkill = sc.nextLine();
                    canUpdate.setProSkill(proSkill);
                    System.out.println("\u001B[31mDone!\u001B[0m");
                    break;
                case 3:
                    loop1 = false;
                    break;
            }
        }
    }

    void changeType2(Intern canUpdate) {
        boolean loop2 = true;
        while (loop2 == true) {
            System.out.print("1/ Date of Graduation\n2/ Rank of graduation\n3/ University where graduated\n4/ Exit\nChoice: ");
            int choice2 = 0;
            String choice2_ = sc.nextLine();
            while (choice2_ != null) {
                if (CheckError.Check_Valid_Num(choice2_) == false) {
                    System.out.print("\u001B[31m**Invalid input! Try again! Choice\u001B[0m: ");
                    choice2_ = sc.nextLine();
                } else if (Integer.parseInt(choice2_) < 1 || Integer.parseInt(choice2_) > 4) {
                    System.out.print("\u001B[31m**Out of this operator! Try again! Choice\u001B[0m: ");
                    choice2_ = sc.nextLine();
                } else {
                    choice2 = Integer.parseInt(choice2_);
                    break;
                }
            }
            switch (choice2) {
                case 1:
                    System.out.print("Date of Graduation: ");
                    String graduationDate = sc.nextLine();
                    while (graduationDate != null) {
                        if (CheckError.Check_Date(graduationDate) == false || CheckError.Check_Month_Valid(graduationDate) == false) {
                            System.out.print("\u001B[31m**Invalid date!Try again\u001B[0m: ");
                            graduationDate = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    canUpdate.setGraduationDate(graduationDate);
                    break;
                case 2:
                    System.out.print("Rank of graduation: ");
                    int graduationRank = 0;
                    String graduationRank_ = sc.nextLine();
                    while (graduationRank_ != null) {
                        if (CheckError.Check_Valid_Num(graduationRank_) == false) {
                            System.out.print("\u001B[31m**Invalid value! Try again\u001B[0m: ");
                            graduationRank_ = sc.nextLine();
                        } else {
                            graduationRank = Integer.parseInt(graduationRank_);
                            break;
                        }
                    }
                    canUpdate.setGraduationRank(graduationRank);
                    break;
                case 3:
                    System.out.print("University where graduated: ");
                    String education = sc.nextLine();
                    canUpdate.setEducation(education);
                    break;
                case 4:
                    loop2 = false;
                    break;
            }
        }
    }

    void changeType3(Fresher canUpdate) {
        boolean loop3 = true;
        while (loop3 == true) {
            System.out.print("1/ Date of Graduation\n2/ Rank of graduation\n3/ University where graduated\n4/ Exit\nChoice: ");
            int choice3 = 0;
            String choice3_ = sc.nextLine();
            while (choice3_ != null) {
                if (CheckError.Check_Valid_Num(choice3_) == false) {
                    System.out.print("\u001B[31m**Invalid input! Try again! Choice\u001B[0m: ");
                    choice3_ = sc.nextLine();
                } else if (Integer.parseInt(choice3_) < 1 || Integer.parseInt(choice3_) > 4) {
                    System.out.print("\u001B[31m**Out of this operator! Try again! Choice\u001B[0m: ");
                    choice3_ = sc.nextLine();
                } else {
                    choice3 = Integer.parseInt(choice3_);
                    break;
                }
            }
            switch (choice3) {
                case 1:
                    System.out.print("Major: ");
                    String majors = sc.nextLine();
                    canUpdate.setMajors(majors);
                    break;
                case 2:
                    System.out.print("Semester: ");
                    String semester = sc.nextLine();
                    canUpdate.setSemester(semester);
                    break;
                case 3:
                    System.out.print("University name: ");
                    String uniname = sc.nextLine();
                    canUpdate.setUniname(uniname);
                    break;
                case 4:
                    loop3 = false;
                    break;
            }
        }
    }

    void changeType(I_Candidate canUpdate) {
        System.out.print("\u001B[34mWhich type?\u001B[0m\n\u001B[34m1> Experience\u001B[0m\n\u001B[34m2> Intern\u001B[0m\n\u001B[34m3>Fresher\u001B[0m\nChoice: ");
        int choice = 0;
        String choice_ = sc.nextLine();
        while (choice_ != null) {
            if (CheckError.Check_Valid_Num(choice_) == false) {
                System.out.print("\u001B[31m**Invalid input! Try again! Choice\u001B[0m: ");
                choice_ = sc.nextLine();
            } else if (Integer.parseInt(choice_) < 1 || Integer.parseInt(choice_) > 3) {
                System.out.print("\u001B[31m**Out of this operator! Try again! Choice\u001B[0m: ");
                choice_ = sc.nextLine();
            } else {
                choice = Integer.parseInt(choice_);
                break;
            }
        }
        switch (choice) {
            case 1:
                if (canUpdate.getCandidate_type() == choice) {
                    try {
                        changeType1((Experience) canUpdate);
                    } catch (Exception e) {
                        System.out.println("\u001B[31mUpdate Error\u001B[0m");
                    }
                } else {
                    System.out.print("Experience in year: ");
                    String expInYear_ = sc.nextLine();
                    int expInYear = 0;
                    while (expInYear_ != null) {
                        if (CheckError.Check_Valid_Num(expInYear_) == false) {
                            System.out.print("\u001B[31m**Invalid input! Try again\u001B[0m: ");
                            expInYear_ = sc.nextLine();
                        } else {
                            expInYear = Integer.parseInt(expInYear_);
                            break;
                        }
                    }
                    System.out.print("Professional Skill: ");
                    String proSkill = sc.nextLine();
                    I_Candidate addnew = new Experience(1, canUpdate.getCandidate_Id(), canUpdate.getFirst_Name(), canUpdate.getLast_Name(), canUpdate.getAddress(), canUpdate.getEmail(), canUpdate.getBirth_Date(), canUpdate.getPhone(), expInYear, proSkill);
                    this.remove(this.indexOf(canUpdate));
                    this.add(addnew);
                    System.out.println("\u001B[31mDone!\u001B[0m");
                }
                break;
            case 2:
                if (canUpdate.getCandidate_type() == choice) {
                    try {
                        changeType2((Intern) canUpdate);
                    } catch (Exception e) {
                        System.out.println("\u001B[31mUpdate Error\u001B[0m");
                    }
                } else {
                    System.out.print("Date of Graduation: ");
                    String graduationDate = sc.nextLine();
                    while (graduationDate != null) {
                        if (CheckError.Check_Date(graduationDate) == false || CheckError.Check_Month_Valid(graduationDate) == false) {
                            System.out.print("\u001B[31m**Invalid date!Try again\u001B[0m: ");
                            graduationDate = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    System.out.print("Rank of graduation: ");
                    int graduationRank = 0;
                    String graduationRank_ = sc.nextLine();
                    while (graduationRank_ != null) {
                        if (CheckError.Check_Valid_Num(graduationRank_) == false) {
                            System.out.print("\u001B[31m**Invalid value! Try again\u001B[0m: ");
                            graduationRank_ = sc.nextLine();
                        } else {
                            graduationRank = Integer.parseInt(graduationRank_);
                            break;
                        }
                    }
                    System.out.print("University where graduated: ");
                    String education = sc.nextLine();
                    I_Candidate addnew = new Intern(2, canUpdate.getCandidate_Id(), canUpdate.getFirst_Name(), canUpdate.getLast_Name(), canUpdate.getAddress(), canUpdate.getEmail(), canUpdate.getBirth_Date(), canUpdate.getPhone(), graduationDate, education, graduationRank);
                    this.remove(this.indexOf(canUpdate));
                    this.add(addnew);
                    System.out.println("\u001B[31mDone!\u001B[0m");
                }
                break;
            case 3:
                if (canUpdate.getCandidate_type() == choice) {
                    try {
                        changeType3((Fresher) canUpdate);
                    } catch (Exception e) {
                        System.out.println("\u001B[31mUpdate Error\u001B[0m");
                    }
                } else {
                    System.out.print("Major: ");
                    String majors = sc.nextLine();
                    System.out.print("Semester: ");
                    String semester = sc.nextLine();
                    System.out.print("University name: ");
                    String uniname = sc.nextLine();
                    I_Candidate addnew = new Fresher(3, canUpdate.getCandidate_Id(), canUpdate.getFirst_Name(), canUpdate.getLast_Name(), canUpdate.getAddress(), canUpdate.getEmail(), canUpdate.getBirth_Date(), canUpdate.getPhone(), majors, semester, uniname);
                    this.remove(this.indexOf(canUpdate));
                    this.add(addnew);
                    System.out.println("\u001B[31mDone!\u001B[0m");
                }
                break;
        }
    }

    void changeCommonInfo(I_Candidate canUpdate) {
        boolean loopCommon = true;
        while (loopCommon == true) {
            System.out.print("1) ID\n2) First name\n3) Last name\n4) Address\n5) Email\n6) Date of birth (dd/mm/yyyy)\n7) Phone\n8) Exit\nChoice: ");
            int choice = 0;
            String choice_ = sc.nextLine();
            while (choice_ != null) {
                if (CheckError.Check_Valid_Num(choice_) == false) {
                    System.out.print("\u001B[31m**Invalid input! Try again! Choice\u001B[0m: ");
                    choice_ = sc.nextLine();
                } else if (Integer.parseInt(choice_) < 1 || Integer.parseInt(choice_) > 8) {
                    System.out.print("\u001B[31m**Out of this operator! Try again! Choice\u001B[0m: ");
                    choice_ = sc.nextLine();
                } else {
                    choice = Integer.parseInt(choice_);
                    break;
                }
            }
            switch (choice) {
                case 1: //ID
                    System.out.print("ID: ");
                    String candidate_Id = sc.nextLine();
                    while (candidate_Id != null) {
                        if (check_Same_ID(candidate_Id) == true) {
                            System.out.print("\u001B[31m**Invalid id!Try again\u001B[0m: ");
                            candidate_Id = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    canUpdate.setCandidate_Id(candidate_Id);
                    break;
                case 2: //First Name
                    System.out.print("First name: ");
                    String first_Name = sc.nextLine();
                    while (true) {
                        if (CheckError.Check_Name(first_Name) == true) {
                            break;
                        } else {
                            System.out.print("\u001B[31m**Invalid fisrt name!Try again\u001B[0m: ");
                            first_Name = sc.nextLine();
                        }
                    }
                    canUpdate.setFirst_Name(first_Name);
                    break;
                case 3:// Last name
                    System.out.print("Last name: ");
                    String last_Name = sc.nextLine();
                    while (true) {
                        if (CheckError.Check_Name(last_Name) == true) {
                            break;
                        } else {
                            System.out.print("\u001B[31m**Invalid last name!Try again\u001B[0m: ");
                            last_Name = sc.nextLine();
                        }
                    }
                    canUpdate.setLast_Name(last_Name);
                    break;
                case 4: // Adress
                    System.out.print("Address: ");
                    String address = sc.nextLine();
                    canUpdate.setAddress(address);
                    break;
                case 5: //Email
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    while (email != null) {
                        if (CheckError.validMail(email) == false) {
                            System.out.print("\u001B[31m**Invalid email!Try again\u001B[0m: ");
                            email = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    canUpdate.setEmail(email);
                    break;
                case 6: //Date of birth
                    System.out.print("Date of birth (dd/mm/yyyy): ");
                    String birth_Date = sc.nextLine();
                    while (birth_Date != null) {
                        if (CheckError.Check_Date(birth_Date) == false || CheckError.Check_Month_Valid(birth_Date) == false || CheckError.isValidFutureDate(birth_Date)==true) {
                            System.out.print("\u001B[31m**Invalid date!Try again\u001B[0m: ");
                            birth_Date = sc.nextLine();
                        } else {
                            break;
                        }
                    }
                    canUpdate.setBirth_Date(birth_Date);
                    break;
                case 7: //Phone
                    int phone = 0;
                    System.out.print("Phone: ");
                    String phone_ = sc.nextLine();
                    while (phone_ != null) {
                        if (CheckError.Check_Valid_Num(phone_) == false|| phone_.length() >10) {
                            System.out.print("\u001B[31m**Invalid input! Try again\u001B[0m: ");
                            phone_ = sc.nextLine();
                        } else {
                            phone = Integer.parseInt(phone_);
                            break;
                        }
                    }
                    canUpdate.setPhone(phone);
                    break;
                case 8:
                    loopCommon = false;
                    break;
            }
        }
    }

    @Override
    public void modifyCan() {
        System.out.print("\u001B[34m**Update Candidate**\u001B[0m\n\u001B[34mID of Candidate to update\u001B[0m: ");
        String update = sc.nextLine();
        I_Candidate canUpdate = findByID(update);
        if (canUpdate == null) {
            System.out.println("\u001B[31mNo result!\u001B[0m");
        } else {
            boolean loopUpdate = true;
            while (loopUpdate == true) {
                System.out.print("\u001B[34m1) Change type\u001B[0m\n\u001B[34m2) Change common information\u001B[0m\n\u001B[34m3) Exit\u001B[0m\nChoice: ");
                int choice = 0;
                String choice_ = sc.nextLine();
                while (choice_ != null) {
                    if (CheckError.Check_Valid_Num(choice_) == false) {
                        System.out.print("\u001B[31m**Invalid input! Try again! Choice\u001B[0m: ");
                        choice_ = sc.nextLine();
                    } else if (Integer.parseInt(choice_) < 1 || Integer.parseInt(choice_) > 3) {
                        System.out.print("\u001B[31m**Out of this operator! Try again! Choice\u001B[0m: ");
                        choice_ = sc.nextLine();
                    } else {
                        choice = Integer.parseInt(choice_);
                        break;
                    }
                }
                switch (choice) {
                    case 1:
                        changeType(canUpdate);
                        break;
                    case 2:
                        changeCommonInfo(canUpdate);
                        break;
                    case 3:
                        loopUpdate = false;
                        break;
                }
            }
        }
    }

    @Override
    public void writeInfotoFile() {
        try {
            Formatter x = new Formatter("Experience.txt");
            Formatter y = new Formatter("Intern.txt");
            Formatter z = new Formatter("Fresher.txt");
            for (I_Candidate i : this) {
                if (i.getCandidate_type() == 1) {
                    x.format(i.Info());
                } else if (i.getCandidate_type() == 2) {
                    y.format(i.Info());
                } else {
                    z.format(i.Info());
                }
            }
            System.out.println("Done");
            x.close();
            y.close();
            z.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
