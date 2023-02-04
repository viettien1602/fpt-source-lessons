import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;

public class List_Control {
	ArrayList<Candidate> _list = new ArrayList<Candidate>();

	int choices_add_data() {
		Scanner sc = new Scanner(System.in);
		int choices = -1;
		boolean looping = true;
		while (looping) {
			try {
				System.out.println("1. NEW");
				System.out.println("2. APPEND");
				System.out.println("3. Quit");
				choices = sc.nextInt();
				sc.nextLine();
				if (choices >= 1 && choices <= 3)
					looping = false;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Invalid input!");
				choices = -1;
			}
		}
		return choices;
	}

	boolean read_data(String path) throws IOException {
		boolean flag = false;
		if (Utility.util_load_data(path).contains("~~~") != true) {
			return false;
		}
		String data[] = Utility.util_load_data(path).split("~~~");
		for (String value : data) {
			Candidate _candidate = Utility.util_parse_data(value);
			_list.add(_candidate);
			flag = true;
		}
		if (flag == true)
			return true;
		return false;
	}

	Candidate get(int index) {
		return _list.get(index);
	}

	ArrayList<Integer> find_data(String s) {
		ArrayList<Integer> _index = new ArrayList<Integer>();
		boolean flag = false;

		String field[] = s.split(";");

		for (int i = 0; i < _list.size(); ++i) {
			int same = 0;
			for (String str : field) {
				String key = str.split(":")[0].trim();
				String value = str.split(":")[1].trim();
				if (_list.get(i).get_map(key).equals(value)) {
					same++;
				}
				if (same == field.length) {
					_index.add(i);
					flag = true;
				}
			}
		}

		// for (Candidate _candidate : _list) {
		// for (String str : field) {
		// String key = str.split(":")[0].trim();
		// String value = str.split(":")[1].trim();
		// // System.out.println(_candidate.get_map(key) + index + same + "\t" + value);
		// if (_candidate.get_map(key).equals(value))
		// same++;
		// if (same == field.length) {
		// _index.add(index);
		// System.out.println("index++\t" + index);
		// index++;
		// flag = true;
		// }
		// }
		// }

		// for (int i = 0; i < _list.size(); ++i) {
		// if (_list.get(i).contains(s) != null) {
		// _index.add(i);
		// flag = true;
		// }
		// }
		if (flag == true)
			return _index;
		return null;
	}

	void add_data(String s) {
		_list.add(Utility.util_add_data(s));
	}

	boolean add_data() {
		Candidate _candidate = new Candidate();
		_candidate.insert_map();
		_candidate = Utility.util_add_data(_candidate.return_data());
		if (_candidate != null) {
			_list.add(_candidate);
			return true;
		}
		return false;
	}

	void update_data(int select) {
		Scanner sc = new Scanner(System.in);
		int choices;
		boolean looping = true;
		while (looping) {
			System.out.println("1. ID");
			System.out.println("2. First name");
			System.out.println("3. Last name");
			System.out.println("4. Birthday");
			System.out.println("5. Address");
			System.out.println("6. Phone");
			System.out.println("7. Email");
			System.out.println("8. Type");
			System.out.println("9. Exit");
			choices = sc.nextInt();
			sc.nextLine();
			switch (choices) {
				case 1: {
					_list.get(select).update_map_id();
					break;
				}

				case 2: {
					boolean inner_loop = true;
					while (inner_loop) {
						boolean flag = _list.get(select).update_map_f_name();
						if (flag) {
							System.out.println("Update successfully!");
							inner_loop = false;
						}
					}
					break;
				}

				case 3: {
					_list.get(select).update_map_l_name();
					break;
				}

				case 4: {
					_list.get(select).update_map_birth_day();
					break;
				}

				case 5: {
					_list.get(select).update_map_address();
					break;
				}

				case 6: {
					_list.get(select).update_map_phone();
					break;
				}

				case 7: {
					_list.get(select).update_map_email();
					break;
				}

				case 8: {
					_list.get(select).update_map_type();
					break;
				}

				case 9: {
					looping = false;
					break;
				}

				default: {
					System.out.println("Invalid input!");
					break;
				}
			}
		}
	}

	boolean remove_data(int select) {
		Candidate flag = _list.remove(select);
		if (flag != null)
			return true;
		return false;
	}

	void remove_all() {
		_list.clear();
	}

	// void export_data() throws IOException {
	// FileWriter writer = new FileWriter("file.txt");
	// for (int i = 0; i < _list.size(); ++i) {
	// String data = _list.get(i).return_map();
	// String value[] = data.split("\n");
	// for (String s : value) {
	// writer.write(s + "\n");
	// }
	// if (i != _list.size() - 1)
	// writer.write("~~~" + "\n");
	// }
	// writer.close();
	// }

	public void export_data() throws IOException {
		FileWriter writer = null;
		String home_dir = System.getProperty("user.dir");
		JFileChooser fChooser = new JFileChooser(home_dir);
		int option = fChooser.showSaveDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			writer = new FileWriter(fChooser.getSelectedFile() + ".txt");
			for (int i = 0; i < _list.size(); ++i) {
				String data = _list.get(i).return_map();
				String value[] = data.split("\n");
				for (String s : value) {
					writer.write(s + "\n");
				}
				if (i != _list.size() - 1)
					writer.write("~~~" + "\n");
			}
		}
		writer.close();
	}

	int return_size() {
		return _list.size();
	}
}
