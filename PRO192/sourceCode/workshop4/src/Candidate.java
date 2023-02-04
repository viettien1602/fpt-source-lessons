import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.*;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Locale;

public class Candidate {
	String regex_name = "[a-zA-Z\s]+$";
	String regex_phone = "^[0-9]+$";
	String regex_email = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
	Pattern p_name = Pattern.compile(regex_name);
	Pattern p_phone = Pattern.compile(regex_phone);
	Pattern p_email = Pattern.compile(regex_email, Pattern.CASE_INSENSITIVE);
	String id, f_name, l_name, birth_day, address, phone, email, type;
	String year_of_ex, pro_skill, graduate_date, rank_of_graduation, education, major, semester, university;
	Scanner sc = new Scanner(System.in);
	private HashMap<String, String> _map = new HashMap<String, String>();

	boolean valid_date(String date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu", Locale.UK)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			dtf.parse(date);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	boolean valid_name(String name) {
		Matcher m = p_name.matcher(name);
		return m.matches();
	}

	boolean valid_phone(String phone) {
		Matcher m = p_phone.matcher(phone);
		return m.matches();
	}

	boolean valid_email(String email) {
		Matcher m = p_email.matcher(email);
		return m.matches();
	}

	boolean set_map(String key, String value) {
		_map.put(key, value);
		return true;
	}

	String get_map(String key) {
		return _map.get(key);
	}

	String contains(String value) {
		for (String data : _map.values()) {
			if (data.equals(value)) {
				return data;
			}
		}
		return null;
	}

	void output_map() {
		for (String data : _map.keySet()) {
			String key = data;
			String value = _map.get(key);
			System.out.println(key + ": " + value);
		}
	}

	String return_map() {
		String return_value = "";
		for (String data : _map.keySet()) {
			String key = data;
			String value = _map.get(key);
			return_value = return_value.concat(key.concat(":" + value + "\n"));
		}
		return return_value;
	}

	void update_map_id() {
		System.out.print("New ID: ");
		id = sc.nextLine();
		_map.replace("id", id);
	}

	boolean update_map_f_name() {
		boolean looping = true;
		while (looping) {
			System.out.print("New first name: ");
			f_name = sc.nextLine();
			if (valid_name(f_name)) {
				_map.replace("f_name", f_name);
				looping = false;
				return true;
			} else
				System.out.println("Invalid format!");
		}
		return false;
	}

	void update_map_l_name() {
		boolean looping = true;
		while (looping) {
			System.out.print("New last name: ");
			l_name = sc.nextLine();
			if (valid_name(l_name)) {
				_map.replace("l_name", l_name);
				looping = false;
			} else
				System.out.println("Invalid format!");
		}
	}

	void update_map_birth_day() {
		boolean looping = true;
		while (looping) {
			System.out.print("New birthday: ");
			birth_day = sc.nextLine();
			if (valid_date(birth_day)) {
				_map.replace("birth_day", birth_day);
				looping = false;
			} else
				System.out.println("Invalid format!");
		}
	}

	void update_map_address() {
		System.out.print("New address: ");
		address = sc.nextLine();
		_map.replace("address", address);
	}

	void update_map_phone() {
		boolean looping = true;
		while (looping) {
			System.out.print("New phone number: ");
			phone = sc.nextLine();
			if (valid_phone(phone)) {
				_map.replace("phone", phone);
				looping = false;
			} else
				System.out.println("Invalid format!");
		}
	}

	void update_map_email() {
		boolean looping = true;
		while (looping) {
			System.out.print("New email: ");
			email = sc.nextLine();
			if (valid_email(email)) {
				_map.replace("email", email);
				looping = false;
			} else
				System.out.println("Invalid format!");
		}
	}

	void update_map_type() {
		boolean looping = true;
		while (looping) {
			System.out.print("New type (Number only!): ");
			type = sc.nextLine();
			try {
				Integer type_temp = Integer.parseInt(type);
				if (type_temp < 1 || type_temp > 3)
					continue;
				else {
					String type_string = type_temp.toString();
					_map.replace("type", type_string);
					looping = false;
				}
			} catch (Exception e) {
				System.out.println("Invalid input!");
			}
		}
	}

	void insert_map() {
		if (_map.isEmpty() == false) {
			for (String s : _map.keySet())
				_map.remove(s);
		}

		boolean looping = true;
		System.out.print("ID: ");
		id = sc.nextLine();

		while (looping) {
			System.out.print("First name: ");
			f_name = sc.nextLine();
			if (valid_name(f_name))
				looping = false;

			else
				System.out.println("Invalid format!");
		}

		looping = true;
		while (looping) {
			System.out.print("Last name: ");
			l_name = sc.nextLine();
			if (valid_name(l_name))
				looping = false;
			else
				System.out.println("Invalid format!");
		}

		looping = true;
		while (looping) {
			System.out.print("Birthday (DD/MM/YYYY): ");
			birth_day = sc.nextLine();
			if (valid_date(birth_day))
				looping = false;
			else
				System.out.println("Invalid format!");
		}

		System.out.print("Address: ");
		address = sc.nextLine();

		looping = true;
		while (looping) {
			System.out.print("Phone number: ");
			phone = sc.nextLine();
			if (valid_phone(phone) && phone.length() == 10) {
				looping = false;
			} else
				System.out.println("Invalid format!");
		}

		looping = true;
		while (looping) {
			System.out.print("Email: ");
			email = sc.nextLine();
			if (valid_email(email))
				looping = false;
			else
				System.out.println("Invalid input!");
		}

		looping = true;
		while (looping) {
			System.out.print("Type (Number only!): ");
			type = sc.nextLine();
			try {
				int type_temp = Integer.parseInt(type);
				if (type_temp < 1 || type_temp > 3)
					continue;
				else if (type_temp == 1) {
					System.out.print("Year of Experience: ");
					year_of_ex = sc.nextLine();
					System.out.print("Professional skills: ");
					pro_skill = sc.nextLine();
					put_map();
					put_map_type_1();
				} else if (type_temp == 2) {
					System.out.print("Graduate date: ");
					graduate_date = sc.nextLine();
					System.out.print("Rank of gradutaion: ");
					rank_of_graduation = sc.nextLine();
					System.out.print("Education: ");
					education = sc.nextLine();
					put_map();
					put_map_type_2();
				} else if (type_temp == 3) {
					System.out.print("Major: ");
					major = sc.nextLine();
					System.out.print("Semester: ");
					semester = sc.nextLine();
					System.out.print("University: ");
					university = sc.nextLine();
					put_map();
					put_map_type_3();
				}
				looping = false;

			} catch (Exception e) {
				System.out.println("Invalid input!");
			}
		}

	}

	String return_data() {
		ArrayList<String> _sorted = new ArrayList<>(_map.keySet());
		Collections.sort(_sorted);

		String something = "";
		for (String s : _sorted) {
			something = something.concat(s + ":" + _map.get(s) + "\n");
		}
		return something;
	}

	/*
	 * ArrayList<Candidate> _find(String str) {
	 * 
	 * ArrayList<Candidate> users = new ArrayList<Candidate>();
	 * 
	 * String[] fields = str.split(";");
	 * 
	 * for (Candidate candy : list) { int same = 0; for (String f : fields) { String
	 * key = f.split(":")[0].trim(); String val = f.split(":")[1].trim(); if
	 * (candy.getProps(key).equals(val)) same++; } if (same == fields.length)
	 * users.add(candy); }
	 * 
	 * return users; }
	 */

	void put_map() {
		_map.put("id", id);
		_map.put("f_name", f_name);
		_map.put("l_name", l_name);
		_map.put("birth_day", birth_day);
		_map.put("address", address);
		_map.put("phone", phone);
		_map.put("email", email);
		_map.put("type", type);
	}

	void put_map_type_1() {
		_map.put("year_of_ex", year_of_ex);
		_map.put("pro_skill", pro_skill);
	}

	void put_map_type_2() {
		_map.put("graduate_date", graduate_date);
		_map.put("rank_of_education", rank_of_graduation);
		_map.put("education", education);
	}

	void put_map_type_3() {
		_map.put("major", major);
		_map.put("semester", semester);
		_map.put("university", university);
	}
}
